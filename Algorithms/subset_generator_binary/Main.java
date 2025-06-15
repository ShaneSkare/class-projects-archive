/*
 * Title: Main.java
 * Description: Generates all possible subsets of a given list using binary representation.
 *              Each subset is represented with a binary flag and the corresponding elements.
 * Author: Shane Skare
 * Date: 02/15/2024
 */

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        String initial = "0";
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            array.add(i,s.next());
            if(i < size -1)
                initial += '0';
        }
        System.out.println("0:" + initial + ":EMPTY");
        for(int i = 1; i < Math.pow(2,size); i++){
            String str = "";
            int binaryNum = i;
            while (binaryNum > 0) {
                if ((binaryNum & 1) == 1) // 1
                    str += '1';
                else // 0
                    str += '0';
                binaryNum >>= 1; // Right Shift by 1
            }
            String list = "", formatted = "";
            for (int k = str.length() - 1; k >= 0; k--){
                formatted += str.charAt(k);
            }
            while(formatted.length() != size){
                formatted = '0' + formatted;
            }
            for(int j = 0; j < size; j++) {
                if (formatted.charAt(j) == '1') {
                    if (list == "") {
                        list += array.get(j);
                    }
                    else{
                        list += " " + array.get(j);
                    }
                }
            }
            System.out.println(i + ":" + formatted + ":" + list);
        }
   }
}