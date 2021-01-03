package bgu.spl.net.main;

import bgu.spl.net.srv.Reactor;

public class Main {
    public static void main(String args[]){
        if(args.length==1){
            TPCMain.tpcMain(args[0]);
        }
        else{
            ReactorMain.reactorMain(args[0],args[1]);
        }
    }
}
