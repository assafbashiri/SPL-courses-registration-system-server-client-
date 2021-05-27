package Commands;

import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class ISREGISTERED implements Command<String> {


    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 9";//didnt registered
        if (protocol.getUsername() == null)
            return "ERROR 9";
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 9";//didnt login
        if(!(user instanceof Student))
            return "ERROR 9"; //not a student
        int courseNumber = Integer.parseInt( arg);
        if(arg.equals("")||!data.courseCheck(courseNumber)){
            return "ERROR 9";
        }
        return data.isReg(protocol.getUsername(),courseNumber);
    }
}
