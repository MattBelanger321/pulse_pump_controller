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
}

void loop() {
}