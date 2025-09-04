package Generics.Concept;

/**
 * Generics are another word for a parametrized class.
 * Think of it like a method with its parameters.
 * But instead of normal parameters, these parameters decide the type of objects within our class.
 * This means that instead of having a class only have a static type for each instance variable it can be interchangeable.
 * For example, instead of node only holding just an int it can now hold what the user chooses to put into the node class.
 * This specific class will show how a basic generic would look like.
 */

// This is an example of a parameterized class
public class Generics <Item_A, Item_B> // All you have to do is add a <> and a label for what the type you will be using. The <Item_A, Item_B> is examples of type parameters
{
    /*
     * This class will only be a wrapper class (a class that can hold one or more primitive types and represents them as an object [Ex: Integer Class])
     */

    private Item_A a; // see here how we have an object called Item_A/B, this object can be any object that user sets within the classes parameters
    private Item_B b; // this can be a String, Scanner, etc.

    public void setA(Item_A a)
    {
        this.a = a;
    }

    public void setB(Item_B b)
    {
        this.b = b;
    }

    public Item_A getA()
    {
        return a;
    }

    public Item_B getB()
    {
        return b;
    }
}
