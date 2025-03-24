public class Searching
{

    final int NumSearches = 1;    //Number of times we search for a number
    final int DataSize = 1000000;     //Size of the data array
    static final int NOT_FOUND = -1; //Used in Binary Search

    int[] data;     //The data array that we will search

    public Searching()
    {
        int FindThisNumber;   //A random number we will search for.
        int Probes;           // Count of the number of Probes it took to FindthisNumber

        data = new int[DataSize];   //create an load data
        for (int i = 0; i < data.length; i++)
            data[i] = i;


        Probes = 0;
        for (int i = 0; i < NumSearches; i++)
        {
            FindThisNumber = (int) (Math.random() * DataSize);
            Probes += FindLinear(FindThisNumber);
        }
        System.out.println(Probes / NumSearches + " ");


        Probes = 0;
        for (int i = 0; i < NumSearches; i++)
        {
            FindThisNumber = (int) (Math.random() * DataSize);
            Probes += FindBinary(data, FindThisNumber);
        }
        System.out.println(Probes / NumSearches + " ");


    }


    //Binary search returning number of probes on a success
    private int FindBinary(int[] a, int x)
    {

        int low = 0, high = a.length - 1;
        int mid;
        int Probes = 0;

        while (low <= high)
        {
            mid = (low + high) / 2;
            Probes++;
            if (a[mid] < x) low = mid + 1;
            else if (a[mid] > x) high = mid - 1;
            else return Probes;
        }

        return NOT_FOUND;

    }


    //Lenear search, returning the number of Probes for a successful search.
    private int FindLinear(int FindThisNumber)
    {


        int probes = 0;

        for (int i = 0; i < data.length; i++)
        {

            probes++;

            if (data[i] == FindThisNumber)
            {
                return probes;
            }
            else if (i == data.length)
            {
                return NOT_FOUND;
            }

        }

        return probes;
    }


    public static void main(String[] args)
    {
        new Searching();
        System.out.println("End Searching");

    }

}
