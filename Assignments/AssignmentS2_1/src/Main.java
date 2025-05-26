/**
 * Author: Arhum Ahmed Khan
 * Course: COSC 1P03 (Spring Term)
 * Title: Assignment 1: Vilfredo Vanguard
 * Student ID: 8074114
 */

import BasicIO.*; // Has the ASCIIDatafile object.

public class Main
{

    private ASCIIDataFile input = new ASCIIDataFile();  // The ASCIIDataFile object was used to read the text file provided for this assignment
    private int[][] candidates;                         // This double array is to store the original candidates (readings of ratios between stops and distance)

    public Main()
    {
        candidates = readData();        // Step 1: Store the data from the textfile
        displayOrg(candidates);         // Step 2: Display the original candidates
    }

    /**
     * Essentially a checker that I can use to check all the elements in one small loop
     * @param dA distance of the first candidate
     * @param sA stops of the first candidate
     * @param dB distance of the second candidate
     * @param sB stops of the second candidate
     * @return true if A conquers B; false if B conquers A
     */

    private boolean checker(int dA, int sA, int dB, int sB)
    {
        if(dA < dB)
        {

        }

        return true; // fixme
    }

    /**
     * readData populates the candidates using any text file with the correct formatting
     * @return candidates
     */

    private int[][] readData()
    {
        int col = input.readInt();
        int row = input.readInt();

        int[][] populatedData = new int[row][col];

        for (int i = 0; i < populatedData.length; i++)
        {
            for (int j = 0; j < populatedData[0].length; j++)
            {
                populatedData[i][j] = input.readInt();
            }
        }


        return populatedData;
    }

    /**
     * Displays the original candidates before the VV algorithm
     * @param original double array storing the candidates
     */

    public void displayOrg(int[][] original)
    {
        System.out.println("The candidates for this algorithm are: ");
        for (int i = 0; i < original.length; i++)
        {
            System.out.print(" [" + original[i][0] + " | " + original[i][1] + "] ");
        }
    }

    public static void main(String[] args)
    {
        new Main();
    }
}