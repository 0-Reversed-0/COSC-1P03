/**
 * Author: Reversed_0
 * Course: COSC 1P03
 * Title: Complexity Lab
 */

public class Main
{
    public Main()
    {
        report(constant(1), 1);
        report(constant(10), 10);

        /**
         * When we run this we can say that no matter how many times you increase 'n' or the problem size the cost (how many times you run a block of code) of the problem will always be 3.
         * Thus, we can conclude that the time complexity is O(1) since the time remains constant
         */

        report(divisible(1), 1);
        report(divisible(10000), 10000);

        /**
         * When you run it the first time it only runs once with a cost of 1
         * As you increase the problem size the cost increases with it, so O(n).
         */

        report(cross(1), 1);
        report(cross(2), 2);
        report(cross(1000), 1000);

        /**
         * We can see that everytime we increase the problem size of n we get n^2 as the cost of the problem this is because we are running every element n times
         * Thus, the time complexity is O(n).
         */

        report(easierThanItLooks(1), 1);
        report(easierThanItLooks(2), 2);
        report(easierThanItLooks(10), 10);

        /**
         * We see that everytime in the worst case scenario that first - we have a runtime of N and in the code block basically in the worst case that we would have log n and since we run it in the loop:
         * Thus, the time complexity is O( n(log[n]) )
         */

    }

    /**
     * The method report is just to show us the cost versus the problem size (N)
     */

    private void report(int cost, int N)
    {
        System.out.println("Steps of N=" + N + ": " + cost);
    }

    /**
     * Here we try to represent constant time.
     */

    private int constant(int N)
    {
        int step = 0;
        step++; //Our 'significant step' always happens 3 times!
        step++;
        step++;
        return step;
    }

    /**
     * This problem is where we are figuring out if a number is odd
     */

    private int divisible(int N)
    {
        int odds = 0, step = 0; // this line here just is declaring to variables of the same type in one line. Translating it would be int odds = 0; int step = 0;
        for (int i = 0; i < N; i++)
        {
            odds += step++ % 2;
        }
        return step;
    }

    /**
     * Basically whatever the program is running is negligible when the step count increases separately, but to explain this method adds the even numbers multiply by both sets and adds it all up.
     */

    private int cross(int N)
    {
        int matches = 0, step = 0;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                step++;
                matches += i % 2 * j % 2;
            }
        }
        return step;
    }

    /**
     * It really just puts an outlandish condition that almost never would work in practice and if that condition isnt met then it will increase the step count by (n/2)
     */

    private int easierThanItLooks( int N ) {
        int step = 0;
        for ( int i = N; i > 0; i-- ) { // 5
            if ( i%13 <= 5 && i%2==i%4 ) { //4
                step++; // 1
            }
            else {
                for ( int j = N; j > 0; j=j/2 ) // this is the REVERSE of an exponential so your going down by half each loop
                    step++; // 2
            }
        }
        return step;
    }

    public static void main(String[] args)
    {
        new Main();
    }

}