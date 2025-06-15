/**
 * Title: Timestamp.java
 * Description: This program reads two timestamps (HH:MM:SS format) from the user and
 *              calculates the difference between them, accounting for rollover past midnight.
 *              It validates time format and provides the difference in HH:MM:SS format.
 * Author: Shane Skare
 * Date: 09/19/2023
 */

import java.util.Scanner;
import java.text.DecimalFormat;
public class Timestamp {
    public static void main(String[] args) {

        String time1, time2, temp;
        int hour1, hour2, minute1, minute2, second1, second2;
        int finalH, finalM, finalS;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("--------- Welcome to Timestamp ---------");
        System.out.print("1st timestamp - ");
        time1 = keyboard.next();
        System.out.print("2nd timestamp - ");
        time2 = keyboard.next();

        try {
            temp = time1.substring(0, 2);
            hour1 = Integer.parseInt(temp);

            temp = time1.substring(3, 5);
            minute1 = Integer.parseInt(temp);

            temp = time1.substring(6, 8);
            second1 = Integer.parseInt(temp);

            temp = time2.substring(0, 2);
            hour2 = Integer.parseInt(temp);

            temp = time2.substring(3, 5);
            minute2 = Integer.parseInt(temp);

            temp = time2.substring(6, 8);
            second2 = Integer.parseInt(temp);

            if (second1 > 59 || second2 > 59){
                System.out.println("Incorrect input.");
                return;
            }
            if(second2 < second1) {
                minute2--;
                second2 += 60;
                finalS = second2 - second1;
            }
            else
                finalS = second2 - second1;

            if (minute1 > 59 || minute2 > 59){
                System.out.println("Incorrect input.");
                return;
            }
            if(minute2 < minute1) {
                hour2--;
                minute2 += 60;
                finalM = minute2 - minute1;
            }
            else
                finalM = minute2 - minute1;

            if (hour1 > 23 || hour2 > 23){
                System.out.println("Incorrect input.");
                return;
            }
            if(hour1 <= hour2)
                finalH = hour2 - hour1;
            else
                finalH = (24 - hour1) + hour2;

            DecimalFormat fmat = new DecimalFormat("00");
            System.out.printf("Result - " + fmat.format(finalH));
            System.out.printf(":" + fmat.format(finalM));
            System.out.printf(":" + fmat.format(finalS));
        }
        catch(Exception error) {
            System.out.println("Incorrect input.");
        }
    }
}
