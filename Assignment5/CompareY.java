package assignment_5;

import java.util.Comparator;

/**
 * @author Corey Sattler
 * @version Assignment FIVE 1.0
 * Tuesday, Nov. 21, 2013
 */
/**
 * Class Description
 *  used for creating a library object that can command the file access
 */
public class CompareY implements Comparator <Point>{

    public CompareY(){}
    
    @Override
    public int compare(Point one, Point two) {
        if(one.getY() > two.getY())
            return 1;
        else{
            if(one.getY() < two.getY())
          	return -1;
            else{      
                if(one.getX() > two.getX())
                    return 1;
                else{
                    if(one.getX() < two.getX())
                        return -1;
                else 
                    return 0;}
            }
        } 
    }
    
    
} //end Class
