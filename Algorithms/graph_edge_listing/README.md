# Graph Edge Listing

This Java program reads graph input from the user and prints each node’s outgoing edges in sorted order. It uses an array of LinkedList objects to represent the adjacency list.

## Features
- Accepts number of nodes and number of edges
- Reads edge connections and organizes them per node
- Sorts and prints each node’s adjacency list
- Handles invalid input (e.g., out-of-range node index)

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
3
4
0
A B
1
C D
1
B C
2
A D

Output:
0->A B
1->B C->C D
2->A D

Copy
Edit
