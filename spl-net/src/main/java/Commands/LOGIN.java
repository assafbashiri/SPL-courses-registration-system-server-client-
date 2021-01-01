package Commands;

import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class LOGIN implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        String username = arg[1];
        String password = arg[2];
        if(!data.userChack(username))
            return "ERROR 03"; //not register
        User user = data.getUser(username);
        if(user.getPassword()!=password)
            return "ERROR 03"; //wrong password
        if (user.isConnected)
            return "ERROR 03"; //connected already
        else {
            data.connectUser(username);
        }
        return "ACK 03";
    }
}
