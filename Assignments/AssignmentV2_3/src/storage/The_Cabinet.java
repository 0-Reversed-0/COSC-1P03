/**
 * Author: Reversed_0
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */

package storage;

/**
 * The Cabinet Class is a storage unit for bins.
 * Each cabinet created needs to specify which type of objects the cabinet will hold
 * Each cabinet can hold an infinite amount of bins
 *
 * @param <E> the type of items each bin will store
 */

public class The_Cabinet<E> implements Cabinet<E>
{

    /*
     * You might notice how I used the bin's implementation as the parametrized type rather than the abstract Bin class.
     * This is because each bin uses a label
     */

    Node<The_Bin<E>> head;

    int count = 0; // to keep track of how many of bins are in the cabinet

    /**
     * Adds a single entry to the cabinet, at the specified category.
     *
     * @param item element to store
     * @param bin  label of where to place the element
     * @throws DisorganizationException if the designated location is 'full'
     */

    public void add(E item, String bin)
    {
        Node<The_Bin<E>> pointer = head;

        while (pointer != null)
        {
            if (pointer.item.label.equals(bin)) // bins cannot be full because they are linked lists that do not have a set capacity on how much values it can store, therefore the exception is never thrown.
            { // I got the .equals() function from Lab 5.
                pointer.item.add(item); // add the items
                break; // its important that we break the loop so that the pointer does not find other bins
            }

            pointer = pointer.next; // progress the pointer otherwise
        }

        if (pointer == null) // if the list was empty then just make a new bin of that label
        {
            The_Bin<E> newBin = new The_Bin<>(bin);

            newBin.add(item);

            head = new Node<>(newBin, head); // we add it to the linked list now

            count++; // and index the count
        }
    }

    /**
     * Convenience method for adding a group of elements to the cabinet.
     * Primarily a complement to the getBin(String) function
     *
     * @param items Bin of elements to add
     * @param bin   Label of where to place the Bin's contents
     */

    public void add(Bin<E> items, String bin)
    {
        Node<The_Bin<E>> pointer = head;

        while (pointer != null) // We need to know if anything is in that bin label before adding to that bin or else we would be replacing the old bin with that label
        {
            if (pointer.item.label.equals(bin)) // so we need to search for a bin with that label first
            {
                break; // break if the bin exists
            }

            pointer = pointer.next; // goes until null
        }

        if (pointer == null) // if the pointer is null then there is no bin with that label
        {
            head = new Node<>((The_Bin<E>) items, head); // so it's safe to add that bin to cabinet
            count++;
        }
        else // if pointer is not null then we successfully stopped at the bin of that label so...
        {

            for(E val: items)
            {
                pointer.item.add(val); // this will empty the bins contents and add it to the pre-existing bin of that instead
            }

        }
    }

    /**
     * Requests the removal/return of one element, identified by Bin label.
     *
     * @param bin label of where to pull the element from
     * @return some member of type E
     * @throws DisorganizationException if the requested label does not exist, or that bin is empty
     */

    public E get(String bin)
    {
        Node<The_Bin<E>> pointer = head;
        E value;

        while (pointer != null) // first we need to find which bin has that label
        {
            if (pointer.item.label.equals(bin))
            {
                break;
            }

            pointer = pointer.next;
        }

        if (pointer != null) // if we found a label at any point then...
        {
            value = pointer.item.grab(); // take that the most recently added item from the bin
            return value;
        }

        throw new DisorganizationException("No label exists"); // if no label ever came to be then throw an exception
    }

    /**
     * Indicates how many elements are stored at the specified label.
     * Note: if the requested label does not exist, then the assumed behaviour
     * is that there are zero elements at that label. It is still legal to ask.
     *
     * @param bin label of bin to 'count'
     * @return number of elements stored at designated label
     */

    public int query(String bin)
    {
        Node<The_Bin<E>> pointer = head;
        int query = 0;

        while (pointer != null && pointer.item != null)  // we want traverse the cabinet and make sure that the item that the node is holding is not null
        {
            if (pointer.item.label.equals(bin))
            {
                for (E val : pointer.item) // we use a for each loop to add iterate the count until there is no more elements
                {
                    query++;
                }

                break;
            }

            pointer = pointer.next;
        }

        return query; // we can still return 0 if no label exists since technically it's true that the bin of that label holds nothing since the bin does not exist
    }

    /**
     * Empties out the entire contents corresponding to the specified label,
     * and returns them within a new Bin.
     * If that location is empty, or the label does not exist within the
     * collection, it simply returns an empty Bin.
     * <p>
     * Note on sequence: since you're emptying from an internal bin into
     * a new one, this will effectively reverse the sequence of the contents.
     *
     * @param bin label for requested elements
     * @return Bin containing requested elements
     */

    public Bin<E> getBin(String bin)
    {
        Node<The_Bin<E>> pointer = head;
        Bin<E> newBin = new The_Bin<>(bin); // this bin will inherent all the old bins contents


        while (pointer != null) // first we locate the requested bin
        {
            if (pointer.item.label.equals(bin))
            {
                break; // break if the bin exists
            }

            pointer = pointer.next;
        }

        if (pointer != null) // if bin has been found then...
        {
            while (pointer.item.hasStuff())
            {
                newBin.add(pointer.item.grab()); // empty out the bin into the replacement bin
            }

            return newBin;
        }

        return new The_Bin<>(bin); // if the bin does not exist then we just return an empty bin of the same label
    }

    /**
     * Requests a listing of all labels for existing bins.
     * For the sake of consistency in client software, this will include
     * now-empty bins, so long as they ever contained anything.
     * If desired, the client may always use the query(String) function
     * to identify whether there are still contents at a given label.
     * The client may always assume that the array is correctly-sized, and thus
     * may traverse it via e.g. a for-each loop.
     *
     * @return array of labels
     */

    public String[] getBins() // uncreative naming scheme honestly...
    {
        Node<The_Bin<E>> pointer = head;
        String[] binLabels = new String[count]; // we set it to count since it is only thing keeping track of how many bins were added to cabinet
        int i = 0;

        while (pointer != null)
        {
            binLabels[i] = pointer.item.label;

            i++;
            pointer = pointer.next;
        }

        return binLabels;
    }

    /**
     * Indicates how many members in total are stored within the collection,
     * across any and all bins.
     *
     * @return total number of members stored within the collection
     */

    public int getCount()
    {
        return count;
    }
}
