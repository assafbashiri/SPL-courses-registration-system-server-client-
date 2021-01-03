package Commands;

import bgu.spl.net.api.ProtocolIMP;
import bgu.spl.net.impl.rci.Command;

import java.io.Serializable;

public class ERRORCOMMAND implements Command<Integer> {

    @Override
    public Serializable execute(Integer arg, ProtocolIMP protocol) {
        return null;
    }
}
