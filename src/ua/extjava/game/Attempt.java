package ua.extjava.game;

public class Attempt
{
    private static int counterOfAttempts = 1;
    private int attemptID;
    private int guess;
    private int lowerBoundForThisGuess;
    private int upperBoundForThisGuess;
    private static int numberOfAttempts = 0;

    public Attempt(int guess, int lowerBound, int upperBound)
    {
        this.guess = guess;
        this.lowerBoundForThisGuess = lowerBound;
        this.upperBoundForThisGuess = upperBound;
        this.attemptID = counterOfAttempts;
        counterOfAttempts++;
        numberOfAttempts++;
    }

    @Override
    public String toString()
    {
        return  "Attempt №" + attemptID +
                ": \tGuess = " + guess +
                ", \tLower Bound = " + lowerBoundForThisGuess +
                ", \tUpper Bound = " + upperBoundForThisGuess +
                "\n";
    }

    public void setGuess(int guess)
    {
        this.guess = guess;
    }

    public void setLowerBoundForThisGuess(int lowerBound)
    {
        this.lowerBoundForThisGuess = lowerBound;
    }

    public void setUpperBoundForThisGuess(int upperBound)
    {
        this.upperBoundForThisGuess = upperBound;
    }

    public static int getNumberOfAttempts()
    {
        return numberOfAttempts;
    }
}
