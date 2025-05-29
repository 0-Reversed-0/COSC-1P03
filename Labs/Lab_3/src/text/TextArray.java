package text;

public class TextArray implements Text
{

    char[] data;

    public TextArray(char[] d)
    {
        data = d;
    }

    @Override
    public int length()
    {
        return data.length;
    }

    @Override
    public char get(int idx)
    {
        return data[idx];
    }

    @Override
    public Text selection(int start, int end)
    {
        char[] copy = new char[end - start];

        for (int i = start; i < end; i++)
        {
            copy[i] = data[i];
        }

        TextArray newText = new TextArray(copy);

        return newText;
    }

    @Override
    public int search(Text t)
    {
        int index = -1;
        int c = 0;
        char[] txt = t.toCharArray();

        for (int i = 0; i < data.length; i++)
        {
            if (txt[c] == data[i])
            {
                txt[c] = data[i];
                if (c < t.length()-1)
                {
                    c++;
                }
            } else if( c == t.length()-1)
            {
                index = i-2; // to account for 0 based
                break;
            }
        }

        return index;
    }

    @Override
    public Text concat(Text t)
    {
        char[] copy = new char[data.length + t.length()];

        for (int i = 0; i < data.length; i++)
        {
            copy[i] = data[i];
        }

        for (int i = data.length; i < copy.length; i++)
        {
            copy[i] = t.get(i- data.length);
        }

        TextArray newText = new TextArray(copy);

        return newText;
    }

    @Override
    public int compareTo(Text t)
    {
        return 0;
    }

    @Override
    public boolean equals(Text t)
    {
        return false;
    }

    @Override
    public int common(Text t)
    {
        int c = data.length + t.length();

        return c;
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
