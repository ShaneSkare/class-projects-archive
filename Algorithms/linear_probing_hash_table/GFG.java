/*
 * Title: LinearProbingHashTable.java
 * Description: Implements a hash table using linear probing in Java, with support for:
 *              - Insert
 *              - Search (by key or value)
 *              - Delete
 *              - Auto-resize based on load factor
 *              - Prime-based resizing strategy
 * Author: Shane Skare
 * Date: 05/02/2024
 * References:
 * https://www.geeksforgeeks.org/program-to-find-the-next-prime-number/
 * https://www.geeksforgeeks.org/java-program-to-implement-hashtables-with-linear-probing/
 */

import java.util.Scanner;

// Helper class - LinearProbingHashTable
class LinearProbingHashTable {
    // Member variables of this class
    private int currentSize, maxSize;
    private String[] keys;
    private String[] vals;

    // Constructor of this class
    public LinearProbingHashTable(int capacity)
    {
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    // Method 1
    // Function to clear hash table
    public void makeEmpty()
    {
        currentSize = 0;
        keys = new String[maxSize];
        vals = new String[maxSize];
    }

    // Method 2
    // Function to get size of hash table
    public int getSize() { return currentSize; }
    public int getMaxSize() { return maxSize; }
    // Method 3
    // Function to check if hash table is full
    public boolean isFull()
    {
        return currentSize == maxSize;
    }

    // Method 4
    // Function to check if hash table is empty
    public boolean isEmpty() { return getSize() == 0; }

    // Method 5
    // Function to check if hash table contains a key
    public boolean contains(String key)
    {
        return get(key) != null;
    }
    public boolean containsValue(String value)
    {
        return find(value) != null;
    }
    // Method 6
    // Function to get hash code of a given key
    private int hash(String key)
    {
        return Integer.parseInt(key) % maxSize;
    }

    // Method 7
    // Function to insert key-value pair
    public void insert(String key, String val)
    {
        int tmp = hash(key);
        int i = tmp;

        // Do-while loop
        // Do part for performing actions
        do {
            if (keys[i] == null) {
                keys[i] = String.valueOf(i);
                vals[i] = val;
                currentSize++;
                return;
            }

            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }

            i = (i + 1) % maxSize;
        }

        // Do-while loop
        // while part for condition check
        while (i != tmp);
    }

    // Method 8
    // Function to get value for a given key
    public String get(String key)
    {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key))
                return vals[i];
            i = (i + 1) % maxSize;
        }
        return null;
    }
    public String find(String value)
    {
        int i = hash(value);
        while (vals[i] != null) {
            if (vals[i].equals(value))
                return keys[i];
            i = (i + 1) % maxSize;
        }
        return null;
    }
    // Method 9
    // Function to remove key and its value
    public void remove(String key)
    {
        if (!contains(key))
            return;

        // Find position key and delete
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % maxSize;
        keys[i] = vals[i] = null;

        // rehash all keys
        for (i = (i + 1) % maxSize; keys[i] != null;
             i = (i + 1) % maxSize) {
            String tmp1 = keys[i], tmp2 = vals[i];
            keys[i] = vals[i] = null;
            currentSize--;
            insert(tmp1, tmp2);
        }
        currentSize--;
    }

    // Method 10
    // Function to print HashTable
    public void printHashTable()
    {
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] + " " + vals[i]);
        System.out.println();
    }

    public LinearProbingHashTable heapify(int newSize) {
        LinearProbingHashTable temp = new LinearProbingHashTable(newSize);
        for (int i = 0; i < this.maxSize; i++){
            if(this.get(String.valueOf(i)) == null){
                continue;
            }
            temp.insert(this.get(String.valueOf(i)), this.get(String.valueOf(i)));
        }
        return temp;
    }
}

// Main testing class
// Main Class for LinearProbingHashTableTest
public class GFG {
    static boolean isPrime(int n)
    {
        // Corner cases
        if (n <= 1) return false;
        if (n <= 3) return true;

        // This is checked so that we can skip
        // middle five numbers in below loop
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    // Function to return the smallest
    // prime number greater than N
    static int nextPrime(int N)
    {

        // Base case
        if (N <= 1)
            return 2;

        int prime = N;
        boolean found = false;

        // Loop continuously until isPrime returns
        // true for a number greater than n
        while (!found)
        {
            prime++;

            if (isPrime(prime))
                found = true;
        }

        return prime;
    }
    // Main driver method
    public static void main(String[] args)
    {

        Scanner scan = new Scanner(System.in);
        int tSize = scan.nextInt();
        int loop = scan.nextInt();
        String str = "";
        LinearProbingHashTable lpht = new LinearProbingHashTable(tSize);
        for (int i = 0; i < loop; i++) {
            String choice = scan.next();

            // Switch case
            switch (choice) {

                // Case 1
                case "insert":

                    int insert = scan.nextInt();
                    lpht.insert(String.valueOf(insert), String.valueOf(insert));
                    if (lpht.getSize() > tSize/2){
                        tSize = nextPrime(tSize*2);
                        lpht = lpht.heapify(tSize);
                    }
                    // Break statement to terminate a case
                    break;

                // Case 2
                case "displayStatus":
                    int key = scan.nextInt();
                    // Display message
                    if(lpht.get(String.valueOf(key)) == null){
                        if(str.equals("")){
                            str += "Empty";
                        }
                        else {
                            str += "\nEmpty" ;
                        }
                        break;
                    }
                    if(str.equals("")){
                        str += lpht.get(String.valueOf(key));
                    }
                    else {
                        str += "\n" + lpht.get(String.valueOf(key));
                    }

                    // Break statement to terminate a case
                    break;

                // Case 3
                case "tableSize":
                    if(str.equals("")){
                        str += lpht.getMaxSize();
                    }
                    else {
                        str += "\n" + lpht.getMaxSize();;
                    }
                    break;

                // Case 4
                case "search":
                    int value = scan.nextInt();
                    if (lpht.containsValue(String.valueOf(value)))
                        if(str.equals("")){
                            str += value + " Found";
                        }
                        else {
                            str += "\n" + value + " Found";
                        }
                    else
                        if(str.equals("")){
                            str += value + " Not found";
                        }
                        else {
                            str += "\n" + value + " Not found";
                        }
                    // Break statement to terminate a case
                    break;
                // Default case
                // Executed when mentioned switch cases are not
                // matched
                default:
                    // Print statement
                    System.out.println("Wrong Entry \n ");
                    // Break statement
                    break;
            }
        }
        System.out.print(str);
    }
}
