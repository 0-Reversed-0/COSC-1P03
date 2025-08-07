package Que;

/**
 * An exception to indicate if the Queue is empty or not
 */

public class QueueEmptyException extends RuntimeException
{
    public QueueEmptyException(String message)
    {
        super(message);
    }
}
