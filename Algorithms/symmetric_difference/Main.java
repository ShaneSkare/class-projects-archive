/*
 * Title: Main.java
 * Description: Computes the symmetric difference between two sets of integers.
 *              It reads two groups of numbers from input, removes duplicates,
 *              and outputs the final list in descending order.
 * Author: Shane Skare
 * Date: 02/08/2024
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        // Read first group size and numbers
        System.out.print("Enter size of first group of numbers followed by the numbers.\nSize:");
        int gSize = s.nextInt();
        for (int i = 0; i < gSize; i++) {
            int num = s.nextInt();
            // Only add if not already in the list (set behavior)
            if(numbers.contains(num)){continue;}
            numbers.add(num);
        }

        // Read second group size and numbers
        System.out.print("Enter size of second group of numbers followed by the numbers.\nSize:");
        int g2Size = s.nextInt();
        for (int i = 0; i < g2Size; i++) {
            int num = s.nextInt();
            // If number exists, remove it; otherwise, add it
            if(numbers.contains(num))
                numbers.removeAll(Collections.singleton(num));
            else
                numbers.add(num);
        }
        // Output result
        System.out.print("Answer:");
        if(numbers.isEmpty())
            System.out.print("NONE");
        else {
            numbers.sort(Collections.reverseOrder());
            for (Integer num : numbers) {
                if(num == numbers.get(numbers.size()-1))
                    System.out.print(num);
                else
                    System.out.print(num+" ");
            }
        }
    }
}