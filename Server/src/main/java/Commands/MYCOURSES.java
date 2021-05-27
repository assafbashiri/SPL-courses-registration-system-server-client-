package Commands;

import bgu.spl.net.DB.Admin;

import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;
import java.util.List;

public class MYCOURSES implements Command<String> {
    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 11";//didnt registered
        if (protocol.getUsername() == null)
            return "ERROR 11";
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 11";//didnt connect
        if (user instanceof Admin)
            return "ERROR 11";//not a student

        List<Integer> list = data.getMyCourses(user.getUsername());
        return  "ACK 11\n"+list.toString().replaceAll("\\s+" , "");//לבדוק

    }
}
