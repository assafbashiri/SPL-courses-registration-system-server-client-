package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;
import java.util.List;

public class STUDENTSTAT implements Command<String> {
    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 08";//didnt registered
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 08";//didnt connect
        if (!(user instanceof Admin))
            return "ERROR 08";//not an admin
        Admin admin = (Admin) user;
        Student student =(Student) data.getUser(arg);
        if (student == null || data.userChack(student.getUsername()))
            return "ERROR 08";//student is not exist
        List<Integer> list= student.getCourseList();
        String toReturn = "Student: " + arg +
                new StringBuilder().append("\n").append(" ").append("Courses: ").append(list).toString(); //מה זה?
        return toReturn;


    }
}
