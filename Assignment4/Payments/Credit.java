package assignment_4.again.Payments;

import assignment_4.again.ControlCenter.Payment;
import assignment_4.again.ControlCenter.*;
import java.util.Date;
import java.text.DateFormat;

/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 * used for calculating credit payments in Assignment 4
 */
public class Credit extends Payment implements Authorization {
    DateFormat easy = DateFormat.getDateInstance(DateFormat.SHORT);
    private int cardNumber;
    private String cardType,expDate, name;
    
//CONSTRUCTORS for Credit object -------------------------------------------------------------  
/**
    * Credit
    * default constructor will set all instance variables with values which will return FALSE for authorization
 */
    public Credit(){
        super();
        expDate = easy.format(new Date());
        cardNumber = 0;
        cardType = "none Given";
        }

//MUTATORS for Check object -------------------------------------------------------------  
/**
    * setDate
    * method used to set the expiration date on a Credit card object
    * @param exp used to get the total amount due
 */
    public void setDate(String exp){
        expDate = exp;
    }
    
/**
    * setNum
    * method used to set the credit card number given for payment
    * @param cn used to register the card number
 */
    public void setNum(int cn){
        cardNumber = cn;
    }
    
/**
    * setName
    * method used to set the name on a credit card given for payment
    * @param shoban used to register the name on a credit card
 */
    public void setName(String shoban){
        name = shoban;
    }
    
/**
    * setType
    * method used to set the type for a credit card payment 
    * @param tiep used to register the kind of credit card being used
 */
    public void setType(String tiep){
        cardType = tiep;
    }
    

    @Override
    public void promptDue(){
        System.out.println("Please enter name on card:");
                    String answer = input.nextLine();
                    setName(answer);

                System.out.println("Please enter card type:");
                    answer = input.nextLine();
                    setType(answer);
                    
                System.out.println("Please enter card number:");
                    int banksy = input.nextInt(); 
                    input.nextLine();
                    setNum(banksy);
                    
                System.out.println("Please enter expire date for card: (mo/dd/yyy)");
                    answer = input.nextLine();
                    setDate(answer);
    }
    
    
 /**
    * authorized
    * method used to check if the form of payment is legal under company standards: 
    * true if name of customer equals name on card && card type matches Visa or MasterCard
    * @return result --- no local boolean variable just anonymous true/false values
 */ 
    @Override
    public boolean authorized(Customer c){
        if (name.equals(c.getName()) && (expDate.equals(easy.format(new Date()))!=true) && cardType.equalsIgnoreCase("Visa") || cardType.equalsIgnoreCase("MasterCard"))
            {return true;}
        else
            return false;}
    
}//END CLASS
