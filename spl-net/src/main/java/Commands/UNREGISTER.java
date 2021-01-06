package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;
import java.util.List;

public class UNREGISTER implements Command<String> {

    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 10";//didnt registered
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 10";//didnt connect
        if (user instanceof Admin)
            return "ERROR 10";//not a student
        Student student = (Student) user;
        List<Integer> courses = student.getCourseList();
        boolean haveCourse = data.removeCourse(protocol.getUsername(),Integer.parseInt(arg));
        if (haveCourse)
            return "ACK 10";
        return "ERROR 10";
    }
}
