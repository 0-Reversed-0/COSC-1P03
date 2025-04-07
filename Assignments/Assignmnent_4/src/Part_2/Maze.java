package Part_2;

import BasicIO.*;

/**
 * Author: Arhum Ahmed Khan
 * Student ID: 8074114
 * Course: COSC 1P03
 * Title: Maze Solver - Assignment 4
 */

// First time I worked on an assignment and I didn't go over 200 lines

public class Maze
{

    static ASCIIDataFile copier = new ASCIIDataFile(); // Obviously to read either of the 2 text files given, user must put text file in manually.
    static int length; // universal length of the maze
    static int width; // universal width for the maze since I use this a lot
    static char[][] maze; // the maze itself!!!
    static int x; // the starting point's X coordinate
    static int y; // the starting point's Y coordinate

    /**
     * This method solves the maze from any point (L = x cord, W = y cord).
     * First it checks for if the given start point is a valid coordinate, then checks for walls and dead ends then checks the wanted result and if its met and then finally it checks if there's a valid space and valid starting point S.
     * After that it does the solving steps where it sets the direction, then it checks if it can go a direction then it returns true and continues, but if it can't go on then it sets it to the next direction and does the same
     */

    static int solver(int L, int W)
    {
        if (L < 0 | W < 0 | L >= length | W >= width) //checks boundaries
        {
            return 0;
        } else if (maze[L][W] == '#' | maze[L][W] == '.') //checks for walls and dead ends!!!
        {
            return 0;
        } else if (maze[L][W] == 'E') //checks if I'm lucky enough
        {
            return 1;

        } else if (maze[L][W] == ' ' | maze[L][W] == 'S') // checks for the starting point for the maze or checks for the next available space
        {

            maze[L][W] = 'V';
            if (solver(L + 1, W) == 1) // firsts check if the next available space is down by setting the current to V
            {
                return 1; // if its available then it returns true or 1.
            } // if not move on to the next direction

            maze[L][W] = '>';
            if (solver(L, W + 1) == 1) // right :(
            {
                return 1;
            }

            maze[L][W] = '^';
            if (solver(L - 1, W) == 1) // up :)
            {
                return 1;
            }

            maze[L][W] = '<';
            if (solver(L, W - 1) == 1) // left!!!!
            {
                return 1;
            }

            maze[L][W] = '.'; // if no available directions then it's a dead end
        }

        return 0; // IDK its just it didn't work when I removed it so it stays
    }

    /**
     * This obviously sets the starting point by randomizing the x and y and storing it in an instance variable.
     * It also puts the starting point in the array.
     */

    static void setStart()
    {
        X_Random();
        Y_Random(); // sets x and y

        if (maze[x][y] == ' ') //there's only 3 values when the maze is initialized. The only one we need to focus on is the space because we do not want to print on '#' or 'E'
        {
            maze[x][y] = 'S'; // puts the S on the maze
        } else
        {
            setStart(); // if it is not on a space then try again
        }
    }

    /**
     * Sets X
     */

    static void X_Random()
    {
        x = (int) (length * Math.random()); // in bounds of the length of the array so no out of bounds because that's bad
    }

    /**
     * Sets Y
     */

    static void Y_Random()
    {
        y = (int) (width * Math.random()); // in bounds of the width of the array
    }

    /**
     * This initializes the maze by reading the text file and copying it into an array called maze.
     */

    static void fillMaze()
    {
        length = copier.readInt(); // sets the length as it is on the first line
        width = copier.readInt();  // sets the width
        maze = new char[length][width]; // initializes the maze array

        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < width; j++)
            {
                char letter = copier.readC(); // reads the letter
                maze[i][j] = letter; // sets the letter to the maze
            }
            copier.nextLine(); // The is the only way it works correctly for some reason?
        }
    }

    /**
     * I honestly didn't want to use ASCIIDataFile, so I used the terminal instead. It just works better.
     */

    static void displayMaze()
    {
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < width; j++)
            {
                System.out.print(maze[i][j]); //manual array print
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {                                                           // Steps to my code:

        fillMaze();                                             // 1) Starts with initializing the array
        setStart();                                             // 2) Puts the starting point
        System.out.println("Start Point: " + x + ", " + y);     // 3) Tells the user what the starting point is
        solver(x, y);                                           // 4) Solves the maze
        maze[x][y] = 'S';                                       // 5) Manually sets the starting point because it replaces with array for whatever reason
        displayMaze();                                          // 6) Displays it finally

    }
}