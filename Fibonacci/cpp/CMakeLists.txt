cmake_minimum_required(VERSION 3.10.2 FATAL_ERROR)
project(fib)
set(CMAKE_CXX_STANDARD 11)

find_library(GTEST_LIB
        NAMES gtest
        PATHS $ENV{gtest}/lib
)

find_library(GMOCK_LIB
        NAMES gmock
        $ENV{gtest}/lib
)

include_directories(
        $ENV{gtest}/include
)

add_executable(${CMAKE_PROJECT_NAME} main.cpp)

target_link_libraries(${CMAKE_PROJECT_NAME}
        ${GTEST_LIB}
        ${GMOCK_LIB}
)
