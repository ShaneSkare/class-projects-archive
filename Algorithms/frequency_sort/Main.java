/*
 * Title: Main.java
 * Description: Reads a list of integers and prints them in order of increasing frequency.
 *              Numbers with the same frequency are printed in ascending order.
 * Author: Shane Skare
 * Date: 02/10/2024
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    int number;
    int frequency;
    static int counter = 1;
    public Main(int num,int freq) {
        this.number = num;
        this.frequency = freq;
    }
    public int getFrequency(){
        return this.frequency;
    }
    public int getNumber(){
        return this.number;
    }
    public void incrementFrequency(){
        this.frequency++;
        if(this.frequency > counter)
            counter++;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Main> unsorted = new ArrayList<Main>();
        ArrayList<Integer> sorted = new ArrayList<Integer>();

        int groupSize = s.nextInt();
        for (int i = 0; i < groupSize; i++) {
            int num = s.nextInt();
            boolean found = false;
            for (Main main : unsorted) {
                if (main.getNumber() == num) {
                    main.incrementFrequency();
                    found = true;
                    break;
                }
            }
            if (!found) {
                unsorted.add(new Main(num, 1));
                sorted.add(num);
            }
        }
        Collections.sort(sorted);
        for(int i = 1;i <= counter; i++) {
            for (int num : sorted) {
                for (Main main : unsorted) {
                    if (main.getFrequency() == i && main.getNumber() == num) {
                        for (int k = 0; k < i; k++) {
                            System.out.print(num + " ");
                        }
                    }
                }
            }
        }
    }
}

