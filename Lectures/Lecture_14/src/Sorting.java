/**
 * This lecture is the intro to sorting.
 */

public class Sorting
{

    /**
     * A sorting algorithm in situ that doesn't require constant additional space.
     * What that means is that is an algorithm uses more allocated memory in the RAM than what is already assigned
     * If it does NOT use any more RAM than needed then it is in situ (in place)
     */

    public Sorting()
    {
        Selection_Sort();
    }

    /**
     * First find the smallest value in the set of numbers.
     * We do this via doing the same thing we do in finding the minimum and maximum values.
     * Then we swap the smallest value to the first index wit the first index
     * Now the set can never access the first index since that part of the set is absolutely sorted
     * Then we pass through the set a second time and look for the second-smallest value
     * Once we find that second-smallest value then we add it to the second index and add it to the absolutely sorted part of the set
     * We do this all the way until the set is sorted
     * This would be in situ and a Big O complexity of O(n^2)
     * Only problem is that we cannot to this for array since it unstable
     */

    void Selection_Sort()
    {

    }

    public static void main(String[] args)
    {
        new Sorting();
    }
}