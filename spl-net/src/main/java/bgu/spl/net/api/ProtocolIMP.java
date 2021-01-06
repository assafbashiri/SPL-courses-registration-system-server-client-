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
        if (msg.length() < 4)
            return "ERROR- WRONG";
        System.out.println(msg+"  lets seee");
        //System.out.println(msg.substring(0,3));
        String op = msg.substring(0,4);
        msg = msg.substring(4);
        //String [] msgLines = msg.split("00");
       // int opcode ;
        System.out.println("processs step "+op);
        if (op.equals("0001")) {
            String [] msgLines = msg.split("00");
            return (String) new ADMINREG().execute(msgLines, this);
        }
        else if (op.equals("0002")) {
            String [] msgLines = msg.split("00");
            return (String) new STUDENTREG().execute(msgLines, this);
        }
        else if (op.equals("0003")) {
            String [] msgLines = msg.split("00");
            return (String) new LOGIN().execute(msgLines, this);
        }
        else if (op.equals("0004")) {
            String [] msgLines = msg.split("00");
            return (String) new LOGOUT().execute(msgLines, this);
        }
        else if (op.equals("0005")) {
           // String [] msgLines = msg.split("00");
            return (String) new COURSEREG().execute(msg, this);
        }
        else if (op.equals("0006")) {
            //String [] msgLines = msg.split("00");
            return (String) new KDAMCHECK().execute(msg, this);
        }
        else if (op.equals("0007")) {
            //String [] msgLines = msg.split("00");
            return (String) new COURSESTAT().execute(msg, this);
        }
        else if (op.equals("0008")) {
            //String [] msgLines = msg.split("00");
            return (String) new STUDENTSTAT().execute(msg.substring(0,(msg.length()-2)), this);
        }
        else if (op.equals("0009")) {
            //String [] msgLines = msg.split("00");
            return (String) new ISREGISTERED().execute(msg , this);
        }
        else if (op.equals("0010")) {
            //String[] msgLines = msg.split("00");
            return (String) new UNREGISTER().execute(msg, this);
        }
        else if (op.equals("0011")) {
            //String[] msgLines = msg.split("00");
            return (String) new MYCOURSES().execute(" ", this);
        }
        else
            return "ERROR"+op;
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }
    public void terminate(){
        shouldTerminate=true;
    }

}