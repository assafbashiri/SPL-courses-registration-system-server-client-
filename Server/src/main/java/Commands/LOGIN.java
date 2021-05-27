package Commands;

import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class LOGIN implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        String username = arg[0];
        String password = arg[1];
        if(username==null||password==null)
            return "ERROR 3";
        if(protocol.getUsername()!=null){
            return "ERROR 3";
        }
        if(!data.userChack(username))
            return "ERROR 3"; //not register
        User user = data.getUser(username);
        if(!data.passCheck(username , password))
            return "ERROR 3"; //wrong password
        if (user.isConnected)
            return "ERROR 3"; //connected already
        boolean output = data.connectUser(username);
        if(!output)
            return "ERROR 3";
        protocol.start(username);
        return "ACK 3";
    }
}
