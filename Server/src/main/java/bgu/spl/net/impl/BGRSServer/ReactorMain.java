package bgu.spl.net.impl.BGRSServer;

import bgu.spl.net.DB.Database;
import bgu.spl.net.api.EncoderDecoderIMP;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.srv.Server;

public class ReactorMain {
    public static void main(String [] args){
        Server.reactor(
                Integer.decode(args[1]),
                Integer.decode(args[0]),
                ProtocolIMP::new,
                //ProtocolIMP::new,
                EncoderDecoderIMP::new
                //EncoderDecoderIMP::new
        ).serve();

    }

}
