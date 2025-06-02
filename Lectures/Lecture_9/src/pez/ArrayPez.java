package pez;

public class ArrayPez implements Pez
{

    private char[] dispenser;

    private int count;

    public ArrayPez()
    {
        this(12);
    }

    public ArrayPez(int capacity)
    {
        dispenser = new char[capacity];
    }

    /**
     * adds a pez to pez dispenser
     *
     * @param c the colored pez that is being added to the dispenser
     * @throws PezFull if full
     */

    public void push(char c)
    {
        if (count >= dispenser.length)
        {
            throw new PezFull("Its full dude");
        } else
        {
            dispenser[count++] = c;
        }
    }

    /**
     * removes a pez and gives us what the pez is
     *
     * @return the pez
     * @throws PezEmpty if empty
     */

    public char pop()
    {
        if (count == 0)
        {
            throw new PezEmpty("Its empty dude");
        }

        return dispenser[count--];
    }

    /**
     * shows us what pez is going to be removed
     *
     * @return the pez that will remove
     * @throws PezEmpty if empty
     */

    public char top()
    {
        if (count < 1)
        {
            throw new PezEmpty("Its empty dude");
        }
        return dispenser[count - 1];
    }

    /**
     * Checks if the pez dispenser is empty
     *
     * @return false or true
     */

    public boolean isEmpty()
    {
        boolean isEmpty = false;

        if (count == 0)
        {
            isEmpty = true;
        }

        return isEmpty;
    }

    /**
     * Checks if the dispenser is full
     *
     * @return false or true
     */

    public boolean isFull()
    {
        boolean isFull = false;

        if(count == dispenser.length)
        {
            isFull = true;
        }

        return isFull;
    }

    /**
     * @return how many values in the dispenser
     * @throws PezEmpty if empty
     */

    public int howMany()
    {
        return count;
    }
}