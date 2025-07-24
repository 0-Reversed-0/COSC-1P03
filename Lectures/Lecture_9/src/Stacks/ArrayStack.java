package Stacks;

public class ArrayStack implements Stack
{

    private int[] array; // in an array stack we use obviously use an array (Note: we have to approach this differently because of that)
    private int index; // the index is how we determine where the item will be stored

    public ArrayStack(int capacity) // notice how we have a constructor here
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

        array[index] = item; // first we want to add the item to the array at the CURRENT index before it is ever increased

        /*
         * How this works is like this;
         * push(3);
         *
         * What goes on internally:
         * index = 0; capacity = 4; item = 3;
         * | 3 | _ | _ | _ |
         * index = 1;
         *
         * We always store at the index before updating it and we revolve our code around this concept
         */

        index++; // we now ready the index to always be front of the stack's "top value".
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
        if(isEmpty())
        {
            throw new StackEmptyException("Stack is empty");
        }

        index--; // NOW we first have to get to the actual top index since our push always goes +1 from the top value
        int item = array[index]; // once there we retrieve the item from the array before we "nullify" the item within the index
        array[index] = 0; // finally before returning just null out the value (or in this case just put 0)

        return item; // now we can safely return the item
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

        return array[index-1]; // here we can just return the top value
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

        if (index == -1) // you can pop every value to the 0th index. Due to this that would leave the index can be at -1.
        {
            empty = true;
        }

        return empty;
    }

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
