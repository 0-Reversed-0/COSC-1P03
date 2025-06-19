package Map;

import java.util.Iterator;

public class TheMap<E> implements Map<E>
{

    private E[] map;
    private int count;
    private String[] keys;

    @SuppressWarnings("unchecked")
    public TheMap(int capacity)
    {
        map = (E[]) new Object[capacity];
        keys = new String[capacity];
        count = 0;
    }

    public void add(String key, E entry)
    {
        int index = 0;

        while (index < count && !keys[index].equals(key))
        {
            index++;
        }

        if (index == keys.length)
        {
            throw new OverFlowException("Map is full");
        }

        map[index] = entry;
        keys[index] = key;

        if (index == count)
        {
            count++;
        }
    }

    public E get(String key)
    {
        for (int i = 0; i < count; i++)
        {
            if (keys[i].equalsIgnoreCase(key)) // finds te matching key for each index
            {
                return map[i];
            }
        }

        throw new UnderFlowException("No value of that type.");
    }

    public void delete(String key)
    {
        int index = 0;

        while (index < count && !keys[index].equals(key))
        {
            index++;
        }

        if (index < count)
        {
            for (int i = index; i < count - 1; i++)
            {
                keys[i] = keys[i + 1];
                map[i] = map[i + 1];
            }

            count--;
            keys[count] = null;
            map[count] = null;
        }
    }

    public int count()
    {
        return count;
    }

    public String[] keys()
    {
        String[] k = new String[count]; //Safe, even for zero entries!

        for (int i = 0; i < count; i++)
        {
            k[i] = keys[i];
        }

        return k;
    }

    public Iterator<E> iterator()
    {
        return new Iterate<>(map, count);
    }
}
