/*
 * Title: Main.java
 * Description: Compares performance of three sorting algorithms: Insertion Sort, Quick Sort, and
 *              Quick Sort with Median-of-Three partitioning. Accepts array size and ordering from user,
 *              then times each algorithm and ranks them by execution time.
 * Author: Shane Skare
 * Date: 04/26/2024
 * References:
 * https://www.geeksforgeeks.org/add-random-number-to-an-array-in-java/
 * https://www.geeksforgeeks.org/measure-time-taken-function-java/
 */
import java.util.*;
public class Main {
    // A utility function to swap two elements
    static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    static int partition(int[] A, int l, int r) {
        int p = A[l];
        int i = l + 1;
        int j = r;
        while(i <= j){
            while(A[i] <= p && A[i] != Integer.MAX_VALUE){
                i++;
            }
            while(A[j] > p && j >= i){
                j--;
            }
            swap(A, i, j);
        }
        swap(A, i , j);
        swap(A, l , j);
        return (j);
    }
    static int medThreePartition(int[] A, int l, int m, int r) {
        int i = l;
        int j = r;
        if (A[i] > A[m]){
            swap(A, i, m);
        }
        if (A[m] > A[j]){
            swap(A, m, j);
        }
        if (A[i] > A[m]){
            swap(A, i, m);
        }
        i++;
        j--;
        swap(A, i, m);
        int p = A[i++];
        while(i <= j){
            while(A[i] <= p){
                i++;
            }
            while(A[j] > p && j >= i){
                j--;
            }
            swap(A, i, j);
        }
        if(A[i] < A[j]) {
            swap(A, i, j);
        }
        swap(A, l +1 , j);
        return (j);
    }
    public static void medianQuickSort(int[] A, int l, int r)
    {
        if (l < r) {
            int s = medThreePartition(A, l, (l+r)/2, r);
            medianQuickSort(A, l, s - 1);
            medianQuickSort(A, s + 1, r);
        }
    }

    // The main function that implements QuickSort
    // A[] --> Array to be sorted,
    // l --> Starting index,
    // r --> Ending index
    // s --> Split position
    public static void quickSort(int[] A, int l, int r)
    {
        if (l < r) {
            int s = partition(A, l, r);
            quickSort(A, l, s - 1);
            quickSort(A, s + 1, r);
        }
    }
   public static void sort(int[] A)
    {
        int n = A.length;
        for (int i = 1; i < n; ++i) {
            int v = A[i];
            int j = i - 1;

            while (j >= 0 && A[j] > v) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = v;
        }
    }
    // To print sorted array
    public static void printArr(int[] A)
    {
        for (int i = 0; i < A.length-1 ;i++) {
            System.out.print(A[i] + " ");
        }
    }
    public static String getRanking(double timeQS, double timeS, double timeMQS){
        double[] arr2 = new double[4];
        arr2[0] = timeQS;
        arr2[1] = timeS;
        arr2[2] = timeMQS;
        arr2[3] = Integer.MAX_VALUE;
        for (int i = 0; i < arr2.length - 1; i++){
            for (int j = i+1; j < arr2.length; j++){
                if (arr2[j] < arr2[i]) {
                    double temp = arr2[i];
                    arr2[i] = arr2[j];
                    arr2[j] = temp;
                }
            }
        }
        StringBuilder ranking = new StringBuilder();
        int counter = 1;
        for(double i : arr2){
            if(i == timeQS && timeQS != 0){
                ranking.append("\n(").append(counter++).append(")");
                ranking.append(" Quick sort");
            }
            if(i == timeS && timeS != 0){
                ranking.append("\n(").append(counter++).append(")");
                ranking.append(" Insertion sort");
            }
            if(i == timeMQS && timeMQS != 0){
                ranking.append("\n(").append(counter++).append(")");
                ranking.append(" Quick sort (Median of Three)");
            }
            if(counter == 4){
                return ranking.toString();
            }
        }
        return ranking.toString();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter input size: ");
        int inputSize = s.nextInt();
        System.out.print("""
                ========== Select Option for Input Numbers ==========
                     1. Ascending Order
                     2. Descending Order
                     3. Random Order
                Choose option:""");
        int option = s.nextInt();
        System.out.print("\nRun insertion sort(y/n)? ");
        String insert = s.next();

        System.out.print("Run quick sort with Median of Three(y/n)? ");
        String quick = s.next();

        int[] arr = new int[inputSize+1];
        arr[inputSize] = Integer.MAX_VALUE;
        int[] arrB = new int[0];
        int[] arrC = new int[0];

        if (option == 1){
            for (int i = 0; i < inputSize; i++) {
                arr[i] = i + 1;
            }
        }
        if (option == 2){
            for (int i = 0; i < inputSize; i++) {
                arr[i] = inputSize - i;
            }
        }
        if (option == 3){
            Random random = new Random();
            for (int i = 0; i < inputSize; i++) {
                arr[i] = random.nextInt(inputSize * 10);
            }
        }

        double timeQS;
        double timeMQS = 0;
        double timeS = 0;

        if(insert.equals("y")) {
            arrB = arr.clone();
        }
        if(quick.equals("y")) {
            arrC = arr.clone();
        }
        if ( arr.length < 22){

            System.out.print("\nNumbers generated: ");
            printArr(arr);
            long startQS = System.nanoTime();
            quickSort(arr, 0, inputSize-1);
            long endQS = System.nanoTime();
            timeQS = (endQS - startQS) / 1000000.0;
            System.out.print("\nQuick sort result: ");
            printArr(arr);
            if (insert.equals("y")) {
                long startS = System.nanoTime();
                sort(arrB);
                long endS = System.nanoTime();
                timeS = (endS - startS) / 1000000.0;
                System.out.print("\nInsertion sort result: ");
                printArr(arrB);
            }
            if (quick.equals("y")){
                long startMQS = System.nanoTime();
                medianQuickSort(arrC, 0, inputSize-1);
                long endMQS = System.nanoTime();
                timeMQS = (endMQS - startMQS) / 1000000.0;
                System.out.print("\nQuick sort (Median of Three): ");
                printArr(arrC);
            }
            System.out.print("\n");
        }
        else {
            long startQS = System.nanoTime();
            quickSort(arr, 0, inputSize-1);
            long endQS = System.nanoTime();
            timeQS = (endQS - startQS) / 1000000.0;
            if (insert.equals("y")) {
                long startS = System.nanoTime();
                sort(arrB);
                long endS = System.nanoTime();
                timeS = (endS - startS) / 1000000.0;
            }
            if (quick.equals("y")){
                long startMQS = System.nanoTime();
                medianQuickSort(arrC, 0, inputSize-1);
                long endMQS = System.nanoTime();
                timeMQS = (endMQS - startMQS) / 1000000.0;
            }
        }
        System.out.println("\n==================== Execution Result ====================");
        System.out.print("Quick sort: " + timeQS + " milliseconds");
        if (insert.equals("y")) {
            System.out.print("\nInsertion sort: " + timeS + " milliseconds");
        }
        if (quick.equals("y")){
            System.out.print("\nQuick sort (Median of Three) " + timeMQS + " milliseconds");
        }
        System.out.println("\n============================================================\n");
        System.out.print("========================== Ranking =========================");
        System.out.println(getRanking(timeQS, timeS, timeMQS));
        System.out.print("============================================================");
    }
}