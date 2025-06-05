package chaotic;

public interface PRNG
{



    /**
     * If the user wants a random number from a certain range of numbers then they can set the randomizer
     * @param lowerbound the starting point of our range, including our lower bound.
     * @param upperbound the ending point of our range, excluding our upper bound.
     * @return a random number!!!!!!!
     * @throws chaotic.PRNGException
     */

    int randomize(int lowerbound, int upperbound);

    /**
     * If the user wants to set a limit on how far the randomize goes then they can. The lower bound will still be 0.
     * @param upperbound the ending point of our range, excluding our upper bound.
     * @return a random number???????
     */

    int randomize(int upperbound);

    /**
     * A method gives a random number from [0, 1) since no boundaries were given. This method is the default random number generator.
     * @return a random number!??!?!
     */

    int randomize();

    /**
     * A method to get the seed if no seed is implemented then we would use the current time of the system to generate the number.
     * @return the seed!!!!!!!!!!!!!
     */

    long getSeed();
}
