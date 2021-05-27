package bgu.spl.net.DB;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    private final List<Integer> courseList ;

    public Student(String username, String password){
        super(username , password);
        this.courseList = new ArrayList<>();
    }

    public String getUsername() {
        return super.username;
    }

    public  List<Integer> getCourseList(){
        return courseList;
    }


    public String getPassword() {
        return super.password;
    }

    public  void addCourse(int courseNum){
        courseList.add(courseNum);
    }

    public boolean removeCourse(int courseNum){
        for (int i = 0; i < courseList.size() ; i++){
            if (courseList.get(i) == courseNum) {
                courseList.remove(i);
                return true;

            }
        }
        return false;
    }
}
