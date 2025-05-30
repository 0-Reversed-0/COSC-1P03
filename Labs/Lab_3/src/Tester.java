/**
 * Author: Reversed_0
 * Course: COS 1P03
 * Title: ADT Lab
 * <>
 * This test harness will only check if the method works and that's it.
 * I am not testing for edge cases since I am way too lazy to do that
 */

import text.*;

public class Tester
{

    TextArray tester; // test object
    char[] data = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'}; // test data we will use in the test harness

    public Tester()
    {
        tester = new TextArray(data);
        System.out.println("\nOriginal Text: " + tester + "\n");

        ///  Testing methods

        System.out.println("Text methods Test: \n");

        lengthTest();
        getTest();
        selectionTest();
        searchTest();
        concatTest();
        compareToTest();
        equalTest();
        commonTest();
        toStringTest();
        toCharArrayTest();
    }

    /**
     * Tests the length method
     */

    private void lengthTest()
    {
        System.out.println("Length Test: ");
        System.out.println("\tThe length of this string is: " + tester.length());
    }

    /**
     * Tests the get method
     */

    private void getTest()
    {
        System.out.println("Get Test: ");
        System.out.println("\tThe third letter is: " + tester.get(2)); // should return l
    }

    /**
     * Tests the selection method
     */

    private void selectionTest()
    {
        System.out.println("Selection Test: ");

        Text temp = tester.selection(0, 5);

        System.out.println("\t" + temp); // should return "Hello"
    }

    /**
     * Tests the search method
     */

    private void searchTest()
    {
        System.out.println("Search Test: ");

        Text temp = tester.selection(1, 5); // looking for "ello" in Hello world

        System.out.println("\tThe index where ello starts is: " + tester.search(temp)); // should return 1 if it works properly
    }

    /**
     * Tests the concat method
     */

    private void concatTest()
    {
        System.out.println("Concatenation Test: ");

        char[] t = {'!'};
        Text temp = new TextArray(t);

        System.out.println("\t" + tester.concat(temp)); // should add a silly exclamation mark to our text
    }

    /**
     * Tests compareTo method
     */

    private void compareToTest()
    {
        System.out.println("Comparison Test: ");

        char[] test1 = {'H', 'e', 'l', 'l'};     // last matching letters are the same
        char[] test2 = {'H', 'a'};               // last matching letter is greater
        char[] test3 = {'H', 'z'};               // last matching letter is less

        Text temp1 = new TextArray(test1);
        Text temp2 = new TextArray(test2);
        Text temp3 = new TextArray(test3);

        System.out.println("\tSame ending letters   |  " + tester.compareTo(temp1));    // should return  0
        System.out.println("\tGreater ending letter |  " + tester.compareTo(temp2));    // should return  1
        System.out.println("\tLesser ending letter  | " + tester.compareTo(temp3));     // should return -1
    }

    /**
     * Tests the equals method
     */

    private void equalTest()
    {
        System.out.println("Equal Test: ");

        Text temp = new TextArray(data);

        System.out.println("\tFirst Text: " + tester);
        System.out.println("\tSecond Text: " + temp);

        System.out.println("\tSay true if both texts are the same: " + tester.equals(temp)); // should return true
    }

    /**
     * Tests the common method
     */

    private void commonTest()
    {
        System.out.println("Common Test: ");

        Text temp = tester.selection(1,5);
        Text temp2 = tester.common(temp);

        System.out.println("\tThe common letters are: " + temp2);
    }

    /**
     * Tests the toString method
     */

    private void toStringTest()
    {
        System.out.println("To String Test: ");

        System.out.println("\tHi? " + tester.selection(0,5)); // should return "Hello"
    }

    /**
     * Tests toCharArray method
     */

    private void toCharArrayTest()
    {
        System.out.println("To Char Array Test: ");

        char[] a = tester.toCharArray();
        System.out.print("\t");

        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i]);
        }
    }

    public static void main(String[] args)
    {
        new Tester();
    }
}
