/*
 * Title: Main.java
 * Description: Uses a divide-and-conquer technique to find the smallest number
 *              in an array of integers. Implements a recursive minimum search.
 * Author: Shane Skare
 * Date: 03/17/2024
 */
import java.util.Scanner;
    public class Main {
        static int lowestValue = Integer.MAX_VALUE;

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int size = s.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                    array[i] = s.nextInt();
            }
            System.out.println(getLowestValue(array, 0, size - 1));
        }

        static int getLowestValue(int A[], int start, int end) {
            if (start == end)
                return A[start];
            else {
                int first = getLowestValue(A, start, (start + end) / 2);
                int second = getLowestValue(A, (start + end) / 2 + 1, end);
                if (first < lowestValue)
                        lowestValue = first;
                if (second < lowestValue)
                        lowestValue = second;
                return lowestValue;
            }
        }
    }