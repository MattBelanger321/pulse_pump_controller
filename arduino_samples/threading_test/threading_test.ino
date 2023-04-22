#include <Thread.h>
#include <ThreadController.h>

// ThreadController that will controll all threads
ThreadController controll = ThreadController();

//My simple Thread
Thread myThread1 = Thread();
Thread myThread2 = Thread();

// callback for myThread1
void niceCallback(){
	Serial.print("COOL! I'm running on: ");
	Serial.println(millis());
}

// callback for myThread2
void meanCallback(){
	Serial.print("Hey Dork! I'm running on: ");
	Serial.println(millis());
}


void handshake()
{
    char handshake = 'H';

    while ( Serial.available() <= 0 ) {
        Serial.print( handshake );
        delay( 300 );
    }
}

void setup()
{
    Serial.begin( 9600 );  // send and receive at 9600 baud

    while ( !Serial ) {
        ;  // wait for serial port to connect. Needed for native USB port only
    }

    handshake();  // send a byte to establish contact until receiver responds

    myThread1.onRun(niceCallback);
	myThread1.setInterval(500);

    myThread2.onRun(meanCallback);
	myThread2.setInterval(500);

	// Adds both threads to the controller
	controll.add(&myThread1);
	controll.add(&myThread2); // & to pass the pointer to it
}

void loop() {
    controll.run();
}