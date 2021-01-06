package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class ISREGISTERED implements Command<String> {


    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 09";//didnt registered
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 09";//didnt login
        if(!(user instanceof Student))
            return "ERROR 09"; //not a student
        int courseNumber = Integer.parseInt( arg);
        Course c = data.getCourse(courseNumber);
        for (String name : c.getStudentList()){
            User user1 = data.getUser(name);
            if (user1.getUsername() == user.getUsername())
                return "REGISTERED";
        }
        return "NOT REGISTERED";
    }
}
