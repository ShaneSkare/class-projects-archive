# ATM Banking Simulator

This Java class simulates an ATM machine with basic banking operations. It includes user authentication by name and PIN, and supports transactions such as deposits, withdrawals, and transfers. The ATM can be initialized with a location, serial number, and bank name, and can report its current configuration and funds.

## Features
- User validation using predefined names and PINs
- Deposit, withdrawal, and fund transfer functionality
- Tracks ATM funds and user balances
- Customizable ATM details (bank name, serial number, location)
- Displays status and handles error cases

## How to Use

### Integrate in a driver class (example: ATMTest.java)
`java
ATM myAtm = new ATM(1234, "Bank of Java", "Main Street");
myAtm.status();
myAtm.withdrawal("Alice", 1234, 100.00);
myAtm.deposit("Alice", 1234, 50.00);
myAtm.transfer("Alice", 1234, 30.00, "Bob");
System.out.println(myAtm);
Example Output
pgsql
Copy
Edit
Serial Number: 1234
Bank Name: Bank of Java
Location: Main Street
Balance: 100.00

Succeed – Withdrawal: Alice new balance: .00  
Succeed – Deposit: Alice new balance: .00  
Succeed – Transfer: Alice new balance: .00  
Notes
Usernames are hardcoded: Alice, Tom, Monica, Bob, Chris

PINs must match exactly to perform transactions

Balances and ATM fund values are updated in real time

Exception handling covers invalid credentials and overdraw attempts

