package String;

public class Text
{

    Node head;
    int count = 0;

    public Text()
    {
        head = null;
    }

    public Text(String initial)
    {
        head = null;
        append(initial);
    }

    public void append(String s)
    {
        if (head != null)
        {
            Node p = head;

            while (p.next != null)
            {
                p = p.next;
            }

            p.next = new Node(s, null);
        } else
        {
            head = new Node(s, null);
        }
        count++;
    }

    public void prepend(String s)
    {
        if (head != null)
        {
            head = new Node(s, head);
        } else
        {
            head = new Node(s, null);
        }
        count++;
    }

    public int getLength()
    {
        return count;
    }

    public String toString()
    {

        String s = "";
        Node p = head;

        while (p != null)
        {
            System.out.print(s + p.item);
            p = p.next;
        }

        return s;
    }
}
