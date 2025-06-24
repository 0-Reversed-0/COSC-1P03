/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */

package storage;

/**
 * We use the node class for both the bin and the cabinet class implements
 * @param <E> The parameter E could either be a Bin or an object that bin stores
 */

class Node<E>
{
    E item;
    Node<E> next;

    Node(E i, Node<E> n)
    {
        item = i;
        next = n;
    }
}
