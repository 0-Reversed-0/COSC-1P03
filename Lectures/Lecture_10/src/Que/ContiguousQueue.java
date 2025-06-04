package Que;

public class ContiguousQueue implements Queue
{

    private int front, tail, count;
    String[] arr;

    public ContiguousQueue()
    {
        this(100);
    }

    public ContiguousQueue(int capacity)
    {
        arr = new String[100];
    }

    /**
     * Adds the specified memeber to the end of the queue
     *
     * @param s a new string
     * @throws OverflowException
     */
    
    public void add(String s)
    {
        /*
         * Check if there's space
         * put into the array
         * use our handy dandy formula to make sure the array does not go out of bounds
         */

        if(count >= arr.length) //checks for space
        {
            throw new OverflowException();
        }

        count++;

        arr[tail] = s; //puts it in the array

        tail = (tail+1) % arr.length; //todo explain this line
    }

    /**
     * Removes the first member of the queue
     *
     * @return a string
     * @throws UnderflowException
     */
    
    public String remove()
    {
        /*
         * Check if its empty
         * remove the item
         * null out the space where the item was
         */

        if (count < 1)
        {
            throw new UnderflowException();
        }

        String item = arr[front]; //grab the item before the item gets nulled out

        arr[front] = null; // remove the space where it was

        front = (front+1) % arr.length; // move the point in front so that we have a new start to the array rather than shifting the entire damn array

        count--;

        return item;
    }

    /**
     * Shows us what's next in queue
     * @return the string that is about to be removed
     */

    public String front()
    {
        if(count < 1)
        {
            throw new UnderflowException();
        }

        return arr[front];
    }

    /**
     * How many elements are in the queue
     *
     * @return the amount in the queue
     * @throws UnderflowException
     */
    
    public int count()
    {
        return count;
    }
}