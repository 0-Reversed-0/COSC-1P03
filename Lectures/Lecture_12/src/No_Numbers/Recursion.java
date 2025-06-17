package No_Numbers;

public class Recursion
{
    public Recursion()
    {
        Node n = genValues(1,6);

        recursiveDisplay(n);
    }

    void recursiveDisplay(Node ptr)
    {
        if (ptr == null)
        {
            return;
        }

        System.out.println(" " + ptr.item);
        recursiveDisplay(ptr);
    }

    Node genValues(int lower, int upper)
    {
        Node ptr = new Node(lower, null);

        for (int i = lower; i <= upper; i++)
        {
            ptr = ptr.next;
            ptr = new Node(i, ptr);
        }

        return ptr;
    }

    public static void main(String[] args)
    {
        new Recursion();
    }
}
