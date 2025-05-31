/**
 * This class just went over sorting algorithms and which ones are more efficient was not the most eventful
 */

public class Main
{

    public Main()
    {
        sorting();
    }

    void sorting()
    {
        int[] arr = rando(100);

        display(arr);

        // we want to find the largest value Algorithm

        sortingAlgorithm(arr);
    }

    /**
     * A storing algorithm that finds the largest value
     * @param arr an int array
     */

    void sortingAlgorithm(int[] arr)
    {
        int large = arr[0]; // the largest value is the first value

        for (int j = 0; j < arr.length; j++)
        { // goes through all the numbers assuming the first value in the set is the largest
            if (arr[j] > large)
            { //until proven otherwise
                large = arr[j]; // changes the largest value into what is now the largest value in the set until proven otherwise
            }
        }

        System.out.println("\nLargest: " + large);
    }

    /**
     * Displays our array
     * @param arr an int array
     */

    void display(int[] arr)
    {

        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Fills an array which random values
     * @param qty an int on how long we want the array to be
     * @return a filled out array
     */

    private int[] rando(int qty)
    {
        int[] arr = new int[qty];

        for (int i = 0; i < qty; i++)
        {
            arr[i] = (int) (Math.random() * 500);
        }

        return arr;
    }

    public static void main(String[] args)
    {
        new Main();
    }
}