/**
 * Title: SumAverage.java
 * Description: This program prompts the user for a positive integer, calculates the
 *              sum from 1 to that number, and then computes and prints the average.
 *              It includes input validation and allows the user to repeat the process.
 * Author: Shane Skare
 * Date: 09/05/2023
 */

import java.util.Scanner;
public class SumAverage {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        boolean done = false;
        int sum = 0, divisor, k;
        double average;
        String continueChoice = "Y";

        while(continueChoice.equals ("Y")){

            while (!done) {
                System.out.print("Enter an integer number: ");
                try {
                    k = keyboard.nextInt();
                    if (k >= 0){
                    divisor = k;
                    System.out.print("Sum: ");
                    while(k != 0) {
                        sum += k;
                        if (k > 1)
                            System.out.print(k + " + ");
                        k--;
                    }
                        System.out.println("1 --> " + sum);
                        average = ((double) sum)/divisor;
                        System.out.printf("Average: " + sum + "/" + divisor + " --> " + "%.2f%n", average);
                        done = true;
                        sum=0;
                    }
                        else {
                        System.out.println("No result for a negative integer.");
                        done = true;
                    }
                }
                catch(Exception error) {
                    System.out.println("Incorrect input.");
                }
                keyboard.nextLine();
            }
            System.out.print("Continue(Y/N)?");
            try {
                continueChoice = keyboard.nextLine();
                if(continueChoice.equals("N")) {
                    System.out.println("Bye.");
                    break;
                }
                else if (continueChoice.equals("Y")) {
                        done = false;
                }
                else {
                    System.out.println("Incorrect input.");
                    continueChoice = "Y";
                }
            }
            catch(Exception error) {
                    System.out.println("Incorrect input.");
            }
        }
    }
}
