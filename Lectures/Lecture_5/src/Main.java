import Measurement.Measurement; //This is the whole reason we separate things into packages so we can import them into things like testers.

public class Main
{

    public Main()
    {
        arrayObj();
    }

    /**0
     * how to make an Array of Objects
     * you need to put the class in a package to import it to your tester.
     */

    void arrayObj()
    {
        Measurement[] measurements = new Measurement[5];
        measurements[0] = new Measurement("Robin", 13.8);
        measurements[1] = new Measurement("Blue", 14.8, "B");
        measurements[2] = new Measurement("Jay", 13.2);
        measurements[3] = new Measurement("Big", 22.3, "B1");
        measurements[4] = new Measurement("Bird", 7.0);
    }

    public static void main(String[] args)
    {
        new Main();
    }
}