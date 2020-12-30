package bgu.spl.net.DB;

public class Admin extends User{



    public Admin(String username, String password){
        super(username , password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
