package client;

import chaotic.*;

public class Test
{
    IncrementingPRNG p = new IncrementingPRNG();

    public Test()
    {
        for (int i = 0; i < 20; i++)
        {
            System.out.println(p.randomize(0, 30));
        }

    }

    public static void main(String[] args)
    {
        new Test();
    }
}
