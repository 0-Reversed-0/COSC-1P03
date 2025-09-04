package Generics;

public class Stack<E> implements GenericApplication<E> // When implementing a parameterized interface you MUST include the <...> with the type parameter variable in both the interface and class
{
    /**
     * A push in a stack is essentially adding to our stack
     *
     * @param item the item that is being added to the stack
     */
    
    public void push(E item)
    {
        
    }

    /**
     * removes an item and gives us what the item is
     *
     * @return the item
     */
    
    public E pop()
    {
        return null;
    }

    /**
     * shows us what item is going to be removed
     *
     * @return the item that will remove
     */
    
    public E top()
    {
        return null;
    }

    /**
     * Checks if the item dispenser is empty
     *
     * @return false or true
     */
    
    public boolean isEmpty()
    {
        return false;
    }
}
