package chaotic;

public class IncrementingPRNG implements PRNG
{

    private long seed; // The seed is the basis of how we generate the "random" number
    private long state; // If the user wants to use PRNG twice then we would need to update seed


    public IncrementingPRNG(long s)
    {
        seed = s;
        state = seed;
    }

    public IncrementingPRNG()
    {
        this(System.nanoTime());
    }

    /**
     * Just our default randomize but with doubles instead
     *
     * @return a random decimal number
     */

    public double randomDouble()
    {
        return 0;
    }

    /**
     * If the user wants a random number from a certain range of numbers then they can set the randomizer
     *
     * @param lower_bound the starting point of our range, including our lower bound.
     * @param upperbound  the ending point of our range, excluding our upper bound.
     * @return a random number!!!!!!!
     * @throws PRNGException if the lower bound is greater than the upperbound
     */

    public int randomize(int lower_bound, int upperbound)
    {
        if (lower_bound > upperbound)
        {
            throw new PRNGException("The lower bound was higher than the upperbound");
        }

        int random = (int) (((state % (upperbound - lower_bound)) + lower_bound) % Integer.MAX_VALUE);

        state = (state + (state / 2)) % Long.MAX_VALUE;

        return random;
    }

    /**
     * If the user wants to set a limit on how far the randomize goes then they can. The lower bound will still be 0.
     *
     * @param upperbound the ending point of our range, excluding our upper bound.
     * @return a random number???????
     * @throws PRNGException if the upper bound is negative since our starting point is at 0 from the default
     */

    public int randomize(int upperbound)
    {
        if (upperbound > 0)
        {
            throw new PRNGException("The upperbound was lower than 0");
        }

        return randomize(0, upperbound);
    }

    /**
     * A method gives a random number from [0, 1) since no boundaries were given. This method is the default random number generator.
     *
     * @return a random number!??!?!
     */

    public int randomize()
    {
        return randomize(0, Integer.MAX_VALUE);
    }

    /**
     * A method to get the seed if no seed is implemented then we would use the current time of the system to generate the number.
     *
     * @return the seed?!?!?!?
     */

    public long getSeed()
    {
        return seed;
    }
}
