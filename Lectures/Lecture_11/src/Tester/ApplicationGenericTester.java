package Tester;

import Generics.Application.*;

/**
 * This class goes over how we would actually apply generics in a 'realistic' setting
 */

public class ApplicationGenericTester
{

    /**
     * Let's say we have a cabinet that has multiple boxes
     * Each box is a stack that holds different types of data.
     * The problem is, normally we would have to make multiple versions of a stack to make this work out
     * And especially if we start introducing customization where a user inputs their own custom object to store in the stack where they won't be able to add it to the box
     * We can easily solve this problem using parameterized classes as seen below.
     */

    private Stack<Integer> integerBox = new Stack<>(); // Now notice how we're easily able to have our Stack hold integers rather than making a whole new class just to hold a different data
    private Stack<String> stringBox = new Stack<>();
    private Stack<Double> doubleBox = new Stack<>(); // Note that you can shorten the initialization of a new stack's parameters to just <> since you do not need to add it every time

    public ApplicationGenericTester()
    {
        cabinet();
    }

    void cabinet()
    {
        System.out.println("You're at a cabinet somehow");

        setIntegerBox();
        setDoubleBox();
        setStringBox();
    }

    /**
     * This method is just to add integers to the box just to show that we can.
     */

    void setIntegerBox()
    {
        System.out.println("Took the Integer box out...");
        System.out.println("Adding 1-20 to the box...");

        for (int i = 0; i <= 20; i++)
        {
            integerBox.push(i); //now we can just add integers to the stack without needing to create a whole new stack class
            System.out.println("Adding: " + i + " ");
        }
    }

    /**
     * This method is for adding doubles to the box
     */

    void setDoubleBox()
    {
        System.out.println("Took the Double box out...");
        System.out.println("Adding 0.1-0.9 to the box...");

        for (double i = 0.1; i <= 0.9; i += 0.1)
        {
            doubleBox.push(i);
            System.out.println("Adding: " + i + " ");
        }
    }

    /**
     * I'm too lazy to this one sorry :(
     */

    void setStringBox()
    {
        System.out.println("Took the String box out..");
        System.out.println("Adding the word to the box:");

        stringBox.push("word");
    }

    public static void main(String[] args)
    {
        new ApplicationGenericTester();
    }
}
