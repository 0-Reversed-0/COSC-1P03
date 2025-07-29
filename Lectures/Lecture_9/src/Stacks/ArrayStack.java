package Stacks;

/**
 * Here we want to make a Stack using arrays instead of linked list.
 * The Big O cost of this will also be O(1) meaning that every function of a Stack is constant/
 * Again like the linked list stack be aware that this is an ADT and how we implement
 * It does not matter as long as it follows the rules of how a stack WORKS.
 */

public class ArrayStack implements Stack
{

    private int[] array; // in an array stack we use obviously use an array (Note: we have to approach this differently because of that)
    private int index = 0; // the index is how we determine where the item will be stored

    public ArrayStack(int capacity) // notice how we have a constructor here,
    {
        array = new int[capacity]; // since arrays aren't infinite in size we have to the user set the size of the array
    }

    /**
     * A push in context of a stack is how an item is added to a stack
     * Pushes work in a last in first out fashion. How this would look like is:
     * User inputs: 1, 2, 4, 7 , 5 into the stack
     * How the stack stores it: 5, 7, 4, 2, 1
     * This is why it's called a stack since ever single new value is 'stacked' onto each other.
     *
     * @param item This will be the item inputted into the stack
     * @throws StackFullException if the stack's array is full since that is actually a problem here
     */

    public void push(int item)
    {
        if (isFull())
        {
            throw new StackFullException("Stack is at capacity");
        }

        /*
         * How this works is like this;
         * push(3);
         *
         * What goes on internally:
         * index = 0; capacity = 4; item = 3;
         * | 3 (index here) | _ | _ | _ |
         * index = 1;
         * | 3 | (index here) | _ | _ |
         *
         * We always store at the index before updating it, and we revolve our code around this concept
         * The index placement is important where the index is first used THEN is incremented
         */

        array[index] = item; // Use the current index
        index++; // Then index to let it be in front
    }

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

    public int pop()
    {
        if (isEmpty()) // we need to check if it is empty before ever popping any value to prevent index out of bounds
        {
            throw new StackEmptyException("Stack is empty");
        }

        /*
         * Now when removing items then we handle it a little differently.
         * We want to first move the index,
         * Then return the item,
         * And finally null out the value.
         *
         * What goes on internally:
         * int value = pop();
         *
         * index = 3, capacity = 5;
         * | 3 | 4 | 7 | _ (index here) | _ |
         * index--; index = 2;
         * | 3 | 4 | 7 (index here) | _ |
         * arr[index] = null;
         * | 3 | 4 | _ (index here) | _ |
         */

        index--;
        int item = array[index];
        array[index] = 0; // this 0 would be null if it was an object but since an integer cannot be defined by null then we have to make it 0

        // Take note of the nullification that cannot be done as of right now as it is important for generics later one :)

        return item;
    }

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

    public int peek()
    {
        if (isEmpty())
        {
            throw new StackEmptyException("Stack is empty");
        }

        return array[index - 1]; // here we can just return the top value
    }

    /**
     * This is a method to check if the stack is empty so we could avoid that pesky exception we made. (self-inflicted problem I'm aware)
     * All this does is check if the stack is empty and if it's not then just return accordingly
     *
     * @return a boolean value according to whether the stack is empty. Empty -> true | Full -> false.
     */

    public boolean isEmpty()
    {
        boolean empty = false;

        /*
         * For us our very last index will be 0 so whenever the index is 0 it is empty and can no longer be popped
         * This works in emptying out the entire stack because once popping the last value the index would be 1
         * This because we made it so that the uppermost value will always have an index above the current index
         */

        if (index == 0)
        {
            empty = true;
        }

        return empty;
    }

    /**
     * Since we are making a Stack using arrays then we must also make a checker than can check if the stack is full or not
     *
     * @return a boolean value according to whether the stack is empty. Empty -> false | Full -> true.
     */

    public boolean isFull()
    {
        boolean full = false;

        if (index == array.length) // same thing with popping where you can until the last index which would above the last index by 1
        {
            full = true;
        }

        return full;
    }
}
