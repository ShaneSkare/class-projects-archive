# Negative-Before-Positive Sort Puzzle

This Java program solves a simple sorting problem: rearrange an input list so that all negative numbers appear before all positive numbers. The program demonstrates **two different in-place algorithms** to achieve this using two separate lists.

## Features
- Accepts 
 integers from user input
- First method uses two-pointer swapping strategy (left-to-right)
- Second method runs a reverse-order variation of the same concept
- Both sorted outputs are printed

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

## Example
Input:
8
4 -3 2 -8 5 -1 7 -6

Output:
-3 -8 -1 -6 2 4 5 7
-3 -8 -1 -6 2 4 5 7

pgsql
Copy
Edit

*Both outputs show negative numbers grouped before positives, with the order determined by the method's traversal direction.*
