//start

package bgu.spl.net.impl.sub;

import bgu.spl.net.api.MessagingProtocol;

import java.time.LocalDateTime;

public class subProtocol implements MessagingProtocol<String> {
    private boolean shouldTerminate = false;

    @Override
    public String process(String msg) {
        shouldTerminate = "bye".equals(msg);
        System.out.println("[" + LocalDateTime.now() + "]: " + msg);
        return createEcho(msg);
    }

    private String createEcho(String message) {
        String echoPart = message.substring(Math.max(message.length() - 2, 0), message.length());
        return message + " .. " + echoPart + " .. " + echoPart + " ..";
    }

    @Override
    public boolean shouldTerminate() {
        return shouldTerminate;
    }

    public String adminProtocol(String msg){



        return new String("hey");//for correctness
    }
    public String studentProtocol(String msg){



        return new String("hey");//for correctness
    }
}
//finish