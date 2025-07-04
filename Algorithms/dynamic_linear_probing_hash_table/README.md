# Dynamic Linear Probing Hash Table

This Java program implements a hash table using linear probing to handle collisions. It includes dynamic resizing based on the load factor, and provides support for insertion, searching, and querying hash table status. The table resizes to the next prime size when more than 50% full.

## Features
- Linear probing collision handling
- Dynamic resizing to next prime number
- Search and status queries
- User-defined insertions and load-triggered rehashing

## How to Run

### Compile
javac Main.java

### Run
java Main

## Example
Input:
5 6  
insert 1  
insert 6  
search 6  
displayStatus 1  
tableSize  
search 3  

Output:
6 Found  
1  
11  
3 Not found
