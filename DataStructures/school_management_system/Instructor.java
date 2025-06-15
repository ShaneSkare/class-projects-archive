/**
 * Title: School.java
 * Abstract: This program preforms methods involved with instructor information. It is used along with the school class.
 * Author: Shane Skare
 * ID: 1481
 * Date: 10/06/23
 */

import java.util.HashMap;
import java.util.Map;
public class Instructor {
    String name;
    String email;
    int number;
    int enrolled;
    String phone;
    HashMap<Integer, Integer> courses = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> studentsInCourse = new HashMap<Integer, Integer>();
    public Instructor(String[] instructorArr, int id) {
        this.name = instructorArr[1];
        this.email = instructorArr[2];
        this.number = id;
        this.phone = instructorArr[3];
    }
    public Instructor(int id, String aName, String aEmail, String aPhone) {
        this.name = aName;
        this.email = aEmail;
        this.number = id;
        this.phone = aPhone;
    }
    public String getInstructorName(){
        return name;
    }
    public String getInstructorEmail(){
        return email;
    }
    public int getInstructorNumber(){
        return number;
    }
    public String getInstructorPhone(){
        return phone;
    }
    public void addInstructorCourse(int id, int instID){
        courses.put(id, instID);
    }
    public boolean checkCourse(int id) {
        if(courses.containsKey(id))
            return true;
        else
            return false;
    }
    public void addEnrolled(int id) {
        if (studentsInCourse.get(id) == null)
            studentsInCourse.put(id,1);
        else
            studentsInCourse.put(id,studentsInCourse.get(id) + 1);
    }
    public void unEnrolled(int id) {
        studentsInCourse.put(id,studentsInCourse.get(id) - 1);
    }
    private String printLoop(){
        for(Map.Entry m : studentsInCourse.entrySet())
                System.out.print("\n       " + m.getKey()+": "+m.getValue()+" enrolled");
        return "";
    }
    public String toString() {
        System.out.print("Instructor Number: " + number + "\nName: " + name + "\nCourses Teaching:");
        return printLoop();
    }
}
