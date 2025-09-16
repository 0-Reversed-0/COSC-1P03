package ADTs;

import Exceptions.UncheckedException;

/**
 * This class stores readings in an arbitrary order
 * It implements the Pool Interface.
 * This class in specific is what we would call an ADT because it is defined by an ADT
 */

public class InterfaceImplementation implements Interface // this is how we implement an interface via using the keyword implements: public class Name implements interfaceName
{

    private Measurement[] arr;
    private int count; // iterating value

    public InterfaceImplementation(int capacity)
    {
        if(capacity > 1)
        {
            arr = new Measurement[capacity];
            count = 0;
        }
        else {
            throw new UncheckedException("There has to be more than 1 Measurements in the Pool"); // we do not want negative array capacities obviously
        }
    }

    public InterfaceImplementation()
    {
        this(100); // in case our user does not want to have a specific amount yet
    }

    public void add(Measurement M)
    {
        if (count < arr.length)
        {
            arr[count++] = M; //if a user decides to add a measurement,
            // then it will add their measurement and go to the next value in the array
        }else {
            throw new UncheckedException("Pool is Full");
        }
    }

    public Measurement draw()
    {
        throw new UnsupportedOperationException("Work in progress"); // this exception makes it so that we do not need to immediately implement the method in question until we want to.
    }

    public Measurement min()
    {
        double min = Double.MAX_VALUE; // it is literally impossible for a bird to be that big
        Measurement mini = new Measurement("Impossible Bird", min); // just a placeholder to set as the minimum value for later but just incase we have a bird that is 1.79769313486231570e+308d cm we won't set it as null

        for (int i = 0; i < arr.length; i++)
        {
            if(min > arr[i].getReading()) // if the reading of the current Measurement's reading is less than the min value then...
            {
                min = arr[i].getReading(); // then set the new minimum double as the current Measurement's reading
                mini = arr[i]; // and set new minimum Measurement as the current Minimum
            }
        }

        return mini;
    }

    public Measurement max()
    {
        double maximum = -1; // the bird wouldn't even exist man. Poor bird...
        Measurement max = null; // here we would set it as null because I would not call the void a bird in my opinion

        for (int i = 0; i < arr.length; i++)
        {
            if(maximum < arr[i].getReading()) // same logic as the minimum value just reversed
            {
                maximum = arr[i].getReading();
                max = arr[i];
            }
        }

        return max;
    }

    public Measurement[] above(Measurement reference)
    {
        throw new UnsupportedOperationException(); // We can use all exceptions as a return as well
    }

    public Measurement[] below(Measurement reference)
    {
        throw new UnsupportedOperationException();
    }
}
