package text;

public class TextArray implements Text
{

    private char[] data; // First our object should have a char array to make an actual string substitute

    public TextArray(char[] d)
    {
        data = d; // set our char array to the char array that a user makes which essentially is making a string char by char
    }

    @Override
    public int length()
    {
        return data.length;
    }

    @Override
    public char get(int idx)
    {
        char a;

        if (idx < data.length) // we do not want invalid indexes crashing our program
        {
            a = data[idx];
        } else
        {
            a = ' '; // if it is an invalid index is made for some silly reason then we just hit the user with an empty space
        }

        return a;
    }

    @Override
    public Text selection(int start, int end)
    {
        TextArray newText;

        if (start < data.length & end < data.length) // same thing with our .get method; we want it to be in bounds of our char array
        {
            char[] copy = new char[end - start];

            for (int i = start; i < end; i++)
            {
                copy[i] = data[i];
            }

            newText = new TextArray(copy);
        } else
        {
            newText = new TextArray(data);
        }

        return newText; // rest is just copying an array to select our specific part of our array
    }

    @Override
    public int search(Text t)
    {
        int index = -1; // the index of the first character of the correct search (I tried with the wording I swear)
        int c = 0; // indexing element from second text
        char[] txt = t.toCharArray();

        for (int i = 0; i < data.length; i++)
        {
            if (txt[c] == data[i]) // check if the letters match up
            {
                txt[c] = data[i]; // add the letter

                if (c < t.length() - 1) // We don't want our index to go out of bounds when we increment c so if c is less than the length of the array - 1 only then we can increment c
                {
                    c++;
                } else //if we cant increment it then obviously we are at the end of the search query array
                {
                    index = i - (t.length() - 1); // record which index the array had the search query via subtracting the current index by the length of the array
                    break; // break the loop so we don't run into stupid errors
                }

            } else // if the search query does not match at any point then reset the indexing element for the second text
            {
                c = 0;
            }
        }

        return index; // should return -1 if the search query fails otherwise it should return the index we are looking for
    }

    @Override
    public Text concat(Text t)
    {
        char[] copy = new char[data.length + t.length()]; //first we want the array to be the size of both the texts objects

        for (int i = 0; i < data.length; i++) // loop 1 should just copy our data array into the copy array
        {
            copy[i] = data[i];
        }

        for (int i = data.length; i < copy.length; i++) // loop 2 is a little more effort where we start from where we left off in copying data to end of the copy array itself
        {
            copy[i] = t.get(i - data.length); //since we want it index to be at 0 rather than it probably going out of bounds for copying the second array into the copy array
        }

        return new TextArray(copy);
    }

    @Override
    public int compareTo(Text t)
    {
        int result = 1; // we return result as either 1, 0, or -1 depending on the alphabetical order of the last letters of each texts

        for (int i = 0; i < data.length; i++) // this loop should check when the arrays letters stop matching
        {
            if (data[i] == t.get(i))
            {
                result = 0; // if the text consistently match letters then it result should stay 0

                if (t.get(i) == t.get(t.length() - 1)) // if we are the end of the second text then we would just leave it at 0 since it would the last character is the same
                {
                    break;
                }

            } else // if at any point the arrays characters  do not match up then we would start a comparison on which one is higher on the ascii table
            {
                int index = i; // we use this to record where specifically the letters stop matching

                if (data[index] > t.get(index)) // if our text has the last letter higher on the list then we would return 1
                {
                    result = 1;
                } else if (data[index] < t.get(index)) // if the other text has its last letter be higher we would want to return -1
                {
                    result = -1;
                }

                break; // no need to continue to loop at this point
            }
        }

        return result;
    }

    @Override
    public boolean equals(Text t) // It is better to have methods independent of each-other which why I don't just use compareTo here
    {
        boolean checker = false;

        if (data.length == t.length()) // first of all if their lengths don't even match up then don't bother running all this code
        {
            for (int i = 0; i < data.length; i++)
            {
                if (data[i] == t.get(i)) //goes through ever value of array, checking if it's equivalent Texts
                {
                    checker = true;
                } else
                { //if AT ANY POINT the first statement is not true then break this loop entirely
                    checker = false;
                    break;
                }
            }
        }

        return checker;
    }

    @Override
    public Text common(Text t) // now to totally go back on what I said previously and make a very in class method dependent function
    {
        TextArray newText = new TextArray(data); // need this for search query

        int start = newText.search(t); // easiest way to find the starting point is to use our search method (im not coding this shit again)
        int end = t.length(); // ending would always the query's length

        Text newer = newText.selection(start, end); // our handy dandy selection method comes into play here

        return newer;
    }

    @Override
    public char[] toCharArray()
    {
        return data;
    }

    @Override
    public String toString()
    {
        String s = "";

        for (int i = 0; i < data.length; i++)
        {
            s = s + data[i];
        }

        return s;
    }
}
