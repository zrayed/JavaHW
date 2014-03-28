package assignment_4.again.ControlCenter;

import java.util.Scanner;
import assignment_4.again.Payments.*;
import java.text.NumberFormat;

/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 * used for operating methods from other classes within a Console Object for question 1 in Assignment 4
 */
public class Register {
    private Credit cred = new Credit();
    private Check ck = new Check();
    private Cash ch = new Cash();
    private String answer;
    private Scanner input;
    private boolean inStore;
    private boolean nonPro, end = false;
    private Customer currentClient;
    private Order nextOrder;
    private OrderDetail toPurchase;
    private Item thing;
    NumberFormat moneyHere = NumberFormat.getCurrencyInstance();

     
//CONSTRUCTORS for Register object -------------------------------------------------------------  
/**
    * Register
    * default constructor
 */
    public Register(){
        input = new Scanner(System.in);
        inStore = true;}
    
//METHODS for Order object ------------------------------------------------------
 /**
    * runRegister
    * method used to generate Orders
    * would return an object Receipt if time allowed (i.e. create a Receipt class)
 */
    public void runRegister(){ //create a class for this object
        System.out.println("Is this order for delivery? (Y/N)");
        answer = input.nextLine();
            if (answer.equalsIgnoreCase("y"))
                inStore = false;
            else
                inStore = true;
            
            System.out.println("Please scan or enter the name of our Customer: ");
                answer = input.nextLine();

                            int setter = 0;
                       for (int i = 0; i < Console.allCustomers.size(); i++){
                           if(answer.equals(Console.allCustomers.get(i).getName())){
                             currentClient = Console.allCustomers.get(i); setter = i;}
                         }
                       if(answer.equals(Console.allCustomers.get(setter).getName()) != true)
                          { currentClient = new Customer(answer);
                            System.out.println("Please enter an address for our new customer:  "); 
                            String addy = input.nextLine();
                            currentClient.setAddress(addy);
                            Console.allCustomers.add(0, currentClient);
                            }
                       nextOrder = new Order(inStore); //create new order
                                if(inStore != true){nextOrder.setAddress(currentClient);}//this is extremely ineffcient despite being required by Assigment's definition of "Association"
                       currentClient.addOrder(nextOrder); // assign order number to customer's history, which is again, inefficient, but required by the assigment

            System.out.println("Is this a non-profit organization? (Y/N)");
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("y")){
                        nonPro = true;}
                    else{nonPro = false;}   
            System.out.println("What would " + currentClient.getName() + " like to order?");
                    int choice = input.nextInt();
                    input.nextLine(); // clear buffer

                    thing = new Item(choice);
            System.out.println("How many " + thing.getItem() +"?"); 
                    int quant = input.nextInt();
                    input.nextLine(); // clear buffer
                    
                    toPurchase = new OrderDetail(quant, nonPro);
                        toPurchase.calcSubTotal(thing); //set subTotal for Detail
                        toPurchase.setDescription(thing);
                        if(inStore == false){toPurchase.calcWeight(thing);}//set subWeight IF delivery - would develop but not req.
                            nextOrder.addDetail(toPurchase); // ADD detail to ArrayList for final calculations
                    //System.out.println();
            System.out.println("Is that all for today? (Y/N)"); 
                    answer = input.nextLine();
                    if (answer.equalsIgnoreCase("y")){
                        end = true;}
                    else{end = false;}
                    
                    if(end == true){
                      Console.allOrders.add(nextOrder);
                    }
                    else{
                        do{ System.out.println("What else would " + currentClient.getName() + " like to order?");
                            choice = input.nextInt();
                            input.nextLine(); // clear buffer

                            thing = new Item(choice);
                        System.out.println("How many " + thing.getItem() +"?"); 
                            quant = input.nextInt();
                            input.nextLine(); // clear buffer

                            toPurchase = new OrderDetail(quant, nonPro);
                            toPurchase.calcSubTotal(thing); 
                            toPurchase.setDescription(thing);
                                if(inStore == false){toPurchase.calcWeight(thing);}
                                    nextOrder.addDetail(toPurchase); 

                            System.out.println("Is that all for today? (Y/N)");
                                answer = input.nextLine();
                                    if (answer.equalsIgnoreCase("y")){end = true;}
                                    else{end = false;}
                        }
                        while(end != true);
                            Console.allOrders.add(nextOrder);//Order completed, add to list of running orders today
                    }
                    printReceipt();
                    Payment.setPayment(nextOrder);//set Amount for all payment classes to operate on

