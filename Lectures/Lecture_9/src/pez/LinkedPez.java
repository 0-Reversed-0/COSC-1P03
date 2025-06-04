package pez;

public class LinkedPez implements Pez
{

    private Node head;

    public LinkedPez()
    {
        head = null;
    }

    /**
     * adds a pez to pez dispenser
     *
     * @param c the colored pez that is being added to the dispenser
     * @throws PezFull if full
     */
    @Override
    public void push(char c)
    {
        head = new Node(c, head);
    }

    /**
     * removes a pez and gives us what the pez is
     *
     * @return the pez
     * @throws PezEmpty if empty
     */

    @Override
    public char pop()
    {
        if (isEmpty())
        {
            throw new PezEmpty("Its empty");
        }

        char c = head.c;

        head = head.next;

        return c;
    }

    /**
     * shows us what pez is going to be removed
     *
     * @return the pez that will remove
     * @throws PezEmpty if empty
     */

    @Override
    public char top()
    {
        if (isEmpty())
        {
            throw new PezEmpty("Its empty");
        }

        char c = head.c;

        return c;
    }

    /**
     * Checks if the pez dispenser is empty
     *
     * @return false or true
     */

    @Override
    public boolean isEmpty()
    {
        boolean empty = false;

        if (head == null)
        {
            empty = true;
        }

        return empty;
    }

    /**
     * Checks if the dispenser is full
     *
     * @return false or true
     */

    @Override
    public boolean isFull()
    {
        return false; // can never be true
    }

    /**
     * @return how many values in the dispenser
     * @throws PezEmpty if empty
     */

    @Override
    public int howMany()
    {
        Node ptr = head;

        int count = 0;

        while (ptr != null)
        {
            count++;
        }

        return count;
    }
}

