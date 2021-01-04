cmake_minimum_required(VERSION 3.17)
project(src)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(src
        connectionHandler.cpp
        echoClient.cpp
        main.cpp
        main.h
        messageDecoder.cpp
        messageDecoder.h
        messageEncoder.cpp
        messageEncoder.h)
