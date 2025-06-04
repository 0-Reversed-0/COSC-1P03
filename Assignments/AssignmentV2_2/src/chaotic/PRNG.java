package chaotic;

public interface PRNG
{

    int nextInt(int min, int max);

    /**
     * A method to get the seed if no seed is implemented then we would use the current time of the system to generate the number
     * @return the seed
     */

    long getSeed();
}
