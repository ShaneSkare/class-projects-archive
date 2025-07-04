# Student Score Grader

This Java program reads student data from a file that includes student ID, name, and two exam scores. It calculates the average of the scores and outputs each student’s ID, name, individual scores, average, and corresponding letter grade.

## File Format
The input file should begin with an integer indicating the number of students, followed by each student's data:
<number_of_students>
<ID> <Name> <Score1> <Score2>
...

shell
Copy
Edit

### Example:
3
1234 Alice 95.5 88.0
5678 Bob 82.0 79.5
9101 Carol 67.0 59.0

shell
Copy
Edit

## Output:
ID: 1234, Name: Alice, Scores: 95.5, 88.0, Average: 91.75, Letter Grade: A
ID: 5678, Name: Bob, Scores: 82.0, 79.5, Average: 80.75, Letter Grade: B
ID: 9101, Name: Carol, Scores: 67.0, 59.0, Average: 63.0, Letter Grade: D

shell
Copy
Edit

## How to Run

### Compile
javac Scores.java

### Run
java Scores

You will be prompted to enter a file name containing the student data.

