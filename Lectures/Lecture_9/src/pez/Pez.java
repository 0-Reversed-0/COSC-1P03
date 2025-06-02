package pez;

/**
 * A general container for holding Pez candies
 * Our Pez is a "Stack"
 * It is a temporary container that is an ADT
 * Basically just a short term storage that can put and give back
 * Stacks conventionally do not let you see the full collection (basically no display)
 * We can implement a stack as a Linked List or Arrays
 */

public interface Pez
{
    /**
     * A push in a stack is essentially adding to our stack
     *
     * @param c the colored pez that is being added to the dispenser
     * @throws PezFull if full
     */

    void push(char c);

    /**
     * removes a pez and gives us what the pez is
     *
     * @return the pez
     * @throws PezEmpty if empty
     */

    char pop();

    /**
     * shows us what pez is going to be removed
     *
     * @return the pez that will remove
     * @throws PezEmpty if empty
     */

    char top();

    /**
     * Checks if the pez dispenser is empty
     *
     * @return false or true
     */

    boolean isEmpty();

    /**
     * Checks if the dispenser is full
     *
     * @return false or true
     */

    boolean isFull();

    /**
     * @return how many values in the dispenser
     * @throws PezEmpty if empty
     */

    int howMany();
}
