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

    void display(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

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