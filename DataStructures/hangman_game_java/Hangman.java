/**
 * Title: Hangman.java
 * Description: A simple text-based Hangman game. The user enters a capital-letter word,
 *              and another player guesses letters or requests hints to reveal the word.
 *              Tracks correct and incorrect guesses, with a limit of 4 mistakes.
 *              Includes input validation and hint functionality.
 * Author: Shane Skare
 * Date: 09/20/2023
 */

import java.util.Scanner;
import java.util.*;
public class Hangman {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int counter, guesses = 4, choice;
        boolean done = false;
        char letter=0;

        System.out.print("Enter a word for the game: ");
        String word = keyboard.nextLine();
        System.out.println("--------- Welcome to Hangman ---------\n");
        ArrayList<Character> array1 = new ArrayList<>();
            for (char c : word.toCharArray())
                array1.add(c);
            counter = array1.size();
        ArrayList <Character> array2 = new ArrayList<>(counter);
        for (int i = 0; i < counter; i++) {
            array2.add('_');
            if (array1.get(i) < 64 || array1.get(i) > 90) {
                done = true;
                System.out.println("Invalid word. Capital letters only. ");
                break;
            }
        }
        ArrayList <Character> array3 = new ArrayList<>();
        ArrayList <Character> array4 = new ArrayList<>();
        while (!done) {
            System.out.print("The word is: ");
            for (Character character : array2) System.out.print(character + " ");

            System.out.println("\nYou have " + guesses + " incorrect guesses left.");
            System.out.print("Enter either 1 for guessing or 2 for hint: ");
            try {
                choice = keyboard.nextInt();
            }
            catch(Exception error) {
                System.out.println("Incorrect input.");
                char junk = keyboard.next().charAt(0);
                continue;
            }

            if (choice > 2 || choice < 1)
                System.out.println("Incorrect input.\n");

            if (choice == 1) {
                System.out.print("Enter your guess: ");
                try {
                    letter = keyboard.next().charAt(0);
                }
                catch(Exception error) {
                    System.out.println("Incorrect input.");
                }
                if(array3.contains(letter))
                    System.out.println("Not valid input. You already guessed " + letter + ".\n");
                if(array4.contains(letter)) {
                    System.out.println("Not valid input. You already guessed " + letter + ".\n");
                    guesses--;
                }
                if (!array1.contains(letter) && !array4.contains(letter)) {
                        System.out.println("Sorry, " + letter + " isn't in the word.\n");
                        array4.add(letter);
                        guesses--;
                }
                if(array1.contains(letter) && !array3.contains(letter)) {
                    for (int i = 0; i < array1.size(); i++) {
                        if (letter == array1.get(i)) {
                            array2.remove(i);
                            array2.add(i, letter);
                            array3.add(letter);
                        }
                    }
                    System.out.println("Great! " + letter + " is in the word.\n");
                }
            }
            if(choice == 2){
                System.out.print("OK! The hint is ");
                for(int i = 0; i < array1.size(); i++) {
                    if (array2.get(i) == '_') {
                        array2.remove(i);
                        array2.add(i, array1.get(i));
                        array3.add(array1.get(i));
                        guesses--;
                        System.out.print(array1.get(i)+ "\n");
                        for(int j = i; j < array1.size(); j++) {
                            if(array2.get(i) == array1.get(j)){
                                array2.remove(j);
                                array2.add(j, array1.get(j));
                            }
                        }
                        if (guesses == 0 || array1.equals(array2)) {
                            System.out.print("\n");
                            break;
                        }
                        System.out.println("But since you used the hint, you can guess incorrectly " + guesses + " more times.\n");
                        break;
                    }
                }
            }
            if(array1.equals(array2)){
                System.out.print("Congratulations! The word was ");
                for (Character character : array1) System.out.print(character + " ");
                System.out.print("\n");
                done = true;
            }
            if (guesses == 0 && !array1.equals(array2)) {
                System.out.print("You failed. The word was ");
                for (Character character : array1) System.out.print(character + " ");
                System.out.print("\n");
                done = true;
            }
        }
    }
}
