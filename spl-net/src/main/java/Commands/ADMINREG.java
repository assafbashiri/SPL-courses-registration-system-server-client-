package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class ADMINREG implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        String username = arg[1];
        String password = arg[2];
        if (data.userChack(username))
            return "ERROR 01"; //registered already
        else {
            User user = new Admin(username, password);
            data.addUser(user);
            protocol.start(username);
        }
        return "ACK 01";
    }
}
