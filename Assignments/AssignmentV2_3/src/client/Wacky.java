/**
 * Author: Earl Foxwell
 * Course: COSC 1P03
 * Title: Bottomless Pit Bins
 */


package client;

import storage.*;
import Media.*;
import BasicIO.*;

/**
 * Changes made to Wacky:
 * - Formatting - I like my scopes done this way. Also spaced things out a bit to my liking!
 * - Changed Ikea to The_Cabinet
 */

public class Wacky
{
    public Wacky()
    {
        BasicForm form = buildForm();
        Cabinet<Picture> cabinet = generate();
        doTheThings(cabinet, form);
    }

    private void doTheThings(Cabinet<Picture> cabinet, BasicForm form)
    {
        form.writeString("listing", String.join(", ", cabinet.getBins()));
        while (true)
        {
            int choice = form.accept("Display", "Stop");
            if (choice == 1) break;
            if (choice == 0)
            {
                String label = form.readString("colour");
                if (cabinet.query(label) > 0)
                {
                    Bin<Picture> bin = cabinet.getBin(label);
                    for (Picture pic : bin)
                    {
                        form.placePicture("view", pic);
                        form.accept("Next");
                    }
                    cabinet.add(bin, label);
                }
            }
        }
    }

    private int genInt(int lb, int ub)
    {
        return (int) (Math.random() * (ub - lb) + lb);
    }

    private Cabinet<Picture> generate()
    {
        Cabinet<Picture> cabinet = new The_Cabinet<>();
        for (int i = 0; i < 5; i++)
        {
            int red = genInt(128, 256);
            int green = genInt(0, 128), blue = genInt(0, 128);
            cabinet.add(genPic(new java.awt.Color(red, green, blue)), "red");
        }
        for (int i = 0; i < 5; i++)
        {
            int green = genInt(128, 256);
            int red = genInt(0, 128), blue = genInt(0, 128);
            cabinet.add(genPic(new java.awt.Color(red, green, blue)), "green");
        }
        for (int i = 0; i < 5; i++)
        {
            int blue = genInt(128, 256);
            int green = genInt(0, 128), red = genInt(0, 128);
            cabinet.add(genPic(new java.awt.Color(red, green, blue)), "blue");
        }
        for (int i = 0; i < 5; i++)
        {
            int red = genInt(0, 128);
            int greenblue = genInt(128, 256);
            cabinet.add(genPic(new java.awt.Color(red, greenblue, greenblue)), "cyan");
        }
        for (int i = 0; i < 5; i++)
        {
            int redblue = genInt(128, 256);
            int green = genInt(0, 128);
            cabinet.add(genPic(new java.awt.Color(redblue, green, redblue)), "magenta");
        }
        for (int i = 0; i < 5; i++)
        {
            int redgreen = genInt(128, 256);
            int blue = genInt(0, 128);
            cabinet.add(genPic(new java.awt.Color(redgreen, redgreen, blue)), "yellow");
        }
        for (int i = 0; i < 5; i++)
        {
            int grey = genInt(128, 256);
            cabinet.add(genPic(new java.awt.Color(grey, grey, grey)), "grey");
        }
        return cabinet;
    }

    private Picture genPic(java.awt.Color c)
    {
        Picture pic = new Picture(200, 200);
        for (Pixel p : pic) p.setColor(c);
        return pic;
    }

    private BasicForm buildForm()
    {
        BasicForm form = new BasicForm();
        form.addCanvas("view");
        form.addTextField("listing", 50);
        form.setEditable("listing", false);
        form.addTextField("colour", "Colour");
        return form;
    }

    public static void main(String[] args)
    {
        new Wacky();
    }
}
