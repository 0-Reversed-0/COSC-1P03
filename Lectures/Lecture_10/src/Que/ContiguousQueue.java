package Que;

public class ContiguousQueue implements Queue
{

    private int front, tail, count;
    String[] arr;

    public ContiguousQueue(int capacity)
    {
        arr = new String[capacity];
    }

    /**
     * Adds the specified memeber to the end of the queue
     *
     * @param item a new string
     * @throws QueueFullException
     */
    
    public void add(String item)
    {
        if(count >= arr.length)
        {
            throw new QueueFullException();
        }

        count++;

        arr[tail] = item; //puts it in the array

        tail = (tail+1) % arr.length; //todo explain this line
    }

    /**
     * Removes the first member of the queue
     *
     * @return a string
     * @throws QueueEmptyException
     */
    
    public String remove()
    {
        if (count < 1)
        {
            throw new QueueEmptyException();
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
            throw new QueueEmptyException();
        }

        return arr[front];
    }

    /**
     * How many elements are in the queue
     *
     * @return the amount in the queue
     * @throws QueueEmptyException
     */
    
    public int size()
    {
        return count;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }
}