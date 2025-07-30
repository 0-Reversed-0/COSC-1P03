package Tester;
import Que.LinkedQueue;

public class LinkedTest
{

    LinkedQueue LQueue = new LinkedQueue();

    LinkedTest()
    {
        System.out.println(LQueue.front());
    }

    private void fill()
    {
        for (int i = 0; i < 20; i++)
        {
            String item = ("" + i);
            LQueue.add(item);
        }
    }

    public static void main(String[] args)
    {
        new LinkedTest();
    }
}
