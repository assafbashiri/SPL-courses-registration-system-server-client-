package bgu.spl.net.main;

import bgu.spl.net.DB.Database;
import bgu.spl.net.srv.Reactor;

public class Main {
    public static void main(String args[]){
        Database database = Database.getInstance();
        System.out.println(database.getCourse(101).getIdNumber());
        if(args.length==1){
            TPCMain.tpcMain(args[0]);
        }
        else{
            ReactorMain.reactorMain(args[0],args[1]);
        }
    }
}
