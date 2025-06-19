/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */

package storage;

public class Node<E>
{
    E item;
    Node<E> next;

    Node(E i, Node<E> n)
    {
        item = i;
        next = n;
    }
}
