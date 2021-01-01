package Commands;

import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class COURSESTAT implements Command<String[]> {
    @Override
    public Serializable execute(String[] arg, ProtocolIMP protocol) {
        User user = data.getUser(protocol.getUsername());
        int courseNum = Integer.parseInt(arg[1]);
        Course course = data.getCourse(courseNum);
        if(!(user instanceof Admin))
            return "ERROR 07"; //not a admin
        //הוסיף הורדת שורה!!!
        String output = "Course: ("+courseNum+") "+ course.getCourseName() +
                "Seats Available: " + course.getAvailableSeats()+ "/" + course.getTotalStudents() +
                "Students Registered:" + course.getStudentList().toString();
        return output;
    }
}
