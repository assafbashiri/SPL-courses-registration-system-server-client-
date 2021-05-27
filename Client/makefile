CFLAGS:=-c -Wall -Weffc++ -g -std=c++11 -Iinclude
LDFLAGS:=-lboost_system -pthread

all: bin/BGRSclient

bin/BGRSclient: bin/connectionHandler.o bin/echoClient.o bin/messageDecoder.o bin/messageEncoder.o bin/client.o
	@echo "Building target: bin/BGRSclient"
	g++ -o bin/BGRSclient bin/connectionHandler.o bin/echoClient.o bin/messageDecoder.o bin/messageEncoder.o bin/client.o $(LDFLAGS)
	@echo "finished Linking"

bin/connectionHandler.o: src/connectionHandler.cpp
	g++ $(CFLAGS) -o bin/connectionHandler.o src/connectionHandler.cpp

bin/echoClient.o: src/echoClient.cpp
	g++ $(CFLAGS) -o bin/echoClient.o src/echoClient.cpp

bin/messageDecoder.o: src/messageDecoder.cpp
	g++ $(CFLAGS) -o bin/messageDecoder.o src/messageDecoder.cpp


bin/messageEncoder.o: src/messageEncoder.cpp
	g++ $(CFLAGS) -o bin/messageEncoder.o src/messageEncoder.cpp

bin/client.o: src/client.cpp
	g++ $(CFLAGS) -o bin/client.o src/client.cpp

.PHONY: clean
clean:
	rm -f bin/*
