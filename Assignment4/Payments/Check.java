package assignment_4.again.Payments;

import assignment_4.again.ControlCenter.Payment;
import assignment_4.again.ControlCenter.*;
import java.util.ArrayList;

/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 * used for calculating check payments in Assignment 4
 */

public class Check extends Payment implements Authorization {
    private String name;
    private int bankID;
    
//CONSTRUCTORS for Check object -------------------------------------------------------------  
/**
    * Check
    * default constructor
 */
    public Check(){
        super();
        name = "none Given";
        bankID = 0;
        runBad();} //intialize the badID's a check cannot use
    
//MUTATORS for Check object -------------------------------------------------------------   
 /**
    * setBank
    * mutator method used to set the bankID on a Customer's check
    * for comparison to a private list of badID's
 */ 
    public void setBank(int bk){
        bankID = bk;}
    
 /**
    * setName
    * mutator method used to set the name on a check given as payment
    * to be compared to the customer's name on an order
 */ 
    public void setName(String shoban){
        name = shoban;}
   
//INTERFACE for Check object -------------------------------------------------------------   
 /**
    * authorized
    * method used to check if the form of payment is legal under company standards: 
    * true if customer name equals name on check && BankID is not found to be on the badID ArrayList
    * @return result --- local boolean variable
 */ 
    @Override
    public boolean authorized (Customer c){
        boolean result = true;
        if (name.equals(c.getName()) && checkBadID() != true)
            {result = true;}
        else{
        if (name.equals(c.getName())!=true){
            System.out.println("Sorry, we only accept checks with names matching the customer placing an order.  Please try an alternative method of payment:");
            result = false;}
        else{System.out.println("Sorry, that BankID has proven to be unaccessible in the past.  Please try an alternative method of payment:");}
        }
        return result;
    }  
    
    
    @Override
    public void promptDue(){
            System.out.println("Please enter name on check:");
                    String answer = input.nextLine();
                    setName(answer);
                System.out.println("Please enter bank ID:");
                    int banksy = input.nextInt();
                    input.nextLine();
                    setBank(banksy);
    }
    

//HELPER METHODS for Credit object ------------------------------------------------------
 /**
    * checkBadID
    * private method used to compare a Customer's check to a list of banned Bank Accounts
    * @return result -- a local boolean which holds true if the customer's ID matches one on the list of bad IDs
 */
    private boolean checkBadID(){
        boolean result = false;
        for(int i = 0; i < bad.size(); i++){
            if(bankID == bad.get(i))
               result = true;
            else
                result = false;
            }
        return result;
    }
    
 /**
    * runBad
    * private method used to store an ArrayList of banned Bank Accounts
    * would extend to allow user to enter new badID's if time allowed
 */
    private ArrayList<Integer> bad = new ArrayList<>();
      
 /**
    * runBad
    * private method used to initialize the list of banned Bank Accounts for each check payment
 */
    private void runBad(){
       bad.add(10000401);
       bad.add(10000405);
       bad.add(1066780401);
       bad.add(155552801);
       bad.add(1111200401);
       bad.add(1405);
       bad.add(180401);
       bad.add(1580144);
    }
    
 /**
    * addBad
    * Mutator method used to hypothetically add new badID's to a list of banned Bank Accounts
 */
    public void addBad(int nowBad){
        bad.add(nowBad);
    }

}//END CLASS
