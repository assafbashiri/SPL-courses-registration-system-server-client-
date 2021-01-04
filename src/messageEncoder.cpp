//
// Created by Assaf Bashiri on 1/3/21.
//

#include <vector>
#include "messageEncoder.h"
#include "vector"
#include "string"
#include <boost/algorithm/string/classification.hpp>
#include <boost/algorithm/string/split.hpp>
messageEncoder::messageEncoder() noexcept{}
using namespace std;

vector<char> messageEncoder::argumentToByte(string argument) {
    int n = argument.length();

    char char_array[n + 1];

    strcpy(char_array, argument.c_str());
    return char_array;
}

vector<char> messageEncoder::encode(string message) {
    char delimiter = ' ';
    vector<string> words;
    boost::split(words , message ,boost::is_any_of(" "), boost::token_compress_on);
    vector<char> toReturn;
    string opCode = words[0];
    short function = opToNumber(opCode);//find the op
    char op = opCodeToByte(function);
    if (op == 01 | op == 02 | op == 03){
    toReturn.push_back(op);
    vector<char> arg = argumentToByte(words[1]);
    for (char a:arg){
        toReturn.push_back(a);
    }
    vector<char> add = argumentToByte(words[1]);
    toReturn.insert(toReturn.end() ,add.begin(),add.end() );
    toReturn.push_back('0');
    add = argumentToByte(words[2]);
    toReturn.insert(toReturn.end() ,add.begin(),add.end() );
    toReturn.push_back('0');
    //op string  0 string 0
    // 5 in vector
    }
    if (op == 04 | op == 11){
    //op
    //1 in vector
    toReturn.push_back(op);
    }
    if (op == 05| op == 06 | op == 07 | op == 9 | op == 10){
    //op 2byte
    // 2 in vector
    toReturn.push_back(op);
    toReturn.push_back(argumentToByte(words[1]));
    }
    if (op == "08"){
    //op string 0
    // 3 in vector
    toReturn.push_back(op);
    toReturn.push_back(argumentToByte(words[1]));
    toReturn.push_back('0');
    }
    return toReturn;
}

short messageEncoder::stringToShort(String function) {}

char messageEncoder::opCodeToByte(short opCode) {

}


short messageEncoder::opToNumber(String op) {
    if (op == "ADMINREG"){
        return (short)01;
    }
    if (op == "STUDENTREG"){
        return (short)02;
    }
    if (op == "LOGIN"){
        return (short)03;
    }
    if (op == "LOGOUT"){
        return (short)04;
    }
    if (op == "COURSEREG"){
        return (short)05;
    }
    if (op == "KDAMCHECK"){
        return (short)06;
    }
    if (op == "COURSESTAT"){
        return (short)07;
    }
    if (op == "STUDENTSTAT"){
        return (short)8;
    }
    if (op == "ISREGISTERED"){
        return (short)9;
    }
    if (op == "UNREGISTER"){
        return (short)10;
    }
    if (op == "MYCURSES"){
        return (short)11;
    }
}
