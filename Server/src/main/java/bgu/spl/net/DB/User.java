package bgu.spl.net.DB;

public class User {
    protected String username;
    protected String password;
    public boolean isConnected;

    public User(String username , String password){
        this.username = username;
        this.password = password;
        this.isConnected=false;
    }
    public void connect(){
        this.isConnected=true;
    }
    public void disConnect(){
        this.isConnected=false;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
