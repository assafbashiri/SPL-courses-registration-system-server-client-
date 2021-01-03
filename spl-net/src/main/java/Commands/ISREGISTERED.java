package Commands;

import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class ISREGISTERED implements Command<String[]> {


    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        User user = data.getUser(protocol.getUsername());
        int courseNumber = Integer.parseInt( arg[1]);
        Course c = data.getCourse(courseNumber);
        for (String name : c.getStudentList()){
            User user1 = data.getUser(name);
            if (user1.getUsername() == user.getUsername())
                return "REGISTERD";
        }
        return "NOT REGISTERED";
    }
}
