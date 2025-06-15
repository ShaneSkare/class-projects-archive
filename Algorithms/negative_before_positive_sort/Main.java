/*
 * Title: Main.java
 * Description: Reads a list of integers and rearranges them so that all negative numbers
 *              appear before all positive numbers. Uses two different in-place approaches.
 * Author: Shane Skare
 * Date: 04/04/2024
 * Reference: https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> numbersTwo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int number = s.nextInt();
            numbers.add(number);
            numbersTwo.add(number);
        }

        int i = 0;
        int j = numbers.size() - 1;
        while(j > i) {
            if (numbers.get(i) > 0 && numbers.get(j) < 0) {
                int temp = numbers.get(i);
                numbers.add(i, numbers.get(j));
                numbers.remove(i+1);
                numbers.remove(j);
                numbers.add(j, temp);
            } else if (numbers.get(i) < 0) {
                i++;
            } else if (numbers.get(j) > 0) {
                j--;
            }
        }
        for(int num : numbers){
            if (num == numbers.get(numbers.size() - 1)){
                System.out.println(num);
            }
            else {
                System.out.print(num + " ");
            }
        }

        i = numbersTwo.size() - 1;
        j = numbersTwo.size() - 1;
        while(i > 0 && j > 0) {
            while (numbersTwo.get(i) >= 0 && i >= 0) {
                i--;
            }
            if (numbersTwo.get(i) <= 0) {
                j = i - 1;
                while (numbersTwo.get(j) <= 0 && j > 0) {
                    j--;
                }
            }
            if (numbersTwo.get(i) < 0 && numbersTwo.get(j) > 0) {
                int temp = numbersTwo.get(i);
                numbersTwo.add(i, numbersTwo.get(j));
                numbersTwo.remove(i + 1);
                numbersTwo.remove(j);
                numbersTwo.add(j, temp);
            }
        }
        for(int num : numbersTwo) {
            if (num == numbersTwo.get(numbersTwo.size() - 1)) {
                System.out.print(num);
            } else {
                System.out.print(num + " ");
            }
        }
    }
}