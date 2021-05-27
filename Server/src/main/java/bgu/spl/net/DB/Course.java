package bgu.spl.net.DB;

import java.util.*;
import java.util.List;

public class Course {
    final private int idNumber;
    final private String courseName;
    final private int[] kdam;
    final private int totalStudents;
    private int availableSeats;
    private List<String> studentList;

    public Course(int id , String name , int[] kdam , int total) {
        this.idNumber = id;
        this.courseName = name;
        this.kdam = kdam;
        this.totalStudents = total;
        this.availableSeats = total;
        this.studentList = new ArrayList<>();


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


    public synchronized int getAvailableSeats() {

            return availableSeats;

    }

    public synchronized List<String> getStudentList(){

            return studentList;

    }

    public synchronized boolean addStudent(String name) {

            if(this.availableSeats==0)
                return false;
            this.availableSeats = availableSeats - 1;
            studentList.add(name);
            java.util.Collections.sort(studentList);
            return true;


    }
    public synchronized boolean removeStudent(String username){

            if (!studentList.contains(username))
                return false;
            studentList.remove(username);
            availableSeats = availableSeats + 1;
            return true;


    }
//    private String[] sort(String[] list){
//        Arrays.sort(list);
//        return list;
//    }
}
