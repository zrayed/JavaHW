package assignment_2.again;
/**
 * @author Corey Sattler
 * @version Assignment TWO 1.0
 * October 3, 2013
 */
/**
 * Class Description
 * sub class used for running Linear Search for Question 3
 * @param list array object for searching
 * @param f magic key being looked for by the search
 */
public class LinearSearch {
        public static int linearSearch (int[] list, int f){
        for (int i = 0; i < list.length; i++){
            if (f == list[i])
                return i;
        }
        return -1;
    }  
 }
