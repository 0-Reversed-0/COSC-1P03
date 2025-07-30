package Que;

public class LinkedQueue implements Queue
{

    Node head;
    Node tail;

    /**
     * Adds a value to the Queue
     *
     * @param s A string item to be added to the Queue
     */

    public void add(String s)
    {
        if (tail == null)
        {
            tail = new Node(s, null);
        } else if (head == null)
        {
            head = tail;
            tail = new Node(s, null);
            head.next = tail;
        } else
        {
            tail.next = new Node(s, null);
            tail = tail.next;
        }
    }

    /**
     * This will remove an item from the Queue.
     * Items will be removed in a first in, first out fashion where the current oldest item in the Queue will be removed first
     * The newest items will be added and removed only when they become the oldest item.
     *
     * @return the oldest item.
     */

    public String remove()
    {
        if (isEmpty())
        {
            throw new QueueEmptyException();
        }

        String item = head.item;
        head = head.next;

        return item;
    }

    /**
     * Shows the next item that will be removed before it will be removed via the remove() method
     *
     * @return the 'most' first value added (i.e. the oldest value that was added into the Queue)
     * @throws QueueEmptyException if the Queue had nothing inside it to begin with then this will be thrown
     */

    public String front()
    {
        String item;

        if (isEmpty())
        {
            throw new QueueEmptyException();
        } else if (head == null)
        {
            item = tail.item;
        }

        item = head.item;

        return item;
    }

    /**
     * The size method is for getting how many elements are in the Queue
     * Although this method goes against the philosophical idea of an ADT since it should be abstracted
     *
     * @return the amount of elements within a Queue
     */

    public int size() //funny that this is the only method that is O(1)
    {
        if (isEmpty())
        {
            return 0;
        } else if (head == null)
        {
            return 1;
        }

        Node pointer = head;
        int count = 0;

        while (pointer != null)
        {
            count++;
            pointer = pointer.next;
        }

        return count;
    }

    /**
     * The isEmpty method checks for if the Queue is empty (useful for emptying out the full Queue)
     *
     * @return a boolean Empty -> true | Full -> false.
     */

    public boolean isEmpty()
    {
        boolean empty = false;

        if (tail == null)
        {
            empty = true;
        }

        return empty;
    }
}
