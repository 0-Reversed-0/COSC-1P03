package Generic;

public class Node <Dealie>
{
    Dealie item;
    Node <Dealie> next;

    public Node(Dealie s, Node <Dealie> n)
    {
        item = s;
        next = n;
    }
}
