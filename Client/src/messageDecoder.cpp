//
// Created by Assaf Bashiri on 1/3/21.
//

#include "../include/messageDecoder.h"
#include <vector>
#include "vector"
#include "string"
#include <boost/algorithm/string/classification.hpp>
#include <boost/algorithm/string/split.hpp>
using namespace std;
//we got a message? what we need to do? we need to decode the message but what we receive? and where we use it? maybe we call the decode from the conection handler? on that string? but??? we get string as answer? probably yes or we get command bCK

messageDecoder::messageDecoder(ConnectionHandler& connectionHandler1){
    connectionHandler = &connectionHandler1;
}
//void messageDecoder::hey(){
    //cout<<"hey<<endl";
//}

void messageDecoder::run() {
    cout<<"we got to the decoder"<<endl;
    while (true) {
        string answer;
        if (!connectionHandler->getLine(answer)) {
            std::cout << "Disconnected. Exiting...\n" << std::endl;
            break;
        }

        //int len=answer.length();
        //answer.resize(len-1);
        cout<<answer<<endl;

        }
    }


//string messageDecoder::decoder(vector<char> curr) {

//}
//string messageDecoder::getLine() {
//}


