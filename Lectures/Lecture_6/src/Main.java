import L5.*;

public class Main
{

    UnorderedPool Pool = new UnorderedPool(5);

    public Main()
    {
        arrayObj();
    }

    void arrayObj()
    {
        Measurement[] measurements = new Measurement[5];
        Pool.add(new Measurement("Robin", 13.8));
        Pool.add(new Measurement("Jay", 18.1)); // See how we can use the method without even needing to implement the "Pool" class
    }

    public static void main(String[] args)
    {
        new Main();
    }
}