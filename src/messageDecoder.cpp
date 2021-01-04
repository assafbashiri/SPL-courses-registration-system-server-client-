//
// Created by Assaf Bashiri on 1/3/21.
//

#include "messageDecoder.h"
#include <vector>
#include "vector"
#include "string"
#include <boost/algorithm/string/classification.hpp>
#include <boost/algorithm/string/split.hpp>
using namespace std;
String decode(vector<char> message);
short byteToOpcode(char opCode);
String byteToArgument(vector<char > byte);
String opcodeToString(short opcode);

String messageDecoder::decode(vector<char> message) {

}

short messageDecoder::byteToOpcode(char opCode) {
}

String messageDecoder::byteToArgument(vector<char > byte) {}

String messageDecoder::opcodeToString(short opcode) {}

