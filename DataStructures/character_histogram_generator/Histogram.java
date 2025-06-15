/**
 * Title: Histogram.java
 * Description: Reads a list of characters from a file and counts the number of times each
 *              letter (A–K) appears. Outputs a vertical histogram showing the frequency of
 *              each character using a star-based bar chart.
 * Author: Shane Skare
 * Date: 09/01/2023
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Histogram {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner (System.in);
        System.out.print("Enter a file name: ");
        String inputFilename = keyboard.next();

        Scanner inputStream = null;
        try
        {
            inputStream = new Scanner(new FileInputStream(inputFilename));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error: File not found.");
            System.exit(0);
        }
        int numLetter = inputStream.nextInt();

        char[] Letters = new char[numLetter];
        for (int i = 0; i <= numLetter-1; i++) {
            char let = inputStream.next().charAt(0);
            Letters[i] = let;
        }
        int location = 0, maxNumber = 0;
        char let = 'A';
        int[] Numbers = new int[11];

        while (let != 'L') {
            int counter = 0;
            for (int i = 0; i <= numLetter - 1; i++) {
                if (Letters[i] == let)
                    counter++;
            }
            Numbers[location] = counter;
            let++;
            location++;
            if (counter > maxNumber)
                maxNumber = counter;
        }
        let = 'A';
        System.out.println("String     Occurrence");
        for (int i = 0; i <= 10; i++) {
            if(Numbers[i] >= 1)
                System.out.println(" " + let + "             " + Numbers[i]);
            let++;
        }
        System.out.println("============= Vertical Bar =============");
        while (maxNumber != 0) {
            location = 0;
            System.out.print("|  " + maxNumber + " |");
            while (location != 11) {
                if (Numbers[location] == maxNumber) {
                    System.out.print("  *");
                    Numbers[location]--;
                }
                else System.out.print("   ");
                location++;
            }
            maxNumber--;
            System.out.println();
        }
        System.out.println("========================================");
        System.out.println("| No |  A  B  C  D  E  F  G  H  I  J  K");
        System.out.println("========================================");
    }
}

