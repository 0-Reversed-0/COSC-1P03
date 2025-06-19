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
