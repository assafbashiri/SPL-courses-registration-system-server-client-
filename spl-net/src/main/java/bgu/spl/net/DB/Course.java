package bgu.spl.net.DB;

import java.util.*;
import java.util.List;

public class Course {
    private int idNumber;
    private String courseName;
    private Integer[] kdam;
    private int totalStudents;
    private int currStudents;
    private List<String> studentList;

    public Course(int id , String name , Integer[] kdam , int total) {
        this.idNumber = id;
        this.courseName = name;
        this.kdam = kdam;
        this.totalStudents = total;
        this.currStudents = 0;
        studentList = new ArrayList<String>();


    }
    public int getIdNumber() {
        return idNumber;
    }



    public String getCourseName() {
        return courseName;
    }



    public Integer[] getKdam() {
        return kdam;
    }


    public int getTotalStudents() {
        return totalStudents;
    }


    public int getCurrStudents() {
        return currStudents;
    }

    public List<String> getStudentList(){
        return studentList;
    }
    public boolean addStudent(String name) {
        if(currStudents==totalStudents)
            return false;
        this.currStudents = currStudents++;
        studentList.add(name);
        return true;
    }
}
