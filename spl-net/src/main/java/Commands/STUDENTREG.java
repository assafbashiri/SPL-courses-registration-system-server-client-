package Commands;

import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class STUDENTREG implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        String username = arg[1];
        String password = arg[2];
        if(data.userChack(username))
            return "ERROR 02"; //registered already
        else {
            User user = new Student(username,password);
            data.addUser(user);
            protocol.start(username);
        }
        return "ACK 02";
    }
}
