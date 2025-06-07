/**
 * Author: Reversed_0
 * Course: COSC 1P03
 * Title: Rando Reincarnated - Assignment 2
 */

package chaotic;

/**
 * This class generated random value using a seed.
 * No matter what seed a user enters you can never get the same results twice.
 */

public class TimelyPRNG implements PRNG
{

    private long initialTime; // we need to know when the object was created and when the last time a method was called
    private long seed; // Our basis for creating a random number
    private long internalState; // seed and internal state would set the same way

    /**
     * This constructor is called when the user wants to use their own seed
     * (even if we input the same seed twice we would not get the same result so there is not much point to setting the seed but this is an assignment requirement)
     *
     * @param input the user inputted seed can be any "long" type number
     */

    public TimelyPRNG(long input)
    {
        initialTime = System.nanoTime(); // We would want to make the initialTime the first variable we set since we need to
        seed = input;
        internalState = seed;
    }

    /**
     * The default constructor just sets the seed to current System time.
     */

    public TimelyPRNG()
    {
        initialTime = System.nanoTime(); // we don't use this() since the time when the object was created is different from the time the seed was set
        seed = System.nanoTime(); // the seed will be different from the seed in orders of operation
        internalState = seed;
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
         * I convert the state to a double so the result would be in a double.
         * The reason why I divide it by specifically integer max value is because we want the current state is in decimal form,
         * Because current state cannot have a result for mod 1 that isn't 0.
         * Normally if you do any whole number % mod 1 it would give 0 since divide anything by 1 it would be give no remainder (Ex: 427842378 % 1 = 0).
         * This is problem because we want to go from [0, 1) and setting a boundary to like 0.99999... would not cut it since 0.99999... is included in the boundary
         * But casting current state to a double wouldn't do the trick either because 26782173.00 % 1 = 0 (or any random number.00 % 1) regardless.
         * If we divide current state by a crazy long number like Integer Max Value (not double.max or long.max because it would result in a crazy long decimal) then,
         * Current state (decimalSeed now) would become a crazy fraction giving us decimals at the end,
         * Then once the state is calculated in the modulo it essentially cuts off the whole number part of the number and only evaluates the decimal since thinking logically,
         * how many times does 1 go into 26782173.48392048? 26782173 times would be the answer. Leaving us 0.48392048 which would be our new random number
         * Even if in the rare chance that the state is a multiple of integer max value which would give a remainder of 0; it would still be valid since 0 is included in the range.
         * This also explains why we use Max value because there little to no chance of getting a multiple of that value since it is a huge number
         * This way of doing things may lose precision but in my case I could not care less since it does the job man.
         */

        double random = (decimalSeed % (1.0)); // gives us a random decimal from cutting the whole number off

        updateState(); //update seed would not change since we just cast the internal state as a double

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
            throw new PRNGException("Lower bound should not be greater than upperbound");
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
         * Then with that range we want our seed to be in bounds of the range
         * Afterward we add the lower bound so that we no matter what it starts from the lower bound, and it never goes above the upper bound
         * Example: (21 % (10-5) ) + 5 -> (21 % 5) + 5 -> 21mod5 = 1 ... 1 + 5 = 6. 6 would be inbounds for lower/upper bound of 5 - 10
         * Then finally we just make sure that it random number does not exceed the Integer Max Value (mod helps us here to YIPPEE)
         */

        updateState(); // only other time update seed needs to be called since we just reuse this instance of randomizer

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
            throw new PRNGException("Upperbound cannot be 0 or less 0");
        }

        return randomize(0, upperbound); // we can use the lower/upper bound method to get the random number to make our lives easier
    }

    /**
     * A method gives a random number from [0, Integer.MAX_Value) since no boundaries were given. This method is the default random number generator.
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
     * The updateState method in this object uses time to update the seed by adding the displacement of time to the state
     */

    private void updateState()
    {
        long currentTime = System.nanoTime(); // First we would want to capture the exact time when the randomize method made a new random number

        // We do this because we want to update the state AFTER it's been use

        long timeDisplacement = (long) ((currentTime - initialTime) * 3293221.949083); // we now want to know how much time has it been since the previous call (which is the displacement of both times)

        /*
         * Now you may be asking wait why are multiplying it by this random decimal number by the time displacement? That wouldn't make it the time displacement at all then?
         * I'll explain after we update the seed...
         */

        internalState += timeDisplacement % Long.MAX_VALUE; // then we want to change the current state

        /*
         * The time displacement between the last instance of the method being called / object being created is trivial.
         * This is because we live in the modern age where computers having ultra-fast processors are in literal family computers.
         * And since literally every operation is at a Big O cost of O(1) in this class, then the program would be crazy fast.
         * Meaning the time it between the last instance and current time is next to nothing.
         * This means that our internalState BARELY updates at all.
         * So we multiply it by a random decimal number so it would make the displacement just enough to update the state.
         * You might ask why not just multiply it by integer max value instead of some random number?
         * This is because of scale.
         * If we multiply too high then we're essentially just multiplying by 10 if you get what that means. (It wouldn't change anything because of mod).
         * So after a little trial an error I just multiplied the state until it got a number that made sense!
         */

        initialTime = currentTime; // now we would want to update the initial time to the current time because we would want to prepare for the next call
    }
}
