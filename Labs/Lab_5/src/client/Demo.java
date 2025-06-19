package client;

import Map.*;

public class Demo
{

    public Demo()
    {
        Map<String> map = new TheMap<String>(10);

        for (int i = 0; i < 10; i++)
        {
            map.add(Integer.toString(i + 1), Character.toString('A' + i));
        }

        map.add("10", "Joe"); //testing an update

        for (String k : map.keys())
        {
            System.out.print("[" + k + ":" + map.get(k) + "]");
        }

        System.out.println(); //The keys()-based seems to work!

        for (String entry : map)
        {
            System.out.println("> " + entry);
        }
    }

    public static void main(String[] args)
    {
        new Demo();
    }
}
