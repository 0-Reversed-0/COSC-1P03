package client;

import chaotic.*;

import java.util.Scanner; // I want to make the Test harness a little funner

public class Test
{
    PRNG I = new IncrementingPRNG();
    PRNG T = new TimelyPRNG();
    PRNG B = new BasicPRNG();

    Scanner input;

    public Test()
    {
        input = new Scanner(System.in);

        boolean continueRunning = true;

        while (continueRunning)
        {
            System.out.println("Welcome to the Test harness! \n To start testing choose a number from 1, 2, 3 to test the methods of each object: \n You can also input -1 to exit ");
            System.out.println("\t1) Test the 'Incrementing PRNG' class");
            System.out.println("\t2) Test the 'Timely PRNG' class");
            System.out.println("\t3) Test the 'Basic PRNG' class \n");

            int choice = input.nextInt();
            switch (choice)
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
                    System.out.println("\nThanks for using the Test Harness!");
                    continueRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Choose a number from 1-3 or -1 to exit.");
            }
        }
    }

    private void testIncrement()
    {
        boolean continueRunning = true;

        while (continueRunning)
        {
            int choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Input how many random values you would like:");
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
                    System.out.println("Upperbound?: ");
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
                    System.out.println("Input how many random values you would like:");
                    break;

                case 4:
                    System.out.println("Input how many random values you would like:");
                    break;

                case 5:
                    System.out.println("The seed is: " + I.getSeed());
                    break;

                case -1:
                    System.out.println("Testing complete! \n");
                    continueRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Choose a number from 1-3 or -1 to exit.");
            }
        }
    }

    private void testBasic()
    {
    }

    private void testTimely()
    {
    }

    public static void main(String[] args)
    {
        new Test();
    }
}