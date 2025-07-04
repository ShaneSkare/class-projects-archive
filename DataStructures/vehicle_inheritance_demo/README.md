# Vehicle Inheritance Demo

This Java project demonstrates object-oriented programming concepts including class inheritance, method overriding, constructors, and equality comparison. The Truck class extends a base Vehicle class, and each vehicle is associated with a Person owner.

## Components

- Main.java: Test driver to demonstrate the behavior of all classes
- Person.java: Stores a person’s name and supports equality checks
- Vehicle.java: Base class with manufacturer, number of cylinders, and owner
- Truck.java: Subclass of Vehicle with additional towing and load capacity fields

## Features

- Object instantiation using constructors and copy constructors
- Setters and getters for class fields
- Custom equals() methods for value-based comparisons
- Demonstrates inheritance and polymorphism

## How to Run

### Compile
javac Main.java Truck.java Vehicle.java Person.java

### Run
java Main

## Sample Output
p1: UNKNOWN
p1's name is: Bob
p2: Joe
true
false
v1's manufacturer is: Ford
v1's cylinders: 4
v1's owner is: Joe
v2: Ford, 4, Joe
t1: Ford, 4, Bob, Load Cap: 54.36, Tow Cap: 10
true

markdown
Copy
Edit

## Notes
- Make sure all .java files are in the same directory
- Ensure proper access modifiers for encapsulation where needed
- The equals() methods demonstrate deep comparisons based on values, not references

