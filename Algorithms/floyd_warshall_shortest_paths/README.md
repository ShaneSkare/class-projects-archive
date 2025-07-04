# Floyd-Warshall Shortest Paths

This Java program applies the Floyd-Warshall algorithm to compute the shortest paths between all pairs of vertices in a weighted graph. The graph is input as an adjacency matrix, with -1 indicating no direct edge between two vertices.

## Features
- Implements Floyd-Warshall algorithm for all-pairs shortest paths
- Handles unreachable nodes using -1 as input
- Outputs the final shortest path matrix in readable format

## How to Run

### Compile
javac Main.java

### Run
java Main

## Example
Input:
4  
0 5 -1 10  
-1 0 3 -1  
-1 -1 0 1  
-1 -1 -1 0  

Output:
0   5   8   9  
-1   0   3   4  
-1   -1   0   1  
-1   -1   -1   0
