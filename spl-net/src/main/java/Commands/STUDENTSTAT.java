package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;
import java.util.List;

public class STUDENTSTAT implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        User user = data.getUser(protocol.getUsername());
        if (!(user instanceof Admin))
            return "ERROR 8 ";
        Admin admin = (Admin) user;
        Student student =(Student) data.getUser(arg[1]);
        if (student == null)
            return "ERROR 8";
        List<Integer> list= student.getCourseList();
        String toReturn = "Student: " + arg[1] +new StringBuilder().append("\n").append(" ").append("Courses: ").append(list).toString();
        return toReturn;


    }
}
