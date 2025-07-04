# MaxHeap Implementation

This Java program implements a MaxHeap data structure supporting:

- insert (bottom-up heapify)
- deleteMax
- extractMax
- display (prints all values in the heap)
- Heap validation and auto-correction if initial array does not meet heap conditions

The program accepts an initial list of integers, then executes a series of commands.

## Features
- Maintains max-heap structure
- Supports command-driven interaction
- Handles both bottom-up and top-down heapification
- Provides correction when input array is not a valid heap

## How to Run

### Compile
javac MaxHeap.java

shell
Copy
Edit

### Run
java MaxHeap

shell
Copy
Edit

## Sample Input
5
10 20 15 30 40
4
displayMax
deleteMax
insert 35
display

shell
Copy
Edit

## Sample Output
This is NOT a heap.
40
35 30 15 10 20

Copy
Edit

