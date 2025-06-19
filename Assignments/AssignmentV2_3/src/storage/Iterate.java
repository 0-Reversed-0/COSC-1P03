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

    Node<E> ptr;

    public Iterate(Node<E> ptr)
    {
        this.ptr = ptr;
    }

    public boolean hasNext()
    {
        return ptr != null;
    }

    public E next()
    {
        E item = ptr.item;
        ptr = ptr.next;
        return item;
    }
}
