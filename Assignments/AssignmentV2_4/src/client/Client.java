/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03 (Spring Term)
 * Title: The Worst Floor Plan
 */

package client;

import Floor.*;

import java.util.Scanner; // I hate BasicIO so much, so I'm using Scanner instead

/**
 * The client class is the only executable class in the entire project
 * It's main purpose is to test the capabilities of the Floor_Plan class
 * The testing will be up to the user via inputting different row : columns ratios and different values of the cell size
 */

public class Client
{
    Scanner input = new Scanner(System.in);

    public Client()
    {
        Floor_Plan floor = new Floor_Plan(60, 5, 5);
    }

    public static void main(String[] args)
    {
        new Client();
    }
}
