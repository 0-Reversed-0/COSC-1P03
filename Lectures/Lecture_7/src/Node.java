public class Node
{

    /**
     * To start making a Dynamically Linked Structure AKA a Linked Lists, we need to make a Node class
     * The node class is a wrapper class that is any object that modify the usage of another (basically an easy way to access our data)
     */

    int item; // This is what the Linked List's node shall hold
    Node next; // This is the reference to the next node

    Node(int n, Node nx) //This is class is package private (only visible and accessible in the same package). All node classes SHOULD BE package private
    {
        item = n; // We put what integer we want to store in the Node,
        next = nx; // then we add what we would like to point it to (could be another Node or null)
    }
}
