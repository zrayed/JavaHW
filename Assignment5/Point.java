package assignment_5;

/**
 * @author Corey Sattler
 * @version Assignment FIVE 1.0
 * Tuesday, Nov. 21, 2013
 */
/**
 * Class Description
 *  MAIN used for running methods in Assignment 4
 */
public class Point implements Comparable<Point> {
    private int x;
    private int y;
//CONSTRUCTORS for Point object -------------------------------------------------------------  
/**
    * Point
    * default constructor
 */  
    public Point(){
        x = 0;
        y = 0;
    }
    
/**
    * Point
    * constructor
    * @param x sets x coordinate
    * @param y sets y coordinate
 */ 
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    
//ACCESSORS for Point object -------------------------------------------------------------   
 /**
    * getX
    * accessor method used to get Point's x-value
    * @return x (actually returns a deep copy of value)
 */

    public int getX(){
        int temp = x;
        return temp;
    }
    
 /**
    * getY
    * accessor method used to get Point's y-value
    * @return y (actually returns a deep copy of value)
 */    
   public int getY(){
        int temp = y;
        return temp;
    }
    
//METHODS for Point object ------------------------------------------------------
/**
    * randomNum
    * method used to create a random number from 0-600
    * @return temp*randomValue() which gives the random number a +/- value
 */ 
    public static int randomNum(){
        int temp = (int)(Math.random()*601); 
        return temp*randomValue();
        }
       
 /**
    * randomValue
    * private helper method for assigning a positive/negative value to randomNum
    * @return tem which is a based on a simple random number generator for 0 to 4 = positive
 */ 
    private static int randomValue(){
        int tem = (int)(Math.random()*10); 
        if(tem < 5)
            {return -1;}
        else
            return 1;
    }

 /**
    * compareTo
    * method used to compare two Points based on x-value
    * @param other other Point to be compared
 */
    @Override
    public int compareTo(Point other){
        int mark = 0;
        if(x > other.getX())
            mark = 1;
        else{
             if(x < other.getX())
                mark = -1;
            else{
                 if(x == other.getX()){
                    if(y > other.getY())
                 	mark = 1;
                    else{
                         if(y < other.getY())
                            mark = -1;
                         else
                             mark = 0;
			}
                 }     
            }
        }
        return mark;
    }
    
 /**
    * toString
    * formating display of a Point object when printed as a String
 */
    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";}
}//end Class
