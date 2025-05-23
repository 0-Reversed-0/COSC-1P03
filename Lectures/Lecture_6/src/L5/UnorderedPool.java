package L5;

/**
 * This class stores readings in an arbitrary order
 * It implements the Pool Interface.
 */

public class UnorderedPool implements Pool // this is how we implement an interface via using the keyword implements: public class Name implements interfaceName
{

    private Measurement[] arr;
    private int count; // iterating value

    public UnorderedPool(int capacity)
    {
        if(capacity > 1)
        {
            arr = new Measurement[capacity];
            count = 0;
        }
        else {
            throw new StopTrollingException(); // we do not want negative array capacities obviously
        }
    }

    public UnorderedPool()
    {
        this(100);
    }

    public void add(Measurement M)
    {
        if (count < arr.length)
        {
            arr[count++] = M; //if a user decides to add a measurement,
            // then it will add their measurement and go to the next value in the array
        }

        /**
         * You can also do this
         */
    }

    public Measurement draw()
    {
        throw new UnsupportedOperationException();
    }

    public Measurement min()
    {
        return null;
    }

    public Measurement max()
    {
        return null;
    }

    public Measurement[] above(Measurement reference)
    {
        throw new UnsupportedOperationException(); // basically tells you that this is a work in progress
    }

    public Measurement[] below(Measurement reference)
    {
        return new Measurement[0];
    }
}
