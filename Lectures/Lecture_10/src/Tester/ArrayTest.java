package Tester;

import Que.*;

/**
 * A simple tester to show that the Array Queue works!
 * Notice how it is implemented word for word as the LinkedTest?
 * This is because I am lazy and also because it shows how it works exactly as a Queue is supposed to work regardless of the implementation (How ADTs should be handled)
 */

public class ArrayTest
{

    Queue AQueue = new ArrayQueue(10);

    public ArrayTest()
    {
        fill(); // First we want to show if we can fill the Queue up!

        System.out.println("\tThe amount of items in the Queue currently is: " + AQueue.size()); // then just for demonstration we show the size and the top/front of the Queue
        System.out.println("\tThe item at the front of the Queue is: " + AQueue.front());

        emptyOut(); // finally we empty it out just to show that it works
    }

    /**
     * A method that uses the .isEmpty() method to empty out the Queue
     */

    private void emptyOut()
    {
        System.out.println();

        while (!AQueue.isEmpty())
        {
            System.out.println("Removed " + AQueue.remove() + " from the Queue");
        }

        System.out.println();
    }

    /**
     * Another method that shows that our item was added to the Queue
     */

    private void fill()
    {
        System.out.println();

        for (int i = 0; i < 10; i++)
        {
            String item = ("" + i);
            AQueue.add(item);
            System.out.println("Added " + item + " to the Queue");
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        new ArrayTest();
    }
}
