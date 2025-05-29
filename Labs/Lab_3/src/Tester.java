import text.TextArray;

public class Tester
{

    TextArray txt;
    TextArray text;

    public Tester()
    {
        char[] data = {'L', 'u', 'c','a'};
        char[] dataOpp = {'u', 'c'};

        txt = new TextArray(data);
        text = new TextArray(dataOpp);

        System.out.println(txt.length());

        System.out.println(txt.concat(text));

    }

    public static void main(String[] args)
    {
        new Tester();
    }
}
