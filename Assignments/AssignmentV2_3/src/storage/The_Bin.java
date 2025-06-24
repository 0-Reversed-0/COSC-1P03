/**
 * Author: Reversed_0
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */

package storage;

import java.util.Iterator;

/**
 * The Bin class is a container ADT that holds an endless amount of "stuff" in it.
 * Each bin needs to have a label that helps identify it from other bins
 * Each bin can hold an endless amount of items
 *
 * @param <E> this parameter sets the type of object that bin will hold.
 */

public class The_Bin<E> implements Bin<E>
{

    private Node<E> head;   // We use a linked list of type E to hold whatever the user wants to hold
    String label;           // The label is the identifier that helps us tell the difference between each bin and helps us search for it

    public The_Bin(String tag)
    {
        label = tag; // Every time a bin is initialized a user MUST have a label associated to the bin.
    }

    /**
     * Removes and returns a single entry from the Bin.
     *
     * @return any single entry within the Bin
     * @throws DisorganizationException if it's empty
     */

    public E grab()
    {
        if (head == null) // the linked list is empty then the bin is empty
        {
            throw new DisorganizationException("Bin is empty!");
        }

        E grabbedValue = head.item; // first we store the item before we remove it from the list

        head = head.next; // now we remove the item from the list

        return grabbedValue; // only then we can remove the item from the list
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

        if (head != null) // there's only stuff if head is NOT null otherwise the linked list would be empty
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