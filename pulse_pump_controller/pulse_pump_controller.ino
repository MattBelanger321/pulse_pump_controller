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
#define POSITION_1    1000  // Change to the first position you want to move the actuator to (50 from HOME)
#define POSITION_2    5000  // Change to the second position you want to move the actuator to (100mm from HOME)

// linear actuator max distance = 150mm

// Initialize state variable
int currentPosition = HOME_POSITION;


// IO

#define TERMINATOR ';'

void initStepper()
{
       // Set up limit switch pin
    pinMode( LIMIT_SWITCH_PIN, INPUT_PULLUP );

    // Set up motor speed and acceleration
    stepper.setMaxSpeed( 5000 );      // Adjust speed as needed
    stepper.setAcceleration( 5000 );  // Adjust acceleration as needed

    // Move motor to home position
    while ( digitalRead( LIMIT_SWITCH_PIN ) == HIGH ) {
        stepper.setSpeed( -200 );  // Move motor slowly in CCW direction
        stepper.runSpeed();
    }
    stepper.setCurrentPosition( HOME_POSITION );  // Set motor position to home position
    currentPosition = HOME_POSITION;              // Set current position to home position

}

#define MAX_MESSAGE_SIZE 128
#define MAX_QUEUE_SIZE 128


// this is a queue of strings that will hold unhandled commands
//  readFromPanel() will produce stepper will consume
int queueSize = 0;
int msgQueue[MAX_QUEUE_SIZE];    


// These integers will denote what command was recieved
#define POSITION_COM 0
#define DELAY_COM 1
#define DURATION_COM 2
#define START_COM 3
#define STOP_COM 4
#define HOME_COM 5
#define UNKNOWN_COM 6

void readPosition(short offset, char * message, short length){

}

void readDelay(short offset, char * message, short length){
    int messageOffset = offset;

    for(; messageOffset < length; messageOffset++){
        if(message[messageOffset] == ';' || message[messageOffset] == ':'){  // If delimeter is hit
            message[messageOffset] = '\0'; //the string libs look for this char
            messageOffset++;
            break;  //and move on
        }
    }

    int delay = atoi(message + offset);

    Serial.print(delay);
}

void readDuration(short offset, char * message, short length){

}

void stepperLoop()
{
    // Move motor to position 1
    stepper.moveTo( POSITION_1 );
    stepper.runToPosition();
    currentPosition = POSITION_1;  // Update current position

    // Wait for actuator to finish moving
    delay( 0 );

    // Move motor to position 2
    stepper.moveTo( POSITION_2 );
    stepper.runToPosition();
    currentPosition = POSITION_2;  // Update current position

    // Wait for actuator to finish moving
    delay( 0 );
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

void establishConnection(){
    Serial.begin( 9600 );  // send and receive at 9600 baud

    while ( !Serial ) {
        ;  // wait for serial port to connect. Needed for native USB port only
    }

    handshake();  // send a byte to establish contact until receiver responds
}



// Producer
void readFromPanel() {
    char message[MAX_MESSAGE_SIZE] = {0};
    short bytes = Serial.readBytesUntil(TERMINATOR, message, MAX_MESSAGE_SIZE);

    short messageOffset = 0;

    for(; messageOffset < bytes; messageOffset++){
        if(message[messageOffset] == ';' || message[messageOffset] == ':'){  // If delimeter is hit
            message[messageOffset] = '\0'; //the string libs look for this char
            messageOffset++;
            break;  //and move on
        }
    }

    if(strcmp("POSITION", message) == 0) {
        msgQueue[queueSize++] = POSITION_COM;
    
        readPosition(messageOffset, message, bytes);
    
    } else if(strcmp("DELAY", message) == 0) {
        msgQueue[queueSize++] = DELAY_COM;
    
        readDelay(messageOffset, message, bytes);
    
    } else if(strcmp("DURATION", message) == 0) {
        msgQueue[queueSize++] = DURATION_COM;

        readDuration(messageOffset, message, bytes);
    
    } else if(strcmp("START", message) == 0) {
    
        msgQueue[queueSize++] = START_COM;
    
    } else if(strcmp("STOP", message) == 0) {
    
        msgQueue[queueSize++] =  STOP_COM;
    
    } else if(strcmp("HOME", message) == 0) {

        msgQueue[queueSize++] = HOME_COM;
    
    }
}

// ThreadController that will controll all threads
ThreadController pool = ThreadController();

//Threads
Thread stepperThread = Thread();
Thread ioThread = Thread();

void initThreadPool(){
    // // Configure myThread
	// stepperThread.onRun(stepperLoop);
	// stepperThread.setInterval(500);

	// Configure myThread
	ioThread.onRun(readFromPanel);
	ioThread.setInterval(1000);

	// Adds both threads to the controller
	pool.add(&ioThread);
	// pool.add(&stepperThread); // & to pass the pointer to it
}

void setup()
{
    // initStepper();  // Initalize the pump

    establishConnection();  // connect to GUI

    initThreadPool();
}

void loop()
{
    pool.run();
}
