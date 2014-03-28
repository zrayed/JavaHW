package assignment_4.again.Payments;

import assignment_4.again.ControlCenter.Customer;

/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 * interface used for checking authorization on payments other than cash in Assignment 4
 */
public interface Authorization {
    
 /**
    * authorized
    * interface method for subClasses to find out if a method of payment can be used
    * @param c is used to use Customer details to verify type of payment chosen defined in each subClass
 */  
    public boolean authorized (Customer c);

} //END Interface

