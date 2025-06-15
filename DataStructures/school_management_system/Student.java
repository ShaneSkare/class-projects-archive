/**
 * Title: School.java
 * Abstract: This program preforms methods involved with student information. It is used along with the school class.
 * Author: Shane Skare
 * ID: 1481
 * Date: 10/06/23
 */

import java.util.HashMap;
import java.util.Map;
import java.text.DecimalFormat;
public class Student {
    String name;
    int id;
    HashMap<Integer, Double> classScore = new HashMap<Integer, Double>();
    public Student(String[] courseArr, int id){
        this.id = id;
        this.name = courseArr[1];
    }
    public Student(int studentId, String name) {
        this.id = studentId;
        this.name = name;
    }

    public String getStudentName(){
        return this.name;
    }
    public int getStudentNumber(){
        return this.id;
    }
    public void addStudentScore(double score, int classId){
        classScore.put(classId,score);
    }
    public void removeStudentScore(int classId){
        classScore.remove(classId);
    }
    public double getScore(int classID){
        return classScore.get(classID);
    }
    public boolean findCourse(int courseId){
        if(classScore.containsKey(courseId))
            return true;
        else
            return false;
    }
    private String printLoop(){
        DecimalFormat form = new DecimalFormat("#.00");
        double sum = 0;
        int counter = 0;
        for(Map.Entry m : classScore.entrySet()) {
            System.out.printf("\n       " + form.format(m.getKey()) + ": " + form.format(m.getValue()));
            sum += classScore.get(m.getKey());
            counter++;
        }
        System.out.printf("\nCourse Average: " + form.format(sum/counter));
        return "";
    }
    public String toString() {
        System.out.print("Student Number: " + id + "\nName: " + name + "\nCourses Enrolled:");
        return printLoop();
    }

}
