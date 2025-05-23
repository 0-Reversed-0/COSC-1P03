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
        arr = new Measurement[capacity];
        count = 0;
    }

    public UnorderedPool()
    {
        this(100);
    }

    public void add(Measurement M)
    {
        arr[count++] = M;
    }

    public Measurement draw()
    {
        return null;
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
        return new Measurement[0];
    }

    public Measurement[] below(Measurement reference)
    {
        return new Measurement[0];
    }
}
