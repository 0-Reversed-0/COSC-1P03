package L5;

/**
 * Stores Measurements
 * Supports trivial analysis
 */

public interface Pool // an interface is defining a type
{
    /**
     * Interfaces are an ADTs.
     * An interface is basically lets us make a class without needing to add any of the code
     * We use this to implement code later even though the class does not yet exist
     * Kind of like placeholder for the class before we implement it.
     * Interfaces have to have comments on the method to actually show what they do.
     * So we can use the non-existent methods in our code then implement it to make them actually work.
     */

     public void add(Measurement M);

     public Measurement draw();

     public Measurement min();

     public Measurement max();

     public Measurement[] above (Measurement reference);

     public Measurement[] below (Measurement reference);

     public String toString();

}
