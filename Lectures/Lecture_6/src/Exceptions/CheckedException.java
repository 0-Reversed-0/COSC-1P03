package Exceptions;

/**
 * This is an example of a CHECKED Exception
 * The few qualities checked exceptions are:
 * That it extends Exception rather than RuntimeException
 * It must be handled by the user I.E. you need to handle it in a try catch block
 * It is caught in the compiler rather than the runtime of a program
 */

public class CheckedException extends Exception
{

    public CheckedException(String message)
    {
        super(message);
    }

}
