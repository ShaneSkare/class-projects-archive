# Character Histogram Generator

This Java program reads a list of characters from a user-specified input file. The first value in the file indicates how many characters will be read. It then counts the frequency of each character between A and K and displays a vertical histogram.

## Features
- Accepts file input with a list of characters
- Counts occurrences of characters A through K
- Displays results in a vertical star-based bar chart
- Includes total frequency printout for each letter

## How to Run

### Compile
javac Histogram.java

### Run
java Histogram

You will be prompted to enter the name of a file containing the input data.

## Example Input File
4
A
E
H
K

shell
Copy
Edit

## Sample Output
String Occurrence
A 1
E 1
H 1
K 1
============= Vertical Bar =============
| 1 | * * * *
| No | A B C D E F G H I J K
Copy
Edit

