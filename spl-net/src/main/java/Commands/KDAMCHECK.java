package Commands;

import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class KDAMCHECK implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        int courseNum = Integer.parseInt(arg[1]);
        Course course = data.getCourse(courseNum);
        User user = data.getUser(protocol.getUsername());
        if(!(user instanceof Student)){
            return "ERROR 06"; //not a student
        }
        return course.getKdam().toString(); //לבדוק
    }
}
