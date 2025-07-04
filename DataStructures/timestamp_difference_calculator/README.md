# Timestamp Difference Calculator

This Java program calculates the difference between two timestamps provided in HH:MM:SS format. It handles standard time formatting rules and accounts for overflow (e.g., when the second timestamp is earlier in the day than the first, implying a rollover at midnight).

## Features
- Parses and compares two timestamps
- Handles overflow between seconds, minutes, and hours
- Accounts for time differences across midnight
- Outputs the result in HH:MM:SS format with leading zeros
- Basic input validation for malformed or invalid time values

## How to Run

### Compile
javac Timestamp.java

### Run
java Timestamp

## Sample Interaction
--------- Welcome to Timestamp ---------
1st timestamp - 23:55:45
2nd timestamp - 00:10:15
Result - 00:14:30

markdown
Copy
Edit

## Notes
- Validates hours (0–23), minutes and seconds (0–59)
- Invalid input such as 24:00:00 or non-numeric formats will trigger an error
- Uses DecimalFormat to ensure proper leading-zero display

