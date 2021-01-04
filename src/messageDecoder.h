//
// Created by Assaf Bashiri on 1/3/21.
//

#ifndef BOOST_ECHO_CLIENT_MESSAGEDECODER_H
#define BOOST_ECHO_CLIENT_MESSAGEDECODER_H

#include <string>
using namespace std;
class messageDecoder{
    private:
    short opcodeCurr;
    short opcodePrev;
    public:
    String decode(vector<char> message);
    short byteToOpcode(char opCode);
    String byteToArgument(vector<char > byte);
    String opcodeToString(short opcode);

};


#endif //BOOST_ECHO_CLIENT_MESSAGEDECODER_H
