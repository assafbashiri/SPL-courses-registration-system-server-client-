package Commands;

import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class ADMINREG implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        if (arg.length < 2)
            return "ERROR 1";//empty string array
        String username = arg[0];
        String password = arg[1];
        if (username == null | password == null )
            return "ERROR 1";
        if(protocol.getUsername()!=null)
            return "ERROR 1";
        if (data.userChack(username))
            return "ERROR 1"; //registered already
        boolean output = data.addAdmin(username,password);
        if(!output)
            return "ERROR 1";


        return "ACK 1";
    }
}
