package chaotic;

public class PRNGException extends RuntimeException
{
    public PRNGException(String message) // I have 2 cases of this being thrown and I want to be able to tell the difference which is why I have contractor
    {
        super(message); // I just think it's more appropriate to have a message tied to a custom uncheck exception
    }
}
