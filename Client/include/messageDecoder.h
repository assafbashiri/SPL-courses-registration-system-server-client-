//
// Created by Assaf Bashiri on 1/3/21.
//
#include "vector"
#include "connectionHandler.h"

#ifndef BOOST_ECHO_CLIENT_MESSAGEDECODER_H
#define BOOST_ECHO_CLIENT_MESSAGEDECODER_H
#include <string>
using namespace std;
class messageDecoder{
private:
    //short op_curr;
    //short op_prev;
    ConnectionHandler* connectionHandler;
public:
    //string decoder(vector<char>);
    //string getLine();
    //string getBytes();
    //string readfromkeyboard();
    messageDecoder(ConnectionHandler& connectionHandler1);
    void run();
    static void hey();
};


#endif //BOOST_ECHO_CLIENT_MESSAGEDECODER_H
