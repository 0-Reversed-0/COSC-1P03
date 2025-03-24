package String;

import java.util.Iterator;


public class StringTIterator implements Iterator<Character>
{

    private final char[] input;
    int idx;

    public StringTIterator(myStringT S)
    {
        this.input = S.ToArray();
        this.idx = 0;
    }

    @Override
    public boolean hasNext()
    {
        if (idx >= input.length)
        {
            return false;
        } else
        {
            return true;
        }
    }

    @Override
    public Character next()
    {
        return input[idx++];
    }
}
