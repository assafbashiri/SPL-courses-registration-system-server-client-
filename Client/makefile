LDFLAGS:=-lboost_system
INCLUDEPATH+="C:\Users\glevy\Downloads\boost_1_75_0"
# All Targets
all: bin/BGRsclient

# Tool invocations
# Executable "BGRsclient" depends on the files BGRsclient.o connectionHandler.o echoClient.o messageEncoder.o messageDecoder.o
bin/BGRsclient: bin/BGRsclient.o bin/connectionHandler.o bin/echoClient.o  messageEncoder.o messageDecoder.o
	@echo 'Building target: BGRsclient'
	@echo 'Invoking: C++ Linker'
	g++ -o bin/BGRsclient bin/BGRsclient.o bin/connectionHandler.o bin/echoClient.o  messageEncoder.o messageDecoder.o $(LDFLAGS)
	@echo 'Finished building target: BGRsclient'
	@echo ' '

#BGRsclient.o Depends on the source and header files src/BGRsclient.cpp include/connectionHandler.h
bin/BGRsclient.o: src/BGRsclient.cpp
	g++ -g -Wall -Weffc++ -std=c++11 -c -Iinclude -o bin/BGRsclient.o src/BGRsclient.cpp

#connectionHandler.o Depends on the source and header files src/connectionHandler.cpp include/connectionHandler.h
bin/connectionHandler.o: src/connectionHandler.cpp
	g++ -g -Wall -Weffc++ -std=c++11 -c -Iinclude -o bin/connectionHandler.o src/connectionHandler.cpp $(LDFLAGS)

#echoClient.o Depends on the source and header files src/echoClient.cpp include/echoClient.h
bin/echoClient.o: src/echoClient.cpp
	g++ -g -Wall -Weffc++ -std=c++11 -c -Iinclude -o bin/echoClient.o src/echoClient.cpp

#messageDecoder.o Depends on the source and header files src/echoClient.cpp include/echoClient.h
bin/messageDecoder.o: src/messageDecoder.cpp
	g++ -g -Wall -Weffc++ -std=c++11 -c -Iinclude -o bin/messageDecoder.o src/messageDecoder.cpp

#messageEncoder.o Depends on the source and header files src/echoClient.cpp include/echoClient.h
bin/messageEncoder.o: src/messageEncoder.cpp
	g++ -g -Wall -Weffc++ -std=c++11 -c -Iinclude -o bin/messageEncoder.o src/messageEncoder.cpp

#Clean the build directory
clean:
	rm -f bin/*
