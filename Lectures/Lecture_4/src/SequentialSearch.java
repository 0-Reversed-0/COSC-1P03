/**
 * Sequential Search (aka Linear search) is the most versatile searching algorithm
 * It can be used with any data structure,
 * It does not require a data structure to be sorted to find the item
 * The only downside is that it is less efficient because it has a Big O complexity of O(n)
 */

public class SequentialSearch
{
    int[] array; // we will use an array with a bunch of random to demonstrate sequential sort.

    public SequentialSearch()
    {
        array = fill();

        System.out.println("The largest element in the array is: " + largest(array));
    }

    /**
     * This will be the sequential search algorithm.
     * Here our goal is to search an array to find the largest number in the set.
     * The steps in sequential generally are:
     * First declare a variable that is initialized as the first index of the data structure.
     * Index through every element in the data structure.
     * While indexing every element, compare each element to the variable you declared earlier (in this case we compare each element with our variable to see if the current element is larger).
     * If the comparison check fails (in this case current element is larger than our variable) then initialize the variable to that element.
     * Return the variable.
     * <p>
     * This is why sequential search is O(n), because we index every element and compare.
     * This makes it inefficient compared something like binary search which is O(log n)
     *
     * @param arr int array will be our data structure of choice
     * @return the largest number
     */

    int largest(int[] arr)
    {
        int largest = arr[0]; // this will be our variable we compare with every element in the array

        for (int i = 0; i < arr.length; i++) // then we would index through every element in the array
        {
            if (largest < arr[i]) // now we compare to see if any element in the array is larger than the first element
            {
                largest = arr[i]; // if any element is larger than the first element then initialize the largest variable to that element
            }
        }

        return largest;
    }

    /**
     * @return an array of 10,000 elements with random numbers from 0-10,000,000
     */

    int[] fill()
    {
        int[] array = new int[10000];

        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int) (Math.random() * 10000000);
        }

        return array;
    }

    public static void main(String[] args)
    {
        new SequentialSearch();
    }
}