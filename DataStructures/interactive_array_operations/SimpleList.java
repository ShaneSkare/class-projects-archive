/**
 * Title: SimpleList.java
 * Description: A basic interactive array manipulation program. It initializes a list
 *              with 10 integers and provides options to delete a value, append a new
 *              value, and reverse the list. The array is updated after each operation.
 * Author: Shane Skare
 * Date: 08/30/2023
 */
import java.util.Scanner;

public class SimpleList {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int[] Value = {10, 20, 30, 40, 50, 15, 25, 35, 45, 55};
        System.out.print("Array Values: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(Value[i] + " ");
            if (i == 9) System.out.println();
        }
        System.out.println("This is a list of operations.");
        System.out.println("1. Delete a number");
        System.out.println("2. Append a number");
        System.out.println("3. Reverse array");

        char Pick = 'y';
        while (Pick != 'n' && Pick != 'N') {
            System.out.print("Enter your choice: ");
            int Num, Head, Choice = keyboard.nextInt();

            if (Choice >= 4 || Choice <= 0)
                System.out.println("Error, entered unidentified number " + Choice);

            if (Choice == 1) {
                System.out.print("Enter a number to delete: ");
                Num = keyboard.nextInt();
                for (int counter = 0; counter <= 9; counter++)
                    if (Value[counter] == Num) {
                        while (Value[counter] != 0 && counter != 9) {
                            counter++;
                            Head = Value[counter--];
                            Value[counter] = Head;
                            counter++;
                        }
                        Value[counter] = 0;
                        counter = 0;
                    }
            }
            if (Choice == 2) {
                System.out.println("Enter a number to Append: ");
                Num = keyboard.nextInt();
                int counter = 0;
                if (Value[counter] == 0)
                    Value[counter] = Num;

                while (Value[counter] != 0 && counter != 9){
                    counter++;
                }
                Value[counter]=Num;
            }
            if (Choice == 3) {
                int first = 0, last = 0, half, placeHolder;
                while (Value[last] != 0 && (last != 9))
                    last++;
                if (Value[last] == 0)
                    last--;
                half = last / 2;
                for (int i = 0; i <= half; i++) {
                    placeHolder = Value[first];
                    Value[first++] = Value[last];
                    Value[last--] = placeHolder;
                }
            }
            System.out.print("New Array Values: ");
            for (int i = 0; i < 10; i++){
                System.out.print(Value[i] + " ");
                if (i == 9)
                    System.out.println();
            }
            System.out.println("Continue? (Y/N) :");
            Pick = keyboard.next().charAt(0);
        }
    }
}