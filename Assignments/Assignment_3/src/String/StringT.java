package String;

public interface StringT
{

    //Concatenates 2 strings, this.ConCat(S)

    public StringT ConCat(StringT s);

    //Returns a string from index 0 to i inclusive.

    public StringT Before(int idx);

    //Returns a string from i to end.

    public StringT After(int idx);

    //Returns the length of this.

    public int Length();

    //Creates a deep clone of this.

    public StringT Clone();

    //Returns the character at index i of this;

    public char CharAt(int idx);

    //Returns a character array representation of this.

    public char[] ToArray();

    //Returns a String.StringT composed of the characters between
    // i inclusive and j not inclusive

    public StringT SubString(int i, int j);

    //Complete the below 2 functions, which are to
    //implement some non-trivial behaviour
    //Look at the supplied link to String to get some ideas
    //It is left to you.


    // returns the amount of letters in the char array

    public int CountLetters();

    //returns the reverse of the string

    public StringT Reverse();

    //prints the string out

    public void Print();

}
