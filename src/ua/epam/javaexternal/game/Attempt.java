package ua.epam.javaexternal.game;

public class Attempt
{
    private static int counter = 1;
    private int attemptID;
    private int userGuess;
    private int tempLowerBound;
    private int tempUpperBound;
    private static int numberOfAttempts = 0;

    public Attempt(int userGuess, int tempLowerBound, int tempUpperBound)
    {
        this.userGuess = userGuess;
        this.tempLowerBound = tempLowerBound;
        this.tempUpperBound = tempUpperBound;
        this.attemptID = counter;
        counter++;
        numberOfAttempts++;
    }

    @Override
    public String toString()
    {
        return  "Attempt №" + attemptID +
                ": \tGuess = \t" + userGuess +
                ", \tLower Bound = " + tempLowerBound +
                ", \tUpper Bound = " + tempUpperBound +
                "\n";
    }

    public void setUserGuess(int userGuess)
    {
        this.userGuess = userGuess;
    }

    public void setTempLowerBound(int tempLowerBound)
    {
        this.tempLowerBound = tempLowerBound;
    }

    public void setTempUpperBound(int tempUpperBound)
    {
        this.tempUpperBound = tempUpperBound;
    }

    public static int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}
