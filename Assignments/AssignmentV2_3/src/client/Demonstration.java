/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */


package client;

import BasicIO.*;

import storage.*;

public class Demonstration
{

    ASCIIDataFile input = new ASCIIDataFile();
    Cabinet<String> cabinet = new The_Cabinet<>();

    public Demonstration()
    {
        System.out.println("\nFirst, To display the cabinet we are going to add to it while displaying what it is adding:\n");
        readData();
        System.out.println();

        System.out.println("Now to test if our program can read how much stuff is in the Zener Diode bin:\n");
        testQuery();
        System.out.println();

        System.out.println("This will just count how many bins are in the cabinet:\n");
        testCount();
        System.out.println();

        System.out.println("And this will show us all the labels are currently in the Cabinet:\n");
        testGetLabels();
        System.out.println("\n");

        System.out.println("While this shows us how to remove specific values from a specific bin:\n");
        testGet();
        System.out.println();

        System.out.println("Finally, This will test the removal of an entire bin's contents:\n");
        testGetBins();

        input.close();
    }

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
        }
    }

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
        }catch (DisorganizationException e)
        {
            System.out.println("\t" + e.getMessage());
        }
    }

    private void testGetLabels()
    {
        String[] arr = cabinet.getBins();

        System.out.print("\t");
        for (String s : arr)
        {
            System.out.print(s + ", ");
        }
    }

    private void testCount()
    {
        System.out.println("\tThere are " + cabinet.getCount() + " bins in the cabinet");

    }

    private void testQuery()
    {
        System.out.println("\tThere is " + cabinet.query("Zener Diode") + " items in the Zener Diode bin");
    }

    private void readData()
    {
        while (!input.isEOF())
        {
            String label = input.readString();
            System.out.println(label);
            Bin<String> bin = new The_Bin<>(label);
            cabinet.add(bin, label);
            String s = null;

            while (s != "")
            {
                s = input.readString();

                if (s == "")
                {
                    break;
                }

                try
                {
                    cabinet.add(s, label);
                    System.out.println("\t" + s);
                } catch (DisorganizationException e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new Demonstration();
    }
}
