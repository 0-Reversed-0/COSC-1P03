public class Main
{

    public Main()
    {
        Arrays();
        Traversal();
    }

    /**
     * Arrays are a collects of data used to efficiently store data
     * Arrays are an object
     * Arrays allocate the ram to a set size that the user sets
     * YOU CANNOT CHANGE ARRAY SIZES
     * They can only hold one type of array
     * Arrays use 0 based indexing i.e. starting value starts from 0,  then 1, then 2, then 3....
     */

    void Arrays()
    {
        /// arrays are set as such: dataType[] arrayName = new dataType[size];

        int[] arr = new int[100]; // example!!!!!

        /// you can also write an array like this

        int[] weirdArr = {1, 2, 5, 7 , 7 , 98}; // here you declare the values directly into the array

        /// indexing is done by just doing this: arrayName[position of the value]

        System.out.println("The second value of weirdArr is: " + weirdArr[3]); // should print 7!!!!!!!!!

    }

    /**
     * Traversing an array is really simple.
     * It's really just: Have a for loop with a condition of array size and have the indexing variable in the array index AKA arrayName[index]
     */

    void Traversal()
    {
        int[] arr = new int[101];

        for (int i = 0; i < arr.length ; i++) // we have array.length with just is how many values can the array holds
        {
            arr[i] = i; // arr[0] = 0 etc. goes from 0-100
            System.out.println(arr[i]);
        }

        /// for each loop refresher: you cannot index with for each loop, they are built like for(data : collection)

        int sum = 0;

        for(int num : arr)
        {
           sum += num; // sum = sum + num;
        }

        System.out.println("The sum is: " + sum);

    }

    public static void main(String[] args)
    {
        new Main();
    }

}