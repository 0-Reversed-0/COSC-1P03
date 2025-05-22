import java.util.Scanner; // For input!

public class WeighingCosts
{
    public WeighingCosts()
    {
        Scanner input = new Scanner(System.in);
        double[] readings = getReadings(input); //O(n)
        double mean = calcMean(readings); // O(n)+O(n) = O(2n) Thus the runtime would be just O(n)
        System.out.println("Average rainfall: " + mean);
    }

    private double[] getReadings(Scanner in) // The runtime of the whole method is O(n)
    {
        System.out.print("How many readings? ");
        int numReadings = in.nextInt();
        double[] arr = new double[numReadings];
        for (int i = 0; i < arr.length; i++) // O(n)
        {
            System.out.print("Next reading: ");
            arr[i] = in.nextDouble();
        }
        return arr;
    }

    private double calcMean(double[] values) // The runtime of the whole method is O(n)
    {
        double mean = 0.0; //Dual-purposed as also the total sum
        for (double v : values) // O(n)
            mean += v;
        return mean / values.length;
    }

    public static void main(String[] args)
    {
        new WeighingCosts();
    }
}


