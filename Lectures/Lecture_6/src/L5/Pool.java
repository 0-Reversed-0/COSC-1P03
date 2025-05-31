package L5;

/**
 * Stores Measurements
 * Supports trivial analysis
 */

public interface Pool // an interface is defining a type
{
    /*
     * Interfaces is what is used to define an ADT.
     * An interface is basically lets us make a class without needing to add any of the code
     * We use this to implement code later even though the class does not yet exist
     * Kind of like placeholder for the class before we implement it.
     * Interfaces have to have comments on the method to actually show what they do.
     * So we can use the non-existent methods in our code then implement it to make them actually work.
     */

     void add(Measurement M);

     Measurement draw();

     Measurement min();

     Measurement max();

     Measurement[] above(Measurement reference);

     Measurement[] below(Measurement reference);

     String toString();

}
