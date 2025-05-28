public class Sequentially_LinkedList
{

    private Node head; // head and tail should not be accessed to avoid users breaking the code
    private Node tail; // a tail is out ending Node kind of like the opposite to the head

    public Sequentially_LinkedList()
    {
        this.head = null; // we both want our tails and heads to be null to begin with just ot make things simpler
        this.tail = null;
    }

    /**
     * Deletes from the front
     */

    public void decapitate()
    {
        head = head.next; // makes the front of the list the 2nd value
    }

    /**
     * Deletes from the back
     */

    public void chopTheTail()
    {
        if (head == null)
        {
            // do nothing. no chopping tails sadly :(
        }else {
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
     * This is how we insert a Node essentially anywhere in the list
     * @param value
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

        while (p != null && p.item < value) // BIG O of N in the worst case because it would take all n values to traverse if the value is at the tail and constant time if it happens to be in the from
        { // If the pointer is NULL then stop it immediately otherwise check if the next statement is true
            q = p;          // Q goes ahead up and then
            p = p.next;     // P goes in front of it
        }

        /*
         * When the loop ends then it will leave q and p exactly where we want to now set our wonderful value
         */

        if (q == null) // to avoid empty list cases
        {
            head = new Node(value, null); //if its empty then like just make the head a new node
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

    public void addFront(int value)
    {
        head = new Node(value, head); //It is seriously easy
    }

    /**
     * To set a new tail/ending point
     * @param value
     */

    public void addBack(int value)
    {
        Node pointer = head;

        if (head == null) //if there's an empty list then this will prevent a null pointer exception
        {
            head = new Node(value, null);
            return;
        } else
        {
            tail.next = new Node(value, null); // tail will always point to null regardless
        }

    }

    /**
     * Just to display the full Node
     */

    public void display()
    {
        Node pointer = head; //this is to prevent destroy the list so we use a temporary pointer

        while (pointer != null) // goes until pointer is null so we can cover every value
        {
            System.out.println(pointer.item);
            pointer = pointer.next; // advance the list
        }
    }

    public static void main(String[] args)
    {
        new Sequentially_LinkedList();
    }
}