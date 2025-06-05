package chaotic;

public interface PRNG
{

    /**
     * If the user wants a random number from a certain range of numbers then they can set the randomizer
     * @param LowerBound the starting point of our range (inclusive)
     * @param UpperBound the ending point of our range (exclusive)
     * @return a random number!!!!!!!
     */

    int randomize(int LowerBound, int UpperBound);

    /**
     * If the user wants to set a limit on how far the randomize goes then they can. The lower bound will still be 0.
     * @param Upperbound the ending point of our range
     * @return a random number???????
     */

    int randomize(int Upperbound);

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
