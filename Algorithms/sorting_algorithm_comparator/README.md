# Sorting Algorithm Comparator

This Java program compares the execution time of:
- Insertion Sort
- Quick Sort
- Quick Sort using Median-of-Three partitioning

The user can specify the array size and whether to populate it in ascending, descending, or random order. Results are printed along with performance rankings.

## Features
- Generates integer arrays in ascending, descending, or random order
- Measures and ranks execution time of:
  - Standard Quick Sort
  - Insertion Sort (optional)
  - Median-of-Three Quick Sort (optional)
- Handles small or large input sizes and prints sorted results if small

## How to Run

### Compile
javac Main.java

shell
Copy
Edit

### Run
java Main

shell
Copy
Edit

## Sample Interaction
Enter input size: 10
========== Select Option for Input Numbers ==========
1. Ascending Order
2. Descending Order
3. Random Order
Choose option: 3

Run insertion sort(y/n)? y
Run quick sort with Median of Three(y/n)? y

Numbers generated: 3 88 12 41 9 77 15 24 68 99
Quick sort result: 3 9 12 15 24 41 68 77 88 99
Insertion sort result: 3 9 12 15 24 41 68 77 88 99
Quick sort (Median of Three): 3 9 12 15 24 41 68 77 88 99

==================== Execution Result ====================
Quick sort: 0.038 milliseconds
Insertion sort: 0.052 milliseconds
Quick sort (Median of Three) 0.036 milliseconds

========================== Ranking =========================
(1) Quick sort (Median of Three)
(2) Quick sort
(3) Insertion sort
Copy
Edit

