/**
 * This lecture goes over Queues and how to implement them using arrays and with linked lists
 */

package Que;

/**
 * A Queue is another type of ADT similar to a Stack
 * Queues store values in a FIFO fashion
 * FIFO stands for first in, first out meaning it is the opposite storing style to a stack.
 * The first item added will the first to move out (think of a line to a roller coaster line first person to arrive is the first to get on the ride)
 * The Big(O) complexity of a Queue is O(1)
 * This Queue holds a string (note this for the Generics lecture)
 */

public interface Queue
{

    /**
     * Adds a value to the Queue
     *
     * @param item A string item to be added to the Queue
     */

    void add(String item);

    /**
     * This will remove an item from the Queue.
     * Items will be removed in a first in, first out fashion where the current oldest item in the Queue will be removed first
     * The newest items will be added and removed only when they become the oldest item.
     *
     * @return the oldest item.
     */
    
    String remove();

    /**
     * Shows the next item that will be removed before it will be removed via the remove() method
     *
     * @return the 'most' first value added (i.e. the oldest value that was added into the Queue)
     * @throws QueueEmptyException if the Queue had nothing inside it to begin with then this will be thrown
     */

    String front();

    /**
     * The size method is for getting how many elements are in the Queue
     * Although this method goes against the philosophical idea of an ADT since it should be abstracted
     * We add it anyway due to it being a very common method to add in a Queue otherwise do not add it
     *
     * @return the amount of elements within a Queue
     */

    int size();

    /**
     * The isEmpty method checks for if the Queue is empty (useful for emptying out the full Queue)
     *
     * @return a boolean Empty -> true | Full -> false.
     */

    boolean isEmpty();
}


