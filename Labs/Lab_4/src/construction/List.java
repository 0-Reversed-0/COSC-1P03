/**
 * Author: Reversed_0
 * Course: COSC 1P03
 * Title: Linked Lists Lab
 */

package construction;

/*
 * Just a heads-up for anyone who is actually looking at this to study,
 * THIS IS NOT HOW YOU SHOULD CODE A LINKED LIST WHATSOEVER REFER TO MY LECTURE 8 NOTES FOR THAT PLEASE!!!!!
 */

public class List
{
    Node head = null;

    public List()
    {
        /*
         * The First part can be completely ignored honestly just show your able to convert an array to a list and traverse a list
         */

        int[] arr = {6, 8, 8, 5, 5, 5, 0};

        toList(arr); // this SHOULD be a void method if we do not have any sort of interface to work with and are hardcoding everything

        display();
    }

    /**
     * A method that converts an array to a list
     * @param arr the array ready to be converted
     */

    private void toList(int[] arr)
    {
        for (int i = arr.length-1; i >= 0; i--) // since link lists add values from right to left, we have to reverse the way we read the array
        {
            head = new Node(arr[i], head); // we point to head because right now the new node is the new head pointing to our old head which is null (everything works!!!)
        }
    }

    /**
     * Displayer method to display our linked list
     */

    private void display()
    {
        Node ptr = head; // first make a pointer node that is set to head(DO NOT USE THE HEAD REFERENCE TO TRAVERSE ANY LINKED LIST WE ONLY USE HEAD TO ADD NODES)

        while (ptr != null) // to make sure we do not get a null pointer exception we make sure that we do not continue if the current node we are at is null
        {
            System.out.print(ptr.item + " -> "); // call the item in the node object currently and add a silly arrow beside it
            ptr = ptr.next; // make the current node we are (example: head) equal to the node in front of it
        }

        System.out.print("null"); // for formatting purposes only
    }

    public static void main(String[] args)
    {
        new List();
    }
}
