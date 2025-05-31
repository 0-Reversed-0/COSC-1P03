/**
 * This lecture introduces the problem we need to solve using ADTs without going into ADTs yet
 */

import Measurement.Measurement; //This is the whole reason we separate things into packages so we can import them into things like testers.

public class Main
{

    public Main()
    {
        arrayObj();
    }

    /**
     * This method shows how we can create an array with an object as its data type
     */

    void arrayObj()
    {
        Measurement[] measurements = new Measurement[5];
        measurements[0] = new Measurement("Robin", 13.8);
        measurements[1] = new Measurement("Blue", 14.8, "B");
        measurements[2] = new Measurement("Blue Jay", 13.2, "J");
        measurements[3] = new Measurement("Big", 22.3, "B1");
        measurements[4] = new Measurement("Bird", 7.0);

        /// Let's say we want to access the 3rd arrays reading then we could use the .get method from the object and call the index of object we want to access

        System.out.println("The size of the bird, " + measurements[2].getName() + ", is: " + measurements[2].getReading() + "cm"); // it's very easy to access the variables of array of objects
    }

    public static void main(String[] args)
    {
        new Main();
    }
}