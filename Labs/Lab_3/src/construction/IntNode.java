package construction;

class IntNode
{
    int item;
    IntNode next; // reference to the next item121

    IntNode(int item, IntNode next)
    {
        this.item = item;
        this.next = next;
    }
}