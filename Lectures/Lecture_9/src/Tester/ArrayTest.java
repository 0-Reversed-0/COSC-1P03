package Tester;
import Stacks.*;

public class ArrayTest
{

    private ArrayStack Astack = new ArrayStack(10);

    public ArrayTest()
    {
        testPush();
        System.out.println("The item at the top if the stack should be 9. Item on top: " + Astack.peek()); // testing the peek function
        testPop();
    }

    /**
     * A test to check if our stack can pop out every value correctly using .pop() and .isEmpty()
     */

    void testPop()
    {
        while (!Astack.isEmpty()) // we can use the .isEmpty() to empty out the stack.
        {
            System.out.println(Astack.pop()); // this will show us how each value is "stacked" on top of each other
        }
    }

    /**
     * A test to check if our push work
     */

    void testPush()
    {
        for (int i = 4; i < 14; i++) // will be inputted from 0-9
        {
            Astack.push(i);
        }
    }

    public static void main(String[] args)
    {
        new ArrayTest();
    }
}
