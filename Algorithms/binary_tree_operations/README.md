# Binary Tree Operations

This Java program builds a binary tree and supports various operations including:
- Insertion (ppend)
- Tree traversals (preOrder, inOrder, postOrder, levelOrder)
- Height calculation (height)
- First node search (indFirstNode)
- BST verification (isBST)

The input includes a root value and a list of commands to execute on the tree.

## Features
- Maintains a binary tree with dynamic left-right insertion strategy
- Traversals are printed as space-separated sequences
- Handles boolean and numerical output from relevant functions

## Commands
- ppend [value]: Add a node to the tree
- isBST: Check if the tree is a Binary Search Tree
- preOrder, inOrder, postOrder, levelOrder: Traversal outputs
- height: Returns height of the tree
- indFirstNode: Finds the leftmost node

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
10
6
append 5
append 15
inOrder
isBST
height
preOrder

Output:
5 10 15
true
1
10 5 15

Copy
Edit
