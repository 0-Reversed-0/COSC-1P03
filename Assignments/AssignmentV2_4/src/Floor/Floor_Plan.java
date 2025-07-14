/**
 * Author: Reversed_0
 * Course: COSC 1P03 (Spring Term)
 * Title: The Worst Floor Plan
 */

package Floor;

/**
 * This is the recursive class of the Floor plan generator.
 * Floor_Plan handles doing the math and logistics behind making the actual floor plan
 * This is also the class the client handles with and where the client inputs the dimensions
 */

public class Floor_Plan
{

    private Draw draw;
    private final int cutoff = 1; // We hardcode these values since we want to have these conditions static regardless of what passed in the constructor

    /**
     * Creates a new object to draw everything needed and immediately runs the recursive solution once values are passed
     *
     * @param cellSize is measurement of how long and wide each square cell is on one side
     * @param rows     is the amount of rows of cells will the floor plan have
     * @param cols     is the amount of columns of cells will the floor plan have
     */

    public Floor_Plan(int cellSize, int rows, int cols)
    {
        draw = new Draw(cellSize, rows, cols);

        floorCreation(rows, cols, 0, 0);
    }


    /**
     * Recursive method that handles the logistics behind painting, creating walls, where to put walls, and when to stop
     *
     * @param endX   the amount of horizontal cells left in the recursive solution (the arbitrary granularity)
     * @param endY   the amount of vertical cells left in the recursive solution
     * @param startX the start of where the cells will be in the X axis
     * @param startY the start of where the cells will be in the Y axis
     */

    private void floorCreation(int endX, int endY, int startX, int startY)
    {
        int stopChance = randomPercent(2);

        int width = endX - startX;
        int height = endY - startY;

        // Base case:
        if (stopChance == 3 || ((width <= cutoff) & (height <= cutoff))) // if the stop chance occurs or if rows/cols is under the cutoff then...
        {
            draw.paint(startX, startY, endX, endY);

            return; // then stop the recursion
        }

        // Recursive solution:
        if (endX == endY || endX > endY) // if we have a perfect square floor then we just cut it with a vertical line or if we have a wide room then
        {
            int randX = randomCell(endX - 1, startX + 1); // helps us avoids the borders of the canvas

            draw.createWall_V(startY, endY, randX);

            floorCreation(randX, endY, startX, startY);
            floorCreation(startX, startY, randX, endY);

        } else if (endX < endY) // if the floor we are dealing with is too tall then we would cut horizontally
        {
            int randY = randomCell(endY - 1, startY + 1);

            draw.createWall_H(startX, endX, randY);

            floorCreation(endX, randY, startX, startY);
            floorCreation(startX, startY, endX, randY);
        }
    }

    /**
     * A method to get a cell to draw a wall on
     *
     * @param max is the further the cell can go
     * @param min is the least the cell can go
     * @return a random cell
     */

    private int randomCell(int max, int min)
    {
        return (int) ((max - min + 1) * Math.random() + min);
    }

    /**
     * Method to get random percentages for the random stop chance that will stop the recursive solution or for painting
     *
     * @return a random percentage
     */

    private int randomPercent(int factor)
    {
        return (int) (((double) 100 / factor) * Math.random());
    }
}
