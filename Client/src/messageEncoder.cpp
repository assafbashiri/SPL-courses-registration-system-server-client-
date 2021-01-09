//
// Created by Assaf Bashiri on 1/3/21.
//

#include <vector>
#include "../include/messageEncoder.h"
#include "string"
#include <boost/algorithm/string/classification.hpp>
#include <boost/algorithm/string/split.hpp>
#include <iostream>
#include <connectionHandler.h>

messageEncoder::messageEncoder(ConnectionHandler& connectionHandler1){
    connectionHandler = &connectionHandler1;
}
using namespace std;

vector<char> messageEncoder::argumentToByte(string msg) {
    vector<char> chars(msg.begin(),msg.end());
    return chars;
}
void messageEncoder::run(){
    while (true){

        const short bufsize = 1024;
        char buf[bufsize];
        cin.getline(buf, bufsize);
        string line(buf);
        int len=line.length();
        string toSend = encode(line);
        //cout<<toSend<<endl;
        //who is convert the string to utf-8?
        //maybe we need to do that.
        //encode->sendbyte
        //string toSend = "hey";
        if (!connectionHandler->sendLine( toSend )){
            cout<<"Disconnecting. Exiting...\n"<<endl;
            break;
        }
    }
}


string messageEncoder::encode(string message) {
    char delimiter = ' ';
    vector<string> words;
    boost::split(words , message ,boost::is_any_of(" "), boost::token_compress_on);
    string toReturn;
    string opCode = words[0];
    vector<char> code;
/*
    numberToshort(string opcode)
    if (opCode == "ADMINREG") {
        return 1;
    }
    short num = numberToshort("ADMINREG"); //1
    char byte[2];
    shortToByte(num,byte);
    ADMINREG mr3e 123;
    1 mr3e 123
    00 01 m r 3 e 00 1 2 3 00
}
 */
    if (opCode == "ADMINREG"){
        string username = words[1];
        string password = words[2];
        toReturn = "0001";
        //replace(username.begin(), username.end() , '0' ,'*');
        toReturn.append(username);
        toReturn.append("000/");
        //replace(password.begin(), password.end() , '0' ,'*');
        toReturn.append(password);
        toReturn.append("000/");
    }
    if (opCode == "STUDENTREG"){
        string username = words[1];
        string password = words[2];
        toReturn = "0002";
        //replace(username.begin(), username.end() , '0' ,'*');
        toReturn.append(username);
        toReturn.append("000/");
        //replace(password.begin(), password.end() , '0' ,'*');
        toReturn.append(password);
        toReturn.append("000/");
    }
    if (opCode == "LOGIN"){
        string username = words[1];
        string password = words[2];
        toReturn = "0003";
        //replace(username.begin(), username.end() , '0' ,'*');
        toReturn.append(username);
        toReturn.append("000/");
        //replace(password.begin(), password.end() , '0' ,'*');
        toReturn.append(password);
        toReturn.append("000/");
    }
    if (opCode == "LOGOUT"){
        toReturn = "0004";
    }
    if (opCode == "COURSEREG"){
        toReturn = "0005";
        toReturn.append(words[1]);
    }
    if (opCode == "KDAMCHECK"){
        toReturn = "0006";
        toReturn.append(words[1]);
    }
    if (opCode == "COURSESTAT"){
        toReturn = "0007";
        toReturn.append(words[1]);
    }
    if (opCode == "STUDENTSTAT"){
        toReturn = "0008";
        string name = words[1];
        //replace(name.begin(), name.end() , '0' ,'*');
        toReturn.append(name);
        toReturn.append("000/");
    }
    if (opCode == "ISREGISTERED"){
        toReturn = "0009";
        string name = words[1];
        //replace(name.begin(), name.end() , '0' ,'*');
        toReturn.append(name);
    }
    if (opCode == "UNREGISTER"){
        toReturn = "0010";
        toReturn.append(words[1]);
    }
    if (opCode == "MYCOURSES"){
        toReturn = "0011";
    }
    /*
    short function = opToNumber(opCode);//find the op
    char op[2];
    toReturn = "0002 ";
   // toReturn.push_back('0002');
    cout<<toReturn<<" me"<<endl;
    //toReturn.push_back(function);
    //toReturn.push_back(' ');

    shortToByte(function,op);
    cout<<op[0]<<"ehy"<<endl;
    cout<<op[1]<<"hey"<<endl;

    //toReturn.insert(toReturn.end() , op.begin() , op.end());

    if (function == 01 | function == 02 | function == 03){
    vector<char> add = argumentToByte(words[1]);
    //toReturn.push_back('00');
    add = argumentToByte(words[1]);
    toReturn.insert(toReturn.end() ,add.begin(),add.end() );
    toReturn.push_back(' ');
    toReturn.push_back('00 ');
    add = argumentToByte(words[2]);
    toReturn.insert(toReturn.end() ,add.begin(),add.end() );
    toReturn.push_back(' ');
        //op string  0 string 0
    // 5 in vector
    }
    if (function == 04 | function == 11){
    //op
    //1 in vector
    //op already in vector
    }
    if (function == 05| function == 06 | function == 07 | function == 9 | function == 10){
    //op 2byte
    // 2 in vector
    vector<char> add = argumentToByte(words[1]);
    toReturn.insert(toReturn.end() ,add.begin(),add.end() );
    }
    if (function == 8){
    //op string 0
    // 3 in vector
    vector<char> add = argumentToByte(words[1]);
    toReturn.insert(toReturn.end() ,add.begin(),add.end() );
    toReturn.push_back('00');
    }
    */
    return toReturn;
}


void messageEncoder::shortToByte(short num, char* bytesArr) {
    bytesArr[0] = ((num>>8)& 0xFF);
    bytesArr[1] = (num & 0xFF);
//do
}


short messageEncoder::opToNumber(string op) {
    if (op == "ADMINREG"){
        return 01;
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
