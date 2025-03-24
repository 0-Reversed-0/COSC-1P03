import BasicIO.*;

public class Main
{

    ASCIIDisplayer output;

    public Main()
    {

        output = new ASCIIDisplayer();
        int[][] grid = {
                {0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 0}
        };

        showGrid(grid);

        int[][] game = new int[grid.length][grid[0].length];

        algorithm(grid, game);

        output.newLine();
        output.writeLine("----------------------------------------------------------");
        output.newLine();

        showGrid(game);

    }

    private void algorithm(int[][] grid, int[][] game)
    {
        for (int x = 0; x < grid.length; x++)
        {

            for (int y = 0; y < grid[0].length; y++)
            {

                int alive = countNeighbours(x, y, grid);

                if (alive == 3 & grid[x][y] == 0)
                {
                    game[x][y] = 1;
                }

                if ((alive == 2 || alive == 3) & grid[x][y] == 1)
                {
                    game[x][y] = 1;
                }
                else if (grid[x][y] == 1)
                {
                    game[x][y] = 0;
                }

            }
        }
    }


    private int countNeighbours(int row, int col, int[][] grid)
    {

        int alive = 0;

        for (int x = row - 1; x <= row + 1; x++)
        {

            for (int y = col - 1; y <= col + 1; y++)
            {

                if (getCell(x, y, grid) == 1)
                {
                    alive++;
                }

            }
        }

        alive -= grid[row][col];

        return alive;
    }

    private int getCell(int row, int col, int[][] grid)
    {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
        {
            return 0;
        }
        return grid[row][col];
    }

    private void showGrid(int[][] grid)
    {
        for (int[] row : grid)
        {
            for (int value : row)
            {
                output.writeC(value > 0 ? 'X' : 'O');
            }
            output.newLine();
        }
    }


    public static void main(String[] args)
    {
        new Main();
    }

}