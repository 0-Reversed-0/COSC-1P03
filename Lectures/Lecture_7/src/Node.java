/**
 * This is a basic introduction into linked list
 * The implementation of actual linked list classes are shown in Lecture_8
 */

public class Node
{

    /**
     * To start making a Dynamically Linked Structure AKA a Linked Lists, we need to make a Node class
     * The node class is a wrapper class
     * A wrapper class is an object that holds primitive types sort of like wrapping an object around a primitive type (Generics)
     */

    int item; // This is what the Linked List's node shall hold
    Node next; // This is the reference to the next node

    Node(int i, Node nx) //This is class is package private (only visible and accessible in the same package). All node classes SHOULD BE package private
    {
        item = i; // We put what integer we want to store in the Node,
        next = nx; // then we add what we would like to point it to (could be another Node or null)
    }
}
