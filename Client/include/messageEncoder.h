//
// Created by Assaf Bashiri on 1/3/21.
//
#include "string"
#include "vector"
#include "connectionHandler.h"

#ifndef BOOST_ECHO_CLIENT_MESSAGEENCODER_H
#define BOOST_ECHO_CLIENT_MESSAGEENCODER_H
using namespace std;
class messageEncoder{
    private:
    vector<char> op_curr;
    vector<char> op_prev;
    ConnectionHandler* connectionHandler;

    public:
        messageEncoder(ConnectionHandler& connectionHandler1);
        string encode(string message);
        void shortToByte(short num , char* bytesArr);
        vector<char> argumentToByte(string argument);
        short opToNumber(string op);
        void run();
};

#endif //BOOST_ECHO_CLIENT_MESSAGEENCODER_H
