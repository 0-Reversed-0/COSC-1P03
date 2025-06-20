/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */

package storage;

public class The_Cabinet<E> implements Cabinet<E>
{

    Node<The_Bin<E>> head;
    int count;

    public The_Cabinet()
    {
        head = null;
        count = 0;
    }

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
                pointer.item.add(item);
                break;
            }

            pointer = pointer.next;
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
        The_Bin<E> newBin = new The_Bin<>(bin);

        head = new Node<>(newBin, head);

        count++;
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

        while (pointer != null)
        {
            if (pointer.item.label.equals(bin))
            {
                E value = pointer.item.grab();
                return value;
            }

            pointer = pointer.next;
        }

        throw new DisorganizationException("No label exists");
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

        while (pointer != null && pointer.item != null) // to ensure that the item within the bin is not null
        {
            if (pointer.item.label.equals(bin))
            {
                for (E val : pointer.item)
                {
                    query++;
                }

                break;
            }

            pointer = pointer.next;
        }

        return query;
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

        while (pointer != null)
        {
            if (pointer.item.label.equals(bin))
            {
                Bin<E> newBin = pointer.item;
                pointer.item = null;
                return newBin;
            }

            pointer = pointer.next;
        }

        return new The_Bin<>("");
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

    public String[] getBins()
    {
        Node<The_Bin<E>> pointer = head;
        String[] binLabels = new String[count];
        int i = 0;

        while (pointer != null)
        {
            binLabels[i] = pointer.item.label;

            pointer = pointer.next;
            i++;
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
