package bgu.spl.net.api;

import Commands.ADMINREG;
import Commands.LOGIN;
import Commands.STUDENTREG;
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
            return (String) new ADMINREG().execute(msgLines,this);
        if (msgLines[0].equals("COURSEREG"))
            return (String) new ADMINREG().execute(msgLines,this);
        if (msgLines[0].equals("KDAMCHECK"))
            return (String) new ADMINREG().execute(msgLines,this);
        if (msgLines[0].equals("COURSESTAT"))
            return (String) new ADMINREG().execute(msgLines,this);
        if (msgLines[0].equals("STUDENTSTAT"))
            return (String) new ADMINREG().execute(msgLines,this);
        if (msgLines[0].equals("ISREGISTERED"))
            return (String) new ADMINREG().execute(msgLines,this);
        if (msgLines[0].equals("UNREGISTER"))
            return (String) new ADMINREG().execute(msgLines,this);
        if (msgLines[0].equals("MYCOURSES"))
            return (String) new ADMINREG().execute(msgLines,this);


/*
        if(opcode==1){
            String username = msgLines[1];
            String password = msgLines[2];
            if(data.userChack(username))
                return "ERROR 01";
            else {
                User user = new Admin(username,password);
                data.addUser(user);
            }
        }
        if(opcode == 2){
            String username = msgLines[1];
            String password = msgLines[2];
            if(data.userChack(username))
                return "ERROR 02";
            else {
                User user = new Student(username,password);
                data.addUser(user);
            }
        }
        if (opcode ==3){
            String username = msgLines[1];
            String password = msgLines[2];
        }
*/
        return null;
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
    public void terminate(){
        shouldTerminate=true;
    }
    public int numOfMsg(String msg){
        int output = -1 ;
        if (msg.equals("ADMINREG"))
            output = 1;
        if (msg.equals("STUDENTREG"))
            output = 2;
        if (msg.equals("LOGIN"))
            output = 3;
        if (msg.equals("LOGOUT"))
            output = 4;
        if (msg.equals("COURSEREG"))
            output = 5;
        if (msg.equals("KDAMCHECK"))
            output = 6;
        if (msg.equals("COURSESTAT"))
            output = 7;
        if (msg.equals("STUDENTSTAT"))
            output = 8;
        if (msg.equals("ISREGISTERED"))
            output = 9;
        if (msg.equals("UNREGISTER"))
            output = 10;
        if (msg.equals("MYCOURSES"))
            output = 11;

        return output;
    }
}