package Measurement;

/**
 * The Pool class manages Measurement objects
 * It can add to a list of measurements (a pool of data),
 * draw a random measurement from the pool,
 * get the minimum/maximum reading value and,
 * get all the measurements above or below a reference
 */

public class Pool
{

    /*
     * The problem if we could get an Unordered pool or an Ordered pool of data. If it's unordered we would have to code half the methods so much more differently.
     * We would have to code the same pool class twice.
     * Sure that's not a horrible way of going about things but if we are going to implement the exact same methods differently then we could use something called an interface
     * Interfaces are something that are explored more deeply in Lecture 6.
     */

    void add(Measurement M)
    {

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

    public Measurement[] above (Measurement reference)
    {
        return null;
    }

    public Measurement[] below (Measurement reference)
    {
        return null;
    }

    public String toString()
    {
        return super.toString();
    }
}
