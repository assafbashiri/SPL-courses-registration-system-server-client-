package Commands;

import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class COURSEREG implements Command<String> {
    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        int courseNum =  Integer.parseInt(arg);
        if(arg.equals("") ||!data.courseCheck(courseNum)){
            return "ERROR 5";
        }
        Course course = data.getCourse(courseNum);
        if (course == null)
            return "ERROR 5";
        if (protocol.getUsername() == null)
            return "ERROR 5";
        User user = data.getUser(protocol.getUsername());

        if(!(user instanceof Student)){
            return "ERROR 5"; //not a student
        }


        boolean output = data.registerCourse(user.getUsername(),courseNum);
        if(!output)
            return "ERROR 5";

        return "ACK 5";

    }
}
