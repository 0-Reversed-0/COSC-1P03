package Generics.Application;

/**
 * This class helps shows why we would use parameterized class over normal classes.
 * Refer to Lecture 9 notes if you have issues understanding Stacks
 * @param <E> the type of object (String, Integer, etc.) that will be held in the stack
 */

public class Stack<E> implements GenericApplication<E> // When implementing a parameterized interface you MUST include the <...> with the type parameter variable in both the interface and class
{

    private Node<E> head; // Here is how we make it so that we can use whatever type of object we want to store in this linked list.

    /**
     * A push in a stack is essentially adding to our stack
     *
     * @param item the item that is being added to the stack
     */
    
    public void push(E item)
    {
        head = new Node<E>(item, head); // now instead of pushing JUST an int or JUST a string we now push what ever we want into the stack.
    }

    /**
     * removes an item and gives us what the item is
     *
     * @return the item
     * @throws StackEmpty if the stack is empty
     */
    
    public E pop()
    {
        if (isEmpty())
        {
            throw new StackEmpty("The stack is empty");
        }

        E item = head.item; // and whenever we want to retrieve an item we return a type parameter rather than a hardcoded
        head = head.next;

        return item;
    }

    /**
     * shows us what item is going to be removed
     *
     * @return the item that will remove
     * @throws StackEmpty if the stack is empty
     */
    
    public E top()
    {
        if (isEmpty())
        {
            throw new StackEmpty("The stack is empty");
        }

        return head.item;
    }

    /**
     * Checks if the item dispenser is empty
     *
     * @return false or true if It's empty or not
     */
    
    public boolean isEmpty()
    {
        return head == null;
    }
}
