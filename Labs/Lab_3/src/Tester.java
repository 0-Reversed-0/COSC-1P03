import text.TextArray;

public class Tester
{

    TextArray txt;
    TextArray text;

    public Tester()
    {
        char[] data = {'L', 'u', 'c', 'a'};
        char[] dataOpp = {'L', 'u','c', 'a'};

        txt = new TextArray(data);
        text = new TextArray(dataOpp);

        System.out.println(txt.compareTo(text));
    }

    public static void main(String[] args)
    {
        new Tester();
    }
}
