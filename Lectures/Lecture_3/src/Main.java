/**
 * This lecture goes further into how things like 2D arrays and ragged arrays work.
 */

public class Main
{

    public Main()
    {
        Array();
        raggedArrays();
    }

    void Array()
    {
        // ArrayIndexOutOfBoundsException is when the index inputted by user is not within the bounds of the array. I.E. int[] arr = new int[10]; arr[200];

        // Double Arrays / 2D Arrays are basically an Array of an Array formed by having 2 [] rather than 1.

        int[][] arr = new int[2][2]; // a 2x2 matrix/array example

        // 2D arrays elements can be accessed via arrayName[row][col];

        int [][] array = generate(2,3);
        showMatrix(array);
    }

    /**
     * Example of filling out array
     */

    int[][] generate(int height, int width)
    {
        int [][] arr = new int[height][width];

        int count = 1;

        for (int row = 0; row < arr.length; row++) // don't use height and width as the bounds for the loop instead use arr.length
        {
            for (int col = 0; col < arr[0].length; col++) // arr[0].length is the length of specifically the first arrays length
            {
                arr[row][col] = count++;
            }
        } // row major traversal

        return arr;
    }

    /**
     * Example of showing an array using for each loops
     * Also an example of traversal
     */

    void showMatrix(int[][] arr)
    {
        for(int[] row : arr) // take the row of the collection: arr
        { // just don't do this it's so stupid
            for(int col : row) // take the number of row[col]
            {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /**
     * Ragged arrays are arrays that do not have a static size of each row. One row could have 5 elements the next could have 3
     * These arrays will still have a static amount of rows (20 rows of unspecified length)
     * they are declare as: int[][] arrayName = new int[row][] // COLUMN SHOULD NOT HAVE ANYTHING
     */

    void raggedArrays()
    {
        // Generating ragged array

        int[][] arr = new int[20][]; //the column is not included

        for (int i = 0; i < arr.length; i++) // goes through all 20 rows
        {
            int col = (int)(20*Math.random()+1); // we define columns as a random number between 1-20 so one row could have 1 element or 20
            int[] row = new int[col]; // we make a new row unrelated to our arr array to fill in our first row. The col defines how big this row is

            for (int j = 0; j < row.length; j++) // since we want to fill in row[] we obviously do row[].length
            {
                row[j] = (int)(20*Math.random()+1); // just defining it as something arbitrary does not matter
            }
            arr[i] = row;
        }

        // Traversal of ragged array

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++) //we would want the specific length of each row since it's not a matrix
            {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}