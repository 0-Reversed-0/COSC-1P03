package Generics.Application;

class Node <E>
{
    E item;
    Node<E> next; // Remember anytime you call upon the class name you MUST add the <Object> no matter what, just like a method call

    Node(E i, Node<E> n)
    {
        item = i;
        next = n;
    }
}
