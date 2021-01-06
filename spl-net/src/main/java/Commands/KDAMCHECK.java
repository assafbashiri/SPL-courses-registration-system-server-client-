package Commands;

import bgu.spl.net.DB.Course;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class KDAMCHECK implements Command<String> {
    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 06";//didnt registered
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 06";//didnt connect
        int courseNum = Integer.parseInt(arg);
        Course course = data.getCourse(courseNum);
        if(!(user instanceof Student)){
            return "ERROR 06"; //not a student
        }
        String toReturn = "[";
        int[] kdam = course.getKdam();
        for (int i = 0; i<kdam.length ; i++ ) {
            toReturn = toReturn + kdam[i];
            if (i < kdam.length-1)
                toReturn = toReturn+",";
        }
        toReturn = toReturn+"]";
        return toReturn;
    }
}
