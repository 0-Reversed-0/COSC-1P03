package Generic;


public interface Stack <Dealie>
{
    /**
     * A push in a stack is essentially adding to our stack
     *
     * @param c the item that is being added to the dispenser
     */

    void push(Dealie c);

    /**
     * removes a item and gives us what the item is
     *
     * @return the item
     */

    Object pop();

    /**
     * shows us what item is going to be removed
     *
     * @return the item that will remove*/

    Object top();

    /**
     * Checks if the item dispenser is empty
     *
     * @return false or true
     */

    boolean isEmpty();
}
