/**
 * Assignment 2: Codebook
 * Course: COSC 1P03
 * Author: Reversed_0
 */

public class Main
{

    static CodeBook cb = new CodeBook();
    static Encrypt a = new Encrypt(cb);
    static Decrypt b = new Decrypt();


    public static void main(String[] args)
    {
        cb.generate();
        //cb.table();

        a.encrypt();

        b.read();

    }

}
