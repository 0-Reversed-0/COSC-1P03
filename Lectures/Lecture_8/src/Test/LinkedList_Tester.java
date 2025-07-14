package Test;

import List.*;

/**
 * This Lecture goes HIGHLY in depth for Linked Lists
 */

public class LinkedList_Tester
{

    Sequentially_LinkedList List = new Sequentially_LinkedList();

    public LinkedList_Tester()
    {
        addTest();
        deleteTest();

        /// Now we just display the final result to show that the program works as intended

        List.display(); // Basically testing if traversal works also note that null is not technically a node in the linked list but rather what the last node is referencing too.
    }

    /**
     * This will test all insertion methods (i.e: addToFront to the front, end, and sorted)
     */

    void addTest()
    {
        /// Simply adding value to the linked list we can use a for loop to addToFront 20 values

        for (int i = 2; i <= 20; i++) // I want to use 1 in a different example
        {
            if (i != 10) // I want to skip 10 to insert in the middle later
            {
                List.addToFront(i); // This will print every node from greatest to least
            }
        }

        List.display(); // to show the progress of the linked list

        /// I want to addToFront 1 at the end so we can use our amazing addToFront to the end function

        List.addToEnd(1); // if we want to we can use this function instead to addToFront every node from least to greatest (THE CORRECT WAY TO SORT ANYTHING)

        List.display();

        /// OH, NO! I forgot to addToFront 10 to my list. No problemo we have the sorted insertion method to help me with this crazy issue

        List.sortedInsertion(10); // This would be a normal case but...

        List.display();

        /*
         * Let's say I wanted to addToFront in the front and back with this method it could technically do that for us
         * This would totally work out too and would essentially be the best version of the "addToFront" method (that is if we wanted our values sorted)
         */

        List.sortedInsertion(21);
        List.sortedInsertion(0); // and boom it would work out just fine

        List.display();
    }

    /**
     * Now this will test our deletion methods
     */

    void deleteTest()
    {
        ///Let's say I HATE the numbers 0 and 21 from our linked list no issue we can remove those treacherous numbers from the linked list

        List.decapitate();  // this will remove 21...
        List.display();
        List.chopTheTail(); // and this would remove that wretched 0
    }

    public static void main(String[] args)
    {
        new LinkedList_Tester();
    }
}
