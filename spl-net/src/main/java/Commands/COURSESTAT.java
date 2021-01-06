package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;
import bgu.spl.net.DB.Database;

import java.io.Serializable;

public class COURSESTAT implements Command<String> {
    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 07";//didnt registered
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 07";//didnt connect
        int courseNum = Integer.parseInt(arg);
        Course course = data.getCourse(courseNum);
        if(!(user instanceof Admin))
            return "ERROR 07"; //not an admin
        //הוסיף הורדת שורה!!!
        String output = "Course: ("+courseNum+") "+ course.getCourseName() +"/n"+
                "Seats Available: " + course.getAvailableSeats()+ "/" + course.getTotalStudents() +"/n"+
                "Students Registered:" + course.getStudentList().toString();
        return output;
    }
}
