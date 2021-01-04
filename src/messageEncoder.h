//
// Created by Assaf Bashiri on 1/3/21.
//
#include "string"
#include "vector"
#ifndef BOOST_ECHO_CLIENT_MESSAGEENCODER_H
#define BOOST_ECHO_CLIENT_MESSAGEENCODER_H
using namespace std;
class messageEncoder{
    private:
    public:
        messageEncoder()noexcept;
        vector<char> encode(string message);
        void shortToByte(short num , vector<char> bytesArr);
        vector<char> argumentToByte(string argument);
        short opToNumber(string op);
};

#endif //BOOST_ECHO_CLIENT_MESSAGEENCODER_H