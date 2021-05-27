package Commands;

import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class STUDENTREG implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        if (arg.length < 2)
            return "ERROR 2";//empty string array
        String username = arg[0];
        String password = arg[1];
        if (username == null | password == null )
            return "ERROR 2";
        if(protocol.getUsername()!=null)
            return "ERROR 2";
        if(data.userChack(username))
            return "ERROR 2"; //registered already
        boolean output = data.addStudent(username,password);
        if(!output)
            return "ERROR 2";

        return "ACK 2";
    }
}
