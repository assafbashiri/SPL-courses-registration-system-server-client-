package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.api.EncoderDecoderIMP;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.srv.Server;

public class TPCMain {
    public static void main(String [] args){
        Server.threadPerClient(
                Integer.decode(args[0]),
                ProtocolIMP::new,
                EncoderDecoderIMP::new
        ).serve();

    }
}
