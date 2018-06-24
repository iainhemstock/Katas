cmake_minimum_required(VERSION 3.10.2 FATAL_ERROR)
project(bank)
set(CMAKE_CXX_STANDARD 11)

set(SOURCES
        main.cpp
        src/Account.cpp
        src/Transaction.cpp
        src/Console.cpp
        src/StatementPrinter.cpp
        src/TransactionRepository.cpp
        src/Date.cpp
)

set(TEST_SOURCES
        tests/Feature_AccountShouldPrintStatementOfAccount.cpp
        tests/AccountShould.cpp
        tests/TransactionRepositoryShould.cpp
        tests/DateShould.cpp
        tests/StatementPrinterShould.cpp
)

add_executable(${CMAKE_PROJECT_NAME}
        ${SOURCES}
        ${TEST_SOURCES}
)

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
        inc
        inc/mocks
        inc/interfaces
        $ENV{gtest}/include
)

target_link_libraries(${CMAKE_PROJECT_NAME}
        ${GTEST_LIB}
        ${GMOCK_LIB}
)
