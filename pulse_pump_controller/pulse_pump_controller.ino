#include <AccelStepper.h>

#include <Thread.h>
#include <ThreadController.h>

#include <string.h>

// Define stepper motor connections
#define STEP_PIN         9   // PUL+
#define DIR_PIN          8   // DIR+
#define LIMIT_SWITCH_PIN 11  // Llimit
#define Enable_Pin       10  // ENA+

// Initialize stepper motor object
AccelStepper stepper( AccelStepper::DRIVER, STEP_PIN, DIR_PIN );

// Define actuator positions
#define HOME_POSITION 0
#define MAX_POSITION  6000  // Maximum position in steps, corresponding to 150mm of travel
// #define POSITION_1    1000  // Change to the first position you want to move the actuator to (50 from HOME)
// #define POSITION_2    5000  // Change to the second position you want to move the actuator to (100mm from HOME)

// linear actuator max distance = 150mm

// Initialize state variable
int currentPosition = 0;

short positionStart = 1000;  // in steps (200 steps in 1 mm)
short positionEnd   = 5000;  // in steps (200 steps in 1 mm)
short strokeDelay;           // in ms
short strokeDuration;        // in us

bool start;
bool home_flag;
// IO

#define TERMINATOR ';'

void initStepper()
{
    start = false;
    // Set up limit switch pin
    pinMode( LIMIT_SWITCH_PIN, INPUT_PULLUP );

    // Set up motor speed and acceleration
    stepper.setMaxSpeed( 5000 );      // Adjust speed as needed
    stepper.setAcceleration( 5000 );  // Adjust acceleration as needed

    // // Move motor to home position
    while ( digitalRead( LIMIT_SWITCH_PIN ) == HIGH ) {
        stepper.setSpeed( -200 );  // Move motor slowly in CCW direction
        stepper.runSpeed();
    }
    stepper.setCurrentPosition( HOME_POSITION );  // Set motor position to home position
    currentPosition = HOME_POSITION;              // Set current position to home position
}

#define MAX_MESSAGE_SIZE 128
#define MAX_QUEUE_SIZE   128

// this is a queue of strings that will hold unhandled commands
//  readFromPanel() will produce stepper will consume
int queueSize = 0;
int msgQueue[MAX_QUEUE_SIZE];

// These integers will denote what command was recieved
#define POSITION_COM 0
#define DELAY_COM    1
#define DURATION_COM 2
#define START_COM    3
#define STOP_COM     4
#define HOME_COM     5
#define UNKNOWN_COM  6

void readPosition( short offset, char * message, short length )
{
    int messageOffset = offset;

    for ( ; messageOffset < length; messageOffset++ ) {
        if ( message[messageOffset] == ';' || message[messageOffset] == ':' ) {  // If delimeter is hit
            message[messageOffset] = '\0';                                       // the string libs look for this char
            messageOffset++;
            break;  // and move on
        }
    }

    positionStart = atoi( message + offset ) * 200;

    offset = messageOffset;

    for ( ; messageOffset < length; messageOffset++ ) {
        if ( message[messageOffset] == ';' || message[messageOffset] == ':' ) {  // If delimeter is hit
            message[messageOffset] = '\0';                                       // the string libs look for this char
            messageOffset++;
            break;  // and move on
        }
    }

    positionEnd = atoi( message + offset ) * 200;
}

void readDelay( short offset, char * message, short length )
{
    int messageOffset = offset;

    for ( ; messageOffset < length; messageOffset++ ) {
        if ( message[messageOffset] == ';' || message[messageOffset] == ':' ) {  // If delimeter is hit
            message[messageOffset] = '\0';                                       // the string libs look for this char
            messageOffset++;
            break;  // and move on
        }
    }

    strokeDelay = atoi( message + offset );
}

void readDuration( short offset, char * message, short length )
{
    int messageOffset = offset;

    for ( ; messageOffset < length; messageOffset++ ) {
        if ( message[messageOffset] == ';' || message[messageOffset] == ':' ) {  // If delimeter is hit
            message[messageOffset] = '\0';                                       // the string libs look for this char
            messageOffset++;
            break;  // and move on
        }
    }

    strokeDuration = atoi( message + offset );
}

