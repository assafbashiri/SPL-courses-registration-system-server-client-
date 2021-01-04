//
// Created by Assaf Bashiri on 1/3/21.
//

#ifndef BOOST_ECHO_CLIENT_MESSAGEDECODER_H
#define BOOST_ECHO_CLIENT_MESSAGEDECODER_H

#include <string>
using namespace std;
class messageDecoder{
    private:
    public:
    char encode(string message);
    char opCodeToByte(short opCode);
    char argumentToByte(string argument);

};


#endif //BOOST_ECHO_CLIENT_MESSAGEDECODER_H
