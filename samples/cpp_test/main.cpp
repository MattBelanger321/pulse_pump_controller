#include <arduino_client.hpp>

#include <iostream>

int main()
{
    pulse_pump_controller::arduino_client cli;

    std::cout << cli.hello_world();
}