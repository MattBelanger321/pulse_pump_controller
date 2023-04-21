#include <AccelStepper.h>

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

void setup()
{

    // // Set up limit switch pin
    // pinMode( LIMIT_SWITCH_PIN, INPUT_PULLUP );

    // // Set up motor speed and acceleration
    // stepper.setMaxSpeed( 5000 );      // Adjust speed as needed
    // stepper.setAcceleration( 5000 );  // Adjust acceleration as needed

    // // Move motor to home position
    // while ( digitalRead( LIMIT_SWITCH_PIN ) == HIGH ) {
    //     stepper.setSpeed( -200 );  // Move motor slowly in CCW direction
    //     stepper.runSpeed();
    // }
    // stepper.setCurrentPosition( HOME_POSITION );  // Set motor position to home position
    // currentPosition = HOME_POSITION;              // Set current position to home position
}

void loop()
{
    // // Move motor to position 1
    // stepper.moveTo( POSITION_1 );
    // stepper.runToPosition();
    // currentPosition = POSITION_1;  // Update current position

    // // Wait for actuator to finish moving
    // delay( 0 );

    // // Move motor to position 2
    // stepper.moveTo( POSITION_2 );
    // stepper.runToPosition();
    // currentPosition = POSITION_2;  // Update current position

    // // Wait for actuator to finish moving
    // delay( 0 );
}
