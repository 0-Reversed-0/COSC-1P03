/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03 (Spring Term)
 * Title: The Worst Floor Plan
 */

package Floor;

/**
 * This is the recursive class of the Floor plan generator.
 * Floor_Plan handles doing the math and logistics behind making the actual floor plan
 * This is also the class the client handles with and where the client inputs the dimensions, cutoff, and stop chance
 * It commands the Draw class to draw it for it.
 */

public class Floor_Plan
{

    private Draw draw;
    private final int cutoff;
    private final double stop;

    /**
     * Creates a new object to draw everything needed and immediately runs the recursive solution once values are passed
     *
     * @param cellSize is measurement of how long and wide each square cell is on one side
     * @param rows     is the amount of rows of cells will the floor plan have
     * @param cols     is the amount of columns of cells will the floor plan have
     * @param cut      is the minimum amount of cells that can be in one singular room
     * @param S        is the stop probability of the program stopping randomly rather just based off cutoff
     */

    public Floor_Plan(int cellSize, int rows, int cols, int cut, int S)
    {
        draw = new Draw(cellSize, rows, cols);
        cutoff = cut;
        stop = (double) S / 100; // I divide stop by 100 just to make it easier to compare it to Math.random

        floorCreation(rows, cols, 0, 0); // we pass in (0,0) since every canvas has to start at (0,0) with how our grid system was coded
    }


    /**
     * Recursive method that handles the logistics behind painting, creating walls, where to put walls, and when to stop
     * This recursing method takes advantage of the Draw classes' grid system to calculate and compare on whether to keep cutting with walls or not
     * The algorithm works via taking a big floor and splitting it into multiple smaller floors until the cutoff is hit, and we then add all the walls stored in the call stack
     *
     * @param endX   the amount of horizontal cells left in the recursive solution (the arbitrary granularity)
     * @param endY   the amount of vertical cells left in the recursive solution
     * @param startX the start of where the cells will be in the X axis
     * @param startY the start of where the cells will be in the Y axis
     */

    private void floorCreation(int endX, int endY, int startX, int startY) // IMPORTANT TO NOTE: that I am stupid and decided the ending coordinates before the starting ones so PLEASE IN MIND (END, END) <- (START, START)
    {
        int width = endX - startX;
        int height = endY - startY; // we do this because there can be pixels in coordinates like (4131243, 491212) that have less space than the cutoff demands so to accommodate we scale it down by subtracting from it

        // Base case:

        /*
         * The base case has 2 condition that stop the recursion
         * 1) If the width and the height of what is being cut is lesser than or equal to the cutoff then stop recursing
         * 2) Or if, on the rare chance, the stop probability is hit then stop recursing as well
         */

        if ((width <= cutoff & height <= cutoff) || (Math.random() <= stop))
        {
            if (Math.random() <= 0.15) // We don't want paint on every single stop so we make paint come 15% of the time
            {
                draw.paint(startX, startY, endX, endY);
                return; // stop the recursion process
            }
        }

        // Recursive solution:

        if (width >= height) // since squares are considered wide we would cut them vertically since Earl Foxwell said so
        {
            if (width <= cutoff) // this is a safeguard before any movement on turtle is made
            {
                return;
            }

            int randX = randomCell(endX - 1, startX + 1); // we need a random spot on the grid to make the new wall

            draw.createWall_V(startY, endY, randX); // the wall would extend from the starting coordinate to the ending coordinate and originate on random X cell we have chosen

            /*
             * The recursive step of this section of this problem involves 2 method calls
             *
             * The first method call handles everything from the LEFT of the newly created wall so (0,0) -> (random #, Max Y value) [NOTE: 0,0 is a placeholder for the starting x and y]
             * It will place more and more walls of until one of the 3 base cases are met. (wall specific cutoff call v.s. main base case)
             *
             * The second method call handles everything from thr RIGHT of the first wall placed so (the same random #, 0) -> (max X, max Y)
             * The same base cases apply to it as well of course
             */

            floorCreation(randX, endY, startX, startY); // LEFT
            floorCreation(endX, endY, randX, startY);   // RIGHT

        } else // if it's not wide or square then, by process of elimination, it has to be tall meaning we would cut them horizontally
        {
            if (height <= cutoff)
            {
                return;
            }

            int randY = randomCell(endY - 1, startY + 1);

            draw.createWall_H(startX, endX, randY);

            floorCreation(endX, randY, startX, startY); // LEFT  : (starting point x,y) -> (MAX X VALUE, random #)
            floorCreation(endX, endY, startX, randY);   // RIGHT : (same random #, 0) -> (Max X,Y)
        }
    }

    /**
     * A method to get a random cell to be used to determine where to place a wall on the floor
     *
     * @param max is the further the cell can go
     * @param min is the least the cell can go
     * @return a random cell
     */

    private int randomCell(int max, int min)
    {
        return (int) ((max - min + 1) * Math.random() + min);
    }
}
