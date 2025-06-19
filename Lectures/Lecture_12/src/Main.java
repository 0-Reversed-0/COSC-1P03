/**
 * Recursion is a function that calls itself until it does not need to.
 */

public class Main
{
    public Main()
    {
        int a = factorial(19);
        System.out.println(a);
    }

    int factorial(int n)
    {
        if (n < 1) // this is our base case meaning it will stop here
        {
            return 1; // stops the recursion here since we would return one and not call the function upon itself
        }

        return n * factorial(n - 1); // this would be the guaranteed progress to the 1 since n has to decrement
    }

    public static void main(String[] args)
    {
        new Main();
    }
}