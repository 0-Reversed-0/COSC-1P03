package String;

import java.util.Iterator;

/**
 * Author: Arhum Ahmed Khan.
 * Student ID: 8074114.
 * Course: COSC 1P03.
 * Title: DIY String Object.
 */

public final class myStringT implements StringT, Iterable<Character> //implements the String.StringT Interface into String.myStringT
{

    private final char[] stringGiven; // this is the placeholder for the user inputted char array which we call the "String"

    private int stringLength; // I found out that I used stringGiven.length so much so I cut myself some slack and just made it an instance variable

    private static char[] c = {};

    /*
    The order I implemented the code goes as follows: ( I did easiest to hardest since it helped me :> )

    1. Constructor obviously
    2. Length Method
    3. ToArray Method
    4. CountLetter Method
    5. Reverse Method
    6. CharAt Method
    7. Clone Method
    8. After/Before Method
    9. ConCat Method
    10.SubString Method

    After implementation of the interface I went on to implement the Test Harness

    After all of that I finally do the Iterator class

    Then I was happy to finish this assignment YIPPEE :)
     */

    /**
     * The first constructor is used to set the very important stringGiven char array to users input char array
     */

    public myStringT(char[] input)
    {
        if (input == null)
        { //obviously if the char array given has nothing in it then it's not a String its just null
            throw new StringTException("Invalid Input"); // if empty give this message
        }

        stringGiven = new char[input.length]; // if it's not then we set the given char array to our stringGiven char array

        for (int i = 0; i < input.length; i++)
        { // manual array copy so that we can set stringGiven
            stringGiven[i] = input[i];
        }

        stringLength = stringGiven.length;
    }

    /**
     * This second constructor is just if the user is dumb and does not want to put any char array whatsoever
     */

    public myStringT()
    {
        this(c); // if nothing is passed through then make stringGiven empty
    } //Note: this part of the contractor Professor Bockus did for me. I have no clue why he did this but

    /**
     * ConCat Method is used to combine 2 char arrays or "Strings" together and make one combined larger string.
     */

    @Override
    public StringT ConCat(StringT s) // String.StringT s is the second string that we want to add to our original string
    {
        char[] secondString = s.ToArray(); // we use our s.ToArray to make the object return a copy of our string

        int stringLength2 = secondString.length;

        int combinedLength = stringLength + stringLength2; // the total length of the entire string

        char[] ConCat = new char[combinedLength]; // make a new char array that will have to be the product the combined the 2 strings

        for (int i = 0; i < stringLength; i++) // start from 0 to the end of the original string
        {
            ConCat[i] = stringGiven[i];
        }

        for (int i = 0; i < combinedLength - stringLength; i++) //starts at 0 to the resultant of the combined length minus the secondString
        {
            ConCat[stringLength + i] = secondString[i]; //ConCat however starts at where ever the first string left off
        }

        return new myStringT(ConCat); //clone object
    }

    /**
     * The Before Method is the same as the After method but in reverse. Instead of going from index given to final position it instead goes from 0 to index given
     */

    @Override
    public StringT Before(int idx)
    {
        if (idx >= stringLength || idx < 0) // reusing the same if statement used in toChar and After!!!
        {
            throw new StringTException("Index is out of bounds!!!!");
        }

        char[] copy = new char[idx + 1]; // made the array length idx+1 because it only has idx amount of elements regardless and the plus 1 because it includes idx position too

        for (int i = 0; i <= idx; i++)
        {
            copy[i] = stringGiven[i];
        }

        return new myStringT(copy); // clones object again
    }

    /**
     * This method gives every value starting from the index given (for example start at the 4th place or 3rd index) all the way to the end of stringGiven or the last index
     */

    @Override
    public StringT After(int idx)
    {
        if (idx >= stringLength || idx < 0) // reusing the same if statement used in toChar!!!
        {
            throw new StringTException("Index is out of bounds!!!!");
        }

        char[] copy = new char[stringLength - idx];

        for (int j = idx; j < stringLength; j++) // goes from index user inputs to the end of the char array
        { //manual array copy
            copy[j - idx] = stringGiven[j]; // the copy index starts at the end point of the stringGiven, so I fixed that via making it start at 'j' - index starting at 0 going to the end
        }

        return new myStringT(copy); // clones the object
    }

