# Traveling Salesman Problem (TSP) Solver

This Java program solves the Traveling Salesman Problem using recursive backtracking. It finds the minimum-cost path that visits every node in a directed graph exactly once and returns to the starting point.

## Features
- Reads number of nodes, edges, and weighted connections
- Uses recursion and backtracking to evaluate all possible paths
- Detects cases with no valid path or multiple optimal paths
- Outputs the lowest-cost valid cycle, if one exists

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
6
0 1 5
0 2 9
1 2 3
2 3 2
3 0 7
1 3 4
0

Output:
Path:0->1->2->3->0
Cost:17

perl
Copy
Edit

If no valid path exists:
Path:
Cost:-1

yaml
Copy
Edit

If multiple paths share the same minimum cost:
Multiple Paths
Cost: [minimum cost]

Copy
Edit
