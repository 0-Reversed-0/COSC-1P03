package client;

import chaotic.*;

public class Test
{
    PRNG p = new IncrementingPRNG();

    public Test()
    {
        for (int i = 0; i < 20; i++)
        {
            try
            {
                System.out.println(p.randomize(15, 5));
            }
            catch (PRNGException e)
            {
                System.out.println("didn't work out");
            }
        }
    }

    public static void main(String[] args)
    {
        new Test();
    }
}
