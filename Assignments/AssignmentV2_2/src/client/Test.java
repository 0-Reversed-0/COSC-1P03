package client;

import chaotic.*;

public class Test
{
    PRNG p = new BasicPRNG();

    public Test()
    {
        for (int i = 0; i < 20; i++)
        {
            try
            {
                System.out.println(p.randomize(20));
            }
            catch(PRNGException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args)
    {
        new Test();
    }
}
