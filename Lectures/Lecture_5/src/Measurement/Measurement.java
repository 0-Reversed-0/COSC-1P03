package Measurement;

/**
 * This class represents a single numerical measurement that may include annotations
 * Each iteration will have a name, reading, and label
 */

public class Measurement // Our class will not have updaters because we want it to be immutable
{

    private double reading; // chose double due to the fact that a lot of birds have similar
    private String name; // Strings are something called an immutable type. This means they cannot be changed
    private String label;

    public Measurement(String name, double reading) //constructors are to make different instances of the same object
    {
        this(name, reading, "");
    }

    public Measurement(String name, double reading, String label)
    {
        this.name = name;
        this.reading = reading;
        this.label = label;
    }

    public String getName()
    {
        return name;
    }

    public double getReading()
    {
        return reading;
    }

    public String getLabel()
    {
        return label==null?"":label; // this line works as (expression T/F) ? (if true then return this) : (if false return this)
                                     // to explain if label is a null value then return "" which is nothing but if label is not null then return the label.
    }

    public String toString()
    {
        return "["+name+", "+reading+", "+label+"}";
    }

}
