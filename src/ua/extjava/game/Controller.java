package ua.extjava.game;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller
{
    private View view;
    private Model model;

    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
    }

    public void start()
    {
        int selectedLanguage = selectLanguage();
        view.setLanguage(selectedLanguage);

        View.printMessage(View.resourceBundle.getString(View.START_THE_GAME_MSG));

        model.setTargetNumber();
        view.guessTargetNumInTheRangeFromTo(model);

        View.printMessage(View.resourceBundle.getString(View.ENTER_GUESS_MSG));
        getAndValidateGuess();

        while (!model.isGuessedTheSearchedNum()) {
            giveUserChanceToTryAgain();
        }
        View.printMessage(View.resourceBundle.getString(View.GUESS_IS_CORRECT_MSG));

        view.printGameStatistics(model);
        view.displayRightAnswer(model);
        view.displayBounds(model);
    }


    /**
     **
     ** UTILITY FUNCTIONS!
     **
     */

    public int selectLanguage()
    {
        View.printMessage(View.CHOOSE_THE_LANGUAGE_MSG);
        Scanner getUserInput = new Scanner(System.in);
        int selectedLanguage = getUserInput.nextInt();
        return selectedLanguage;
    }


    public void getAndValidateGuess()
    {
        try
        {
            Scanner getUserInput = new Scanner(System.in);

            // might throw InputMismatchException if user enters incorrect type
            int guess = getUserInput.nextInt();

            if(model.isGuessOutOfBounds(guess))
            {
                View.printMessage(View.resourceBundle.getString(View.GUESS_IS_OUT_OF_BOUNDS_MSG));
            }
            else
            {
                model.setUserGuess(guess);
                Attempt attempt = new Attempt(model.getUserGuess(), model.getLowerBound(), model.getUpperBound());
                model.addAttemptToUserAttemptsList(attempt);
            }
        }
        catch (InputMismatchException ex)
        {
            View.printMessage(View.resourceBundle.getString(View.INCORRECT_TYPE_MSG));
        }
    }

    public void giveUserChanceToTryAgain()
    {
        View.printMessage(View.resourceBundle.getString(View.GUESS_IS_INCORRECT_MSG));

        if(!model.isGuessOutOfBounds(model.getUserGuess()))
        {
            if (model.getUserGuess() < model.getTargetNumber())
            {
                model.setLowerBound(model.getUserGuess());
            }
            else
            {
                model.setUpperBound(model.getUserGuess());
            }
        }
        view.displayBounds(model);

        View.printMessage(View.resourceBundle.getString(View.ENTER_GUESS_MSG));
        getAndValidateGuess();
    }
}