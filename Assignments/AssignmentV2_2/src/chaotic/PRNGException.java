/**
 * Author: Reversed_0
 * Course: COSC 1P03
 * Title: Rando Reincarnated - Assignment 2
 */

package chaotic;

/**
 * PRNGException catches any invalid boundaries that the client inputs.
 * PRNG is a checked exception
 */

public class PRNGException extends Exception // we need to make this a checked exception since the CLIENT should handle PRNGExceptions (boundary exceptions)
{
    public PRNGException(String message) // I throw PRNGException in 2 separate methods with 2 different types of boundary checks before the methods run
    {
        super(message); // So I would like the distinct which method caused the error using the constructor for PRNGException
    }
}
