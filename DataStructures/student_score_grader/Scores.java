/*
 * Title: Scores.java
 * Description: Reads student records from a file containing ID, name, and two scores.
 *              Calculates the average score and outputs the corresponding letter grade.
 * Author: Shane Skare
 * Date: 08/27/2023
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Scores {
    public static void main(String[] args) {
        // Read the input file name
        Scanner keyboard = new Scanner (System.in);
        System.out.print("Enter a file name: ");
        String inputFilename = keyboard.next();

        Scanner inputStream = null;
        try
        {
            // Open an input stream to read from the input file.
            inputStream = new Scanner(new FileInputStream(inputFilename));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found.");
            System.exit(0);
        }

        // Read the number of students from the file.
        int studentNums = inputStream.nextInt();

        // Read each student's record (= ID, name, two exam scores).
        int id;
        String name;
        double firstScore, secondScore, average;
        for (int i=0; i < studentNums; i++)
        {
            id = inputStream.nextInt();
            name = inputStream.next();
            firstScore = inputStream.nextDouble();
            secondScore = inputStream.nextDouble();
            average =(firstScore + secondScore)/2;

            // Just display the student's record on the screen.
            System.out.print("ID: " + id);
            System.out.print(", Name: " + name);
            System.out.print(", Scores: " + firstScore + ", " + secondScore);
            System.out.print(", Average: " + average);
            if (average >= 90)
                System.out.print(", Letter Grade: A " + "\n");
            if (average <= 89.99 && average >= 80)
                System.out.print(", Letter Grade: B " + "\n");
            if (average <= 79.99 && average >= 70)
                System.out.print(", Letter Grade: C " + "\n");
            if (average <= 69.99 && average >= 60)
                System.out.print(", Letter Grade: D " + "\n");
            if (average <= 59.99)
                System.out.print(", Letter Grade: F " + "\n");
        }

        // Close the input stream of the file.
        inputStream.close();
    }
}
