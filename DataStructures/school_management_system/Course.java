/**
 * Title: School.java
 * Abstract: This program preforms methods involved with course information. It is used along with the school class.
 * Author: Shane Skare
 * ID: 1481
 * Date: 10/06/23
 */

import java.util.HashMap;
public class Course {
    String name;
    String location;
    int id;
    int students;
    int enrolled;
    HashMap<Integer, Integer> Students = new HashMap<Integer, Integer>();
    public Course(String[] courseArr, int student, int id){
        this.id = id;
        this.name = courseArr[1];
        this.students = student;
        this.location = courseArr[3];
    }
    public Course(int id,String name, int student, String location){
        this.id = id;
        this.name = name;
        this.students = student;
        this.location = location;
    }
    public String getCourseName(){
        return this.name;
    }
    public String getCourseLocation(){
        return this.location;
    }
    public int getEnrollment(){
        return this.enrolled;
    }
    public int getStudents(){
        return this.students;
    }
    public int getCourseNumber(){
        return this.id;
    }
    public boolean checkStudent(int studentId){
        if(Students.containsKey(studentId))
            return true;
        else
            return false;
    }
    public void addStudentCourse(int courseId, int id){
        Students.put(id,id);
        this.enrolled++;
    }
    public void removeStudentCourse(int id){
        Students.remove(id);
        this.enrolled--;
    }
    public void updateLocation(String location) {
        this.location = location;
    }
}
