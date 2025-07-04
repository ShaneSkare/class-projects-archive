# Depth First Search (DFS) Graph Traversal

This Java program reads a directed graph and performs a Depth First Search (DFS) starting from a specified node. It outputs the visitation sequence and the "mark" (visit order) for each node.

## Features
- Graph represented as an adjacency matrix
- Uses recursion and a stack to simulate DFS
- Outputs:
  - The visiting sequence (e.g., 0->1->3)
  - The visit order (Mark[x]) for each node

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
4
0 1
1 2
1 3
2 3
0

Output:
Mark[0]:1
Mark[1]:2
Mark[2]:3
Mark[3]:4
Visiting sequence:0->1->2->3

Copy
Edit
