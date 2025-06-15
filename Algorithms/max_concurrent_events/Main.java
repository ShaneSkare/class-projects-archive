/*
 * Title: Main.java
 * Description: Reads a list of events with time intervals and determines the
 *              maximum number of overlapping (concurrent) events.
 * Author: Shane Skare
 * Date: 02/22/2024
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int counter = 0;

        int events = s.nextInt();
        int[] dailyPlanner = new int[25];
        for(int i = 0; i < events; i++) {
            int first = s.nextInt();
            int last = s.nextInt();
            for(int j = first; j <= last; j++){
                dailyPlanner[j] += 1;
            }
        }
        for(int iter : dailyPlanner){
            if(iter>counter)
                counter = iter;
        }
        System.out.print("Max events: " + counter);
    }
}