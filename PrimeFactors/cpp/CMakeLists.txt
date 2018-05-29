cmake_minimum_required(VERSION 3.10.2 FATAL_ERROR)
project(factors)
set(CMAKE_CXX_STANDARD 11)
add_executable(${CMAKE_PROJECT_NAME} main.cpp)

unset(GMOCK_LIB CACHE)
find_library(GMOCK_LIB
        NAMES gmock
        PATHS $ENV{gtest}/lib
)

unset(GTEST_LIB CACHE)
find_library(GTEST_LIB
        NAMES gtest
        PATHS $ENV{gtest}/lib
)

include_directories(
        $ENV{gtest}/include
)

target_link_libraries(${CMAKE_PROJECT_NAME}
        ${GTEST_LIB}
        ${GMOCK_LIB}
)
