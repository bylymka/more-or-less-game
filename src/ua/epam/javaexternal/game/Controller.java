package ua.epam.javaexternal.game;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Controller
{
    private View view;
    private Model model;
    public ArrayList <Attempt> attempts = new ArrayList<Attempt>();
    private Attempt attempt;

    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
    }

    public void start()
    {
        view.printMessage(View.START_THE_GAME_MSG);
        model.setRandNumber();

        view.printMessage(View.GUESS_THE_NUM_MSG  +
                model.getLowerBound() + " to " + model.getUpperBound() + "\n");

        view.printMessage(View.ENTER_GUESS_MSG);
        getValueOfGuessFromUser();

        if(isGuessOutOfBounds())
        {
            view.printMessage(View.WRONG_INPUT_MSG);
        }

        while(!isGuessCorrect())
        {
            giveUserChanceToTryAgain();
        }

        view.printMessage(View.GUESS_IS_CORRECT_MSG);

        view.printGameStatistics(attempts);
        view.printMessage(View.THE_RIGHT_ANSWER + model.getNumber() + "\n");
        displayBounds();
    }

    /*
     *
     * Utility functions
     *
     */

    public  void displayBounds()
    {
        System.out.println("Lower bound is: " + model.getLowerBound());
        System.out.println("Upper bound is: " + model.getUpperBound());
    }

    private boolean isGuessOutOfBounds()
    {
        if(model.getGuess() > model.getUpperBound() ||
                model.getGuess() < model.getLowerBound())
            return true;
        else
            return false;
    }

    private void getValueOfGuessFromUser()
    {
        try
        {
            Scanner getUserInput = new Scanner(System.in);
            model.setGuess(getUserInput.nextInt());
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
        attempt = new Attempt(model.getGuess(), model.getLowerBound(), model.getUpperBound());

        attempts.add(attempt);

        view.printMessage(View.GUESS_IS_INCORRECT_MSG);

        if(!isGuessOutOfBounds())
        {
            if (model.getGuess() < model.getNumber())
            {
                view.printMessage(View.NUM_IS_BIGGER_MSG + model.getGuess() + "\n");
                model.setLowerBound(model.getGuess());
            } else
            {
                view.printMessage(View.NUM_IS_SMALLER_MSG + model.getGuess() + "\n");
                model.setUpperBound(model.getGuess());
            }
        }

        displayBounds();

        view.printMessage(View.ENTER_GUESS_MSG);
        getValueOfGuessFromUser();

        if(isGuessOutOfBounds())
        {
            view.printMessage(View.WRONG_INPUT_MSG);
        }
    }
}