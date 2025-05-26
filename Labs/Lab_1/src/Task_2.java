import java.util.*;

public class Task_2
{

    byte[][] grades = new byte[100][2]; //I just wanted to use this for fun. Normally do not use bytes use integers instead
    byte size = 0; // also used it for fun
    Scanner input = new Scanner(System.in);

    /**
     * Task 2's purpose is to enter the grades of all the students, find the average, and then finally find which students are failing
     */

    public Task_2()
    {
        generateGrades();
        System.out.println("The amount of grades recorded are: " + size + "\n");
        System.out.println("The average grade is: " + avg(grades));
        failingStudent();
    }

    /**
     * The average method collects all the values and sums it up and then divides it by the already determined size
     */

    double avg(byte[][] grades)
    {
        int sum = 0;

        for (byte i = 0; i < size; i++)
        {
            sum += grades[i][0];
        }

        double avg = (double)sum/ size;

        return avg;
    }

    /**
     * Stores the ID and the Grade of Students
     */

    void generateGrades()
    {
        for (byte i = 0; i < grades.length; i++)
        {
            System.out.print("Input grade: ");
            byte GR = input.nextByte();
            System.out.print("Input ID:");
            byte ID = input.nextByte();

            if (GR == -1 | ID == -1)
            {
                break;
            }
            else
            {
                grades[i][0] = GR;
                grades[i][1] = ID;
                size++;
            }
        }
    }

    /**
     * Find the inventors (F Students)
     */

    void failingStudent()
    {
        for (byte i = 0; i < size; i++)
        {
            if (grades[i][0] < 50)
            {
                System.out.println("The student with the ID of " + grades[i][1] + " is failing with a grade of: " + grades[i][0]);
            }
        }
    }

    public static void main(String[] args)
    {
        new Task_2();
    }

}
