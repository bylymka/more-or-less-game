package ua.epam.javaexternal.game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Model
{
    private int number;
    private int guess;
    private int lowerBound = 0;
    private int upperBound = 100;

    public void setRandNumber()
    {
        Random random = new Random();
        number = random.nextInt(100);
    }

    public int getNumber()
    {
        return number;
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

    public void setGuess(int guess) { this.guess = guess; }

    public int getGuess()
    {
        return guess;
    }

    private boolean isGuessOutOfBounds(int guess)
    {
        if(guess > this.getUpperBound() || guess < this.getLowerBound())
            return true;
        else
            return false;
    }
}

