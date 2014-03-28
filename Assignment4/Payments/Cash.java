package assignment_4.again.Payments;

import assignment_4.again.ControlCenter.Payment;

/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 * used for calculating Cash payments in Assignment 4
 */
public class Cash extends Payment {
    private double cashTendered;
    private double changeDue;
    
//CONSTRUCTORS for Cash object -------------------------------------------------------------  
/**
    * Cash
    * default constructor
 */
    public Cash(){
        super();
        cashTendered = 0.0;
        changeDue = 0.0;
    }
    

/**
    * promptDue
    * used to calculate cash exchange
 */
    @Override
    public void promptDue(){
        System.out.println("How much was received in cash?");
                    double pay = input.nextDouble();
                    input.nextLine();
         changeDue(pay);
    }
    
    
//HELPER METHOD for Cash object ------------------------------------------------------
 /**
    * changeDue
    * private helper method used to calculate how much change should be returned to a Customer
    * @param given amount provided by customer 
 */
    private void changeDue(double given){
        cashTendered = given;
        changeDue = given - amount;
        if(cashTendered < amount){
            System.out.println("Not enough money to complete order.  Please ask for " + moneyOut.format(amount - cashTendered) + " to complete the order");
                amount-= cashTendered;}
        else
            {System.out.println("Payment received: " + moneyOut.format(cashTendered) + "\nCHANGE DUE: " + moneyOut.format(changeDue) + "\n");
                amount = 0.0;}
    }
    
} // END CLASS
