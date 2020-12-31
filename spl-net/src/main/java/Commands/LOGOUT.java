package Commands;

import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class LOGOUT implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        String username = protocol.getUsername();
        if(data.userChack(username) )
            return "ERROR 04"; //not registered
        User user = data.getUser(username);
        if(!user.isConnected)
            return "ERROR 04"; //not connected
        else {
            user.disConnect();
            protocol.terminate();
        }
        return "ACK 04";

    }
}
