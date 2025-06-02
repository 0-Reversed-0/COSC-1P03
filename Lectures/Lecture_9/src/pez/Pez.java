package pez;

/**
 * A general container for holding things
 */

public interface Pez
{
    /**
     * adds a pez to pez dispenser
     * @param c the colored pez that is being added to the dispenser
     */

    void add(char c);

    /**
     * removes a pez
     *
     */

    char remove();
}
