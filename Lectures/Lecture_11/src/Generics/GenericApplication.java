package Generics;

/**
 * If the name was not obvious than this class goes over how and why would use a generic class over a normal class
 * This class will be our basic Stack (Linked List implementation)
 * Normally we would use a Generic data structure (like a Generic Stack) because we could easily just reuse it to store any type of value we like, rather than hard coding it to one type of value
 *
 * @param <E> The type of object we would store in a Stack
 */

public interface GenericApplication<E> // I chose the letter E for a reason since there is a naming convention a lot of people use to set there type parameters

        /*
         * In Generics, you shouldn't just name the parameters for the types whatever you like.
         * Normally people choose specific letters to show why they are using a parameterized class
         *
         * T: Stands for Type. This is the most basic letter just like naming an int num. Normally used to show that there is no specific reason and just a general use of Generics
         * E: Stands for Element. This is usually used for collections. Things like linked list, stacks, queues, etc.
         * K: Stands for Key. This is something used outside COSC 1P03 so don't worry about it. But, if you curious It's used in key-value pair structures like hashmaps where the Key is the access to the value.
         * V: Stand for Value. This is the value that is accessed by the key. Key-value data structures are something you learn in COSC 2P03
         * N: Stands for Number. This is specifically for values that are expected to be of some sort of numeric value (Example: IntNode, Integer, Double, etc.)
         * S, U, V: Does not stand for anything particular (can also be T, U, V). Typically used to represent more than 1 parameterized type (That isn't K and V since they go hand in hand with mapping). Example: class ObjA<S, U, V>{}
         */

{
    /**
     * A push in a stack is essentially adding to our stack
     *
     * @param item the item that is being added to the stack
     */

    void push(E item);

    /**
     * removes an item and gives us what the item is
     *
     * @return the item
     */

    E pop();

    /**
     * shows us what item is going to be removed
     *
     * @return the item that will remove
     */

    E top();

    /**
     * Checks if the item dispenser is empty
     *
     * @return false or true
     */

    boolean isEmpty();
}
