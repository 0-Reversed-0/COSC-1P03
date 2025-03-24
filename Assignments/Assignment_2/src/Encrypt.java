import BasicIO.*;

public class Encrypt
{

    private CodeBook book;
    private ASCIIDataFile in = new ASCIIDataFile("Message.txt");
    private ASCIIOutputFile out = new ASCIIOutputFile("Encrypt.txt");

    private ASCIIDataFile input = new ASCIIDataFile("Encrypt.txt");
    private ASCIIOutputFile output = new ASCIIOutputFile("Decrypt.txt");

    private char[][] c = new char[94][];

    public Encrypt(CodeBook book)
    {
        this.book = book;
    }


    /**
     * This is method is made to take the Message.txt file and turn it into a weird number encryption that it asks of us
     */

    public void encrypt()
    {
        readAndEncode();

        in.close();
        out.close();
    }

    private void readAndEncode()
    {
        for (int i = 0; i < c.length; i++)
        {
            String copier = in.readString();

            c[i] = copier.toCharArray();
        }

        for (int i = 0; i < c.length; i++)
        {
            for (int j = 0; j < c[i].length; j++)
            {
                char ch = c[i][j];

                int asc = (int) ch;
                Node header = CodeBook.book[asc];
                int head = header.data;

                if (head == 0)
                {
                    continue;
                }

                int rand = (int) (1 + Math.random() * head);

                Node current = header;

                for (int k = 0; k < rand; k++)
                {
                    current = current.next;
                }

                out.writeInt(current.data);

            }

            out.newLine();

        }

    }

}
