public class Main
{
    public Main()
    {
        Bubble_Sort();
        Insertion_Sort();
        Merge_Sort();
    }

    /**
     * Bubble sort is also known as exchange sort
     * The biggest value gets "bubbled" to the front
     * How this works is we compare 2 values "relative" order
     * Let's take this set as an example: 3 , 9 , 8
     * Bubble sort will say that 3 and 9 are relatively sorted so we DO NOT swap them
     * We move on the next index which is 9 and 8 which are not relatively sorted so we do swap them. This leaves us with...
     * 3 , 8 , 9
     * This is fully in-situ sorting algorithm and has a Big O cost of an expensive O(n^2)
     * It is also in-situ
     */

    void Bubble_Sort()
    {
        int[] arr = randomArray(10);
        displayArray(arr);
        boolean unsorted = true;

        while (unsorted)
        {
            for (int i = 0; i < arr.length - 1; i++)
            {
                int val_1 = arr[i];
                int val_2 = arr[i + 1];

                if (val_1 == val_2)
                {
                    arr[i] = val_1;
                    arr[i+1] = val_2;
                }
                else if (val_1 > val_2)
                {
                    arr[i + 1] = val_1;
                    arr[i] = val_2;
                }
            }

            for (int i = 0; i < arr.length-1; i++)
            {
                if (arr[i] < arr[i+1])
                {
                    unsorted = false;
                }
                else
                {
                    unsorted = true;
                }
            }

        }


        displayArray(arr);
    }

    /**
     * Insertion Sort is an adaptive sort where its Big O cost
     * We start at the end of the set with Insertion sort
     * Once at the end of the set we look at penultimate value and compare if they are relatively sorted and swap accordingly
     * We say that now at the current index we are absolutely sorted until a new index
     * We then index backwards (i--, tail.prev, etc.)
     * Note: The order of how index does NOT matter and is just a preference for Earl Foxwell
     * What makes it different from a bubble sort is...
     * When we index the set we then take the new value and compare with the absolutely sorted set until it is fully sorted itself
     * This would a fully in-situ algorithm as well
     * The Big O cost would vary since if the set is completely organized then there is only really one pass through the entire set
     * At worst it is O(n^2)
     * At best it is O(n)
     */

    void Insertion_Sort()
    {

    }

    /**
     * Merge sort is a recursive algorithm
     * It works via taking the set and splitting it in half
     * Then taking both of those halves and slowly halving them until they are all individual numbers that are all sorted (since they are literally a set of one number)
     * Once at that point then we merge those individual sets and sort them in the correct order
     * Set A (3), Set B(1) | Set C (2), Set D(4)
     * If it is not ordered then we swap them around and then merge them into one set: Set AB (1, 3)
     * We keep doing this until we combine every set together.
     * Once dealing with a set that has more than one value we compare the first indexes and check for which one is lesser to then put it in the new set first then index the set that one
     * Set AB (1, 3) , Set CD (2, 4)
     * 1) Set ABCD (1) [1 < 2]
     * 2) Set ABCD (1, 2) [2 < 3]
     * 3) Set ABCD (1, 2 ,3) [3 < 4]
     * 4) Set ABCD (1, 2, 3, 4)
     * This would NOT be in-situ at all.
     * This does give us the cost of O(n * log n).
     */

    void Merge_Sort()
    {

    }

    int[] randomArray(int capacity)
    {
        int[] rando = new int[capacity];

        for (int i = 0; i < capacity; i++)
        {
            rando[i] = (int) (Math.random() * 20);
        }

        return rando;
    }

    void displayArray(int[] array)
    {
        System.out.println();

        for (int i : array)
        {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}