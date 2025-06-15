/*
 * Title: Main.java
 * Description: Solves a variation of the knapsack problem by finding the best subset of items
 *              based on weight and value constraints. Prints the selected item(s), total capacity used,
 *              and maximum value achieved. Handles cases with multiple solutions.
 * Author: Shane Skare
 * Date: 02/23/2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String item = "";
        int capacity = 0, value = 0;

        int size = s.nextInt();
        final int startingCapacity = s.nextInt();

        int[] weightArray = new int[size];
        int[] valueArray = new int[size];

        for (int i = 0; i < size; i++) {
            weightArray[i] = s.nextInt();
            valueArray[i] = s.nextInt();
        }
        for (int i = 0; i < weightArray.length; i++){
            int first = weightArray[i];
            int firstValue = valueArray[i];
            for (int j = 1; j < weightArray.length; j++){
                int second = weightArray[j];
                if(first + second <= startingCapacity && value <= firstValue + valueArray[j]){
                    if(firstValue == value){
                        item += " " + String.valueOf(j+1);
                    }
                    else if(value == firstValue + valueArray[j]){
                        item = "Multiple solutions";
                    }
                    else{
                        item = String.valueOf(i+1) + " " + String.valueOf(j+1);
                    }
                    value = firstValue + valueArray[j];
                    firstValue = value;
                    first += second;
                    capacity = first;
                }
                else if(first != weightArray[i]){
                    first = weightArray[i];
                    firstValue = valueArray[i];
                    j--;
                }
                else if (first < startingCapacity && value < firstValue){
                    value = firstValue;
                    capacity = first;
                    item = String.valueOf(i+1);
                }
            }
        }
        System.out.println("Item:" + item);
        System.out.println("Capacity:" + capacity);
        System.out.print("Value:" + value);
    }
}