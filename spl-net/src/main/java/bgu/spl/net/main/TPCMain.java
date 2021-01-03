package bgu.spl.net.main;

import bgu.spl.net.api.EncoderDecoderIMP;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.srv.Server;

public class TPCMain {
    public static void tpcMain(String port){
        Server.threadPerClient(
                Integer.decode(port),
                ProtocolIMP::new,
                EncoderDecoderIMP::new
        ).serve();

    }
}
