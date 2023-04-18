cmake_minimum_required(VERSION 3.5)

project(cpp_test LANGUAGES CXX)

add_executable(${PROJECT_NAME}
    "main.cpp"
)

target_compile_features(${PROJECT_NAME} PRIVATE cxx_std_20)

target_include_directories(${PROJECT_NAME}
    PUBLIC
    $<INSTALL_INTERFACE:include/${PROJECT_NAME}>
    $<BUILD_INTERFACE:${CMAKE_CURRENT_SOURCE_DIR}/include>

    PRIVATE
)

target_link_libraries(${PROJECT_NAME}
    PRIVATE
    arduino_client
)