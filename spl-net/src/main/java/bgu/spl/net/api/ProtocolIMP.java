package bgu.spl.net.api;

import Commands.*;
import bgu.spl.net.DB.Admin;
import bgu.spl.net.DB.Database;
import bgu.spl.net.DB.Student;
import bgu.spl.net.DB.User;
import bgu.spl.net.impl.rci.Command;

import java.awt.*;

public class ProtocolIMP implements MessagingProtocol<String> {
    private boolean shouldTerminate;
    private String username;
    //private Connections<String> connections;
    private Database data= Database.getInstance();

    public ProtocolIMP() {
        this.shouldTerminate = false;
        this.username=null;
    }
    public String getUsername(){
        return username;
    }
    public void start(String username){
        this.username=username;
    }

    @Override
    public String process(String msg) {
        String [] msgLines = msg.split(" ");
        int opcode ;
        if (msgLines[0].equals("ADMINREG"))
            return (String) new ADMINREG().execute(msgLines,this);
        if (msgLines[0].equals("STUDENTREG"))
            return (String) new STUDENTREG().execute(msgLines,this);
        if (msgLines[0].equals("LOGIN"))
            return (String) new LOGIN().execute(msgLines,this);
        if (msgLines[0].equals("LOGOUT"))
            return (String) new LOGOUT().execute(msgLines,this);
        if (msgLines[0].equals("COURSEREG"))
            return (String) new COURSEREG().execute(msgLines,this);
        if (msgLines[0].equals("KDAMCHECK"))
            return (String) new KDAMCHECK().execute(msgLines,this);
        if (msgLines[0].equals("COURSESTAT"))
            return (String) new COURSESTAT().execute(msgLines,this);
        if (msgLines[0].equals("STUDENTSTAT"))
            return (String) new STUDENTSTAT().execute(msgLines,this);
        if (msgLines[0].equals("ISREGISTERED"))
            return (String) new ISREGISTERED().execute(msgLines,this);
        if (msgLines[0].equals("UNREGISTER"))
            return (String) new UNREGISTER().execute(msgLines,this);
        if (msgLines[0].equals("MYCOURSES"))
            return (String) new MYCOURSES().execute(msgLines,this);

        return null;
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
    public void terminate(){
        shouldTerminate=true;
    }

}