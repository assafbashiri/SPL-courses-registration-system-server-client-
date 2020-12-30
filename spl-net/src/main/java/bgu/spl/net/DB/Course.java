package bgu.spl.net.DB;

import java.util.*;
import java.util.List;

public class Course {
    private int idNumber;
    private String courseName;
    private int[] kdam;
    private int totalStudents;
    private int currStudents;
    private List<String> studentList;

    public Course(int id , String name , int[] kdam , int total) {
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



    public int[] getKdam() {
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
    public void addStudent(String name) {
        this.currStudents = currStudents++;
        studentList.add(name);
    }
}
