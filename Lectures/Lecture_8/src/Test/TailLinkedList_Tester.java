package Test;

import List.*;

public class TailLinkedList_Tester
{
    Tail_LinkedList T = new Tail_LinkedList();


    public TailLinkedList_Tester()
    {
        addToFrontTest();
        addToLastTest();
        T.removeHead();
        T.removeTail();

        T.display();
        System.out.println("\nThe tail is: " + T.getTail());
    }


    void addToFrontTest()
    {
        for (int i = 1; i <= 20; i++)
        {
            T.addToFront(i);
        }
    }

    void addToLastTest()
    {
        for (int i = 0; i <= 20; i++)
        {
            T.addToLast(i);
        }
    }

    public static void main(String[] args)
    {
        new TailLinkedList_Tester();
    }
}
