# Hangman Game (Java)

This is a simple two-player Hangman game implemented in Java. One player enters a secret word (capital letters only), and the second player attempts to guess it letter by letter or use limited hints. The game ends when the word is fully guessed or all incorrect guesses are used up.

## Features
- Accepts a capital-letter word as input
- User can guess letters or request hints
- Tracks and displays correct/incorrect guesses
- Limits incorrect attempts to 4
- Input validation for repeated letters and invalid formats

## How to Run

### Compile
javac Hangman.java

### Run
java Hangman

## Sample Interaction
Enter a word for the game: HELLO
--------- Welcome to Hangman ---------

The word is: _ _ _ _ _
You have 4 incorrect guesses left.
Enter either 1 for guessing or 2 for hint: 1
Enter your guess: E
Great! E is in the word.

The word is: _ E _ _ _
You have 4 incorrect guesses left.
...

sql
Copy
Edit

## Notes
- Only capital-letter words are accepted (A–Z)
- Using a hint reveals a letter but costs one guess
- Game ends with a win or after 4 failed attempts
- Designed for console-based play with minimal external dependencies

