package Commands;

import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class KDAMCHECK implements Command<String> {
    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 6";//didnt registered
        if (protocol.getUsername() == null)
            return "ERROR 6";
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 6";//didnt connect
        int courseNum = Integer.parseInt(arg);
        if(!data.courseCheck(courseNum)){
            return "ERROR 6";
        }

        if(!(user instanceof Student)){
            return "ERROR 6"; //not a student
        }
        return  data.getKdam(courseNum);
    }
}
