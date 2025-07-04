# BFS with Disconnected Component Detection

This Java program implements a Breadth-First Search (BFS) traversal on a directed graph represented as an adjacency list. It begins traversal from node 0, printing edges needed to connect any disconnected components as it encounters them.

## Features
- BFS traversal from node 0
- Detects and handles disconnected graph components
- Prints minimal edges needed to connect isolated subgraphs
- Displays 'No new edge:' if the graph is fully connected

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
6
4
0 1
0 2
1 3
4 5

Output:
Edge: 0-4

csharp
Copy
Edit

If the graph is already fully connected from node 0:
Output:
No new edge:

Copy
Edit
