import pez.*;

public class Tester
{

    ArrayPez a = new ArrayPez();

    public Tester()
    {
        a.push('B');
        a.push('Y');

        System.out.println(a.pop());
    }

    public static void main(String[] args)
    {
        new Tester();
    }
}
