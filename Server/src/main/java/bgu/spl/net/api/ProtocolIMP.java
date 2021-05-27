package bgu.spl.net.api;

import Commands.*;




public class ProtocolIMP implements MessagingProtocol<String> {
    private boolean shouldTerminate;
    private String username;


    public ProtocolIMP() {
        this.shouldTerminate = false;
        this.username=null;
    }
    public void terminate(){
        shouldTerminate=true;
    }
    public String getUsername()
    {
        return username;
    }
    public void start(String username1){
        this.username = username1;
    }

    @Override
    public String process(String msg) {
        if (msg.length() < 4)
            return "ERROR- WRONG TYPING";
        String op = msg.substring(0,4);
        msg = msg.substring(4);

        if (op.equals("0001")) {
            if(msg.equals(""))
                return "ERROR 1";
            String [] msgLines = msg.split("000/");
            return (String) new ADMINREG().execute(msgLines, this);
        }
        else if (op.equals("0002")) {
            String [] msgLines = msg.split("000/");
            if(msg.equals(""))
                return "ERROR 2";

            return (String) new STUDENTREG().execute(msgLines, this);
        }
        else if (op.equals("0003")) {

            String [] msgLines = msg.split("000/");

            if(msg.equals(""))
                return "ERROR 3";
            return (String) new LOGIN().execute(msgLines, this);
        }
        else if (op.equals("0004")) {
            String [] msgLines = msg.split("000/");
            return (String) new LOGOUT().execute(msgLines, this);
        }
        else if (op.equals("0005")) {
            if(msg.equals(""))
                return "ERROR 5";
            return (String) new COURSEREG().execute(msg, this);
        }
        else if (op.equals("0006")) {
            if(msg.equals(""))
                return "ERROR 6";
            return (String) new KDAMCHECK().execute(msg, this);
        }
        else if (op.equals("0007")) {
            if(msg.equals(""))
                return "ERROR 7";
            return (String) new COURSESTAT().execute(msg, this);
        }
        else if (op.equals("0008")) {
            if(msg.equals(""))
                return "ERROR 8";
            return (String) new STUDENTSTAT().execute(msg.substring(0,(msg.length()-4)), this);
        }
        else if (op.equals("0009")) {
            if(msg.equals(""))
                return "ERROR 9";
            return (String) new ISREGISTERED().execute(msg , this);
        }
        else if (op.equals("0010")) {
            if(msg.equals(""))
                return "ERROR 10";
            return (String) new UNREGISTER().execute(msg, this);
        }
        else if (op.equals("0011")) {
            return (String) new MYCOURSES().execute(" ", this);
        }
        else
            return "ERROR"+op;
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }

}