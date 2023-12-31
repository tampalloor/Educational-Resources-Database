


/**
 * CompareToByInterface.
 * ---------------------
 * This interface has just one method, the CompareToBy method.
 * It is similar to the compareTo method, 
 * except that you can specify an attribute of the class that you want to use
 * as the basis for comparison.
 * @author Karen
 */
public interface CompareToByInterface
{
    /**
     * compareToBy
     * -----------
     * This method will compare this to other using the attribute specified by attributeToCompareBy.
     * A negative number is returned if this < other when comparing their respective attributeToCompareBy.
     * A 0 is returned if this = other with respect to attributeToCompareBy
     * a positive number is returned if this > other with respect to their attributeToCompareBy
     * So for example, if attributeToCompareBy is "Name", then 
     *              (assuming that both this and other have an attribute called 'Name')
     * if this.Name < other.Name, we'll return -1
     * if this.Name = other.Name, we'll return 0
     * if this.Name > other.Name, we'll return 1
     * PRECONDITION: Both this and other have the attribute specified by attributeToCompareBy. 
     *               If neither has the attribute, return 0; 
     *               If this has the attribute, but other does not, we'll return a negative number.
     *               If this doesn't have the attribute, but other does, we'll return a positive number.
     *               This strategy will make it so that the items that DO have the attributeToCompareBy
     *               will wind up at the beginning of a sorted list.
     *               
     * POSTCONDITION: Neither this nor other is changed in any way. An integer is returned 
     */
    public int compareToBy(Record other, String attributeToCompareBy);
    
    

}

