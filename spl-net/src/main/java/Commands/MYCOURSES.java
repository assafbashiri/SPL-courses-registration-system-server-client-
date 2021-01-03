package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;
import java.util.List;

public class MYCOURSES implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        User user = data.getUser(protocol.getUsername());
        if (user == null || user instanceof Admin)
            return "ERROR 11";
        Student student =(Student) user;
        List<Integer> list = student.getCourseList();
        return list.toString();//לבדוק
    }
}
