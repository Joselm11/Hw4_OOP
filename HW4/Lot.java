
/**
 * Write a description of class Lot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lot
{
    // instance variables - replace the example below with your own
    private Bid highestBid;

    /**
     * Constructor for objects of class Lot
     */
    public boolean bidFor(Bid bid)
    {
        // initialise instance variables
        if(highestBid == null) 
        {
            highestBid = bid;
            return true;
        }
        else if (bid.getValue() > highestBid.getValue())
        {
            highestBid = bid;
            return true;
        }
        else 
        {
            return false;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
