# Priority Queue Manager

This Java program processes customer data using priority-based queues. It supports reading a list of customers with priorities, then processes Add, List, and Delete commands accordingly.

## Features
- Maintains customer queues per priority using a HashMap<Integer, Queue<String>>
- Supports:
  - List: Prints all customers in ascending priority order
  - Add: Adds a new customer to the proper priority queue
  - Delete: Removes the next customer from the highest-priority queue

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
Alice 3
Bob 1
Carol 2
4
List
Add Dave 2
Delete
List

Output:
Bob 1
Carol 2
Alice 3
Dave added
Bob deleted
Carol 2
Dave 2
Alice 3

Copy
Edit
