package chaotic;

/**
 * PRNG is a pseudo random number generator.
 * It generates seemingly random numbers rather than actual true random numbers, giving the illusion of randomness.
 * <p>
 * This interface defines 3 ADTs:
 * Incrementing PRNG ADT,
 * Timely PRNG ADT,
 * Basic PRNG ADT.
 * <p>
 * All these methods share the exact same implementation of methods with the only change being:
 * the constructor,
 * the instance variables,
 * and the private update seed method.
 */

public interface PRNG
{

    /**
     * Just our default randomize but with doubles instead from ranges 0.0 to 1
     * Essentially the Math.random function all over again.
     *
     * @return a random decimal number
     */

    double randomDouble();

    /**
     * If the user wants a random number from a certain range of numbers then they can set the randomizer
     *
     * @param lower_bound the starting point of our range, including our lower bound.
     * @param upperbound  the ending point of our range, excluding our upper bound.
     * @return a random number!!!!!!!
     * @throws PRNGException if the lower bound is greater than the upperbound
     */

    int randomize(int lower_bound, int upperbound) throws PRNGException;

    /**
     * If the user wants to set a limit on how far the randomize goes then they can. The lower bound will still be 0.
     *
     * @param upperbound the ending point of our range, excluding our upper bound.
     * @return a random number???????
     * @throws PRNGException if the upper bound is negative since our starting point is at 0 from the default
     */

    int randomize(int upperbound) throws PRNGException;

    /**
     * A method gives a random number from [0, Integer.MAX_Value) since no boundaries were given. This method is the default random number generator.
     *
     * @return a random number!??!?!
     */

    int randomize() throws PRNGException;

    /**
     * A method to get the original seed
     *
     * @return the seed?!?!?!?
     */

    long getSeed();
}
