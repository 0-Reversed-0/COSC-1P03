/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */


package client;

import BasicIO.*;

import storage.*;

/**
 * The Demonstration class proves that each method in the "Cabinet" objects works as intended
 * Make sure when using this program that you first read the documentation for each method, otherwise running it will not make sense.
 * This class is a very bare-bones test harness
 */

public class Demonstration
{

    ASCIIDataFile input = new ASCIIDataFile();
    Cabinet<String> cabinet = new The_Cabinet<>();

    public Demonstration()
    {
        System.out.println("\nFirst, To display the cabinet we are going to add to it while displaying what it is adding:\n");
        readData();
        System.out.println();

        System.out.println("Now to test if our program can read how much stuff is in each bin:\n");
        testQuery();
        System.out.println();

        System.out.println("This will just count how many bins are in the cabinet:\n");
        testCount();
        System.out.println();

        System.out.println("And this will show us all the labels are currently in the Cabinet:\n");
        testGetLabels();
        System.out.println();

        System.out.println("While this shows us how to remove specific values from a specific bin:\n");
        testGet();
        System.out.println();

        System.out.println("Finally, This will test the removal of an entire bin's contents:\n");
        testGetBins();

        input.close();
    }

    /**
     * The get bin test method tests...
     * - the get bin method via setting it to a new bin
     * - if the exception is thrown if we attempt to access the emptied out bin
     * - and finally does a query to prove for certain that the bin has been emptied out but not removed
     *
     * @throws DisorganizationException if the desired bin empties out as it's supposed to and was accessed when emptied
     */

    private void testGetBins()
    {
        System.out.println("Created new instance of Zener Diode and removing the instance within the cabinet...");
        Bin<String> bin = cabinet.getBin("Zener Diode");
        System.out.println("\tAccessing new bin element... " + bin.grab());
        System.out.println("\tAccessing new bin element... " + bin.grab());
        System.out.println("\tAccessing new bin element... " + bin.grab());

        try
        {
            System.out.println(cabinet.get("Zener Diode"));
        } catch (DisorganizationException e)
        {
            System.out.println("\tAttempting to access old bin... " + e.getMessage());
            System.out.println("\tThere is " + cabinet.query("Zener Diode") + " items in the bin");
        }
    }

    /**
     * The get test method tests...
     * - if the get method returns the element 'E' (i.e. String in this case)
     * - if the get method throws an exception if a bin empty
     *
     * @throws DisorganizationException if user to attempts to access the bin more than how many items are in that bin (meaning it worked successfully)
     */

    private void testGet()
    {
        for (int i = 0; i < 6; i++)
        {
            try
            {
                System.out.println("\tRemoving from Resistor bin... " + cabinet.get("Resistor"));
            } catch (DisorganizationException e)
            {
                System.out.println("\tAttempting to access value from Resistor Bin... " + e.getMessage());
            }
        }

        System.out.println("\tAttempting to also access non-existent bin label, Pywikibot... ");
        try
        {
            String s = cabinet.get("Pywikibot");
            System.out.println(s);
        } catch (DisorganizationException e)
        {
            System.out.println("\t" + e.getMessage());
        }
    }

    /**
     * The get labels test method only if we can get every label in the cabinet...
     */

    private void testGetLabels()
    {
        String[] arr = cabinet.getBins();

        for (String s : arr)
        {
            System.out.println("\t" + s);
        }
    }

    /**
     * Literally only tests if it can identify how many bins are in the cabinet
     */

    private void testCount()
    {
        System.out.println("\tThere are " + cabinet.getCount() + " bins in the cabinet");

    }

    /**
     * Shows every labelled bin's quantity
     */

    private void testQuery()
    {
        System.out.println("\tThere is " + cabinet.query("Buck") + " items in the Buck bin");
        System.out.println("\tThere is " + cabinet.query("Linear") + " items in the Linear bin");
        System.out.println("\tThere is " + cabinet.query("Resistor") + " items in the Resistor bin");
        System.out.println("\tThere is " + cabinet.query("Step-up") + " items in the Step-up bin");
        System.out.println("\tThere is " + cabinet.query("Zener Diode") + " items in the Zener Diode bin");
    }

    /**
     * The read data method tests...
     * - both instances of the add method
     * - if the bins are being added with the correct labels
     * - if each bin itself adds all the contents correctly
     */

    private void readData()
    {
        while (!input.isEOF()) // keep going until we reach the end of the file i.e. all the bins are added and populated
        {
            String label = input.readString(); // We can make an assumption that the first line is a label
            System.out.println(label);
            Bin<String> bin = new The_Bin<>(label); // then we make new bin with that label
            cabinet.add(bin, label); // then we add that bin to cabinet
            String s = null; // we use this string to ensure that ASCIIDataFile does not read new lines (which is why we do not set it to "")

            while (s != "") // continue until new line is hit (note that we do not use .equals()/.isEmpty() since null is not compatible with those methods)
            {
                s = input.readString(); // first read the line

                if (s.isEmpty()) // then WE HAVE TO MAKE SURE it is not a new line before we add it to the bin
                { // I found .isEmpty() from: https://www.w3schools.com/java/ref_string_isempty.asp
                    break; // due to orders of operations java will first read the new line, add it to bin, then break, so we have to manually break the while loop.
                }

                cabinet.add(s, label); // if all goes well then we can add it to the bin
                System.out.println("\t - " + s);
            }
        }
    }

    public static void main(String[] args)
    {
        new Demonstration();
    }
}
