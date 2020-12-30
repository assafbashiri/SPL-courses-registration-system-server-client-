package bgu.spl.net.DB;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{

    private String username;
    private String password;
    private List<Integer> courseList ;

    public Student(String username, String password){
        super(username , password);
        this.courseList = new ArrayList<Integer>();
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public void addCourse(int courseNum){
        courseList.add(courseNum);
    }

}
