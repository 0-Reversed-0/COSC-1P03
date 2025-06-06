package Test;

import String.Text;

public class Tester
{
    Text t = new Text();

    public Tester()
    {
        // Tests text's method

        testAppend(20);
        testPrepend();
        testToString();
        testCount();

        // Big O complexity comparison

        versus(1000);
    }

    void versus(int n)
    {
        long start = System.currentTimeMillis();
        testAppend(n);
        long stop = System.currentTimeMillis();

        System.out.println(stop - start + "ms");

        long start2 = System.currentTimeMillis();
        testNormalConcat(n);
        long stop2 = System.currentTimeMillis();

        System.out.println(stop2 - start2 + "ms");
    }

    void testAppend(int upperbound)
    {
        System.out.println();
        for (int i = 2; i <= upperbound; i++)
        {
            String s = Integer.toString(i);
            t.append(s + "\n");
        }
    }

    void testNormalConcat(int upperbound)
    {
        String s = "";

        for (int i = 0; i < upperbound; i++)
        {
            s = s + i;
        }
    }

    void testPrepend()
    {
        t.prepend("1 \n"); // constant time
        t.prepend("0 \n");
    }

    void testCount()
    {
        System.out.println("\nThe amount of strings stitched in the text is: " + t.getLength());
    }

    void testToString()
    {
        System.out.println(t.toString());
    }

    public static void main(String[] args)
    {
        new Tester();
    }
}
