package construction;

public class Node
{
    int item; // Nodes are what stores the values in a linked list so it makes sense why we have an item that the object will hold
    Node next; // this is our link to all the other nodes

    Node(int I, Node N) // remember that nodes are package private!!!
    {
        item = I; // Now the user can set the item to be whatever they like
        next = N; // Every node HAS TO HAVE a reference to another Node whether it is a random node our the actual next node
    }
}