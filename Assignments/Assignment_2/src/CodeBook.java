public class CodeBook
{
    static Node[] book = new Node[128]; //array of linked lists for ASCII characters 0–127


    public CodeBook() { // constructors only use is to make sure to initially set the values at 0
        for (int i = 0; i < 128; i++) {
            book[i] = new Node(0);
        }
    }

    /**
     * Generates the CodeBook by generating 2000 random ASCII codes. Each generated code is sequentially numbered and added to the corresponding linked list.
     */

    public void generate()
    {

        for (int i = 1; i <= 2000; i++) // Loop from 1 to 2000
        {
            int character = (int) (Math.random() * 128); // Generate a random ASCII value (0–127)
            add(book[character], i);  // Add the code to the linked list for aChar
        }
    }

    /**
     * Adds a new node with the given code to the end of the linked list. Also increments the header nodes count.
     */

    public void add(Node list, int num)
    {
        Node newNode = new Node(num);
        Node current = list;

        while (current.next != null) // traverse until the tail
        {
            current = current.next; // point to the next value
        }
        current.next = newNode; // updates current's data
        list.data++; // increments header count
    }

    /**
     * Prints the entire CodeBook as a table. Each ASCII index is printed.
     */

    public void table()
    {
        for (int i = 0; i < 128; i++)
        {
            System.out.print(i + ": ");
            Node current = book[i].next;
            while (current != null)
            {
                System.out.print(current.data + " - ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}
