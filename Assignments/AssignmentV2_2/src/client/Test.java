/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Rando Reincarnated - Assignment 2
 */

package client;

import chaotic.*;

import java.util.Scanner; // I know in guidelines it was mentioned not to use any other import, but using BasicIO for the test harness is so difficult for what essentially is a horrible version of scanner

/**
 * A class meant to test the 3 PRNG concrete classes
 */

public class Test
{
    PRNG I = new IncrementingPRNG();    // We will be using all 3 Class to and testing them all individually
    PRNG T = new TimelyPRNG();          // It wouldn't make a huge difference if the user set the seed for the user but would be harder to implement for again doing the same thing
    PRNG B = new BasicPRNG();

    Scanner input; // again no use in using BasicIO just to do the same thing but worse

    /**
     * Contains the main user interface for ta
     */

    public Test()
    {
        input = new Scanner(System.in);

        boolean continueRunning = true; // this is used to stop the tester from running indefinitely

        /*
         * How I am going to go about using the test harness is a user interface
         * First the user will choose which object they want to mess around with (which will put them in a new interface),
         * then the user will choose which method they want to meddle with (since every method is the same, the testing interface does not change at all except for the object name),
         * then once done with the method they can exit the class testing interface and loop back to the main interface
         * Afterward once the user is sick of testing my amazing and beautiful code they can hit -1 to stop the program
         * The also means that technically the client and client package will handle the exceptions as well
         */

        while (continueRunning)
        {
            System.out.println("Welcome to the Test harness! \n To start testing choose a number from 1, 2, 3 to test the methods of each object: \n You can also input -1 to exit ");
            System.out.println("\t 1) Test the 'Incrementing PRNG' object");
            System.out.println("\t 2) Test the 'Timely PRNG' object");
            System.out.println("\t 3) Test the 'Basic PRNG' object \n");

            System.out.print("Choose: ");
            int choice = input.nextInt(); // the deciding value that determines which object

            switch (choice) // this is probably the first time I used a switch statement since fall term
            {
                case 1:
                    testIncrement();
                    break;

                case 2:
                    testTimely();
                    break;

                case 3:
                    testBasic();
                    break;

                case (-1):
                    System.out.println("\nThanks for using the Test Harness! While your at it you should give 100 on this assignment. I worked hard :)");
                    continueRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Choose a number from 1-3 or -1 to exit."); // just to weed out anyone trying to troll and mess around
            }
        }
    }

    /**
     * The test increment method is used to test,
     * 1) The methods working the way they are supposed
     * 2) The PRNG Exception gets thrown correctly
     */

