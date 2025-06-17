package Generic;

public class Stacks<Dealie> implements Stack<Dealie>
{

    private Node head;

    private int count;

    public Stacks()
    {
        head = null;
    }


    /**
     * A push in a stack is essentially adding to our stack
     *
     * @param c the item that is being added to the stack
     */
    public void push(Dealie c)
    {

        head = new Node<>(c, head);

    }

    /**
     * removes a item and gives us what the item is
     *
     * @return the item
     */
    public Object pop()
    {
        return null;
    }

    /**
     * shows us what item is going to be removed
     *
     * @return the item that will remove
     */
    public Object top()
    {
        return null;
    }

    /**
     * Checks if the item stack is empty
     *
     * @return false or true
     */
    public boolean isEmpty()
    {
        return false;
    }
}
