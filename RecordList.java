

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * RecordList
 * ----------
 * RecordList is essentially an ArrayList of Records with a few sorting methods and display methods added.
 * 
 *
 * @author Thomas Ampalloor
 */
public class RecordList extends ArrayList<Record>
{
	
	public static int count = 1; 
    

    /**
     * Constructor for objects of class RecordList
     */
    public RecordList()
    {
        super();
    }

    
    /**
     * sortBy
     * ------
     * This sorts the Records by featureToSortBy.
     * This uses the Insertion Sort algorithm, since that one is stable
     * PRE: featureToSortBy describes one of the instance variables of at least one of the Records in the database,
     *      such that it is taken into account by that Record's compareToBy method.
     *      (If not, correct sorting is not guaranteed, but the program should not crash.)
     * POST: the records in the database are sorted in ascending order by the sorting criteria specified.
     */
    public void sortBy(String featureToSortBy){
        // [OH NO! IT GOT ERASED!] 
            for (int i = 1; i < this.size(); i++) {
                    Record current =  this.get(i);
                        int j = i-1;
                        
                        while ((j > 0) && (current.compareToBy(this.get(j),featureToSortBy) > 0)) {
                           overwrite((j+1), this.get(j)); //Overwrite helper method
                            j--;
                        }
                        overwrite((j+1), current); 
            }
            
            
            //Checks if the first element is in the right spot, if not then it sorts it accordingly 
            if(this.get(1).compareToBy(this.get(0), featureToSortBy) > 0) {
                int x = 1; 
                while(x < this.size() && this.get(0).compareToBy(this.get(x), featureToSortBy) < 0) {
               	 x++; 
                }
                Record current = this.get(0); 
                this.insert(current, x); 
                this.remove(0); 
                count++;
            }

     }
    
     /*
      * // NOTE FROM KAREN:
      * 
      * I got this Insertion Sort code from 
      * https://stackabuse.com/insertion-sort-in-java/
      * (I'll use it as a template for making my own insertSort -- sortBy -- that works with my own ArrayList/RecordList)
      * 
      * public static void insertionSort(int array[]) {
      *     for (int i = 1; i < array.length; i++) {
      *         int current = array[i];
      *         int j = i-1;
      *         while ((j > -1) && (array[j] > current)) {
      *             array[j+1] = array[j];
      *             j--;
      *         }
      *         array[j+1] = current;
      *     }
      * }
      */
    
    
    
    /**
     * swap
     * ----
     * If you're gonna sort an ArrayList, 
     * you might need a way to swap the elements of our ArrayList by index.
     * PRE: indices refer to elements in the arrayList.
     * POST: elements at indices a and b will have swapped places (the memory locations)
     */
    private void swap(int a, int b){
         // [OH NO! IT GOT ERASED!]
         // [EVEN IF YOU DON'T END UP USING THIS METHOD IN YOUR SORT, CREATE IT.]
    	if(this.get(a) instanceof Book) {
    		Book current = (Book) this.get(a); 
    		this.set(a, this.get(b));
    		this.set(b, current);
    	}
    	else if(this.get(a) instanceof Movie) {
    		Movie current = (Movie) this.get(a);
    		this.set(a, this.get(b));
    		this.set(b, current);
    	}
    	else if(this.get(a) instanceof OnlineRec) {
    		OnlineRec current = (OnlineRec) this.get(a); 
    		this.set(a, this.get(b));
    		this.set(b, current);
    	}

    }
    
    /**
     * overwrite
     * ---------
     * This method overwrites the elements at index i with Record r,
     * so long as there is an element at index i.
     * PRE: there's an element at i
     * POST: overwrites element at i with r.
     */
    private void overwrite(int i,Record r){
         // [OH NO! IT GOT ERASED!]
         // [EVEN IF YOU DON'T END UP USING THIS METHOD IN YOUR SORT, CREATE IT.]
    	this.set(i, r);
    }
    
    /**
     * displayAllRecords
     * -----------------
     * This prints to the screen a nice representation of all the records in their current order
     * Each record is on its own line.
     * PRE: none
     * POST: none.
     */
    public void displayAllRecords(){
         // [OH NO! IT GOT ERASED!]
    	for(int i =0; i <this.size(); i++) {
    		if(this.get(i) instanceof Book) {
    			System.out.println("Book: ");
        		System.out.println(this.get(i));

    		}
    		else if(this.get(i) instanceof Movie) {
    			System.out.println("Movie: ");
        		System.out.println(this.get(i));

    		}
    		else if(this.get(i) instanceof OnlineRec) {
    			System.out.println("Online: ");
        		System.out.println(this.get(i));

    		}
    	}
    	
        
    }
    
    /**
     * displayRecordsOfRecordType()
     * ----------------------------
     * This prints to the screen a nice representation of all the records in the RecdordList 
     * whose recordType matches the parameter recType.  It displays them in their current order.
     * Each record is on its own line.
     * PRE: r must be a recordType of at least some records, or else it will display no records.
     * POST: none
     */
  public void displayRecordsOfRecordType(String recType){
  // [OH NO! IT GOT ERASED!]
  // [EVEN IF YOU DON'T END UP USING THIS METHOD IN YOUR SORT, CREATE IT.]

	if(recType.equalsIgnoreCase("Movie")) {
		for(int i =0; i < this.size(); i++) {
			if(this.get(i) instanceof Movie) {
				System.out.println(this.get(i));
			}
		}

	}
	else if(recType.equalsIgnoreCase("Online")) {
		for(int i =0; i < this.size(); i++) {
			if(this.get(i) instanceof OnlineRec) {
				System.out.println(this.get(i));
			}
		}
	}
	else if(recType.equalsIgnoreCase("Book")) {
		for(int i =0; i < this.size(); i++) {
			if(this.get(i) instanceof Book) {
				System.out.println(this.get(i));
			}
		}
	}
}

    
  
}

