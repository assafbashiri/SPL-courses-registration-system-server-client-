package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
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
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 11";//didnt connect
        if (user instanceof Admin)
            return "ERROR 11";//not a student
        if (user == null)
            return "ERROR 11";//why?
        Student student =(Student) user;
        List<Integer> list = student.getCourseList();
        return list.toString();//לבדוק
    }
}
