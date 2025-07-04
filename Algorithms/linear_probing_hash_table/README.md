# Linear Probing Hash Table

This Java program implements a hash table using **linear probing**. It supports:

- Insertion of integer keys
- Collision handling via linear probing
- Automatic resizing (rehashing) when load factor > 0.5
- Status lookup by key
- Search by value
- Prime number logic for table resizing

## Features
- Dynamic resizing based on load factor (uses next prime number strategy)
- Efficient collision resolution with linear probing
- Supports integer keys as both key and value

## How to Run

### Compile
javac GFG.java

shell
Copy
Edit

### Run
java GFG

shell
Copy
Edit

## Sample Input
5
8
insert 10
insert 15
insert 20
displayStatus 15
tableSize
search 10
insert 25
tableSize

shell
Copy
Edit

## Sample Output
15
5
10 Found
11

markdown
Copy
Edit

This shows that:
- 15 was inserted and found,
- the table initially had size 5,
- after insertions exceed load factor, the table resized to the next prime above 10 (which is 11).

