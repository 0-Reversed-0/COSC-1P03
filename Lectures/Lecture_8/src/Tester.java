import List.*;

public class Tester
{

    Sequentially_LinkedList List = new Sequentially_LinkedList();

    public Tester()
    {
        addTest();
        deleteTest();

        /// Now we just display the damn thing

        List.display(); // Basically testing if traversal works
    }

    /**
     * This will test all insertion methods (i.e: add to the front, end, and sorted)
     */

    void addTest()
    {
        /// Simply adding value to the linked list we can use a for loop to add 20 values

        for (int i = 2; i <= 20; i++) // I want to use 1 in a different example
        {
            if (i != 10) // I want to skip 10 to insert in the middle later
            {
                List.addToFront(i); // This will print every node from greatest to least
            }
        }

        /// I want to add 0 at the end so we can use our amazing add to the end function

        List.addToEnd(1); // if we want to we can use this function instead to add every node from least to greatest (THE CORRECT WAY TO SORT ANYTHING)

        /// OH, NO! I forgot to add 10 to my list. No problemo we have the sorted insertion method to help me with this crazy issue

        List.sortedInsertion(10); // This would be a normal case but...

        /*
         * Let's say I wanted to add in the front of back with this method
         * This would totally work out too and would essentially be the best version of the "add" method (that is if we wanted our values sorted)
         */

        List.sortedInsertion(21);
        List.sortedInsertion(0); // and boom it would work out just fine

    }

    /**
     * Now this will test our deletion methods
     */

    void deleteTest()
    {
        ///Let's say I HATE the numbers 0 and 21 from our linked list no issue we can remove those treacherous numbers from the linked list

        List.decapitate();  // this will remove 21...
        List.chopTheTail(); // and this would remove that wretched 0
    }

    public static void main(String[] args)
    {
        new Tester();
    }
}
