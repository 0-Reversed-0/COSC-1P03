/**
 * Author: Reversed_0
 * Course: COSC 1P03 (Spring Term)
 * Title: Assignment 1: Vilfredo Vanguard!
 */

///  Side Notes: Yes, I comment every line. Also, I attached another text file just for testing (feel free to use it!!!).

import BasicIO.*; // Has the ASCIIDatafile object.

public class Main
{

    private ASCIIDataFile input = new ASCIIDataFile();  // The ASCIIDataFile object was used to read the text file provided for this assignment
    private int[][] candidates;                         // This double array is to store the original candidates (readings of ratios between stops and distance)
    private int[][] vanguard;                           // This is to store the unconquered values
    private int count;                                  // To display how many valid candidates there are just for the HaHa's (as the professor would say)

    public Main()
    {
        candidates = readData();        // Step 1: Store the data from the textfile
        displayOrg(candidates);         // Step 2: Display the original candidates
        vvAlgorithm(candidates);        // Step 3: Put all candidates against each-other through a checker which will sort it into a Vilfredo Vanguard
        displayVV(vanguard);            // Step 4: Display the finished output in a more organized fashion
    }

    /**
     * This method will go through all the candidates one by one and determine if it is Vilfredo Vanguard
     *
     * @param original double array storing the candidates
     */

    private void vvAlgorithm(int[][] original)
    {
        vanguard = new int[original.length][original[0].length]; // first initialize the vanguard array

        for (int i = 0; i < original.length; i++) // the first loop will select the rows that shall be conquered (OR WILL IT???)
        {
            int[] rowA = original[i]; // the row that will be conquered
            boolean check = true; //check is how we will determine whether rowA will go into the vanguard array

            for (int j = 0; j < original.length; j++) // now we will go through the entire collection to determine if rowA is the unconquered GOD
            {
                int[] rowB = original[j]; // rowB will challenge rowA's unconquered godhood

                if (conqueror(rowA, rowB)) //if the conqueror method turns out to be true at any point then,
                {
                    check = false; //check is immediately false because well rowA is no longer an unconquered god sadly
                    break; // also will break the loop because there is no need to check for other candidates
                }
            }

            if (check) // if the check turns out to be true after all this then,
            {
                vanguard[i] = rowA; // add it to the vanguard array
                count++;            // increment the count to count how many valid candidates are there
            }
        }
    }

    /**
     * Essentially a checker that I can use to compare 2 rows. I use this to make it simpler to check for valid candidates by using one small nested loop
     *
     * @param rowA the row that is being challenged on whether it is unconquered
     * @param rowB the row that will try to conquer rowA
     * @return a boolean called "conquered" which will return false if A is the conqueror or will return true if B is the conqueror
     */

    private boolean conqueror(int[] rowA, int[] rowB) // THE GREAT CONQUEROR'S TEST!!!!
    {
        boolean conquered = false; // this boolean will be changed (or not) depending on the conditions below.

        if ((rowA[0] > rowB[0]) & (rowA[1] > rowB[1])) // if both distance AND stops of A are greater than B's then... (We need both to be true so we use the "&" operator),
        {
            conquered = true; // A, will be completely conquered in every way. THROW THE KING OFF HIS THRONE!
        } else if ((rowA[0] == rowB[0]) && (rowA[1] > rowB[1])) // if the distance of B and A are the same AND if A's stops are greater than B's then... (If the first statement isn't true, then do not continue just as a safeguard),
        {
            conquered = true; // A, will be conquered just not as harsh this time...
        } else if ((rowA[1] == rowB[1]) && (rowA[0] > rowB[0])) // if the stops of B and A are the same AND if A's distance is greater than B's then...
        {
            conquered = true; // A, will be conquered also not as harsh...
        }

        return conquered; // should return false if rowA is the unconquered king that he says he is (if rowA fails all 3 checks done by the if statements) otherwise return true.
    }

    /**
     * readData populates the candidates using any text file with the correct formatting
     *
     * @return candidates
     */

    private int[][] readData()
    {
        int col = input.readInt(); // reading the rows and columns makes it easier to read the textfile without any weird errors
        int row = input.readInt();

        int[][] populatedData = new int[row][col]; // initializing the array after reading the rows and cols for obvious reasons

        for (int i = 0; i < populatedData.length; i++)
        {
            for (int j = 0; j < populatedData[0].length; j++)
            {
                populatedData[i][j] = input.readInt(); // fills data row by row
            }
        }

        return populatedData;
    }

    /**
     * Displays the original candidates before the VV algorithm
     *
     * @param original double array storing the candidates
     */

    private void displayOrg(int[][] original)
    {
        System.out.println("The candidates for this algorithm are: ");
        for (int i = 0; i < original.length; i++)
        {
            System.out.print(" [" + original[i][0] + " | " + original[i][1] + "] "); // only 2 rows so no point in making a nested loop to display the array
        }
        System.out.println(); // formatting!!!
    }

    /**
     * Displays the Vilfredo Vanguard array
     *
     * @param VV should be an already sorted double array that have all valid candidates in  terms of Vilfredo Vanguard
     */

    private void displayVV(int[][] VV)
    {
        System.out.println("There are " + count + " Vilfredo Vanguard candidates in this data pool. \nThese are the valid candidates."); // silly message in the console

        int[][] cleanerVanguard = new int[count][VV[0].length]; // As of right now, the vvAlgorithm gives leaves the vanguard array with empty rows of 0's so to get rid of that we need use the count from earlier to set the amount of rows needed, and then we print it out
        int idx = 0; // the idx int is used to increment through the cleanerVanguard without going out of bounds

        for (int i = 0; i < VV.length; i++) // This first loop goes through the original vanguard array and checks which values are not empty and puts those value into cleanerVanguard
        {
            if (VV[i][0] != 0) // the logic here is that it is impossible to have a trip of 0 distance, hence the reading would be empty. So, if the distance of Row[index][0] (distance of current row) is 0 then its false. If the distance is not 0 then true.
            {
                cleanerVanguard[idx] = VV[i]; //the distance is not 0 so set the current row of new array to the current row that verified the check
                idx++; // increment the index to continue down the array
            }
        }

        for (int i = 0; i < cleanerVanguard.length; i++)
        {
            System.out.println("[" + cleanerVanguard[i][0] + " | " + cleanerVanguard[i][1] + "]"); //now that our array is clean (no weird empty rows) we can print it out like normal
        }

        System.out.println(); // just for formatting purposes
    }

    public static void main(String[] args)
    {
        new Main();
    }
}
