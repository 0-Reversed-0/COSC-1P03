/**
 * This Lecture goes into lengthy detail on what Interfaces are,
 * How Interfaces are implemented and Exception Handling.
 */

import Exceptions.CheckedException;
import Exceptions.UncheckedException;
import ADTs.*;

public class Main
{

    InterfaceImplementation Pool = new InterfaceImplementation(5);

    public Main()
    {
        poolTest();
        tryCatch();
        try
        {
            throwExample(-1); // This call of this method physically will not work unless handled with a try catch block
        }
        catch(CheckedException e)
        {
            System.out.println(e.getMessage()); // We can also
        }
    }

    /**
     * Try-Catch is a way of testing code to see if it might throw up an exception
     * It is under the wing of something called exception handling which is what the name implies (You deal with exceptions directly rather than crashing the program)
     */

    void tryCatch()
    {
        try //try catch is basically where you have a block of code you want to see if it works
        {
            //This is the code we want to "try" out
            InterfaceImplementation p = new InterfaceImplementation(-20); // we cannot -20 as a valid capacity obviously so this will throw a StopTrollingException
        } catch (UncheckedException e) // here it catches any exception that it comes by
        {
            System.out.println("why dude"); // gives us a message instead of crashing out code
        }
    }

    /**
     * Throw is a little different from try-catch.
     *
     * @param age - for testing purposes to see if someone wants to troll and put a negative number as an age
     */

    int throwExample(int age) throws CheckedException
    {
        /*
         * Throw works by wanting our code to work in one specific way
         * Example: I want to have a value for age in an object and I do not want any negative number for age
         * To avoid negative numbers we can have throw a specific exception for this exact issue and have it dealt with
         */

        if (age > 0)
        {
            int Age = age;
            return Age;
        } else
        {
            throw new CheckedException("Age cannot be negative");
        }
    }

    /**
     * Here we can test our Unordered Pool and verify whether the method we actually bothered to implement works.
     */

    void poolTest()
    {
        InterfaceImplementation pool = new InterfaceImplementation(3);

        pool.add(new Measurement("Big Bird", 20.4, "XL"));
        pool.add(new Measurement("Small Bird", 12.2, "XS"));
        pool.add(new Measurement("birb", 15.0, "M"));

        System.out.println(pool.max()); // we can print the object directly since we have our beautiful toString method
        System.out.println(pool.min());
    }

    public static void main(String[] args)
    {
        new Main();
    }
}