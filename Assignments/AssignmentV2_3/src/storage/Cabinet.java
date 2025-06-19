package storage;

/**
 * Semi-organized Container, for holding an arbitrary number of elements,
 * stored within an arbitrary number of categories/bins.
 * Each bin is identified by a label, but otherwise mostly unorganized
 * within the bin.
 * Bins must at least behave as if ordered lexicographically.
 * <p>
 * Storage is assumed to be semi-temporary. Members are removed from the bins,
 * and if they're to remain within it after operations then they must be
 * manually re-entered.
 * <p>
 * The cabinet relies on a secondary container, the Bin, as a means of
 * quickly removing/returning all members that match a given label.
 *
 * @see Bin
 * @see DisorganizationException
 */

public interface Cabinet<E>
{
    /**
     * Adds a single entry to the cabinet, at the specified category.
     *
     * @param item element to store
     * @param bin  label of where to place the element
     * @throws DisorganizationException if the designated location is 'full'
     */

    public void add(E item, String bin);

    /**
     * Convenience method for adding a group of elements to the cabinet.
     * Primarily a complement to the getBin(String) function
     *
     * @param items Bin of elements to add
     * @param bin   Label of where to place the Bin's contents
     */

    public void add(Bin<E> items, String bin);

    /**
     * Requests the removal/return of one element, identified by Bin label.
     *
     * @param bin label of where to pull the element from
     * @return some member of type E
     * @throws DisorganizationException if the requested label does not exist, or that bin is empty
     */

    public E get(String bin);

    /**
     * Indicates how many elements are stored at the specified label.
     * Note: if the requested label does not exist, then the assumed behaviour
     * is that there are zero elements at that label. It is still legal to ask.
     *
     * @param bin label of bin to 'count'
     * @return number of elements stored at designated label
     */

    public int query(String bin);

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

    public Bin<E> getBin(String bin);

    /**
     * Requests a listing of all labels for existing bins.
     * For the sake of consistency in client software, this will include
     * now-empty bins, so long as they ever contained anything.
     * If desired, the client may always use the query(String) function
     * to identify whether or not there are still contents at a given label.
     * The client may always assume that the array is correctly-sized, and thus
     * may traverse it via e.g. a for-each loop.
     *
     * @return array of labels
     */

    public String[] getBins();

    /**
     * Indicates how many members in total are stored within the collection,
     * across any and all bins.
     *
     * @return total number of members stored within the collection
     */

    public int getCount();
}
