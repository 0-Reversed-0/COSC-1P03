/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03 (Spring Term)
 * Title: The Worst Floor Plan
 */

package Floor;

import Media.*;

import java.awt.*;

/**
 * The Draw class does all the drawing for the recursive class
 * This class is package private since the Floor_Plan should be the only class commanding the Draw class to draw
 * This class handles the grid/cell system for the recursive class
 * It also handles creating horizontal and vertical walls
 * It can also paint entire cells if the user requests to do so
 */

class Draw
{
    private int cellSize;
    private int canvasWidth;
    private int canvasHeight;
    private Turtle T = new Turtle(0);
    private TurtleDisplayer display;

    /**
     * This object can only be created if the user specifics the cell size, rows, and columns
     *
     * @param size    is measurement of how long and wide each square cell is on one side
     * @param rows    is the amount of rows of cells will the floor plan have
     * @param columns is the amount of columns of cells will the floor plan have
     */

    public Draw(int size, int rows, int columns)
    {
        cellSize = size;
        canvasWidth = rows * size; // The canvas dimension are directly determined and set by the rows/cols and cell size
        canvasHeight = columns * size;

        display = new TurtleDisplayer(T, canvasWidth, canvasHeight);
    }

    /**
     * This method fills cells with a random colour
     *
     * @param X1 is the starting cell's X coordinate
     * @param Y1 is the starting cell's Y coordinate
     * @param X2 is the ending cell's X coordinate
     * @param Y2 is the ending cell's Y coordinate
     */

    public void paint(int X1, int Y1, int X2, int Y2)
    {
        Color c = new Color((int) (Math.random() * 16777216)); // Formula derived from COSC 1P02 Lab 2 to get a random colour

        T.setPenColor(c);
        T.penUp();
        T.moveTo(getCellX(X1), getCellY(Y1));

        for (int y = getCellY(Y1) + 1; y < getCellY(Y2) - 1; y++)
        {
            for (int x = getCellX(X1) + 1; x < getCellX(X2) - 1; x++) // The +/- 1's are to prevent overlapping over walls.
            {
                T.penDown();
                T.moveTo(x, y); // We approach paint a room by slowly going through each coordinate one by one and moving to them which slowly fills the room
                T.penUp();
            }
        }

        T.setPenColor(Color.black);
    }

    /**
     * This method creates a horizontal wall between 2 'X' cell coordinates from a specific 'Y' cell coordinate
     *
     * @param X1 is the starting cell coordinate, excluding the cell itself
     * @param X2 is the ending cell coordinate, including the cell itself
     * @param Y  is where the wall will come out off
     */

    public void createWall_H(int X1, int X2, int Y)
    {
        int door = chooseDoor(X1, X2);

        T.penUp();
        T.moveTo(getCellX(X1), getCellY(Y)); // We first want to move to where the X1 starts

        for (int i = X1 + 1; i <= X2; i++) // since we already went to X1 we don't have to move there again, hence the X1 +1
        {
            T.penDown();

            if (door == i) // This is to ensure the door is actually drawn on one of the cells 
            {
                T.setPenColor(Color.orange);
                T.moveTo(getCellX(i), getCellY(Y));
                T.setPenColor(Color.black);
            } else
            {
                T.moveTo(getCellX(i), getCellY(Y));
            }

            T.penUp();
        }
    }

    /**
     * This method creates a vertical wall between 2 'Y' cell coordinates from a specific 'X' cell coordinate
     *
     * @param Y1 is the starting cell coordinate, excluding the cell itself
     * @param Y2 is the ending cell coordinate, including the cell itself
     * @param X  is where the wall will come out off
     */

    public void createWall_V(int Y1, int Y2, int X)
    {
        int door = chooseDoor(Y1, Y2);

        T.penUp();
        T.moveTo(getCellX(X), getCellY(Y1)); // We first want to move to where the Y1 starts

        for (int i = Y1 + 1; i <= Y2; i++) // since we already went to Y1 we don't have to move there again, hence the Y1 +1
        {
            T.penDown();

            if (door == i) // This is to ensure the door is actually drawn on one of the cells 
            {
                T.setPenColor(Color.orange);
                T.moveTo(getCellX(X), getCellY(i));
                T.setPenColor(Color.black);
            } else
            {
                T.moveTo(getCellX(X), getCellY(i));
            }

            T.penUp();
        }
    }

    /**
     * Makes a random number between the minimum and maximum number to decided which cell coordinate will be a door
     *
     * @param min is the minimum number for where the door can be placed
     * @param max is the maximum number for where the door can be placed
     * @return the cell coordinate for where the door will be placed.
     */

    private int chooseDoor(int min, int max)
    {
        return (int) ((max - (min + 1) + 1) * Math.random() + min + 1); // we add +1 to the minimum value since we do not include the min value
    }

    /**
     * This translates cell coordinates to actual Turtle coordinates we could use for our paint and wall methods
     *
     * @param X is the x coordinate for the cell on the grid
     * @return the translated X Turtle coordinate
     */

    private int getCellX(int X)
    {
        return X * cellSize - (canvasWidth / 2);

        /*
         * How I approached getting cell values is using this formula
         * Fist I decided that cell's turtle coordinate will be the bottom left corner of the cell
         * Once that was decided we then first get the cell the user request and multiply it by the size of each cell
         * We do this to align the Turtle coordinates with our imaginary grid.
         * This is we use coordinates from now on so that we never get past the grid lines
         */
    }

    /**
     * This translates cell coordinates to actual Turtle coordinates we could use for our paint and wall methods
     *
     * @param Y is the y coordinate for the cell on the grid
     * @return the translated Y Turtle coordinate
     */

    private int getCellY(int Y)
    {
        return Y * cellSize - (canvasHeight / 2); // we approach getting the Y cell coordinate the same way
    }
}
