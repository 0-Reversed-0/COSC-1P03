package construction;

public class Node
{
    int item;
    Node next;

    Node(int I, Node N) // remember that nodes are package private!!!
    {
        item = I;
        next = N;
    }
}