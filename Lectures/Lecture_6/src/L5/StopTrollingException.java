package L5;

/**
 * Runtime exception is basically an unchecked exception
 * To explain what am unchecked exception is we have to explain a normal exception
 * In a literal sense, a checked exception is an exception checked when a class in compiled
 * (Example ClassNotFoundException: Basically any error that will not allow the program to run at all will be a checked exception. This means that any exception that is caught when the error is compiled is a checked exception)
 * Now the exact opposite that is an unchecked exception is where it slips past the compiler
 * Exceptions like these get pass the compiler and will result in a crash when the program runs into it or in the "Runtime" of the program
 * (Example: ArrayIndexOutOfBoundsException: It will crash the program only when the index goes overboard and will never been seen by the compiler)
 */

public class StopTrollingException extends RuntimeException //basically says that a Stop Trolling class is a Runtime(uncheck) exception that will crash the program if ever ran into
{

    /*
     * StopTrolling Exception is what we call a custom exception
     * This is an exception that is not prepackaged in java but instead something that we ourselves want to count as an exception
     * We would want to make a custom exception if we want to program to crash if it does not work specifically the way we want
     * For example: If a user puts an invalid age then java would not say anything about it, but it would mess up our program so we would throw our custom InvalidAge exception
     */

    public StopTrollingException(String message)
    {
        super(message); // If the user so please to and wants to send a message using their exception then they can by just putting it in the instance's parameters
    }

    public StopTrollingException()
    {
        // If the user does not want to replace the ugly red text with a message they can do so
    }
}
