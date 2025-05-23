import L5.*;

public class Main
{

    UnorderedPool Pool = new UnorderedPool(5);

    public Main()
    {
        arrayObj();
        tryCatch();
    }

    void tryCatch()
    {
        try //try catch is basically where you have a block of code you want to see if it works
        {

            UnorderedPool p = null;
            p.add(new Measurement("bluejay", 12.5)); //obviously not working code
        }
        catch (Exception e) // here it catches any exception that it comes by
        {
            System.out.println("why dude"); // gives us a message instead of crashing out code
        }
    }

    void arrayObj()
    {
        Measurement[] measurements = new Measurement[5];
        Pool.add(new Measurement("Robin", 13.8));
        Pool.add(new Measurement("Jay", 18.1));
    }

    public static void main(String[] args)
    {
        new Main();
    }
}