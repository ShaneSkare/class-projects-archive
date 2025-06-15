/*
 * Title: main_hw0_1.cpp
 * Description: Reads two integers from user input and calculates
 *              their sum and absolute difference.
 * Author: Shane Skare
 * Date: 02/06/2024
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = 0, num2 = 0, difference = 0;

        // Read two integers from input
        System.out.println("Enter two numbers");
        try {
            num = s.nextInt();
            num2 = s.nextInt();
        }
        catch(Exception e) {
            System.out.println("Incorrect input");
        }
        // Calculate and display the sum
        int sum = num + num2;
        System.out.println("Sum: " + (num + num2));
        // Calculate and display the absolute difference
        if(num > num2)
            difference = num - num2;
        else
            difference = num2 - num;
        System.out.println("Difference: " + difference);
    }
}