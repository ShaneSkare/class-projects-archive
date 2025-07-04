# School Management System

This Java project models a basic school system with classes for instructors, students, and courses. The School class manages interactions between these entities, allowing for instructor assignment, course enrollment, grading, and student management.

## Components

- School.java: Main logic for data loading, operations, and interaction between entities.
- Instructor.java: Represents an instructor with attributes like name, email, phone, and assigned courses.
- Course.java: Represents a course with location, enrollment count, and capacity.
- Student.java: Stores student info, enrolled courses, and scores.
- main.java: Driver program to interact with the School object using user input.

## Features

- Load instructors, courses, and students from a file
- Assign instructors to courses
- Register and unregister students
- Add and remove instructors, courses, and students
- Score students and compute course averages
- Print course and instructor info
- Perform validations on data consistency

## How to Run

### Compile
javac *.java

### Run
java main

## Input File Format (example)
2
1001,John Smith,john@example.com,555-1234
1002,Jane Doe,jane@example.com,555-5678
2
2001,Math 101,30,Room A
2002,History 201,25,Room B
3
3001,Alice
3002,Bob
3003,Charlie

shell
Copy
Edit

## Sample Output
School Name: Sample School
Instructor Information
John Smith
Jane Doe
Course Information
Math 101
History 201
Student Information
Alice
Bob
Charlie

Copy
Edit

