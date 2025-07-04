# Social Network BFS Connection Finder

This Java program simulates a social network using a graph and performs a Breadth First Search (BFS) to find all people exactly N degrees of connection away from a given user. Connections are directional (follows/followed).

## Features
- Reads person names and their connections from input
- Builds an adjacency list to represent the social network
- Uses BFS to traverse outward from a starting user
- Prints alphabetically sorted names at the given connection degree

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
5
Alice Bob Carol Dave Eve
4
Alice Bob
Bob Carol
Bob Dave
Carol Eve
Alice
2

Output:
Eve

perl
Copy
Edit

If no users are found at the given degree:
Output:
NONE

Copy
Edit
