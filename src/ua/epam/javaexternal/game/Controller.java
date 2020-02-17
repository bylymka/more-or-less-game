package ua.epam.javaexternal.game;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Controller {
    private View view;
    private Model model;
    public ArrayList<Attempt> attempts = new ArrayList<Attempt>();
    private Attempt userAttempt;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void start() {

        view.printMessage(View.START_THE_GAME_MSG);
        chooseTheLanguage();
        model.setRandNumber();

        view.printMessage(View.GUESS_THE_NUM_MSG +
                model.getLowerBound() + " to " + model.getUpperBound() + "\n");

        view.printMessage(View.ENTER_GUESS_MSG);
        getValueOfGuessFromUser();

        while (!isGuessCorrect())
        {
            giveUserChanceToTryAgain();
        }

        view.printMessage(View.GUESS_IS_CORRECT_MSG);

        view.printGameStatistics(attempts);
        view.printMessage(View.THE_RIGHT_ANSWER_MSG + model.getNumber() + "\n");
        displayBounds();
    }

    /*
     *
     * Utility functions
     *
     */

    public void chooseTheLanguage()
    {
        view.printMessage(View.CHOOSE_THE_LANGUAGE_MSG);
        Scanner getUserInput = new Scanner(System.in);
        int lang = getUserInput.nextInt();

        switch(lang)
        {
            case 1: view.setLocale(new Locale("en", "US"));
            case 2: view.setLocale(new Locale("uk", "UA"));
            default: view.printMessage(View.WRONG_INPUT_MSG);
        }
    }

    public  void displayBounds()
    {
        System.out.println(View.LOWER_BOUND_MSG + model.getLowerBound());
        System.out.println(View.UPPER_BOUND_MSG + model.getUpperBound());
    }

    private boolean isGuessOutOfBounds(int guess)
    {
        if(guess > model.getUpperBound() || guess < model.getLowerBound())
            return true;
        else
            return false;
    }

    private void getValueOfGuessFromUser()
    {
        try
        {
            Scanner getUserInput = new Scanner(System.in);
            int attempt = getUserInput.nextInt();

            if(!isGuessOutOfBounds(attempt))
            {
                model.setGuess(attempt);
                userAttempt = new Attempt(model.getGuess(), model.getLowerBound(), model.getUpperBound());
                attempts.add(userAttempt);
            }
            else
            {
                view.printMessage(View.GUESS_IS_OUT_OF_BOUNDS_MSG);
            }
        }
        catch (InputMismatchException ex)
        {
            view.printMessage(View.INCORRECT_TYPE_MSG);
        }
    }

    private boolean isGuessCorrect()
    {
        if(model.getGuess() == model.getNumber())
            return true;
        else
            return false;
    }

    public void giveUserChanceToTryAgain()
    {
        view.printMessage(View.GUESS_IS_INCORRECT_MSG);

        if(!isGuessOutOfBounds(model.getGuess()))
        {
            if (model.getGuess() < model.getNumber())
            {
                model.setLowerBound(model.getGuess());
            }
            else
            {
                model.setUpperBound(model.getGuess());
            }
        }

        displayBounds();
        view.printMessage(View.ENTER_GUESS_MSG);

        getValueOfGuessFromUser();
    }
}