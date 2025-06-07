/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Rando Reincarnated - Assignment 2
 */

package client;

import chaotic.*;

import java.util.Scanner;

/**
 * A class used to demonstrate how a user might want to use our random number generator in a fun little game!!!!
 */

public class HiLo
{

    Scanner input = new Scanner(System.in);
    PRNG I = new IncrementingPRNG();
    PRNG T = new TimelyPRNG();
    PRNG B = new BasicPRNG();

    public HiLo()
    {
        boolean isRunning = true;

        System.out.print("\nFirst, before we start the game choose the limit on how far the winning number can generate to: ");
        int range = input.nextInt();
        System.out.print("and where they start: ");
        int lower_bound = input.nextInt();
        System.out.println();

        while (isRunning)
        {
            System.out.println("Welcome to the HiLo Guessing Game!!!!");
            System.out.println("To start playing first pick which object you would like to use to randomize the guess!");
            System.out.println("\t 1) Increment Object");
            System.out.println("\t 2) Timely Object");
            System.out.println("\t 3) Basic Object");
            System.out.println("Pick 1 - 3 or -1 to exit\n");

            System.out.print("Choose: ");
            int choice = input.nextInt();

            switch (choice)
            {
                case 1:
                    hiloIncrement(range, lower_bound);
                    break;
                case 2:
                    hiloTimely(range, lower_bound);
                    break;
                case 3:
                    hiloBasic(range, lower_bound);
                    break;
                case (-1):
                    System.out.println("\nThanks for playing!\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pick a number between 1-3 to play or -1 to stop playing");
            }
        }
    }

    /**
     * If the user decides to guess using the increment object then this method would be called
     */

    private void hiloIncrement(int range, int lower_bound)
    {
        int currentAnswer = (int) (range * I.randomDouble() + lower_bound); // literally using it like a Math.random function

        /*
         * I also used .randomDouble() because I do not want to include a try-catch in this method.
         * If you want to see the use of try-catch then see to Test.java
         */

        while (true)
        {
            System.out.println("Guess a number between " + lower_bound + " and " + range + " please. \n");
            int guess = input.nextInt();

            if (currentAnswer == guess)
            {
                System.out.println("You did it OMG YAY YIPPEE!!!!!!\n");
                break;
            } else if (currentAnswer > guess)
            {
                System.out.println("Guess again :( ... Lo\n");
            } else if (currentAnswer < guess)
            {
                System.out.println("Guess again :( ... Hi\n");
            } else
            {
                System.out.println("Dont be silly pick inside the range\n");
            }
        }
    }

    /**
     * If the user decides to guess using the timely object then this method would be called
     */

    private void hiloTimely(int range, int lower_bound)
    {
        int currentAnswer = (int) (range * T.randomDouble() + lower_bound); // literally using it like a Math.random function

        /*
         * I also used .randomDouble() because I do not want to include a try-catch in this method.
         * If you want to see the use of try-catch then see to Test.java
         */

        while (true)
        {
            System.out.println("Guess a number between " + lower_bound + " and " + range + " please. \n");
            int guess = input.nextInt();

            if (currentAnswer == guess)
            {
                System.out.println("You did it OMG YAY YIPPEE!!!!!!\n");
                break;
            } else if (currentAnswer > guess)
            {
                System.out.println("Guess again :( ... Lo\n");
            } else if (currentAnswer < guess)
            {
                System.out.println("Guess again :( ... Hi\n");
            } else
            {
                System.out.println("Dont be silly pick inside the range\n");
            }
        }
    }

    /**
     * If the user decides to guess using the basic object then this method would be called
     */

    private void hiloBasic(int range, int lower_bound)
    {
        int currentAnswer = (int) (range * B.randomDouble() + lower_bound); // literally using it like a Math.random function

        /*
         * I also used .randomDouble() because I do not want to include a try-catch in this method.
         * If you want to see the use of try-catch then see to Test.java
         */

        while (true)
        {
            System.out.println("Guess a number between " + lower_bound + " and " + range + " please. \n");
            int guess = input.nextInt();

            if (currentAnswer == guess)
            {
                System.out.println("You did it OMG YAY YIPPEE!!!!!!\n");
                break;
            } else if (currentAnswer > guess)
            {
                System.out.println("Guess again :( ... Lo\n");
            } else if (currentAnswer < guess)
            {
                System.out.println("Guess again :( ... Hi\n");
            } else
            {
                System.out.println("Dont be silly pick inside the range\n");
            }
        }
    }

    public static void main(String[] args)
    {
        new HiLo();
    }
}
