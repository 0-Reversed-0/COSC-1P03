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

    private int divisible( int N )
    {
        int odds = 0, step = 0;
        for (int i = 0; i < N; i++)
        {
            odds += step++ % 2;
        }
        return step;
    }

    public static void main(String[] args)
    {
        new Main();
    }

}