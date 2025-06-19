package Map;

import java.util.Iterator;

public class Iterate<E> implements Iterator<E>
{

    E[] array;
    int index;
    int count;

    public Iterate(E[] arr, int idx)
    {
        array = arr;
        count = arr.length - idx;
        index = arr.length-1;
    }

    public boolean hasNext()
    {
        return index >= count;
    }

    public E next()
    {
        return array[index--];
    }
}
