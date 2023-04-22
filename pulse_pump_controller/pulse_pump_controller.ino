#include <AccelStepper.h>

#include <Thread.h>
#include <ThreadController.h>

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


// IO Constants

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

#define MESSAGE_SIZE 128

void readFromPanel() {
    char message[MESSAGE_SIZE];
    int bytes = Serial.readBytesUntil(TERMINATOR, message, MESSAGE_SIZE);

    // TODO: Use Message
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
