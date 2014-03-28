package assignment_2.again;
/**
 * @author Corey Sattler
 * @version Assignment TWO 1.0
 * October 3, 2013
 */
/**
 * Class Description
 * sub class used for running Binary Search for Question 3
 *  * @param list array object for searching
 * @param keye magic key being looked for by the search
 */
public class BinarySearch {
    public void BinarySearch (){
    
    }
    
    public static int binarySearch (int [] list, int keye){
        int low = 0;
        int high = list.length -1;
        
        while (high >= low){
            int mid = (low + high)/2;
            if (keye <list[mid])
                    high = mid -1;
            else if (keye == list[mid])
                    return mid;
            else
                low = mid + 1;
        }
        return -low - 1;
        }
    
    }
