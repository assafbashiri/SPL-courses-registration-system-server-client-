package bgu.spl.net.main;

import bgu.spl.net.api.EncoderDecoderIMP;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.srv.Server;

public class ReactorMain {
    public static void main(String[] args){
        String port = args[0];
        Server.reactor(
                Runtime.getRuntime().availableProcessors(),
                Integer.decode(port),
                ProtocolIMP::new,
                EncoderDecoderIMP::new
        ).serve();
    }

}