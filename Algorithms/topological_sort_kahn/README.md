# Topological Sort using Kahn's Algorithm

This Java program performs a topological sort on a directed acyclic graph (DAG) using **Kahn's algorithm**. It reads graph input, computes in-degrees, and outputs the topological order of vertices if one exists.

## Features
- Accepts up to 25 vertices and a list of directed edges
- Computes and prints in-degree for each vertex
- Detects cycles (no valid topological order)
- Outputs topological order using Kahn's BFS-like queue strategy

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
6
5 2
5 0
4 0
4 1
2 3
3 1

Output:
In-degree[0]:2
In-degree[1]:2
In-degree[2]:1
In-degree[3]:1
In-degree[4]:0
In-degree[5]:0
Order:4->5->0->2->3->1

pgsql
Copy
Edit

If no valid topological sort exists (i.e., a cycle is detected):
Output:
No Order:

Copy
Edit
