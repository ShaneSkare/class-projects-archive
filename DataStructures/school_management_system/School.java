/**
 * Title: School.java
 * Description: Implements a `School` class that manages students, instructors, and courses.
 *              Handles reading data from a file and supports operations such as registration,
 *              enrollment, grading, searching, and course deletion using related class objects.
 * Author: Shane Skare
 * Date: 10/06/2023
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class School {
    private final String schoolName;
    HashMap<Integer, Instructor> instructor = new HashMap<Integer, Instructor>();
    HashMap<Integer, Student> student = new HashMap<Integer, Student>();
    HashMap<Integer, Course> course = new HashMap<Integer, Course>();
    public School(String aName) {
        this.schoolName = aName;
    }
    public String getSchoolName(){
        return schoolName;
    }
    public void readData(String file){

        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(file));
        }
        catch(FileNotFoundException e) {
            System.out.println("Error: File not found.");
            System.exit(0);
        }
        int numInstructors = inputStream.nextInt();
        inputStream.nextLine();

        for (int i = 0; i <= numInstructors-1; i++) {
            String instructors = inputStream.nextLine();
            String[] instructorArr = instructors.split(",", 5);
            int id = Integer.parseInt(instructorArr[0]);
            if(instructor.containsKey(id))
                System.out.println("Instructor info reading failed – Employee number " + id + " already used.");
            else {
                Instructor Inst = new Instructor(instructorArr, id);
                instructor.put(id, Inst);
            }
        }
        int numCourses = inputStream.nextInt();
        inputStream.nextLine();

        for (int i = 0; i <= numCourses-1; i++) {
            String courses = inputStream.nextLine();
            String[] courseArr = courses.split(",", 5);
            int id = Integer.parseInt(courseArr[0]);
            int student = Integer.parseInt(courseArr[2]);
            if(course.containsKey(id))
                System.out.println("Course info reading failed – Course number " + id + " already used.");
            else {
                Course Cour = new Course(courseArr,student, id);
                course.put(id, Cour);
            }
        }
        int numStudents = inputStream.nextInt();
        inputStream.nextLine();

        for (int i = 0; i <= numStudents-1; i++) {
            String students = inputStream.nextLine();
            String[] studentArr = students.split(",", 5);
            int id = Integer.parseInt(studentArr[0]);
            if(student.containsKey(id))
                System.out.println("Student info reading failed – Student ID " + id + " already used.");
            else {
                Student Stud = new Student(studentArr, id);
                student.put(id, Stud);
            }
        }
        System.out.println("Done.");
    }
    public void schoolInfo(){
        System.out.println("School Name: " + getSchoolName());
        System.out.println("Instructor Information");
        for(Instructor k:instructor.values())
            System.out.println("       " + k.getInstructorName());
        System.out.println("Course Information");
        for(Course k:course.values())
            System.out.println("       " + k.getCourseName());
        System.out.println("Student Information");
        for(Student k:student.values())
            System.out.println("       " + k.getStudentName());
    }
    public void searchByEmail(String mail) {
        System.out.println("Search key: " + mail);
        for(Instructor k:instructor.values()) {
            if (k.getInstructorEmail().equals(mail)) {
                System.out.println("       Employee Number: " + k.getInstructorNumber());
                System.out.println("       Name: " + k.getInstructorName());
                System.out.println("       Phone: " + k.getInstructorPhone());
                return;
            }
        }
        System.out.println("       No employee with email " + mail);
    }
    public void addInstructor(int id, String name, String email, String phone) {
        if(instructor.containsKey(id))
            System.out.println("Instructor info reading failed – Employee number " + id + " already used.");
        else {
            Instructor Inst = new Instructor(id, name, email, phone);
            instructor.put(id, Inst);
        }
    }
    public void addCourse(int id, String name, int students, String location) {
        if(course.containsKey(id))
            System.out.println("Course addition failed – Course number " + id + " already used.");
        else {
            Course Cour = new Course(id, name, students, location);
            course.put(id, Cour);
        }
    }
    public void assignInstructor(int courseId, int instructorId) {
        if(instructor.containsKey(instructorId) && (course.containsKey(courseId)))
            for (Instructor k : instructor.values())
                if(k.getInstructorNumber() == instructorId)
                    for (Course j : course.values())
                        if(j.getCourseNumber() == courseId){
                            k.addInstructorCourse(courseId, instructorId);
                            return;
                }
        if(!instructor.containsKey(instructorId) && (course.containsKey(courseId))) {
            System.out.println("Instructor " + instructorId + " does not exist.");
        }
        if(instructor.containsKey(instructorId) && (!course.containsKey(courseId)))
            System.out.println("Course " + courseId + " does not exist.");
    }
    public void register(int courseId, int studentId){
        if(student.containsKey(studentId) && (course.containsKey(courseId)))
            for (Course k : course.values()) {
                if(k.getCourseNumber() == courseId)
                    if (k.getEnrollment() >= k.getStudents()) {
                     System.out.println("Registration failed – Class is full.");
                     return;
                     }
                if (k.getCourseNumber() == courseId) {
                    k.addStudentCourse(courseId, studentId);
                    for (Instructor e : instructor.values())
                        if (e.checkCourse(courseId)) {
                            e.addEnrolled(courseId);
                            break;
                        }
                    return;
                }
            }
        if(!student.containsKey(studentId) && (course.containsKey(courseId))) {
            System.out.println("Student " + studentId + " does not exist.");
        }
        if(student.containsKey(studentId) && (!course.containsKey(courseId)))
            System.out.println("Course " + courseId + " does not exist.");
    }
    public void putScore(int courseId, int studentId, double score){
        if(student.containsKey(studentId) && (course.containsKey(courseId)))
            for (Student k : student.values())
                if(k.getStudentNumber() == studentId)
                    for (Course j : course.values())
                        if(j.checkStudent(studentId)){
                            k.addStudentScore(score,courseId);
                            return;
                        }
        if(!student.containsKey(studentId) && (course.containsKey(courseId))) {
            System.out.println("Student " + studentId + " does not exist.");
            return;
        }
        if(student.containsKey(studentId) && (!course.containsKey(courseId))) {
            System.out.println("Course " + courseId + " does not exist.");
            return;
        }
        for (Student k : student.values())
            if(k.getStudentNumber() == studentId)
                System.out.println("Student " + studentId + " (" + k.getStudentName() + ") is not enrolled in " + courseId + ".");

    }
    public void unRegister(int courseId, int studentId){
        if(student.containsKey(studentId) && (course.containsKey(courseId)))
            for (Course k : course.values())
                if(k.getCourseNumber() == courseId) {
                    k.removeStudentCourse(studentId);
                    for (Student j : student.values())
                        if (j.getStudentNumber() == studentId) {
                            j.removeStudentScore(courseId);
                            for (Instructor e : instructor.values())
                                if (e.checkCourse(courseId)) {
                                    e.unEnrolled(courseId);
                                    break;
                                }
                            return;
                        }
                }
        if(!student.containsKey(studentId) && (course.containsKey(courseId))) {
            System.out.println("Student " + studentId + " does not exist.");
        }
        if(student.containsKey(studentId) && (!course.containsKey(courseId)))
            System.out.println("Course " + courseId + " does not exist.");
    }
    public void courseInfo(int courseId){
        if(course.containsKey(courseId)){
            System.out.println("Course number: " + courseId);
            for (Instructor k : instructor.values())
                if(k.checkCourse(courseId)) {
                    System.out.println("Instructor " + k.getInstructorName());
                    break;
                }
            for (Course j : course.values())
                if(j.getCourseNumber() == courseId){
                    System.out.println("Course title: " + j.getCourseName());
                    System.out.println("Room: " + j.getCourseLocation());
                    System.out.println("Total enrolled: " + j.getEnrollment());
                    int totalStudents = j.getEnrollment();
                    double sum = 0;
                    for (Student w : student.values())
                        if(w.findCourse(courseId)) {
                            sum += w.getScore(courseId);
                        }
                    double average = sum/totalStudents;
                    if(totalStudents == 0)
                        System.out.println("Course Average: NA");
                    else
                        System.out.println("Course Average: " + average);
                    break;
                }
        }
        if(!course.containsKey(courseId)) {
            System.out.println("Student " + courseId + " does not exist.");
        }
    }
    public void courseInfo(){
        System.out.println("Number of Courses: " + course.size());
    for (Course j : course.values())
            System.out.println("      " + j.getCourseNumber() + ": " + j.getEnrollment() + " enrolled");
    }
    public Course getCourse(int id){
        if(course.containsKey(id))
            return course.get(id);
        return null;
    }
    public void deleteCourse(int courseId){
        if(!course.containsKey(courseId))
            return;
        Course j = course.get(courseId);
        if(j.getEnrollment() > 0) {
                System.out.print("\nCourse deletion failed – Enrolled student(s) in the class.");
                return;
        }
        course.remove(courseId);
    }
    public void addStudent(int studentId, String name) {
        Student Stud = new Student(studentId, name);
        student.put(studentId, Stud);
    }
    public Instructor getInstructor(int courseId){
        if(course.containsKey(courseId))
            for (Instructor k : instructor.values())
                if(k.checkCourse(courseId)) {
                    int num = k.getInstructorNumber();
                    return instructor.get(num);
                }
        return null;
    }
    public Student getStudent(int studentId){
        if(student.containsKey(studentId))
            return student.get(studentId);
        else
            return null;

    }
    public void graduateStudent(int studentId){
        if(student.containsKey(studentId))
            student.remove(studentId);
        for (Course j : course.values())
            if(j.checkStudent(studentId)){
                j.removeStudentCourse(studentId);
            }
    }
}
