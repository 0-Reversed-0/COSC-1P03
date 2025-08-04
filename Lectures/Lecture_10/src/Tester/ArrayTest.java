package Tester;
import Que.*;

public class ArrayTest
{

    Queue AQueue = new ContiguousQueue(4);

    public ArrayTest()
    {
        AQueue.add("20");
        AQueue.add("Aneeba");

        System.out.println(AQueue.front());
        System.out.println(AQueue.size());
        System.out.println(AQueue.remove());
        System.out.println(AQueue.remove());
        System.out.println(AQueue.isEmpty());
    }

    public static void main(String[] args)
    {
        new ArrayTest();
    }
}
