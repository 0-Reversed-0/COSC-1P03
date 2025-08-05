package Que;

public class ArrayQueue implements Queue
{

    private String[] array;
    private int index = -1;
    private int tail;

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
        if (isFull())
        {
            throw new QueueFullException();
        } else if (isEmpty())
        {
            tail = index + 1;
        }

        index = (index + 1) % array.length;
        array[index] = item;
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
        if (isEmpty())
        {
            throw new QueueEmptyException();
        }

        String item = array[tail];
        array[tail] = null;
        tail++;

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
            throw new QueueEmptyException();
        }

        return array[tail];
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
        return Math.abs(index-tail);
    }

    /**
     * The isEmpty method checks for if the Queue is empty (useful for emptying out the full Queue)
     *
     * @return a boolean Empty -> true | Full -> false.
     */

    public boolean isEmpty()
    {
        return tail == index;
    }

    public boolean isFull()
    {
        return index == array.length - 1 & tail == 0;
    }
}