                    System.out.println("How would you like to pay? (Credit/Cash/Check)");
                          String payment = input.nextLine();
                          payMe(payment);
                            boolean test = findAmount();
                            if(findAmount() != true){//PROVES abstract class through shared static value of double "amount"
                                do{
                                    System.out.println(moneyHere.format(Payment.getAmountDue()) + " still due.  Please select another method of payment to finish off your tab: (Credit/Cash/Check)");
                                    payment = input.nextLine();
                                    payMe(payment);
                                    test = findAmount();//needed to prevent early termination
                                    } 
                                    while(test != true);
                            }
                    nextOrder.setStatus(3);//once AmountDue = 0, can set order as paid
                    currentClient.addOrder(nextOrder); //document the customer's order - would get passed to an outside list for ref. but not neccessary for assigment
                    Console.exportLog();   //send to day log for back up
                    Console.welcome();      //re prompt user
    } //END runRegister method    
    
    
//Helper methods for runRegister ------------------------------------------------------
 /**
    * printReceipt
    * private helper method used to print a receipt after an order is finished being placed
 */
    private void printReceipt(){
        System.out.println("\nCOMPANY NAME                                  " + nextOrder.getDate());
        System.out.println("                     ORDER" + nextOrder.getOrder() + "\n" + nextOrder.getList());
        System.out.println("----------------------------------------------"); 
        System.out.println("Sub Total: " + nextOrder.moneyOut.format(nextOrder.calcRevenue()) + "\nTax Due: " + nextOrder.moneyOut.format(nextOrder.calcTax()) + "\nTotal Due: " + nextOrder.moneyOut.format(nextOrder.calcTotal()) + "\n");
        if(nextOrder.getType().equals("Delivery")){System.out.println("SHIPPING TO: " + nextOrder.getAddress() + "\n"); 
            }
        System.out.println("THANK YOU " + currentClient.getName() + "!\n");}
    
 /**
    * payMe
    * private helper used to prompt a user for payment and run methods from Payment subClasses
    * @param x is used to find out which type of payment a Customer wants to use
 */ 
    private void payMe(String x){
                if(x.equalsIgnoreCase("credit"))
                    {cred.promptDue();
                     cred.authorized(currentClient);
                     System.out.println("Authorizing......one moment please");
                            if(cred.authorized(currentClient) == true)
                                {System.out.println("How much would you like to pay with this credit card?");
                                    double given = input.nextDouble();
                                    input.nextLine();
                                        cred.calcDue(given);
                                    System.out.println(moneyHere.format(given) + " was charged to " + currentClient.getName() + "\n");

                            } else {System.out.println("Sorry...we cannot accept this form of payment.  Please try another form of payment:");
                                System.out.println("Please pick cash or check:");
                                    answer = input.nextLine();
                                        payMe(answer);
                                    } 
                    }//end for CREDIT
                else{
                    if(x.equalsIgnoreCase("check"))
                        {ck.promptDue();
                            ck.authorized(currentClient);

                        System.out.println("Authorizing......one moment please");
                            if(ck.authorized(currentClient) == true)
                                {System.out.println("How much would you like to pay with this check?");
                                    double given = input.nextDouble();
                                    input.nextLine();
                                    ck.calcDue(given);
                                System.out.println(moneyHere.format(given) + " will be processed in 2-4 business days.\n"); 

                            } else {System.out.println("Sorry...we cannot accept this form of payment.  Please try another form of payment:");
                            System.out.println("Please pick cash or credit:");
                                answer = input.nextLine();
                                payMe(answer);
                            } 
                    }//end for CHECK
                    else{ch.promptDue();}
                  }
 }//end payMe method
   
 /**
    * findAmount
    * private helper used to compare AmountDue with a zero balance to test if bill is paid off
 */ 
    private boolean findAmount(){
        boolean zero;
            if(moneyHere.format(Payment.getAmountDue()).equals("$0.00") == true)
                zero = true;
            else
                zero = false;
        return zero;
    }
     
}// END CLASS
