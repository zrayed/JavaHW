package assignment_4.again.ControlCenter;

import java.text.NumberFormat;
import java.util.Scanner;
/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 *  used for generating a payment in Assignment 4
 */
public abstract class Payment {
    protected NumberFormat moneyOut = NumberFormat.getCurrencyInstance();
    protected static Scanner input = new Scanner(System.in);
    protected static double amount;
    protected Order finalOrder;
    
//CONSTRUCTORS for Payment object -------------------------------------------------------------  
/**
    * Payment
    * default constructor
 */
    public Payment(){
    amount = 0.0;
    }
   
//MUTATORS for Payment object -------------------------------------------------------------  
/**
    * setPayment
    * mutator method 
    * @param nextO used to set the final amount due for an order
 */
    public static void setPayment(Order nextO){
        amount = nextO.getTotal(); 
    }
    
 /**
    * calcDue
    * protected Mutator method for subClasses to calculate if any more money is due on the order
 */  
    protected void calcDue(double given){
        amount-= given; //set amount to new amount due
    }
    

//ACCESSORS for Payment object -------------------------------------------------------------   
 /**
    * getAmountDue
    * accessor method used to get a Payment's final amount due
    * @return result -- a local variable displaying the amount as a formatted currency String
 */  

    public static double getAmountDue(){
        double result = amount;
        return result;
    }
    
 /**
    * promptDue
    * abstract method for subClasses to specialize how a payment is handled
 */  
    public abstract void promptDue();

}//END Class
