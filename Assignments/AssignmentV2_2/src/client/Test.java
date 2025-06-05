package client;

import chaotic.*;

public class Test
{
    PRNG p = new IncrementingPRNG();

    public Test()
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.println(p.randomDouble());
        }
    }

    public static void main(String[] args)
    {
        new Test();
    }
}
