package L5;

/**
 * Runtime exception is basically an unchecked exception
 */

public class StopTrollingException extends RuntimeException //basically says that a Stop Trolling class is a Runtime exception
{
    public StopTrollingException(String message)
    {
        super(message); // If the user so please to and wants to send a message using their exception then they can by just putting it in the constructor parameters
    }

    public StopTrollingException()
    {
        // If the user does not want to replace the ugly red text with a message they can do so
    }
}
