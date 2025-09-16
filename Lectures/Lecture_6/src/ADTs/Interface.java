package ADTs;

/**
 * Stores the object, Measurements
 * Supports trivial analysis
 */

public interface Interface
{
    /*
     * An interface is used to define a type of object without implementing it.
     * Interfaces is what is used to define an ADT.
     * An interface is basically lets us make a class without needing to add any of the code
     * We use this to implement code later even though the class does not yet exist
     * Kind of like placeholder for the class before we implement it.
     * Interfaces have to have comments on the method to actually show what they do.
     * So we can use the non-existent methods in our code then implement it to make them actually work.
     * This also lets us have multiple implementations of the same object.
     * Example: If we have an interface for a dog then we can have multiple implementations like Dog obj = new GermanShepherd(); or Dog obj2 = new Bulldog();
     */

     void add(Measurement M);

     Measurement draw();

     Measurement min();

     Measurement max();

     Measurement[] above(Measurement reference);

     Measurement[] below(Measurement reference);

     String toString();

}
