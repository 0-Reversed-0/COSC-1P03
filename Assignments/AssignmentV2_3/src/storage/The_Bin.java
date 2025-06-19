package storage;

import java.util.Iterator;

public class The_Bin<E> implements Bin<E>
{

    Node<E> head;

    public The_Bin()
    {
        head = null;
    }

    /**
     * Removes and returns a single entry from the Bin.
     *
     * @return any single entry within the Bin
     * @throws DisorganizationException if it's empty
     */
    
    public E grab()
    {
        if (head == null)
        {
            throw new DisorganizationException("Bin is empty!");
        }

        E grabbedValue = head.item;

        head = head.next;

        return grabbedValue;
    }

    /**
     * For adding a new entry to the Bin.
     *
     * @param entry new member for the Bin
     * @throws DisorganizationException if it's full, where applicable
     */
    
    public void add(E entry)
    {
        head = new Node<>(entry, head);
    }

    /**
     * Does this bin still have something left kicking around in it?
     *
     * @return a boolean that indicates whether the bin has something inside of it
     */
    
    public boolean hasStuff()
    {
        boolean stuff = false;

        if (head != null)
        {
            stuff = true;
        }

        return stuff;
    }

    public Iterator<E> iterator()
    {
        return new Iterate<>(head);
    }
}