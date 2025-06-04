package Que;

/**
 * A queue is a different type of container that has a first in and first out return and add
 */

public interface Queue
{

    /**
     * Adds the specified memeber to the end of the queue
     * @param s a new string
     * @throws OverflowException
     */

    void add(String s);

    /**
     * Removes the first member of the queue
     * @return a string
     * @throws UnderflowException
     */

    String remove();

    /**
     * Shows us what's next in queue
     * @return the string that is about to be removed
     */

    String front();

    /**
     * How many elements are in the queue
     * @return the amount in the queue
     * @throws UnderflowException
     */

    int count();
}


