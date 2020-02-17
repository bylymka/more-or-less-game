package ua.epam.javaexternal.game;

import java.util.*;

public class View
{
   /* public static final String START_THE_GAME_MSG = "The game is started!\n";
    public static final String GUESS_THE_NUM_MSG = "Try to guess the number in the range from ";
    public  static final String ENTER_GUESS_MSG = "\nEnter your guess: ";
    public  static final String CHOOSE_THE_LANGUAGE_MSG = "\nChoose the language:\n1 - English\n2 - Ukrainian";

    public static final String GUESS_IS_INCORRECT_MSG = "\nYou didn't guess the number! Try again!\n";
    public static final String GUESS_IS_CORRECT_MSG = "\nCongratulations! This is the correct answer!\n";
    public static final String THE_RIGHT_ANSWER_MSG = "The searched number is:\t";
    public static final String WRONG_INPUT_MSG = "\nWrong input!";
    public static final String INCORRECT_TYPE_MSG = "\nThe type of the guess is incorrect! It has to be an integer!";

    public static final String LOWER_BOUND_MSG = "The lower bound: ";
    public static final String UPPER_BOUND_MSG = "The upper bound: "; */

   Locale locale;
   ResourceBundle resourceBundle;

   Locale defaultLocale = new Locale("en", "US");
   ResourceBundle defaultResourceBundle = ResourceBundle.getBundle("property/language", defaultLocale);

    public void setLocale(Locale locale)
    {
       this.locale = locale;
       this.resourceBundle = ResourceBundle.getBundle("language", locale);

       if(locale == null)
       {
           this.locale = defaultLocale;
           this.resourceBundle = defaultResourceBundle;
       }
    }

    public  static final String CHOOSE_THE_LANGUAGE_MSG = "\nChoose the language:\n1 - English\n2 - Ukrainian\n";
    public static final String START_THE_GAME_MSG = "start_the_game";
    public static final String GUESS_THE_NUM_MSG = "guess_num";
    public  static final String ENTER_GUESS_MSG = "enter_guess";

    public static final String GUESS_IS_INCORRECT_MSG = "guess_is_incorrect";
    public static final String GUESS_IS_CORRECT_MSG = "guess_is_correct";
    public static final String THE_RIGHT_ANSWER_MSG = "right_answer";
    public static final String WRONG_INPUT_MSG = "wrong_input";
    public static final String INCORRECT_TYPE_MSG = "incorrect_type";
    public static final String GUESS_IS_OUT_OF_BOUNDS_MSG = "out_of_bounds";
    public static final String LOWER_BOUND_MSG = "lower_bound";
    public static final String UPPER_BOUND_MSG = "upper_bound";

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

