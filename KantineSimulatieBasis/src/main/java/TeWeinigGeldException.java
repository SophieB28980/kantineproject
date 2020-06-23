
/**
 * Write a description of class TeWeinigGeldException here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TeWeinigGeldException extends Exception
{
    
    
    public TeWeinigGeldException()
    {
        super("Niet genoeg saldo");
    }
    
    public TeWeinigGeldException(Exception e)
    {
        super(e);
    }
    
    public TeWeinigGeldException(String message)
    {
        super(message);
    }
    
}