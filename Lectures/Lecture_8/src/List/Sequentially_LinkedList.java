/**
 * This lecture only goes over the basic operations of Linked Lists.
 * It goes over: Deletion, Insertion, and Traversal
 * We did not go in depth for other types of linked lists like Doubly Linked lists or Circular Linked Lists, etc.
 */

package List;

public class Sequentially_LinkedList
{

    private Node head; // head and tail should not be accessed to avoid users breaking the code
    private Node tail; // a tail is our ending to the list kind of like the opposite to the head I personally never used it in my code because I found it hard to implement, but I keep it here for note’s sake

    public Sequentially_LinkedList()
    {
        this.head = null; // we both want our tails and heads to be null to begin with just to make things simpler
        this.tail = null; // although when declared they were null, this is just to make sure they are actually null. (completely unnecessary)
    }

    /**
     * Deletes the current head
     */

    public void decapitate()
    {
        if (head == null)
        {
            //no public execution :(
        } else
        {
            head = head.next; // makes the front of the list the 2nd value
        }
    }

    /**
     * Deletes the current tail
     */

    public void chopTheTail()
    {
        if (head == null)
        {
            // do nothing. no chopping tails sadly :(
        } else
        {
            Node p = head; // our favorite duo would be needed because we want to have the node behind the tail to point to null instead.
            Node q = null;

            while (p.next != null)
            {
                q = p;
                p = p.next;
            }

            if (q == null) // empty list case
            {
                head = null; // well everything so no chopping tails again :(
            } else
            {
                q.next = null; // the node before our tail (Node Q) will point to null and essentially remove the tail from the list entirely
            }

        }
    }

    /**
     * This is how we insert a node essentially anywhere in the list
     *
     * @param value the value of the item in the node that we want to add into the list
     */

    public void sortedInsertion(int value) // This is just for the sake for learning sorted insertions with the method belows would not work at all
    {
        Node p = head; // what will be in front of the node
        Node q = null; // what will BE our node that we are inserting

        /*
         * To put it in the middle of 2 nodes.
         * The node in front of our node is GREATER than our node
         * The node behind it should be LESS than our node
         */

        while (p != null && p.item >= value) // BIG O of N in the worst case because it would take all n values to traverse if the value is at the tail and constant time if it happens to be in the front then it would be constant time
        { // If the pointer is NULL then stop it immediately otherwise check if the next statement is true
            q = p;          // Q goes ahead up and then
            p = p.next;     // P goes in front of it
        }

        /*
         * When the loop ends then it will leave q and p exactly where we want to now set our wonderful value
         */

        if (q == null) // to avoid empty list cases
        {
            head = new Node(value, p); //if its empty then like just make the head a new node
        } else //otherwise...
        {
            q.next = new Node(value, p); // set the value after q (the node behind) to a new node and make it point to p (the node in front)
        }

    }

    /**
     * To set a new head/starting point
     *
     * @param value value we want to be added
     */

    public void addToFront(int value)
    {
        head = new Node(value, head); //It is seriously easy
    }

    /**
     * To set a new tail/ending point
     *
     * @param value the new node that will be at the end of a list
     */

    public void addToEnd(int value)
    {
        if (head != null) // as long as the list is not empty then we can add to the end of the list (if the start is empty then how will the list be full of values)
        {
            Node p = head; // a temporary pointer to traverse the list

            while (p.next != null) // we want to stop until we are literally at the last node. We do p.next in our condition so it stops at the tail rather than null
            {
                p = p.next; // set p to be last node essentially
            }

            p.next = new Node(value, null);  //now our next node will be a new node rather than null and will replace the old tail node
        } else // if the node happens to be empty then we can use this
        {
            head = new Node(value, null);
        }
    }

    /**
     * A method that displays every node's item in the linked list.
     * Goes over traversal in the simplest way possible
     */

    public void display()
    {
        Node pointer = head; //this is to prevent destroy the list so we use a temporary pointer that starts at the head

        System.out.print("Head");

        while (pointer != null) // goes until pointer is null so we can cover every value
        {
            System.out.print(" -> " + pointer.item);
            pointer = pointer.next; // advance the list
        }

        System.out.println(" -> null");
    }

}