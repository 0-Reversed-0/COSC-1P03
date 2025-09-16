/**
 * This lecture goes over Classes and introduces the problem with storing values
 */

public class Main
{

    public Main() // a constructor contracts an instance of the class
    {
        someMethod(); // notice how IntelliJ stops complaining after we put our methods in the constructor instead
        theProblem();
    }

    private void theProblem()
    {
        /*
         * Let's say we want to find the mean of several variables. We would have to:
         * 1) Store the variables in an int data type
         * 2) Sum every variable
         * 3) Find out how many variables are included in the mean
         * 4) Divide the sum by the amount of variables
         * Example:
         */

        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;

        double mean = (a+b+c+d+e)/5.0; // mean = sum/n. (n = count of all variables)
        System.out.println(mean);

        /*
         * See the problem?
         * Let's say we want to calculate the mean of 100 variables
         * We would have to individually put every variable in their own int
         * Then we would have to count how many variables are in problem.
         * The point is that it is horribly tedious to store variables.
         * So how do we fix it? (It is covered in the next lecture, so I'll pretend to not know)
         */
    }

    void someMethod() // the only way to not attach static is to put the method in a Constructor
    {
        /*
         * The keyword "static" defines a method, instance variable, etc. as a class level instead of an object level
         * Static methods (Class Level) and variables share will all share the same memory
         * Non-static (Object level) methods and variables will instead get their own memory per instance(object) created
         * To make a method object level we would want to put it in our constructor instead of the main method because we want the object to have it own special memory slot when initialized
         * If we decide to not use the constructor and instead use the main method then we would have to make everything class level which would mean that every variable and method would share memory
         * It is good practice to use non-static as your default way of coding methods, instance variables, etc.
         */

        int a = 5; // the variable 'a' would have its own memory slot every time we call for the class Main. We would want to do this if we plan on having multiple instances of Main which all do different things

        /*
         * We would use Non-static if:
         * A) We want to have multiple instances of Main
         * B) We want each instance of main to be special
         * C) You want Override Methods
         * D) We would want each instance of Main to have different data
         */

        System.out.println(a);
    }

    static void anotherMethod()
    {
        int b = 4; // Here the variable 'b' would only have one memory slot regardless of how many instances of Main is there.

        /*
         * We would Static if:
         * A) We only have one class and nothing else
         * B) We only use an instance of this class once
         * C) We want to have shared variables, settings, methods, etc.
         * D) Constant variables
         */

        System.out.println(b); // There are more reasons to have static/non-static methods but the ones listed out are the most prominent.
    }

    public static void main(String[] args)
    {
        anotherMethod(); // since our method is static we would not put it in constructor since we have only one instance of this method regardless
        new Main(); // creates a new instance of Main
    }
}