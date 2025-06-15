/*
 * Title: Main.java
 * Description: Reverses the digits of an integer using recursion.
 *              Handles both positive and negative numbers.
 * Author: Shane Skare
 * Date: 03/09/2024
 */

import java.util.Scanner;
public class Main {
    public static String numberInput = "";
    public static String numberOutput = "";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        numberInput = s.nextLine();
        if(numberInput.charAt(0) == '-'){
            numberOutput += "-";
            numberInput = numberInput.substring(1);
        }
        int length = numberInput.length() - 1;
        reverseString(length);
        System.out.println(Integer.parseInt(numberOutput));
    }
    public static int reverseString(int length){
        if(length == 0){
            numberOutput += numberInput.charAt(length);
            return 0;
        }
        else{
            numberOutput += numberInput.charAt(length);
            return reverseString(length - 1);
        }
    }
}