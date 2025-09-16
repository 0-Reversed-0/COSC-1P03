package Que;

/**
 * This is the implementation of a Queue using arrays instead of linked lists
 * Reminder: DO NOT IMPLEMENT QUEUES OR ADTS USING ARRAYS SINCE IT'S A LIVING HELL JUST USE LINKED LISTS
 * That aside, it requires a little more thinking and a better understanding of FIFO to implement so if you want to practice then you can try it
 * They are also referred to as Contiguous Queues
 */

public class ArrayQueue implements Queue
{

    private String[] array;
    private int index; // The index is mainly used for adding (sorta like the head in the linked list implementation) but using these integers is vital to know where to add/remove items
    private int head;  // The head is the oldest item in the Queue
    private int size;  // We need a counter to keep track of how many items are in the Queue since we index circular (more on that soon!)

    /**
     * We have a constructor this time because it is an array based Queue
     *
     * @param capacity the amount of items one instance of a Queue can hold
     */

    public ArrayQueue(int capacity)
    {
        array = new String[capacity];
    }

    /**
     * Adds a value to the Queue
     *
     * @param item A string item to be added to the Queue
     * @throws QueueFullException will be thrown if the queue is full since this is a
     */

    public void add(String item)
    {
        if (isFull()) // Since it's an array, this is now a factor we have to check and address accordingly
        {
            throw new QueueFullException("Cannot add more items :(");
        } else if (isEmpty()) // if the Queue is empty then we need to initialize the head to be the item being added since that would be the oldest item until removed
        {
            head = (index + 1) % array.length; // read the paragraph below | Good, we add the +1 because the index of the first item will change before we add it, and we modulate in the rare case that the tail is at the last index
        }

        /*
         * To explain how adding and indexing works with Queues you must first understand FIFO
         * We have to keep taking items away from the front of the queue and adding to the back.
         * The problem is that front can't ALWAYS be the first index because we have to nullify each index we remove from, MEANING the index is now the new "front" of the Queue
         * So to solve this problem we first make a head index that will always refer to the oldest item in the Queue which increments every time we remove an item
         * ANOTHER PROBLEM ARISES!!! Now the index for adding reaches the end of the array index, and we can no longer add more values to the Queue, even if there is available space from removed items
         * So to solve this we make the index circulate; meaning, we make the index modulate through array length so that it can reset back to 0 if it reached the final index
         * If array.length = 10 and index = 9, and we try to increment (9 + 1 aka index + 1) it then we would be left with 10 % 10 which would be 0 since 10/10's remainder is 0.
         * So all that space that was removed could be reused until the size is array.length (aka the array is full).
         */

        index = (index + 1) % (array.length);
        array[index] = item; // we use the index to refer to the next item to add.

        size++;
    }

    /**
     * This will remove an item from the Queue.
     * Items will be removed in a first in, first out fashion where the current oldest item in the Queue will be removed first
     * The newest items will be added and removed only when they become the oldest item.
     *
     * @return the oldest item.
     * @throws QueueEmptyException if the queue as no more items.
     */

    public String remove()
    {
        if (isEmpty()) // first check if the Queue is empty so we don't return null
        {
            throw new QueueEmptyException("No more items left to remove :(");
        }

        String item = array[head]; // we want to first retrieve the item in head because we need to nullify it to make space
        array[head] = null;

        head = (head + 1) % array.length; // This line will ensure that new head is the next index

        size--;
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
        if (isEmpty())
        {
            throw new QueueEmptyException("No items at the front of the Queue");
        }

        return array[head]; // just return the item at head
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
        return size;
    }

    /**
     * The isEmpty method checks for if the Queue is empty (useful for emptying out the full Queue)
     *
     * @return a boolean where Empty -> true | Full -> false.
     */

    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * A private boolean method to check if the Queue is full since its Array based
     *
     * @return a boolean where Empty -> false | Full -> true.
     */

    private boolean isFull()
    {
        return size == array.length; // remember size is not 0-based so we don't do array.length - 1
    }
}
