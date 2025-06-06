package chaotic;

/**
 * This class generates random values using a seed
 * This seed will be incremented to get a random number each time a method is called
 */

public class IncrementingPRNG implements PRNG
{

    private long seed;          // The seed is the basis of how we generate the "random" number
    private long currentSeed;   // If the user wants to use PRNG twice then we would need to update seed so we use a temporary seed to updated the see

    /**
     * If the user decides to set the seed instead of it being system time then they can put it in the object arguments
     * @param s the user inputted seed
     */

    public IncrementingPRNG(long s)
    {
        seed = s;               // set the seed to whatever user decides to set it as
        currentSeed = seed;     // our current seed is kind of like pointer node in linked lists, hence we should set our current seed to the original seed so that we keep the original intact
    }

    /**
     * If the user does not know what number they like then we can help them out set seed to the current system time in nanoseconds
     * We do this because nanoseconds gives a longer more "random" value we can use to work around with
     */

    public IncrementingPRNG()
    {
        this(System.nanoTime()); // if the user decides not to set the seed then we would
    }

    /**
     * Just our default randomize but with doubles instead
     * @return a random decimal number
     */

    public double randomDouble()
    {
        double decimalSeed = ((double) currentSeed / Integer.MAX_VALUE); // This is hard to explain in one line, so:

        /*
         * 1) it converts the current seed to a double via casting
         * 2) I divide the current seed by the Integer Max Value
         *
         * I convert the seed to a double so the result would be in a double
         * The reason why I divide it by specifically integer max value is because when current seed is in decimal form,
         * Because current seed can have a result for mod 1 if done so
         * Normally if you do any# % mod 1 it would give 0 since divide anything by 1 it would be give no remainder
         * This is problem because we want to go from [0, 1) and setting a boundary like 0.99999... would not cut it since 0.99999... included in the boundary
         * But casting current seed do a double wouldn't do the trick either because 26782173.00 % 1 = 0 regardless
         * If we divide current seed by a crazy long number like Integer Max Value (not double or long because it would result in a crazy long decimal) then,
         * Current seed (decimal seed now) would become a crazy fraction
         * Then once the seed is calculated in the modulo it essentially cuts off the whole number part of the number and only evaluates the decimal since thinking logically,
         * how many times does 1 go into 26782173.48392048? 26782173 times would be the answer. Leaving us 0.48392048 which would be our new random number
         * Even if in the rare chance that the seed is a multiple of integer max value which would give a remainder of 0; it would still be valid since 0 is included in the range.
         * This also explains why we use Max value because there little to no chance of getting a multiple of that value since it is a huge number
         */

        double random = (decimalSeed % (1.0)); // gives us our decimal

        updateSeed();

        return random;
    }

    /**
     * If the user wants a random number from a certain range of numbers then they can set the randomizer
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

        int random = (int) (((currentSeed % (upperbound - lower_bound)) + lower_bound) % Integer.MAX_VALUE);

        updateSeed();

        return random;
    }

    /**
     * If the user wants to set a limit on how far the randomize goes then they can. The lower bound will still be 0.
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
     * @return a random number!??!?!
     */

    public int randomize()
    {
        return randomize(0, Integer.MAX_VALUE);
    }

    /**
     * A method to get the seed if no seed is implemented then we would use the current time of the system to generate the number.
     * @return the seed?!?!?!?
     */

    public long getSeed()
    {
        return seed;
    }

    /**
     * Typing out this line over and over again is not it
     * So I just made this method to update the seed everytime a "random" number is generated
     */

    private void updateSeed()
    {
        currentSeed = (currentSeed + (currentSeed / 2)) % Long.MAX_VALUE;
    }
}
