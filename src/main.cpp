//
// Created by spl211 on 03/01/2021.

#include <string>
#include <mutex>
#include "include/connectionHandler.h"
#include "include/messageEncoder.h"
#include "include/messageDecoder.h"
#include <thread>

using namespace std;
    int main(int argc , char *argv[]) {
        /*if (argc < 3) {
            std::cerr << "Usage: " << argv[0] << " host port" << std::endl << std::endl;
            return -1;
        }
*/
        std::mutex mutex;
        std::string host = argv[1];
        //std::string host ="127.0.0.1";
        //short port = atoi(argv[2]);
        short port = 7777;
        ConnectionHandler ch(host, port);
        if (!ch.connect()) {
            std::cerr << "Cannot connect to " << host << ":" << port << std::endl;
            return 1;
        }
        messageEncoder enc(ch);
        messageDecoder dec(ch);
        //readFromSocket socket(ch);
        thread t1(&messageEncoder::run , &enc);
        thread t2(&messageDecoder::run , &dec);

        t1.join();
        t2.join();
        return 0;
    }
