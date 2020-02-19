package ua.extjava.game;

import java.util.Locale;
import java.util.ResourceBundle;

public class View
{
    public static ResourceBundle resourceBundle;
    public  static final String MESSAGES_BUNDLE_NAME = "language";

    public void setLanguage(int userSelectedLanguage)
    {
        Locale ukrainianLocale = new Locale("uk", "UA");
        Locale englishLocale = new Locale("en", "US");
        Locale defaultLocale = englishLocale;

        switch (userSelectedLanguage) {
            case 1:
                resourceBundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, englishLocale);
                break;
            case 2:
                resourceBundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, ukrainianLocale);
                break;
            default:
                resourceBundle = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, defaultLocale);
                break;
        }
    }

    public  static final String CHOOSE_THE_LANGUAGE_MSG = "\nChoose the language:\n1 - English\n2 - Ukrainian\nYour choice: ";
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


    public static void printMessage(String msg)
    {
        System.out.print(msg);
    }

    public void printGameStatistics(Model model)
    {
        System.out.println("\n\nGame statistics:\n");

        for(Attempt attempt: model.getUserAttemptsList())
        {
            System.out.println(attempt);
        }

        System.out.println("Number of attempts:\t" + Attempt.getNumberOfAttempts());
    }

    public void displayBounds(Model model)
    {
        System.out.println(resourceBundle.getString(LOWER_BOUND_MSG) + model.getLowerBound());
        System.out.println(resourceBundle.getString(UPPER_BOUND_MSG) + model.getUpperBound());
    }

    public void displayRightAnswer(Model model)
    {
        System.out.println(resourceBundle.getString(THE_RIGHT_ANSWER_MSG) + model.getTargetNumber() + "\n");
    }

    public void guessTargetNumInTheRangeFromTo(Model model)
    {
        System.out.println(resourceBundle.getString(View.GUESS_THE_NUM_MSG) +
                model.getLowerBound() + " to " + model.getUpperBound());
    }

}
