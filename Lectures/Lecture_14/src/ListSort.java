import Extras.Node;

/**
 * This lecture is the intro to sorting.
 * This means that we only go over selection sort
 */

public class ListSort
{

    Node head;

    /**
     * A sorting algorithm is in situ that doesn't require constant additional space.
     * What that means is that is an algorithm does not uses more allocated memory in the RAM than what is already assigned
     * If it does NOT use any more RAM than needed then it is in situ (in place) or if it
     */

    public ListSort()
    {
        fill();
        System.out.println("List before sorting:");
        display();

        Selection_Sort(head);

        System.out.println("\nList after Sorting");
        display();
    }

    /**
     * First find the smallest value in the set of numbers (if we intend to sort in ascending order).
     * We do this via doing the same thing we do in finding the minimum and maximum values. (A loop that goes over every variable and compares it to a variable called the "minimum").
     * Then we swap the smallest value in the set with the first index.
     * Now the set can never access the first index since the first index relatively sorted.
     * Then we pass through the set a second time and look for the second-smallest value.
     * Once we find that second-smallest value, we swap it with the second index, which makes everything from the first index to the second index become relatively sorted.
     * We do this all the way until the set is sorted.
     * Example: Set A = [5, 0 , 2]
     *          Loop 1: is sorted?: no,
     *              Inner Loop: smallest?: 0, Set A = [0, 5, 2], Set A = [0 | 5, 2] (anything behind '|' is relatively sorted).
     *          Loop 2: is sorted: no,
     *              Inner loop: smallest: 2, Set A = [0 , 2 | 5].
     *          Loop 3: is sorted?: yes.
     * <p>
     * This would be an in situ algorithm since we do not make an extra linked list/array nor did we add a new node to the list, and we just swap them instead
     * The algorithm has a Big O complexity of O(n^2) (Each pass has an inner loop) but in the best case scenario it can be O(n) if the set is already sorted.
     * <p>
     *
     * Only problem is that this algorithm is unstable.
     * An algorithm that is unstable is an algorithm that cannot keep objects of equal value would be in their original spaces.
     * Example: a = b,
     * Set A = [e, a, b, d, c].
     * Unstable Sorted Set A = [b, a, c, d, e].
     * Since a = b, then technically having b then a would be correct when using selection sort
     * Stable Sorted Set A = [a, b, c, d, e].
     * A stable sorting algorithm would be keep a & b in their original spaces (relative to each other) without swapping either of them
     *
     * @param relativelySorted should be set as the temporary head of the linked list
     */

    void Selection_Sort(Node relativelySorted)
    {
        if (isSorted() | relativelySorted == null) // using recursion lets us have a best case of O(n) if the list is already sorted
        {
            return;
        }

        int smallest = Integer.MAX_VALUE; // This is to ensure that we can initialize the comparison without having to compare to an uninitialized variable and because no integer can be larger than this to make sure we find numbers lower than the smallest variable
        Node minimum = null; // this is so we have the position where the minimum value is and will reference the smallest node
        Node pointer = relativelySorted; // our starting point for our pointer will be relativelySorted rather than head so we can have the relatively sorted part of the list untouched and letting us not be stuck in an infinite loop

        while (pointer != null)
        {
            if (pointer.item < smallest) // first we need to find the smallest value from relativelySorted to null
            {
                smallest = pointer.item; // once it is found we then set the smallest integer to the pointer's item
                minimum = pointer; // then we set the minimum to the pointer with the smallest item
            }

            pointer = pointer.next;
        }

        minimum.item = relativelySorted.item; // First we would want to swap the item of the minimum pointer with the first index (which is relativelySorted in this case)
        relativelySorted.item = smallest; //

        Selection_Sort(relativelySorted.next); // Then we finally start the selection sort again
    }

    /**
     * We use this method to check if the list is sorted in ascending order
     *
     * @return true if the linked list is sorted and false if it is not
     */

    boolean isSorted()
    {
        if (head == null || head.next == null) // Here, if the list only has a singular node or have nothing at all then it is already sorted
        {
            return true;
        }

        Node pointer = head;

        while (pointer.next != null) // Now if it isn't already sorted then we should check to see if it is. (I add the pointer.next because we check 2 nodes at a time, and we would be comparing will null at one point)
        {
            if (pointer.item > pointer.next.item) // this compares every value with the value that comes after it, making sure that every value is sorted.
            {
                return false; // if it isn't then we would return false
            }

            pointer = pointer.next;
        }

        return true;
    }

    /**
     * A method to add random numbers in a linked list
     */

    void fill()
    {
        for (int i = 20; i > 0; i--)
        {
            int random = (int) (Math.random() * 20);
            head = new Node(random, head);
        }
    }

    /**
     * A method to display the linked list
     */

    void display()
    {
        Node pointer = head;

        while (pointer != null)
        {
            System.out.print(pointer.item + " -> ");
            pointer = pointer.next;
        }

        System.out.print(" null \n");
    }

    public static void main(String[] args)
    {
        new ListSort();
    }
}