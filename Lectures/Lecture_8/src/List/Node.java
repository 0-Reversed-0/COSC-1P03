package List;

/**
 * The Node class is the most important class in a linked list.
 * Nodes must hold 2 things.
 * 1) An item.
 * Items are instances variables that hold any type of data type(Objects, integers, strings, etc.).
 * 2) A reference to the next node.
 * The reference is what makes a linked list what it is. A reference holds a node object that is typically the next node in list. Since we add nodes backwards we usually refer a node to its former self. This will make more sense later...
 * A Node class's constructor (which, reminder, creates an instance of node) should have the item and the next node set by the user
 */

public class Node
{
    int item; // What a Node holds
    Node next; // What the next node is

    Node(int I, Node N)
    {
        item = I; // sets the item to the user inputted item
        next = N; // sets the next node to the user inputted node
    }

}
