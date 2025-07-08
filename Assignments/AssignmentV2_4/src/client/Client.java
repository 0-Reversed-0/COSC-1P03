/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03 (Spring Term)
 * Title: The Worst Floor Plan
 */

package client;

import Floor.*;

import java.util.Scanner; // I hate BasicIO so much, so I'm using Scanner instead

public class Client
{

    Scanner input = new Scanner(System.in);
    Draw drawer = new Draw(30, 10, 10);

    public Client()
    {
        drawer.createWall_H(0, 7, 2);
        drawer.createWall_V(0, 10, 7);

        drawer.paint(0, 0, 7, 2);
        drawer.paint(7, 0, 10, 10);
    }

    public static void main(String[] args)
    {
        new Client();
    }
}
