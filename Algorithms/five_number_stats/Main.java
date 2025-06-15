        /*
         * Title: main_hw0_1.cpp *
         * Description: Reads five integers from user input and calculates
         *              the minimum, maximum, and median.
         * Author: Shane Skare
         * Date: 02/06/2024
         */
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int difference = 0;

        System.out.println("Enter five numbers");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        // Insert numbers in sorted order as they are entered
        for (int i = 0; i < 5; i++) {
            int num = s.nextInt();
            // Insert number in correct position to maintain sorted list
            if (numbers.isEmpty() || num >= numbers.get(numbers.size() - 1)) {
                numbers.add(num);
            } else {
                for (int j = 0; j < numbers.size(); j++) {
                    if (num < numbers.get(j)) {
                        numbers.add(j, num);
                        break;
                    }
                }
            }
        }
        // Output results
        System.out.println("Min:" + numbers.get(0));
        System.out.println("Max:" + numbers.get(4));
        System.out.println("Median:" + numbers.get(2));
    }
}