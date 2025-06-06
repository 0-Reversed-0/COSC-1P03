/**
 * This lecture is the introduction to Linked Lists.
 */

public class Main
{

    /**
     * Storing data is challenging with arrays since we have a static amount of space
     * We want a data structure (course name mentioned!!!) that is resizable
     * We also want to have something that is easy to insert values in the middle
     * Our solution would be a Dynamic Structure (LINKED LISTS BUT THAT'S FOR LECTURE 8)
     */

    public Main()
    {
        theProblem();

        /*
         * The Solution would be something called a Linked List
         * A linked list would be a collection of Nodes that are sequentially linked
         * Nodes: An object that stores a pointer and an item(any type of data)
         * Pointer: A pointer is a reference to a Node/Null to sequentially link a list
         * Sequentially Linked: Objects with references that point to the next object until it hits null
         */

        hardCodedLinkedList();
    }

    private void hardCodedLinkedList()
    {
        Node head;                          // The head is the starting point of the Linked List
        head = new Node(14, null);   // The head is basically starting the list with 14 out alone pointing to nothing
        head = new Node(7, head);        // Then the new head starts the list with 7 then points to the old head
        head = new Node(3, head);        // Think about it like pushing a bunch of blocks(Nodes in our case)
        head = new Node(1, head);        // and then adding a new block in the front of the blocks
        head = new Node(13, head);       // Insertion in the front is literally as easy as setting the value you want as head.

        Node ptr = head; // To traverse this horrible list, we can use a temporary pointer Node that points to head since if we use head itself then it would pretty much just unlink the entire list

        while (ptr != null) //then we make it so that if the POINTER POINTS TO NULL, THEN WE STOP THE TRAVERSING!!!!
        {
            System.out.print(ptr.item + " -> "); //then we take the item out of the pointer node so we can display it
            ptr = ptr.next; //then we set the pointer node to the node it was linked to (our next node) which moves the pointer to the next node
        }

        System.out.print("null"); // just to show what the end of the list and for style points
    }

    private void theProblem()
    {
        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = i;
        }

        /*
         * If I wanted to add let's say the 9th element,
         * then I would have to make a whole new array just add a new element
         * If I wanted to add something in the middle at arr[3] would have me end up copying the array AND shifting the values along
         */
    }

    public static void main(String[] args)
    {
        new Main();
    }
}