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
        Course course = data.getCourse(courseNum);
        User user = data.getUser(protocol.getUsername());

        if(!(user instanceof Student)){
            return "ERROR 05"; //not a student
        }
        for(int i =0;i<course.getKdam().length;i++){
            if(!((Student) user).getCourseList().contains(course.getKdam()[i]))
                return "ERROR 05"; //dont have a course kdam
        }
        if(((Student) user).getCourseList().contains(courseNum) )
            return "ERROR 05";//the student is registered to the course
        if(course.getAvailableSeats()==0)
            return "ERROR O5"; //the course is full
        else {
            data.registerCourse(user.getUsername(),courseNum);
        }
        return "ACK 05";

    }
}
