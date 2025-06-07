/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Rando Reincarnated - Assignment 2
 */

package chaotic;

/**
 * This class generates random values using a seed
 * This seed will be incremented to get a random number each time a method is called
 */

public class IncrementingPRNG implements PRNG
{

    private long seed; // The seed is the basis of how we generate the "random" number
    private long internalState; // If the user wants to use PRNG twice then we would need to update seed so we use a temporary seed to update the seed

    /**
     * This constructor is called when the user wants to set the seed. If the user puts the same seed twice we get same "random" values
     *
     * @param input the user inputted seed can be any "long" type number
     */

    public IncrementingPRNG(long input)
    {
        seed = input; // set the seed to whatever user decides to set it as
        internalState = seed; // our current seed is kind of like pointer node in linked lists, hence we should set our current seed to the original seed so that we keep the original intact
    }

    /**
     * If the user does not know what number they like then we can help them out set seed to the current system time in nanoseconds.
     * We do this because nanoseconds gives a longer more "random" value we can use to work around with.
     */

    public IncrementingPRNG()
    {
        this(System.nanoTime()); // if the user decides not to set the seed then we would
    }

    /**
     * Just our default randomize but with doubles instead from ranges 0.0 to 1
     * Essentially the Math.random function all over again.
     *
     * @return a random decimal number
     */

    public double randomDouble()
    {
        double decimalSeed = ((double) internalState / Integer.MAX_VALUE); // This is hard to explain in one line, so:

        /*
         * 1) it converts the current state to a double via casting
         * 2) I divide the current state by the Integer Max Value
         *
         * I convert the state to a double so the result would be in a double
         * The reason why I divide it by specifically integer max value is because we want the current state is in decimal form,
         * Because current state can have a result for mod 1 if done so
         * Normally if you do any# % mod 1 it would give 0 since divide anything by 1 it would be give no remainder
         * This is problem because we want to go from [0, 1) and setting a boundary like 0.99999... would not cut it since 0.99999... included in the boundary
         * But casting current state do a double wouldn't do the trick either because 26782173.00 % 1 = 0 regardless
         * If we divide current state by a crazy long number like Integer Max Value (not double.max or long.max because it would result in a crazy long decimal) then,
         * Current state (decimal state now) would become a crazy fraction giving us decimals at the end
         * Then once the state is calculated in the modulo it essentially cuts off the whole number part of the number and only evaluates the decimal since thinking logically,
         * how many times does 1 go into 26782173.48392048? 26782173 times would be the answer. Leaving us 0.48392048 which would be our new random number
         * Even if in the rare chance that the state is a multiple of integer max value which would give a remainder of 0; it would still be valid since 0 is included in the range.
         * This also explains why we use Max value because there little to no chance of getting a multiple of that value since it is a huge number
         * This way of doing things may loose precision but in my case I could not care less since it does the job man
         */

        double random = (decimalSeed % (1.0)); // gives us a random decimal from cutting the whole number off

        updateState(); //update seed would not change since we just cast the current seed as a double

        return random;
    }

    /**
     * If the user wants a random number from a certain range of numbers then they can set the randomizer
     *
     * @param lower_bound the starting point of our range, including our lower bound.
     * @param upperbound  the ending point of our range, excluding our upper bound.
     * @return a random number!!!!!!!
     * @throws PRNGException if the lower bound is greater than the upperbound
     */

    public int randomize(int lower_bound, int upperbound) throws PRNGException
    {
        if (lower_bound > upperbound) // makes sure that the program stays in bounds
        {
            throw new PRNGException("Lower Bound cannot be greater than upperbound");
        }

        int random = (int) (((internalState % (upperbound - lower_bound)) + lower_bound) % Integer.MAX_VALUE); // Do you like the first explanation rant? Well here's a second!!!

        /*
         * To understand this line of code we can break it down into a few steps:
         *
         * 1) We first and foremost subtract the lower bound from the upper bound!
         * 2) We get the remainder of the internalState when divided by the result of the previous step!!
         * 3) We add the lower bound to that result of the step above!!!
         * 4) We make sure it does not go out of the integer max value!!!!
         * 5) We finally cast the long into an int so it can be stored in the "random" variable!!!!!
         *
         * To understand why we did the first step, it's because we just want the range of values without caring where it starts and ends
         * Then with that range we want our state to be in bounds of the range
         * Afterward we add the lower bound so that we no matter what it starts from the lower bound, and it never goes above the upper bound
         * Example: (21 % (10-5) ) + 5 -> (21 % 5) + 5 -> 21mod5 = 1 ... 1 + 5 = 6. 6 would be inbounds for lower/upper bound of 5 - 10
         * Then finally we just make sure that it random number does not exceed the Integer Max Value (mod helps us here to YIPPEE)
         */

        updateState(); // only other time update state needs to be called since we just reuse this instance of randomizer

        return random;
    }

    /**
     * If the user wants to set a limit on how far the randomize goes then they can. The lower bound will still be 0.
     *
     * @param upperbound the ending point of our range, excluding our upper bound.
     * @return a random number???????
     * @throws PRNGException if the upper bound is negative since our starting point is at 0 from the default
     */

    public int randomize(int upperbound) throws PRNGException
    {
        if (upperbound <= 0) // since the instructions specified that it starts at 0 then we have to check if its above 0
        {
            throw new PRNGException("Upperbound cannot be 0 or less than 0");
        }

        return randomize(0, upperbound); // we can use the lower/upper bound method to get the random number to make our lives easier
    }

    /**
     * A method gives a random number from [0, Integer.MAX_Value) since no boundaries were given.
     * This method is the default random number generator.
     *
     * @return a random number!??!?!
     */

    public int randomize() throws PRNGException
    {
        return randomize(0, Integer.MAX_VALUE); // we can again use the lower/upper bound method to get the random number to make our lives easier
    }

    /**
     * A method to get the original seed
     *
     * @return the seed?!?!?!?
     */

    public long getSeed()
    {
        return seed;
    }

    /**
     * The current state need to be updated somehow,
     * So we have an updateState method where in this the state get updated via:
     * Adding the current state value to half of the current state value
     * We make a private method since we do not want clients to mess with the state at all or even see the state (hence the state would be abstract)
     */

    private void updateState()
    {
        internalState = Math.abs((internalState + (internalState / 2)) % Long.MAX_VALUE); // We add the %Long.Max_Value so we do not go past the state boundaries
    }
}
