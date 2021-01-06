
cmake_minimum_required(VERSION 3.17)
project(Client)


set(Boost_USE_STATIC_LIBS OFF)
set(Boost_USE_MULTITHREADED ON)
set(Boost_USE_STATIC_RUNTIME OFF)
#[[find_package(Boost 1.45.0 COMPONENTS *boost libraries here*)

if(Boost_FOUND)
    include_directories(${Boost_INCLUDE_DIRS})
    add_executable(progname file1.cxx file2.cxx)
    target_link_libraries(progname ${Boost_LIBRARIES})
endif()]]

set(CMAKE_CXX_STANDARD 11)
link_libraries("-lboost_system")
link_libraries("-pthread")
include_directories(include)

add_executable(src
        src/BGRsclient.cpp
        src/connectionHandler.cpp
        src/messageDecoder.cpp
        src/messageEncoder.cpp
        src/echoClient.cpp
        include/messageDecoder.h
        include/messageEncoder.h
        include/connectionHandler.h)
