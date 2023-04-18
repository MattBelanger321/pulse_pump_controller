cmake_minimum_required(VERSION 3.5)

project(pulse_pump_controller LANGUAGES CXX)

list(APPEND CMAKE_MODULE_PATH "${CMAKE_BINARY_DIR}") #check the build folder (which conan uses) for 3rd party libs


add_subdirectory("arduino_client")

add_subdirectory("samples/cpp_test")