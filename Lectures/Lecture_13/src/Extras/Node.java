package Extras;

/**
 * Normally you don't add public to node class
 * But I hate seeing it beside my cool ass classes so deal with it MWAH <3
 */

public class Node
{
    public int item;
    public Node next;

    public Node(int i, Node n)
    {
        item = i;
        next = n;
    }
}
