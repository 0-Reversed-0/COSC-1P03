public class Puzzle
{

    /**
     * The time complexity of this class would be O(n^2)
     */

    public Puzzle() //O(n^2 + n) = O(n^2) we always take the highest order of n for big O notation
    {
        //Let's calculate whether the first 10 positive integers are prime!
        boolean[] results = analysis(10); //O(n^2)
        for (int i = 0; i < results.length; i++)
            System.out.println(i + ": " + (results[i] ? "yes" : "no")); // O(n)
    }

    /**
     * For some number of values, just check if each one
     * is prime, and keep track of the results.
     *
     * @param qty ...whattaya think?
     * @return a nice bouquet of roses!
     */
    private boolean[] analysis(int qty) //The whole method is O(n^2)
    {
        boolean[] primes = new boolean[qty];
        for (int i = 0; i < qty; i++) // O(n) its just filling out the array initially
            primes[i] = checkPrime(i); // O(n) * O(n) = O(n^2) since every space of the array is O(n) runtime since check prime as method is O(n) we would have to multiply it
        return primes;
    }

    /**
     * A value is prime if it is divisible only by 1 and itself.
     * We only need to check up to V/2, since any factor higher than that
     * would have been multiplied by one lower than it (which we'd have
     * already found). The algorithm's a basic 'proof by contradiction':
     * we'll assume it's prime, and then look for factors to disprove.
     *
     * @param value to check
     * @return if the provided value is prime
     */
    private boolean checkPrime(int value) //O(n)
    {
        if (value < 2) return false;
        for (int i = 2; i <= value / 2; i++) // This is O(n) since any constant on O(cn) will be cancelled in the long run which will equate it to O(n)
            if (value % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args)
    {
        new Puzzle();
    }
}