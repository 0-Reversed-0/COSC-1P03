package Test;

import List.*;

public class TailLinkedList_Tester
{
    Tail_LinkedList T = new Tail_LinkedList();


    public TailLinkedList_Tester()
    {
        addToFrontTest();
        T.display();
        addToLastTest();
        T.display();
        T.removeHead();
        T.display();
        T.removeTail();
        T.display();

        T.sortedInsertion(13); //adding the missing 13 that we intentionally skipped to prove that the insertion actually works

        T.display();

        System.out.println("\nThe tail is: " + T.getTail());
    }


    void addToFrontTest()
    {
        for (int i = -20; i <= 0; i++)
        {
            T.addToFront(i);
        }
    }

    void addToLastTest()
    {
        for (int i = 0; i <= 20; i++)
        {
            if (i != 13)
            {
                T.addToLast(i);
            }
        }
    }

    public static void main(String[] args)
    {
        new TailLinkedList_Tester();
    }
}
