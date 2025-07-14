/**
 * Author: Reversed_0
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
 * I used Scanner over BasicIO because Earl approves of its use
 */

public class Client
{
    Scanner input = new Scanner(System.in);

    public Client()
    {
        userTest();
    }

    /**
     * Gathers information through the Scanner object to pass the certain items through the constructor.
     */

    private void userTest()
    {
        System.out.print("\nInput the ratio at which the cell will sized in Turtle pixels: ");
        int cellSize = input.nextInt();
        System.out.print("\nInput the amount of rows of cells will be on the floor: ");
        int rows = input.nextInt();
        System.out.print("\nInput the amount of columns of cells will be on the floor: ");
        int columns = input.nextInt();
        System.out.print("\nInput the cutoff for when cells are too small: ");
        int cutoff = input.nextInt();
        System.out.print("\nInput the stop probability of the program ending on its on (in whole number form): %");
        int stopProb = input.nextInt();

        Floor_Plan floor = new Floor_Plan(cellSize, rows, columns, cutoff, stopProb);
    }

    public static void main(String[] args)
    {
        new Client();
    }
}
