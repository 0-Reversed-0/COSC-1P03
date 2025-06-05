package Test;

import String.Text;

public class Tester
{
    Text t = new Text();

    public Tester()
    {
        testPrepend();
        testToString();
        versus();
        testCount();
    }

    void versus()
    {
        testAppend(10000);
        testNormalConcat(10000);
    }

    void testAppend(int upperbound)
    {
        long start = System.currentTimeMillis();

        for (int i = 2; i <= upperbound; i++)
        {
            String s = Integer.toString(i);
            t.append(s + "\n");
        }

        long stop = System.currentTimeMillis();

        System.out.println("The time it took to do this operation was: " + (stop - start) + "ms");
    }

    void testNormalConcat(int upperbound)
    {
        long start = System.currentTimeMillis();

        String s = "";

        for (int i = 0; i < upperbound; i++)
        {
            s = s + i;
        }

        long stop = System.currentTimeMillis();
        System.out.println("The time it took to do this operation was: " + (stop - start) + "ms");
    }

    void testPrepend()
    {
        t.prepend("1 "); // constant time
        t.prepend("0 ");
    }

    void testCount()
    {
        System.out.println("\nThe amount of strings stitched in the text is: " + t.getLength());
    }

    void testToString()
    {
        //System.out.println(t.toString());
    }

    public static void main(String[] args)
    {
        new Tester();
    }
}
