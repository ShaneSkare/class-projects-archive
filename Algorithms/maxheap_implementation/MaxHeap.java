/*
 * Title: MaxHeap.java
 * Description: Implements a MaxHeap data structure in Java, supporting operations such as insert,
 *              deleteMax, extractMax, and heap validation. Includes both top-down and bottom-up
 *              heapify methods to maintain heap properties.
 * Author: Shane Skare
 * Date: 05/02/2024
 * References:
 * https://www.geeksforgeeks.org/max-heap-in-java/
 */

import java.util.Scanner;
public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
    public static String str = "";
    private boolean boolHeap = true;

    // Constructor to initialize an
    // empty max heap with given maximum
    // capacity
    public MaxHeap(int maxsize)
    {
        // This keyword refers to current instance itself
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }
    // Method 1
    // Returning position of parent
    private int parent(int pos) { return (pos - 1) / 2; }

    // Method 2
    // Returning left children
    private int leftChild(int pos) { return (2 * pos) + 1; }

    // Method 3
    // Returning right children
    private int rightChild(int pos)
    {
        return (2 * pos) + 2;
    }

    // Method 4
    // Returning true if given node is leaf
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    // Method 5
    // Swapping nodes
    private void swap(int fpos, int spos)
    {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    // Method 6
    // Recursive function to max heapify given subtree
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
            return;

        if (Heap[pos] < Heap[leftChild(pos)]
                || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)]
                    > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    private void bottomUpHeapify(int pos){

        if (isLeaf(pos))
            pos = parent(pos);
        if (Heap[pos] < Heap[leftChild(pos)] || Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                bottomUpHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                bottomUpHeapify(rightChild(pos));
            }
        }
        else if(pos != 0)
            bottomUpHeapify(parent(pos));
    }

    // Method 7
    // Inserts a new element to max heap
    public void insertBU(int element)
    {
        Heap[size] = element;

        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }
    public void insert(int element)
    {
        Heap[size] = element;
        size++;
    }
    public boolean checkHeap(){
        for (int i = 0; i < size; i++){
            if(Heap[i] < Heap[leftChild(i)] || Heap[i] < Heap[rightChild(i)]){
                return boolHeap = false;
            }
        }
        return boolHeap;
    }
    // Method 8
    // To display heap

    public void deleteMax(){
        Heap[0] = Heap[--size];
        maxHeapify(0);
    }
    // Method 9
    // Remove an element from max heap
    public int extractMax()
    {
        return Heap[0];
    }
    public String print(){
        StringBuilder string = new StringBuilder();
        for(int j = 0; j < size; j++){
            if (string.isEmpty()){
                string.append(String.valueOf(Heap[j]));
            }
            else{
                string.append(" ").append(String.valueOf(Heap[j]));
            }
        }
        return string.toString();
    }

    // Method 10
    // main driver method
    public static void main(String[] arg)
    {
        Scanner s = new Scanner(System.in);

        int initialSize= s.nextInt();
        MaxHeap maxHeap = new MaxHeap(initialSize*5);

        for(int i = 0; i < initialSize; i++){
            maxHeap.insert(s.nextInt());
        }
        int numberOfCommands = s.nextInt();
        if (maxHeap.checkHeap()){
            str += "This is a heap.";
        }
        else{
            str += "This is NOT a heap.";
            maxHeap.bottomUpHeapify((maxHeap.size-2)/2);
        }

        for (int i = 0; i < numberOfCommands; i++){
            String command = s.next();
            if (command.equals("display")){
                str += "\n" + maxHeap.print();
            }
            if (command.equals("deleteMax")){
                maxHeap.deleteMax();
            }
            if (command.equals("displayMax")){

                str += "\n" + String.valueOf(maxHeap.extractMax());
            }
            if (command.equals("insert")){
                int num = s.nextInt();
                maxHeap.insertBU(num);
            }
        }
        System.out.print(str);
    }
}