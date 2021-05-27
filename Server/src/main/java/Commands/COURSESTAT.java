package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;


import java.io.Serializable;

public class COURSESTAT implements Command<String> {
    private String output;

    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
            if (arg == null)
                return "ERROR 7";
            if (protocol.getUsername() == null)
                return "ERROR 7";
            if (!data.Registered())
                return "ERROR 7";//didnt registered
            User user = data.getUser(protocol.getUsername());
            if (!user.isConnected)
                return "ERROR 7";//didnt connect
            int courseNum = Integer.parseInt(arg);
             if(arg.equals("")||!data.courseCheck(courseNum)){
                return "ERROR 7";
             }
            if (!(user instanceof Admin))
                return "ERROR 7"; //not an admin
            //הוסיף הורדת שורה!!!
            return data.getCourseStatus(courseNum);

    }
}
