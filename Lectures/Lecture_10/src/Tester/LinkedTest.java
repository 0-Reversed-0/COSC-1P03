package Tester;
import Que.LinkedQueue;

/**
 * Just a tester to show that the methods works feel free to mess around with this
 */

public class LinkedTest
{

    LinkedQueue LQueue = new LinkedQueue();

    LinkedTest()
    {
        fill();
        System.out.println(LQueue.size());
        System.out.println(LQueue.front());
        emptyOut();
    }

    private void emptyOut()
    {
        while (!LQueue.isEmpty())
        {
            System.out.println("Removed " + LQueue.remove() + " from the Queue");
        }
    }

    private void fill()
    {
        for (int i = 0; i < 20; i++)
        {
            String item = ("" + i);
            LQueue.add(item);
            System.out.println("Added " + item + " to the Queue");
        }
    }

    public static void main(String[] args)
    {
        new LinkedTest();
    }
}
