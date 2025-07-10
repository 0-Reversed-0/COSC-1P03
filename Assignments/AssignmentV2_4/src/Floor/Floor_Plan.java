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

        floorCreation(rows, cols);
    }

    /**
     * Recursive method that handles the logistics behind painting, creating walls, where to put walls, and when to stop
     *
     * @param rows the amount of horizontal cells on the canvas
     * @param cols the amount of vertical cells on the canvas
     */

    private void floorCreation(int rows, int cols)
    {
        int stopChance = randomPercent();

        if (stopChance == stop || (rows <= cutoff && cols <= cutoff)) // if the stop chance occurs or if rows/cols is under the cutoff
        {
            int paintChance = randomPercent();

            if (paintChance == paint)
            {
                draw.paint(0, 0, rows, cols); // fixme
            }

            return;
        }

        if (rows == cols)
        {
            draw.createWall_V(0, 0, 0); // fixme
            floorCreation(0, 0); // fixme
        } else if (rows > cols)
        {
            draw.createWall_V(0, 0, 0); // fixme
            floorCreation(0, 0); // fixme
        } else if (rows < cols)
        {
            draw.createWall_H(0, 0, 0); // fixme
            floorCreation(0, 0); // fixme
        }
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
