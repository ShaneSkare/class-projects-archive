/*
 * Title: Main.java
 * Description: Solves the maximum subset sum problem with the constraint
 *              that no two adjacent coins can be selected. Determines both
 *              the maximum value and the specific coins that form this sum.
 * Author: Shane Skare
 * Date: 05/06/2024
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int length = s.nextInt();
        int[] coins = new int[length+1];
        int[] maxValue = new int[length+1];

        coins[0] = 0;
        maxValue[0] = 0;

        for (int i = 1; i <= length; i++) {
            int num = s.nextInt();
            coins[i] = num;
        }

        maxValue[1] = coins[1];

        for (int i = 2; i < coins.length; i++) {
            maxValue[i] = Math.max(maxValue[i-2] + coins[i], maxValue[i-1]);
        }

        System.out.print("Best set:");
        for (int i = 1; i < maxValue.length - 1; i++){
            int j = i + 1;
            if(i == 1 && maxValue[j] == maxValue[i]){
                System.out.print(i + " ");
            }
            if(maxValue[j] > maxValue[i]){
                if (j != maxValue.length - 1) {
                    int k = j + 1;
                    if (maxValue[k] == maxValue[j]) {
                        System.out.print(j + " ");
                    } else if (maxValue[k] > maxValue[j]) {
                        if(i == 1){
                            System.out.print(i + " ");
                        }
                        else {
                            if(k == maxValue.length - 1){
                                System.out.print(k);
                            }
                            else{
                                System.out.print(k + " ");
                            }
                            i++;
                        }
                    }
                }
                else{
                    System.out.print(j);
                }
            }
        }
        System.out.print("\nMax Value:" + maxValue[maxValue.length - 1]);
    }
}