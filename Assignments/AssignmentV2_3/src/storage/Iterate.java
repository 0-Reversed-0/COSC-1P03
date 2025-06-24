/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */

package storage;

import java.util.Iterator;

public class Iterate<E> implements Iterator<E>
{

    Node<E> ptr; // what we use to traverse the bin

    public Iterate(Node<E> ptr)
    {
        this.ptr = ptr;
    }

    public boolean hasNext()
    {
        return ptr != null; // if the pointer is not null then there is still values next to the pointer
    }

    public E next()
    {
        E item = ptr.item; // retrieve item first
        ptr = ptr.next; // move the next item
        return item; // return the item
    }
}
