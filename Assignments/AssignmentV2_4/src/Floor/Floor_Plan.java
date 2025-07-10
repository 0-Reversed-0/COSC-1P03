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
 * This is also the class the client handles with and where the client inputs the dimensions
 */

public class Floor_Plan
{

    private Draw draw;
    private final int cutoff = 3; // We hardcode these values since we want to have these conditions static regardless of what passed in the constructor 
    private final int stop = 5;
    private final int paint = 20;

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
     * @param currentX the amount of horizontal cells on the canvas
     * @param currentY the amount of vertical cells on the canvas
     */

    private void floorCreation(int currentX, int currentY, int lastX, int lastY)
    {
        int stopChance = randomPercent();

        // Base case:
        if (stopChance == stop || (currentX <= cutoff && currentY <= cutoff)) // if the stop chance occurs or if rows/cols is under the cutoff then...
        {
            int paintChance = randomPercent();

            if (paintChance == paint) // check if we want to paint this section
            {
                draw.paint(lastX, lastY, currentX, currentY);
            }

            return; // then stop the recursion
        }

        // Recursive solution:
        if (currentX == currentY) // if we have a perfect square floor then we just cut it with a vertical line
        {
            int rand = randomCell(currentX-1, lastX);

            draw.createWall_V(lastY, currentY, rand);

            floorCreation(rand, currentY, lastX, lastY);
        } else if (currentX < currentY) // if the floor we are dealing with is too tall then we would cut horizontally
        {
            int rand = randomCell(currentY-1, lastY);

            draw.createWall_H(lastX, currentX, rand);

            floorCreation(currentX, rand, lastX, lastY);
        } else if (currentX > currentY) // if the floor we are dealing with is too wide then we would cut it vertically
        {
            int rand = randomCell(currentX-1, lastX);

            draw.createWall_V(lastY, currentY, rand);

            floorCreation(rand, currentY, lastX, lastY);
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

    private int randomPercent()
    {
        return (int) (100 * Math.random());
    }
}
