package ua.epam.javaexternal.game;

import java.util.ArrayList;
import java.util.List;

public class View
{
    public static final String START_THE_GAME_MSG = "The game is started!\n";
    public static final String GUESS_THE_NUM_MSG = "Try to guess the number in the range from ";
    public  static final String ENTER_GUESS_MSG = "\nEnter your guess: ";

    public static final String GUESS_IS_INCORRECT_MSG = "\nYou didn't guess the number! Try again!\n";
    public static final String GUESS_IS_CORRECT_MSG = "\nCongratulations! This is the correct answer!\n";
    public static final String THE_RIGHT_ANSWER = "The searched number is:\t";
    public static final String WRONG_INPUT_MSG = "\nWrong input!";
    public static final String INCORRECT_TYPE_MSG = "\nThe type of the guess is incorrect! It has to be an integer!";

    public static final String NUM_IS_BIGGER_MSG = "The number is bigger than ";
    public static final String NUM_IS_SMALLER_MSG = "The number is smaller than ";

    public void printMessage(String msg)
    {
        System.out.print(msg);
    }

    public void printGameStatistics(ArrayList<Attempt> attempts)
    {
        System.out.println("\n\nGame statistics:\n");

        for(Attempt element: attempts)
        {
            System.out.println(element);
        }

        System.out.println("Number of attempts:\t" + Attempt.getNumberOfAttempts());
    }
}