// Producer
void readFromPanel()
{
    if ( Serial.available() <= 0 ) {
        return;
    }

    char  message[MAX_MESSAGE_SIZE] = { 0 };
    short bytes                     = Serial.readBytesUntil( TERMINATOR, message, MAX_MESSAGE_SIZE );

    short messageOffset = 0;

    for ( ; messageOffset < bytes; messageOffset++ ) {
        if ( message[messageOffset] == ';' || message[messageOffset] == ':' ) {  // If delimeter is hit
            message[messageOffset] = '\0';                                       // the string libs look for this char
            messageOffset++;
            break;  // and move on
        }
    }

    if ( strcmp( "POSITION", message ) == 0 ) {
        // msgQueue[queueSize++] = POSITION_COM;    // POSITION DOESN'T NEED TO BE QUEUED

        readPosition( messageOffset, message, bytes );
    }
    else if ( strcmp( "DELAY", message ) == 0 ) {
        // msgQueue[queueSize++] = DELAY_COM;  //  DELAY DOESN'T NEED TO BE QUEUED

        readDelay( messageOffset, message, bytes );
    }
    else if ( strcmp( "DURATION", message ) == 0 ) {
        msgQueue[queueSize++] = DURATION_COM;

        readDuration( messageOffset, message, bytes );
    }
    else if ( strcmp( "START", message ) == 0 ) {

        // msgQueue[queueSize++] = START_COM;
        start = true;
    }
    else if ( strcmp( "STOP", message ) == 0 ) {
        start = false;
        // msgQueue[queueSize++] =  STOP_COM;
    }
    else if ( strcmp( "HOME", message ) == 0 ) {

        // msgQueue[queueSize++] = HOME_COM;
        home_flag = true;  // next loop main call needs to go home
        start     = false;
    }
}

short dequeue()
{
    short com = msgQueue[0];
    queueSize--;  // poped msgQueue

    for ( int i = 0; i < queueSize; i++ ) {
        msgQueue[i] = msgQueue[i + 1];  // move elements forward in queue
    }

    return com;
}

short getCommand()
{
    if ( queueSize <= 0 ) {
        return UNKNOWN_COM;
    }

    return dequeue();
}

void processCommand()
{
    // short com = getCommand();
    if ( home_flag ) {
        stepper.setMaxSpeed( 5000 );
        // Move motor home
        stepper.moveTo( HOME_POSITION );
        stepper.runToPosition();
        currentPosition = HOME_POSITION;  // Update current position
        home_flag       = false;
    }
}

// MAIN FUNCTION
void stepperLoop()
{
    readFromPanel();
    processCommand();

    if ( stepper.currentPosition() < positionStart ) {  // resetting from home or re_configuring
        stepper.setMaxSpeed( 5000 );                    // speed in steps/ second
    }

    if ( start ) {
        // Move motor to position 1
        stepper.moveTo( positionStart );
        while ( start && stepper.run() ) {
            currentPosition = stepper.currentPosition();  // Update current position
            readFromPanel();
            if ( stepper.currentPosition() >= positionStart ) {
                // clang-format off
                stepper.setMaxSpeed( ( positionEnd - positionStart ) * 1000000 / strokeDuration );  // speed in steps/ second
                // clang-format on
            }
        }

        if ( !start ) {
            return;
        }

        // Move motor to position 2
        stepper.moveTo( positionEnd );
        while ( start && stepper.run() ) {
            currentPosition = stepper.currentPosition();  // Update current position
            readFromPanel();
            // clang-format off
            stepper.setMaxSpeed(( positionEnd - positionStart ) * 1000000 / strokeDuration);  // speed in steps/ second
            // clang-format on
        }

        delay( strokeDelay );
    }
}

void handshake()
{
    char handshake = 'H';

    while ( Serial.available() <= 0 ) {
        Serial.print( handshake );
        delay( 300 );
    }

    handshake = Serial.read();
}

void establishConnection()
{
    Serial.begin( 9600 );  // send and receive at 9600 baud
    Serial.setTimeout( 25 );

    while ( !Serial ) {
        ;  // wait for serial port to connect. Needed for native USB port only
    }

    handshake();  // send a byte to establish contact until receiver responds
}

// ThreadController that will controll all threads
ThreadController pool = ThreadController();

// Threads
Thread stepperThread = Thread();
Thread ioThread      = Thread();

// void initThreadPool(){
//     // Configure myThread
// 	stepperThread.onRun(stepperLoop);
// 	stepperThread.setInterval(1000);

// 	// // Configure myThread
// 	// ioThread.onRun(readFromPanel);
// 	// ioThread.setInterval(1);

// 	// // Adds both threads to the controller
// 	// pool.add(&ioThread);
// 	pool.add(&stepperThread); // & to pass the pointer to it
// }

void setup()
{
    initStepper();  // Initalize the pump

    establishConnection();  // connect to GUI

    // initThreadPool();
}

void loop() { stepperLoop(); }
