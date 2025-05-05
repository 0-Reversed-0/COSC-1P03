import java.*;

public class Main
{

    public Main() // a constructor contracts an instance of the class
    {
        someMethod();
    }

    private void nope()
    {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;

        double mean = (a+b+c+d+e)/5.0;
        System.out.println(mean); 
    }

    public static void main(String[] args)
    {
        new Main();
    }

    void someMethod() // the only way to not attach static is to put the method in a Constructor
    {
        System.out.println("Hi");
    }

}