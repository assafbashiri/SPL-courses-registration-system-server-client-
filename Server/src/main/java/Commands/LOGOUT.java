package Commands;

import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class LOGOUT implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        String username = protocol.getUsername();
        if (protocol.getUsername() == null)
            return "ERROR 4";
        if(!data.userChack(username) )
            return "ERROR 4"; //not registered
        User user = data.getUser(username);
        if(!user.isConnected)
            return "ERROR 4"; //not connected
        boolean output = data.disConnectUser(username);
        if(!output)
            return "ERROR 4";
        protocol.terminate();
        return "ACK 4";

        //return "ACK 4";

    }
}
