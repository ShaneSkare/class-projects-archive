# Max Concurrent Events

This Java program calculates the maximum number of overlapping events based on their start and end times. Each event is defined by an interval between two hours (inclusive).

## Features
- Tracks event overlaps using a fixed-size time array
- Efficiently calculates the maximum number of simultaneous events
- Time range assumed to be between 0 and 24

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
4
1 4
2 5
3 6
5 7

Output:
Max events: 3

Copy
Edit
