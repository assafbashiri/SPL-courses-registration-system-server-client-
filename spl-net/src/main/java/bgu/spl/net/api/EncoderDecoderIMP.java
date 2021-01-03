package bgu.spl.net.api;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncoderDecoderIMP implements MessageEncoderDecoder<String> {
    private byte[] bytes = new byte[1 << 10];
    private int length = 0;

    public EncoderDecoderIMP(){}

    @Override
    public String decodeNextByte(byte nextByte) {
        if (nextByte == '\0') {
            return popString();
        }
        pushByte(nextByte);
        return null; // we dont have all the message yet.
    }

    @Override
    public byte[] encode(String message) {
        return (message+"\0").getBytes();
    }

    private void pushByte(byte nextByte) {
        if (length >= bytes.length) {
            bytes = Arrays.copyOf(bytes, length * 2);
        }
        bytes[length++] = nextByte;
    }

    private String popString() {
        String result = new String(bytes, 0, length, StandardCharsets.UTF_8);
        length = 0;
        return result;
    }
}