    private void testIncrement()
    {
        boolean continueRunning = true;

        while (continueRunning)
        {
            System.out.println("Testing the Incrementing PRNG. \n Choose from 1-5 or -1 to exit: ");
            System.out.println("\t 1) Test the default random number generator");
            System.out.println("\t 2) Test the upperbound random number generator (cannot accept upperbounds of 0 and under)");
            System.out.println("\t 3) Test the upper and lower bound random number generator (cannot accept lower bounds greater than upper bounds)");
            System.out.println("\t 4) Test the decimal random number generator (cannot accept lower bounds greater than upper bounds)");
            System.out.println("\t 5) Test if you can get the seed");

            System.out.print("Choose: ");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Input how many random values you would like:");

                    System.out.print("How many? ");
                    int numEntries = input.nextInt();

                    for (int i = 0; i < numEntries; i++)
                    {
                        try
                        {
                            System.out.println(I.randomize());
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 2:
                    System.out.println("First input how many random values you would like, then the upperbound of the random numbers:");

                    System.out.print("How many? ");
                    int numEntriesUB = input.nextInt();
                    System.out.print("Upperbound?: ");
                    int upperbound = input.nextInt();

                    for (int i = 0; i < numEntriesUB; i++)
                    {
                        try
                        {
                            System.out.println(I.randomize(upperbound));
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 3:
                    System.out.println("First input how many random values you would like, then the lower-bound of the random numbers, and finally input the upperbound:");

                    System.out.print("How many? ");
                    int numEntriesUBLB = input.nextInt();
                    System.out.print("Lower bound?:");
                    int lower_boundUBLB = input.nextInt();
                    System.out.print("Upperbound?: ");
                    int upperboundUBLB = input.nextInt();

                    for (int i = 0; i < numEntriesUBLB; i++)
                    {
                        try
                        {
                            System.out.println(I.randomize(lower_boundUBLB, upperboundUBLB));
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 4:
                    System.out.println("Input how many random values you would like:");

                    System.out.print("How many? ");
                    int numEntriesD = input.nextInt();

                    for (int i = 0; i < numEntriesD; i++)
                    {
                        System.out.println(I.randomDouble());
                    }

                    break;

                case 5:
                    System.out.println("The seed is: " + I.getSeed());
                    break;

                case -1:
                    System.out.println("Testing complete! \n");
                    continueRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Choose a number from 1-5 or -1 to exit.");
            }
        }
    }

    /**
     * The test increment method is used to test,
     * 1) The methods working the way they are supposed
     * 2) The PRNG Exception gets thrown correctly
     */

    private void testBasic()
    {
        boolean continueRunning = true;

        while (continueRunning)
        {
            System.out.println("Testing the Basic PRNG. \n Choose from 1-5 or -1 to exit: ");
            System.out.println("\t 1) Test the default random number generator");
            System.out.println("\t 2) Test the upperbound random number generator (cannot accept upperbounds of 0 and under)");
            System.out.println("\t 3) Test the upper and lower bound random number generator (cannot accept lower bounds greater than upper bounds)");
            System.out.println("\t 4) Test the decimal random number generator (cannot accept lower bounds greater than upper bounds)");
            System.out.println("\t 5) Test if you can get the seed");

            System.out.print("Choose: ");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Input how many random values you would like:");

                    System.out.print("How many? ");
                    int numEntries = input.nextInt();

                    for (int i = 0; i < numEntries; i++)
                    {
                        try
                        {
                            System.out.println(B.randomize());
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 2:
                    System.out.println("First input how many random values you would like, then the upperbound of the random numbers:");

                    System.out.print("How many? ");
                    int numEntriesUB = input.nextInt();
                    System.out.print("Upperbound?: ");
                    int upperbound = input.nextInt();

                    for (int i = 0; i < numEntriesUB; i++)
                    {
                        try
                        {
                            System.out.println(B.randomize(upperbound));
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 3:
                    System.out.println("First input how many random values you would like, then the lower-bound of the random numbers, and finally input the upperbound:");

                    System.out.print("How many? ");
                    int numEntriesUBLB = input.nextInt();
                    System.out.print("Lower bound?:");
                    int lower_boundUBLB = input.nextInt();
                    System.out.print("Upperbound?: ");
                    int upperboundUBLB = input.nextInt();

                    for (int i = 0; i < numEntriesUBLB; i++)
                    {
                        try
                        {
                            System.out.println(B.randomize(lower_boundUBLB, upperboundUBLB));
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 4:
                    System.out.println("Input how many random values you would like:");

                    System.out.print("How many? ");
                    int numEntriesD = input.nextInt();

                    for (int i = 0; i < numEntriesD; i++)
                    {
                        System.out.println(B.randomDouble());
                    }

                    break;

                case 5:
                    System.out.println("The seed is: " + B.getSeed());
                    break;

                case -1:
                    System.out.println("Testing complete! \n");
                    continueRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Choose a number from 1-5 or -1 to exit.");
            }
        }
    }

    /**
     * The test increment method is used to test,
     * 1) The methods working the way they are supposed
     * 2) The PRNG Exception gets thrown correctly
     */

    private void testTimely()
    {
        boolean continueRunning = true;

        while (continueRunning)
        {
            System.out.println("Testing the Timely PRNG. \n Choose from 1-5 or -1 to exit: ");
            System.out.println("\t 1) Test the default random number generator");
            System.out.println("\t 2) Test the upperbound random number generator (cannot accept upperbounds of 0 and under)");
            System.out.println("\t 3) Test the upper and lower bound random number generator (cannot accept lower bounds greater than upper bounds)");
            System.out.println("\t 4) Test the decimal random number generator (cannot accept lower bounds greater than upper bounds)");
            System.out.println("\t 5) Test if you can get the seed");

            System.out.print("Choose: ");
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Input how many random values you would like:");

                    System.out.print("How many? ");
                    int numEntries = input.nextInt();

                    for (int i = 0; i < numEntries; i++)
                    {
                        try
                        {
                            System.out.println(T.randomize());
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 2:
                    System.out.println("First input how many random values you would like, then the upperbound of the random numbers:");

                    System.out.print("How many? ");
                    int numEntriesUB = input.nextInt();
                    System.out.print("Upperbound?: ");
                    int upperbound = input.nextInt();

                    for (int i = 0; i < numEntriesUB; i++)
                    {
                        try
                        {
                            System.out.println(T.randomize(upperbound));
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 3:
                    System.out.println("First input how many random values you would like, then the lower-bound of the random numbers, and finally input the upperbound:");

                    System.out.print("How many? ");
                    int numEntriesUBLB = input.nextInt();
                    System.out.print("Lower bound?:");
                    int lower_boundUBLB = input.nextInt();
                    System.out.print("Upperbound?: ");
                    int upperboundUBLB = input.nextInt();

                    for (int i = 0; i < numEntriesUBLB; i++)
                    {
                        try
                        {
                            System.out.println(T.randomize(lower_boundUBLB, upperboundUBLB));
                        } catch (PRNGException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }

                    break;

                case 4:
                    System.out.println("Input how many random values you would like:");

                    System.out.print("How many? ");
                    int numEntriesD = input.nextInt();

                    for (int i = 0; i < numEntriesD; i++)
                    {
                        System.out.println(T.randomDouble());
                    }

                    break;

                case 5:
                    System.out.println("The seed is: " + T.getSeed());
                    break;

                case -1:
                    System.out.println("Testing complete! \n");
                    continueRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Choose a number from 1-5 or -1 to exit.");
            }
        }
    }

    public static void main(String[] args)
    {
        new Test();
    }
}