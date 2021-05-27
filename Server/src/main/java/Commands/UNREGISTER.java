package Commands;

import bgu.spl.net.DB.Admin;

import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class UNREGISTER implements Command<String> {

    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 10";//didnt registered
        if (protocol.getUsername() == null)
            return "ERROR 10";
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 10";//didnt connect
        if (user instanceof Admin)
            return "ERROR 10";//not a student

        if(!data.courseCheck(Integer.parseInt(arg))){
            return "ERROR 10";
        }
        boolean haveCourse = data.removeCourse(protocol.getUsername(),Integer.parseInt(arg));
        if (haveCourse)
            return "ACK 10";
        return "ERROR 10";
    }
}
