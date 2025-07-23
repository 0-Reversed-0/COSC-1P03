package Tester;

import Stacks.*;

public class LinkedTest
{
    Stack Lstack = new LinkedStack();

    public LinkedTest()
    {
        testPush();
        System.out.println("The item at the top if the stack should be 9. Item on top: " + Lstack.peek()); // testing the peek function
        testPop();

    }

    /**
     * A test to check if our stack can pop out every value correctly using .pop() and .isEmpty()
     */

    void testPop()
    {
        while (!Lstack.isEmpty()) // we can use the .isEmpty() to empty out the stack.
        {
            System.out.println(Lstack.pop()); // this will show us how each value is "stacked" on top of each other
        }
    }

    /**
     * A test to check if our push work
     */

    void testPush()
    {
        for (int i = 0; i < 10; i++)
        {
            Lstack.push(i);
        }
    }

    public static void main(String[] args)
    {
        new LinkedTest();
    }
}
