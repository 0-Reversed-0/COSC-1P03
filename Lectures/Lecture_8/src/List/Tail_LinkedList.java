package List;

public class Tail_LinkedList
{

    Node head;
    Node tail; // You might notice that we added a tail here. This is called a tail node which makes adding to the end of a list more Big O efficient (This comes at the cost of a little bit more complicated code)

    public Tail_LinkedList()
    {
        head = null;
        tail = null;
    }

    /**
     * A method to addToFront value to the Linked List using tail nodes
     *
     * @param value an integer value to be added
     */

    public void addToFront(int value) // adding to a linked list with a tail node is a little bit more work than one line but still O(1)
    {
        if (tail == null) // First we want to see if the tail node is not set yet. (If the linked list is empty)
        {
            tail = new Node(value, null); // if the linked list is empty then the first node we want to addToFront is the tail
        } else if (head == null) // now if the linked list does have a tail but no head then the second node we addToFront is the head
        {
            head = new Node(value, tail); // this is to ensure that both the head and tail are connected to each other at the start of a linked list (currently: Node Head -> Node Tail)
        } else
        {
            head = new Node(value, head); // after the tail and head are initialize then we just continue to addToFront to a linked list how we normally do.
        }
    }

    /**
     * Adds to the end of the linked list
     *
     * @param value the new value to be added to the tail node
     */

    public void addToLast(int value)
    {
        if (tail == null) // as you can see we use tail node to check not the head since the tail is initialized first
        {
            tail = new Node(value, null); // now  we can initialize the list like this
        } else if (head == null) // we need a head in this list so if the head is not set yet, then we NEED to deal with that.
        {
            head = tail; // first we make both head and tail share the same node
            tail = new Node(value, null); // then we make tail equal to a whole new node
            head.next = tail; // make the reference of our new head point to tail to connect the whole thing together

        } else // if we have a head and a tail then we can add from the tail in a Big O cost of O(1)
        {
            tail.next = new Node(value, null); // first make the reference of the tail into the node we are adding
            tail = tail.next; // then make the tail the new node so we don't lose the reference to it
        }
    }

    /**
     * A simple method to remove the head.
     */

    public void removeHead()
    {
        if (head != null)
        {
            head = head.next; // it does not change from a normal linked list
        }
    }

    /**
     * We can't just have a remove head method with a remove tail method.
     */

    public void removeTail() // The remove tail method will always be O(n) regardless of the inclusion of the tail node
    {
        if (head != null) // It's just a copy of the normal way of removing the tail. the only reason
        {
            Node p = head;
            Node q = null;

            while (p.next != null)
            {
                q = p;
                p = p.next;
            }

            if (q == null) // empty list case
            {
                tail = null;
            } else // only difference is we need to update the tail or else it will end up as null
            {
                tail = q; // make sure that the tail is updated to the penultimate node instead which is Q
                tail.next = null; // the node before our tail (Node Q) will point to null and essentially remove the tail from the list entirely
            }
        }
    }


    public void sortedInsertion(int value) // sorted insertion does not change whatsoever when it comes to having a tail pointer
    {
        Node p = head;
        Node q = null;

        while (p != null && p.item >= value)
        {
            q = p;
            p = p.next;
        }

        if (q == null)
        {
            addToFront(value); // adds a new value to our empty list
        } else
        {
            q.next = new Node(value, p);
        }

    }

    /**
     * A method purely for educational purposes.
     * This method shows us what value the tail node is holding
     *
     * @return the item the tail node is holding
     */

    public int getTail()
    {
        return tail.item;
    }

    /**
     * A simple traversal of the linked list to display it.
     */

    public void display()
    {
        Node ptr;

        if (head != null) // Only change to traversing is if the head is not initialized or if the list itself is empty
        {
            ptr = head; // if it's not empty then traversal will go as normal
        } else if (tail != null)
        {
            ptr = tail; // if it has 1 node then we would want the pointer to equal tail
        } else
        {
            ptr = null; // immediately stops the traversal from happening if the list is empty
        }

        System.out.print("Head -> ");

        while (ptr != null) // the rest of traversal is the same otherwise
        {
            System.out.print(ptr.item + " -> ");
            ptr = ptr.next;
        }

        System.out.print("null");
    }
}
