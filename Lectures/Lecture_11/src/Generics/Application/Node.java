package Generics.Application;

public class Node <E>
{
    E item;
    Node<E> next; // Remember anytime you call upon the class name you MUST add the <> no matter waht

    Node(E i, Node<E> n)
    {
        item = i;
        next = n;
    }
}
