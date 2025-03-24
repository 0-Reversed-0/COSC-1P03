import BasicIO.*;

public class Decrypt
{

    ASCIIDataFile in = new ASCIIDataFile("Encrypt.txt");
    ASCIIOutputFile out = new ASCIIOutputFile("Decrypt.txt");

    public void read() // The ASCIIDATAFILE cannot read no matter what I do even when I put away the encryption txt in in the param for the object so I can only get this far
    {
        while (true)
        {
            int copier = in.readInt();

            if (in.isEOF())
                break;

            System.out.println(copier);

            while (in.successful())
            {
                int copier2 = in.readInt();

                System.out.println(copier2);
            }
        }
    }

}