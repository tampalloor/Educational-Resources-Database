

/**
 * Movie
 * ----
 * This class holds a record of a movie.
 * 
 * @author Thomas Ampalloor
 */
public class Movie extends Record
{
    //public String name;
    //public String description;
    public String director;
    public int year;

    /**
     * Constructors for objects of class Movie
     */
    public Movie()
    {
        // initialise instance variables
        super("Movie", "unNamed Movie","blank description" );
        this.director = "UnNamed Director";
        this.year = 2021;
    }
    public Movie(String name, String description, String director, int year)
    {
        // initialise instance variables
        super("Movie", name, description );
        this.director = director;
        if (year < 1000 || year > 2021) year = 2021;
        else this.year = year;
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
    		else if(attributeToCompareBy.equalsIgnoreCase("director")) {
	    			if(other instanceof Movie) {
	    			Movie that = (Movie) other; 
	        		if(this.getDirector().compareTo(that.getDirector()) > 0) {
	        			return 1; 
	        		}
	        		else if(this.getDirector().compareTo(that.getDirector()) < 0) {
	        			return -1; 
	        		}
	        		else {
	        			return 0; 
	        		}
	    		}
	    		else {
	    			return 0; 
	    		}
    		}
    		else if(attributeToCompareBy.equalsIgnoreCase("year")) {
    			
	    		if(other instanceof Movie) {
	    			Movie that = (Movie) other; 
	    			if(this.year > that.getYear()) {
	    				return 1; 
	    			}
	    			else if(this.year < that.getYear()) {
	    				return -1; 
	    			}
	    			else {
	    				return 0; 
	    			}
	    		}
	    		else if(other instanceof Book) {
	    			Book that = (Book) other; 
	    			if(this.year > that.getYear()){
	    				return 1; 
	    			}
	    			else if(this.year < that.getYear()) {
	    				return -1; 
	    			}
	    			else {
	    				return 0; 
	    			}
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
				else if(this.getDescription().compareTo(other.getDescription())< 0) {
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
     * getDirector
     * -----------
     */
    public String getDirector() {
    	return this.director; 
    }

        // [OH NO! IT GOT ERASED!]
    
    /**
     * getYear
     * -------
     */
    public int getYear(){
        // [OH NO! IT GOT ERASED!]
    	return this.year;
    }
    
    
    /**
     * toString
     * --------
     * This provides a nice looking String representation of this particular Record
     * PRE: none
     * POST: current object is unchanged. A String is returned.
     */
    public String toString(){
        return this.identifier + " (" + this.year + "), directed by " + this.director + ": \n" + niceLookingDescription()+ "\n";
        
    }
}