    /**
     * Essentially a getter method for the stringLength
     */

    @Override
    public int Length()
    {
        return stringLength; // returns the length of the char array
    }

    /**
     * The clone method is different from the ToArray in the form that it makes it so that we have a whole new instance/object of the string rather than just a copy of the Array
     * This is useful for testing because it lets us experiment with clones of the array rather than using the original for everything :)
     */

    @Override
    public StringT Clone()
    {
        char[] copy = new char[stringLength];

        for (int i = 0; i < stringLength; i++)
        { // manual array copy I have explained this 100 times, so I do not think I need to repeat myself
            copy[i] = stringGiven[i];
        }

        return new myStringT(copy); //instead returning the copy I instead give a whole new object to mess around with. This clones the object completely rather than just getting a copy of the array like ToArray did
    }

    /**
     * This method is just to give u the letter at the position specified
     * For example: string is "food" and I put System.out.print(String.myStringT.CharAt(3)); in my code then I would get the char 'd'
     */

    @Override
    public char CharAt(int idx)
    {
        if (idx >= stringLength || idx < 0)
        { // if the index given is greater than/equal to the string length then it would be out of bounds since index is 0 based OR if the index is in the negatives then obviously it would be out of bounds
            throw new StringTException("Index is out of bounds!!!!"); // gives us our exception if at least 1 of the 2 conditions are true
        }

        return stringGiven[idx]; // if it falls in place of the index boundaries then just return was letter it is, and we are all happy YIPPEE!!!
    }

    /**
     * This method is to make a copy of the stringGiven char array to make sure that this class "immutable" or to keep stringGiven final
     */

    @Override
    public char[] ToArray()
    {
        char[] copy = new char[stringLength]; // first the copy of course!!!

        for (int i = 0; i < stringLength; i++)
        { // manual array, copy takes every index of the original and then sets the copy to equal the same as the original value at the same index
            copy[i] = stringGiven[i];
        }

        return copy; // returns a copy of our lovely stringGiven
    }

    /**
     * The method SubString is used to make a new string object where it starts from point A of the char array to point B of the char array
     */

    @Override
    public StringT SubString(int i, int j)
    {
        if (j < 0 || i < 0 || j > stringLength || i >= j)
        { // this if statement checks the boundaries of the index so no negative numbers, no number greater than stringLength and most importantly i CANNOT be greater than j
            throw new StringTException("Oh no! Index out of bounds :(");
        }

        char[] SubString = new char[j - i]; // the array size is determined by j and i

        for (int k = i; k < j; k++)
        { // go from i to j
            SubString[k-i] = stringGiven[k];
        }

        return new myStringT(SubString); // return the resultant!!!!
    }

    /**
     * This method counts ever LETTER in the char array that is NOT AN EMPTY SPACE because I wanted it to be a bit more complex than just counting everything
     */

    @Override
    public int CountLetters()
    {
        int counter = 0;

        for (int i = 0; i < stringLength; i++)
        {
            if (stringGiven[i] != ' ')
            {
                counter++;
            }
        }

        return counter;
    }

    /**
     * This method just reverses any char array or "String" you give it
     */

    @Override
    public StringT Reverse()
    {
        char[] reversed = new char[stringLength]; // made a new char array because it would be stupid to try to change the original stringGiven array

        for (int i = 0; i < stringLength; i++)
        {
            reversed[i] = stringGiven[stringLength - i - 1]; // goes from the last char of the array then backwards from there
        }

        return new myStringT(reversed); // just to return the reversed array
    }

    /**
     * The print method obviously prints the char one by one
     */

    @Override
    public void Print()
    {
        for (int i = 0; i < stringLength; i++)
        {
            System.out.print(stringGiven[i]); // pretty straight forward :)
        }
    }

    @Override
    public Iterator<Character> iterator()
    {
        return new StringTIterator(this);
    }
}