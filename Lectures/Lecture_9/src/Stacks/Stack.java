/**
 * This lecture fully covers what a Stack is,
 * properties of a stack,
 * how to implement a stack using arrays and linked lists,
 * and tips and tricks along the way. Enjoy!
 */

package Stacks;

/**
 * A stack is an ADT that stores temporarily.
 * It stores data via using last in first out procedures.
 * Stacks can only show the last value stored and nothing else
 * A stack only contains about 4 methods being push, pop, peek, and isEmpty (would be funny if I started that with a p too)
 * This stack in particular will hold integer (Note this for when we get into generics!!!)
 * Stacks, in general, have a Big O complexity of O(1).
 */

public interface Stack
{
    /**
     * A push in context of a stack is how an item is added to a stack
     * Pushes work in a last in first out fashion. How this would look like is:
     * User inputs: 1, 2, 4, 7 , 5 into the stack
     * How the stack stores it: 5, 7, 4, 2, 1
     * This is why it's called a stack since ever single new value is 'stacked' onto each other.
     *
     * @param item This will be the item inputted into the stack
     */

    void push(int item);

    /**
     * A pop in content of a stack how a stack is able to remove its content and be able to use those at the same time
     * Since a stack works in a last in first out fashion then it would also take the items too.
     * Current Stack: 4, 5, 2, 8
     * User: int a = 21 + Stack.pop();
     * Current Stack: 5, 2, 8
     *
     * @return an integer item in the stack
     * @throws StackEmptyException if the stack has run out of contents
     */

    int pop();

    /**
     * Peeking in a stack simply does what its name suggests.
     * Sometimes we want to check what is in the stack before removing it. This is what peek does
     * When a user calls peek it checks the last item entered into the stack.
     * Current Stack: 4, 5, 2, 8
     * User: int a = 21 + Stack.peek();
     * Current Stack: 4, 5, 2, 8
     * Note: Sometimes peek() could be referred to top() since we are looking at the top of the stack
     *
     * @return the next item to be removed in the stack within the stack.
     * @throws StackEmptyException if the stack is empty (this should be obvious)
     */

    int peek();

    /**
     * This is a method to check if the stack is empty so we could avoid that pesky exception we made. (self-inflicted problem I'm aware)
     * All this does is check if the stack is empty and if it's not then just return accordingly
     *
     * @return a boolean value according to whether the stack is empty. Empty -> true | Full -> false.
     */

    boolean isEmpty();
}
