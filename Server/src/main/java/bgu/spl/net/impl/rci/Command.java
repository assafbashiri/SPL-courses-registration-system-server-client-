package bgu.spl.net.impl.rci;

import bgu.spl.net.DB.Database;
import bgu.spl.net.api.ProtocolIMP;

import java.io.Serializable;

public interface Command<T> extends Serializable {
    public static Database data = Database.getInstance();

    Serializable execute(T arg,ProtocolIMP protocol);
}
