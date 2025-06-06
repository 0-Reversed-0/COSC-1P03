package chaotic;

/**
 * PRNG is a pseudo random number generator
 * It generates seemingly random numbers rather than actual true random numbers, giving the illusion of randomness
 *
 * This interface defines 3 ADTs
 * Incrementing PRNG ADT
 * Timely PRNG ADT
 * Basic PRNG ADT
 */

public interface PRNG
{

    /**
     * Just our default randomize but with doubles instead from ranges 0.0 to 1
     * @return a random decimal number
     */

    double randomDouble();

    /**
     * If the user wants a random number from a certain range of numbers then they can set the randomizer
     * @param lower_bound the starting point of our range, including our lower bound.
     * @param upperbound the ending point of our range, excluding our upper bound.
     * @return a random number!!!!!!!
     * @throws PRNGException if the lower bound is greater than the upperbound
     */

    int randomize(int lower_bound, int upperbound);

    /**
     * If the user wants to set a limit on how far the randomize goes then they can. The lower bound will still be 0.
     * @param upperbound the ending point of our range, excluding our upper bound.
     * @return a random number???????
     * @throws PRNGException if the upper bound is negative since our starting point is at 0 from the default
     */

    int randomize(int upperbound);

    /**
     * A method gives a random number from [0, Integer.MAX_Value) since no boundaries were given. This method is the default random number generator.
     * @return a random number!??!?!
     */

    int randomize();

    /**
     * A method to get the seed if no seed is implemented then we would use the current time of the system to generate the number.
     * @return the seed?!?!?!?
     */

    long getSeed();
}
