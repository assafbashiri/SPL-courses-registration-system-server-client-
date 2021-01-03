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

    public List<Integer> getCourseList(){
        return courseList;
    }


    public String getPassword() {
        return password;
    }

    public void addCourse(int courseNum){
        courseList.add(courseNum);
    }

    public boolean removeCourse(int courseNum){
        for (int num : courseList){
            if (num == courseNum) {
                courseList.remove(courseNum);
                return true;
            }
        }
        return false;
    }
}
