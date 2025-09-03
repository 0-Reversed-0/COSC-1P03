package Tester;

import Generics.*;

/**
 * This tester is for showing the basic abilities of a parameterized classes and wrapper classes
 */

public class BasicGenericTester
{

    Generics<Integer, String> box; // See how we put 'Integer' and String in the <> parameters? This is how you would set a type of object in a Generic Class.

    public BasicGenericTester()
    {
        box = new Generics<Integer, String>(); // You might wonder why I used Integer instead of 'int' and that's because the Generic classes only accept Objects.

        set(19, "M");
        get();
    }

    /**
     * This class goes over Autoboxing
     * @param a a primitive int
     * @param b a string
     */

    void set(int a, String b)
    {
        box.setA(a); // see how I was able to set Item A to a primitive int 'a' instead of the Integer? That is because of autoboxing.

        /*
         * Autoboxing (or boxing) is a simple concept of when you type cast from a primitive type to a wrapper class (Like Integer to int).
         *      Example: Integer value = 19;
         * We usually refer to it as autoboxing instead of boxing because most of the type you do not need to manually do:
         *      Integer value = new Integer(19)
         * That would be a form of boxing.
         */

        box.setB(b);
    }

    void get()
    {
        int valueA = box.getA(); // now look at how we set a primitive int to an Integer object? This would be unboxing
        System.out.println(valueA); // It is also worth noting that if we printed out an Integer object it would still print out an integer

        /*
         * Unboxing is when you take a primitive type and set it to its Wrapper class counterpart
         *      Example: double value = new Double(21.8);
         */

        String valueB = box.getB();
        System.out.println(valueB);
    }

    public static void main(String[] args)
    {
        new BasicGenericTester();
    }
}
