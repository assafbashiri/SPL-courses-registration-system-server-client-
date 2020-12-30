package bgu.spl.net.api;

import bgu.spl.net.DB.Database;
import bgu.spl.net.DB.User;

import java.awt.*;

public class ProtocolIMP implements MessagingProtocol<String> {
    private boolean shouldTerminate;
    private String username;
    //private int connectionId;
    //private Connections<String> connections;
    private Database data;

    public ProtocolIMP() {
        this.data = Database.getInstance();
        this.shouldTerminate = false;
        this.username=null;
    }

    public void start(String username){
        this.username = username;

    }
    
    @Override
    public String process(String msg) {
        String [] msgLines = msg.split("\n");
        int opcode = numOfMsg(msgLines[0]);

        return null;
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
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