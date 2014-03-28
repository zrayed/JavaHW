package assignment_5;

import java.text.DecimalFormat;

/**
 * @author Corey Sattler
 * @version Assignment FIVE 1.0
 * Tuesday, Nov. 21, 2013
 */
/**
 * Class Description
 *  used for creating and object that can store a single letter and count value
 */
public class Sherlock  {
    private DecimalFormat fourPlaces = new DecimalFormat("#0.0000");
    private char symbol;
    private int count;
    public static int totalCount;
//CONSTRUCTORS for Sherlock object -------------------------------------------------------------  
/**
    * Sherlock
    * default constructor
 */
    public Sherlock (){
        symbol = 'a'; //start nothing just in case 
        count = 0; //local count for letter/character - start with 0 if no character set
    }
    
/**
    * Sherlock
    * constructor
    * @param incoming sets the character value to be counted over the course of a file
 */
    public Sherlock(char incoming){
        symbol = Character.toLowerCase(incoming);
        count = 1; //an instance of THE character has been recorded
        totalCount++; //an instance of a character has been recorded
    }
    
//MUTATORS for Sherlock object -------------------------------------------------------------   
 /**
    * setCount
    * mutator method used to change the count for a Sherlock object (i.e. document number of occurrence for Sherlock's char)
 */ 
    public void setCount(){
       count++; //for just cases of this character
       totalCount++;// for ALL characters in a document
    }
    
//ACCESSORS for Sherlock object -------------------------------------------------------------   
 /**
    * getCount
    * accessor method used to get a Sherlock's current count for given char/letter
    * @return count (actually returns a surface copy to prevent deep displacement of value)
 */
    public int getCount(){
     int result = count;
     return result;
    }

 /**
    * getSymbol
    * accessor method used to get a Sherlock's char which is being documented
    * @return symbol (actually returns a surface copy to prevent deep displacement of value)
 */
    public char getSymbol(){
        char result = symbol;
        return result;
    }
    
 /**
    * getTotal
    * accessor method used to get the total count for number of ALL char's between ALL Sherlock objects
    * @return totalCount (actually returns a surface copy to prevent deep displacement of value)
 */
    public static int getTotal(){
        int result = totalCount;
        return result;
    }
    
 /**
    * getTotal
    * accessor method used to calculate the frequency of a letter and then return it as a String -- 
    * would split this up into two separate methods (i.e. one for calculation, one for return formatting), but not required for this assignment
    * @return freq (a String formatted version of the counted integers cast to a double)
 */
    public String getFrequency(){
        double freq = (double)count/totalCount;
        return fourPlaces.format(freq); // NEED to format decimal to two places!!! in toString
    }
    
 /**
    * toString
    * formating display of a Sherlock object when printed as a String
 */
    @Override
    public String toString (){
        return Character.toUpperCase(getSymbol()) + " ---> " + getCount() + "/" + getTotal() + " letters in file = " + getFrequency();
    }

}//end CLASS
