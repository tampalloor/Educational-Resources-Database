


/**
 * OnlineRec
 * ---------
 * This class holds a record of some online resource like a website or an online article.
 * 
 * @author Thomas Ampalloor
 */
public class OnlineRec extends Record
{

    public String websiteURL;

    /**
     * Constructors for objects of class OnlineRec
     */
    public OnlineRec()
    {
        // initialise instance variables
        super("Online", "unNamed OnlineRec","blank description" );
        this.websiteURL = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }
    public OnlineRec(String name, String description, String websiteURL)
    {
        // initialise instance variables
        super("Online", name, description );
        this.websiteURL = websiteURL;
    }

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
     *               If this has the attribute, but other does not, return a negative number.
     *               If this doesn't have the attribute, return a positive number.
     *               If neither has the attribute, return 0;
     *               This strategy will make it so that the items that DO have the attributeToCompareBy
     *               will end up at the beginning of a sorted list.
     *               other must be a Record. If not, we'll return 0;
     * POSTCONDITION: Neither this nor other is changed in any way. An integer is returned     
     */
    public int compareToBy(Record other, String attributeToCompareBy){ //??
        // [OH NO! IT GOT ERASED!]
       	if(other.hasAttribute(attributeToCompareBy) && this.hasAttribute(attributeToCompareBy)) {
    		if(attributeToCompareBy.equalsIgnoreCase("recordType")) {
    			if(this.getRecordType().compareTo(other.getRecordType()) > 0) {
    				return 1; 
    			}
    			else if(this.getRecordType().compareTo(other.getRecordType()) < 0) {
    				return -1; 
    			}
    			else {
    				return 0; 
    			}
    		}
    		else if(attributeToCompareBy.equalsIgnoreCase("websiteurl")) {
       			if(other instanceof OnlineRec) {
       				OnlineRec that = (OnlineRec) other; 
           			if(this.getWebsiteURL().compareTo(that.getWebsiteURL()) > 0) {
           				return 1; 
           			}
           			else if(this.getWebsiteURL().compareTo(that.getWebsiteURL()) < 0) {
           				return -1; 
           			}
           			else {
           				return 0; 
           			}
       			}
       			
       			else {
       				return -1; 
       			}
       		}

       		else if(attributeToCompareBy.equalsIgnoreCase("identifier")) {
	    		if(this.getIdentifier().compareTo(other.getIdentifier()) > 0) {
					return 1; 
				}
				else if(this.getIdentifier().compareTo(other.getIdentifier()) < 0) {
					return -1; 
				}
				else {
					return 0; 
				}
    		}
	    	else if(attributeToCompareBy.equalsIgnoreCase("description")) {
				if(this.getDescription().compareTo(other.getDescription()) > 0) {
					return 1; 
				}
				else if(this.getDescription().compareTo(other.getDescription()) < 0) {
					return -1; 
				}
				else {
					return 0; 
				}
	    	}
   	
    	}
    	else if(other.hasAttribute(attributeToCompareBy) && !this.hasAttribute(attributeToCompareBy)) {
    		return 1; 
    	}
    	else if(!other.hasAttribute(attributeToCompareBy) && this.hasAttribute(attributeToCompareBy)) {
    		return -1; 
    	}
    	else if(!other.hasAttribute(attributeToCompareBy) && !this.hasAttribute(attributeToCompareBy)) {
    		return 0; 
    	}
    	
    	return 0; 
    }
    
    /**
     * getWebsiteURL
     * -------------
     */
    public String getWebsiteURL(){
        // [OH NO! IT GOT ERASED!]
    	return this.websiteURL; 
    }
    
    /**
     * toString
     * --------
     * This provides a nice looking String representation of this particular Record
     * PRE: none
     * POST: current object is unchanged. A String is returned.
     */
    public String toString(){
        return this.identifier + " (" + this.websiteURL + "): \n" + niceLookingDescription() + "\n";
        
    }
}

