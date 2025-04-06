package Part_2;

import BasicIO.*;

public class Maze
{

    static ASCIIDataFile copier = new ASCIIDataFile();
    static int length;
    static int width;
    static char[][] maze;

    static void solver(int L, int W)
    {
        if (L > 0 | W > 0 | L >= length | W >= width)
        {
            return;
        }
    }

    static void fillMaze()
    {
        length = copier.readInt();
        width = copier.readInt();
        maze = new char[length][width];

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < width; j++)
            {
                char letter = copier.readC();
                maze[i][j] = letter;
            }
            copier.nextLine();
        }
    }

    static void displayMaze()
    {
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < width; j++)
            {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        fillMaze();
        displayMaze();
    }
}