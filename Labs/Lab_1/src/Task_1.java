public class Task_1
{
    public Task_1()
    {
        task1();
    }

    /**
     * Task 1
     * Purpose: Get an array of 10 values and display them. Show the first/last value and finally the average
     */

    void task1()
    {
        int[] arr = generate(10);

        display(arr);
    }

    /**
     * Show what is required i.e., first value, last value, average
     */

    void display(int[] array)
    {
        /// Displays the Array as a whole

        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        /// First and last value

        System.out.println("First Value: " + array[0]);
        System.out.println("Last Value: " + array[array.length - 1]);

        /// Average

        System.out.println("Average Value: " + average(array));

        /// Penultimate

        if (array.length >= 2)
        {
            System.out.println("Penultimate Value : " + array[array.length - 2]);
        } else
        {
            System.out.println("Penultimate Value: " + array[0]); // This is because The first value is arr[0] the last value is the same and technically the penultimate is the same
        }
    }

    /**
     * Show the average of the array
     */

    double average(int[] array)
    {
        int size = array.length;

        int sum = 0;

        for (int i = 0; i < size; i++)
        {
            sum += array[i];
        }

        double avg = (double) sum / size;

        return avg;
    }

    /**
     * Generate the array and fill it with random numbers
     */

    int[] generate(int size)
    {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++)
        {
            arr[i] = (int) (5 * Math.random() + 1);
        }

        return arr;
    }

    public static void main(String[] args)
    {
        new Task_1();
    }
}