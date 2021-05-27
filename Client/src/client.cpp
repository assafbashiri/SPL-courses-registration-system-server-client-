//
// Created by spl211 on 03/01/2021.
#include <string>
#include <mutex>
#include "../include/connectionHandler.h"
#include "../include/messageEncoder.h"
#include "../include/messageDecoder.h"
#include <thread>
#include <boost/algorithm/string/classification.hpp>

using namespace std;
    int main(int argc , char *argv[]) {
        if (argc < 3) {
            std::cerr << "Usage: " << argv[0] << " host port" << std::endl << std::endl;
            return -1;
        }
       // mutex* _mutex=new std::mutex;
        mutex _mutex;
        std::string host = argv[1];
        short port = atoi(argv[2]);
        ConnectionHandler ch(host, port);
        if (!ch.connect()) {
            std::cerr << "Cannot connect to " << host << ":" << port << std::endl;
            return 1;
        }
        messageEncoder enc(ch);
        messageDecoder dec(ch);
        thread t1(&messageEncoder::run,&enc);
        dec.run();


        t1.join();
      
        return 0;
    }
