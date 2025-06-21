/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */


package client;

import BasicIO.ASCIIDataFile;

import storage.*;

public class Demonstration
{

    ASCIIDataFile input = new ASCIIDataFile();
    Cabinet<String> cabinet = new The_Cabinet<>();

    public Demonstration()
    {
        readData();
        testQuery();
        testCount();
        testGetLabels();
        testGet();
        testGetBins();

        input.close();
    }

    void testGetBins()
    {
        Bin<String> bin = cabinet.getBin("Zener Diode");
        System.out.println(bin.grab());
        System.out.println(bin.grab());
        System.out.println(bin.grab());

        try
        {
            System.out.println(cabinet.get("Zener Diode"));
        }catch (DisorganizationException e)
        {
            System.out.println(e.getMessage());
        }
    }

    void testGet()
    {
        for (int i = 0; i < 5; i++)
        {
            try
            {
                System.out.println(cabinet.get("Resistor"));
            }catch (DisorganizationException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    void testGetLabels()
    {
        String[] arr = cabinet.getBins();

        for (String s : arr)
        {
            System.out.println(s);
        }
    }

    void testCount()
    {
        System.out.println(cabinet.getCount());

    }

    void testQuery()
    {
        System.out.println(cabinet.query("Zener Diode"));
    }

    void readData()
    {
        while (!input.isEOF())
        {
            String label = input.readString();
            Bin<String> bin = null;
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
