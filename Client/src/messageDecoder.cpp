//
// Created by Assaf Bashiri on 1/3/21.
//

#include "../include/messageDecoder.h"
#include <mutex>

#include "string"
#include <boost/algorithm/string/classification.hpp>

using namespace std;
//we got a message? what we need to do? we need to decode the message but what we receive? and where we use it? maybe we call the decode from the conection handler? on that string? but??? we get string as answer? probably yes or we get command bCK

messageDecoder::messageDecoder(ConnectionHandler& connectionHandler1):connectionHandler(&connectionHandler1){
}

void messageDecoder::run() {
    while (!connectionHandler->shouldTerminate) {
        string answer;
        if (!connectionHandler->getLine(answer)) {
            std::cout << "Disconnected. Exiting...\n" << std::endl;
            break;
        }

        //int len=answer.length();
        //answer.resize(len-1);
        cout << answer << endl;
        if (answer == "ACK 4") {//check
//            try {
//                terminate();
//            }catch (std::exception& e) {}
            connectionHandler->shouldTerminate = true;
            //myMutex.unlock();
        }
        connectionHandler->gotAmessage= true;
    }
}



//string messageDecoder::decoder(vector<char> curr) {

//}
//string messageDecoder::getLine() {
//}


