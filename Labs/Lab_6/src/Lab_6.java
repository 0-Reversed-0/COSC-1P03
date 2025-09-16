import Media.*;

public class Lab_6
{

    Turtle T;
    TurtleDisplayer D;
    boolean[][] visited = new boolean[30][30]; 

    public Lab_6()
    {
        T = new Turtle(0);
        D = new TurtleDisplayer(T);
        fill();

        int x = 0;
        int y = 0;

        travel(x, y);
        T.penDown();
        genMaze(x, y);
    }

    void genMaze(int x, int y)
    {
        if (visited[x][y])
        {
            return;
        }

        visited[x][y] = true;

        travel(x, y);

        char[] direction = random();

        for (char dir : direction)
        {
            int tempX = x;
            int tempY = y;
            switch (dir)
            {
                case 'N':
                    tempY--;

                    if (tempX >= 0 && tempY >= 0 && tempX < 30 && tempY < 30)
                    {
                        genMaze(tempX, tempY);
                        travel(x, y);
                        break;
                    }
                case 'S':
                    tempY++;

                    if (tempX >= 0 && tempY >= 0 && tempX < 30 && tempY < 30)
                    {
                        genMaze(tempX, tempY);
                        travel(x, y);
                        break;
                    }
                case 'E':
                    tempX++;

                    if (tempX >= 0 && tempY >= 0 && tempX < 30 && tempY < 30)
                    {
                        genMaze(tempX, tempY);
                        travel(x, y);
                        break;
                    }
                case 'W':
                    tempX--;

                    if (tempX >= 0 && tempY >= 0 && tempX < 30 && tempY < 30)
                    {
                        genMaze(tempX, tempY);
                        travel(x, y);
                        break;
                    }
            }
        }

    }

    private char[] random()
    {
        char[] directions = {'N', 'S', 'E', 'W'};
        for (int i = 0; i < 4; i++)
        {
            int other = (int) (Math.random() * 4);
            char swp = directions[i];
            directions[i] = directions[other];
            directions[other] = swp;
        }
        return directions;
    }

    private void travel(int x, int y)
    {
        T.moveTo(x * 10 - 145, y * 10 - 145);
    }

    /**
     * The fill method makes our canvas a purely black so that we can ready our maze solver
     */

    private void fill()
    {
        T.setPenWidth(400);
        T.penDown();
        T.moveTo(-100, 100);
        T.moveTo(100, 100);
        T.moveTo(100, -100);
        T.moveTo(-100, -100);
        T.moveTo(-100, 100);
        T.penUp();
        T.setPenWidth(5);
        T.setPenColor(java.awt.Color.white);
    }

    public static void main(String[] args)
    {
        new Lab_6();
    }
}
