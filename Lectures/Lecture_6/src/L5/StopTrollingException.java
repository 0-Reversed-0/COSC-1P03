package L5;

/**
 * Runtime exception is basically an unchecked exception
 * To explain what am unchecked exception is we have to explain a normal exception
 * In a literal sense, a checked exception is an exception checked when a class in compiled (Example ClassNotFoundException: Basically anything that the IDE will highlight red line over is a checked exception)
 * Now the exact opposite that is an unchecked exception is where the IDE does not scream you for.
 * Exceptions like these get pass the compiler and will result in a crash when a program is runs (Example: ArrayIndexOutOfBoundsException will not have a red line because it is impossible for the IDE to know until the program is run)
 */

public class StopTrollingException extends RuntimeException //basically says that a Stop Trolling class is a Runtime exception or an unchecked exception
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
