# Basic Bank Account Manager

This Java project includes a Bank2 class for managing up to five bank accounts, and an Account2 class that stores individual account details. Users can open and close accounts, deposit or withdraw funds, and print all current account information.

## Components

- Bank2.java: Main controller that stores and manages up to five accounts.
- Account2.java: Represents individual bank accounts with name, account number, type, and balance.

## Features

- Open an account with name, number, type, and initial balance
- Close an account by number
- Deposit and withdraw funds with validation
- Print all account information
- Simple internal shifting to maintain array order after deletion

## How to Run

### Compile
javac Bank2.java Account2.java

### Run
You can use this project as a backend to a driver class like this:

`java
Bank2 myBank = new Bank2();
myBank.setBankName("OpenAI Credit Union");
myBank.openAccount("Alice", 101, 1, 1000.00);
myBank.openAccount("Bob", 102, 2, 500.00);
myBank.printAllAccounts();
myBank.closeAccount(101);
myBank.printAllAccounts();
Sample Output
yaml
Copy
Edit
Account holder's name: Alice
Account number: 101
Account type: 1
Balance: 1000.0

Account holder's name: Bob
Account number: 102
Account type: 2
Balance: 500.0

Account holder's name: Bob
Account number: 102
Account type: 2
Balance: 500.0
