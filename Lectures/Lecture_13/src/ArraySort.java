public class ArraySort
{

    int array[] = new int[20];

    public ArraySort()
    {
        fill();
        display();
    }

    void Selection_Sort()
    {

    }

    /**
     * Same thing as before just adds random numbers to the array
     */

    void fill()
    {
        for (int i = 0; i < array.length; i++)
        {
            array[i] = (int) (20 * Math.random());
        }
    }

    /**
     * Displays the array
     */

    void display()
    {
        for (int j : array)
        {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args)
    {
        new ArraySort();
    }
}
