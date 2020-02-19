package ua.extjava.game;

import java.util.ArrayList;
import java.util.Random;

public class Model
{
    private final int INITIAL_LOWER_BOUND = 0;
    private final int INITIAL_UPPER_BOUND = 100;

    private int targetNumber;
    private int userGuess;
    private int lowerBound = INITIAL_LOWER_BOUND;
    private int upperBound = INITIAL_UPPER_BOUND;
    private ArrayList<Attempt> userAttemptsList = new ArrayList<Attempt>();


    public void setTargetNumber()
    {
        Random random = new Random();
        targetNumber = random.nextInt(100);
    }

    public int getTargetNumber()
    {
        return targetNumber;
    }

    public void setLowerBound(int lowerBound)
    {
        this.lowerBound = lowerBound;
    }

    public int getLowerBound()
    {
        return lowerBound;
    }

    public void setUpperBound(int upperBound)
    {
        this.upperBound = upperBound;
    }

    public int getUpperBound()
    {
        return upperBound;
    }

    public void setUserGuess(int guess) { this.userGuess = guess; }

    public int getUserGuess()
    {
        return userGuess;
    }

    public boolean isGuessedTheSearchedNum()
    {
        if(userGuess == targetNumber)
            return true;
        else
            return false;
    }

    public boolean isGuessOutOfBounds(int guess)
    {
        if(guess > upperBound || guess < lowerBound)
            return true;
        else
            return false;
    }

    public void addAttemptToUserAttemptsList(Attempt attempt)
    {
        userAttemptsList.add(attempt);
    }

    public ArrayList<Attempt> getUserAttemptsList()
    {
        return userAttemptsList;
    }
}

