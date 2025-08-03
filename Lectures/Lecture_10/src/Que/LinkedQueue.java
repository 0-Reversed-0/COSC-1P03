package Que;

/**
 * This class is the Linked List implementation of a Queue
 */

public class LinkedQueue implements Queue
{

    private Node head; // always make every instance variable in an ADT to be private
    private Node tail;
    private int sizeCounter; // this is to count the amount of items to have the size function O(1)

    /**
     * Adds a value to the Queue
     *
     * @param item A string item to be added to the Queue
     */

    public void add(String item) // The add method is functionally the same as a tail linked list addToTail method (refer to lecture 8)
    {
        /*
         * Now I hear your silly little voice saying, well why are we adding from the tail to begin with?
         * Remember how we defined a Queue? It is an ADT that has the first item in be the first item that comes out of it.
         * To easily understand this better, We always output the oldest value in the Queue first and input the newest values at the tail.
         * This is because we want to slowly push the oldest items to the head (hence, only adding to the tail).
         * And this will also make it so that the newest item will always be the last to be removed because we remove from the head to the tail.
         */

        if (tail == null)
        {
            tail = new Node(item, null);
        } else if (head == null)
        {
            head = tail;
            tail = new Node(item, null);
            head.next = tail;
        } else
        {
            tail.next = new Node(item, null);
            tail = tail.next;
        }

        sizeCounter++;
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
        if (isEmpty()) // we first want to check if the linked list is empty
        {
            throw new QueueEmptyException();
        } else if (head == tail | head == null) // then we check if the tail is the only node left through checking if the head is null/pointing to the tail (if its either of those 2 then we have already removed to the last node)
        {
            String item = tail.item;
            tail = null; // this is to ensure that the item is removed from the Queue
            sizeCounter--;

            return item;
        }

        String item = head.item; // if all is normal then we want to first retrieve the item from the current 'oldest node' to make sure we don't lose it
        head = head.next; // now once the item we want is safe, we can safely remove the head from the list.
        sizeCounter--;

        return item;
    }

    /**
     * Shows the next item that will be removed before it will be removed via the remove() method
     *
     * @return the 'most' first value added (i.e. the oldest value that was added into the Queue)
     * @throws QueueEmptyException if the Queue had nothing inside it to begin with then this will be thrown
     */

    public String front() // if you understood the remove() method then you can understand this one. It is literally just returning items without nullifying anything
    {
        if (isEmpty())
        {
            throw new QueueEmptyException();
        } else if (head == tail | head == null)
        {
            return tail.item;
        }

        return head.item;
    }

    /**
     * The size method is for getting how many elements are in the Queue
     * Although this method goes against the philosophical idea of an ADT since it should be abstracted
     * We add it anyway due to it being a very common method to add in a Queue otherwise do not add it
     *
     * @return the amount of elements within a Queue
     */

    public int size()
    {
        return sizeCounter; // So instead of traversing the list, we can simply return our counter
    }

    /**
     * The isEmpty method checks for if the Queue is empty (useful for emptying out the full Queue)
     *
     * @return a boolean Empty -> true | Full -> false.
     */

    public boolean isEmpty()
    {
        return tail == null; // returning a conditional will result in returning a boolean depending on the condition being true or false.
    }
}
