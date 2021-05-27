package Commands;

import bgu.spl.net.DB.Admin;

import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;


public class STUDENTSTAT implements Command<String> {
    @Override
    public Serializable execute(String arg, ProtocolIMP protocol) {
        if (!data.Registered())
            return "ERROR 8";//didnt registered
        if (protocol.getUsername() == null)
            return "ERROR 8";
        User user = data.getUser(protocol.getUsername());
        if (!user.isConnected)
            return "ERROR 8";//didnt connect
        if (!(user instanceof Admin))
            return "ERROR 8";//not an admin
        if (data.getUser(arg) == null) {
            return "ERROR 8";
        }
        Student student =(Student) data.getUser(arg);
        if (student == null )
            return "ERROR 8";
        if(!data.userChack(student.getUsername()))
            return "ERROR 8";//student is not exist
        return data.studentStatus(arg);



    }
}
