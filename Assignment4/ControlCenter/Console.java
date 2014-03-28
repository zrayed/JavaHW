package assignment_4.again.ControlCenter;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 *  used for prompting a user for question 1 in Assignment 4
 *  and to store orders for the day and then export them to a commom file for all
 *  sales over lifetime of the store
 */

public class Console {
    public static ArrayList<Order> allOrders = new ArrayList<>();
    public static ArrayList<Customer> allCustomers = new ArrayList<>();
    private int command;
    private Register getMoney;
    private int counter = 0;
    private boolean close;

 /**
    * Default Constructor
    * to initialize class variables for a Console object
 */
    public Console(){
        if(counter == 0){Customer c = new Customer(); allCustomers.add(c);} //needed to initialize software for comparison to Customer List for the day -- would need to make this a continuous log of customer names
        //if(counter == 0){Order o = new Order(); allOrders.add(o);} //needed to initialize software
        else counter++;//required for initializing software
        command = 0;
        close = false;
        getMoney = new Register();}
    
  /**
    * runConsole
    * method used to generate an interface for the user to control various commands(i.e. other methods)
     * @param user takes an integer command from the user based on the welcome screen
 */ 
    public void runConsole(){
        switch(command){
            case 0: welcome(); break;
            case 1: getMoney.runRegister(); break;
            case 2: displayMenu(); break;
            case 3: readLog(); break;
            case 4: System.out.println("Under development -- please pick another option:"); welcome(); break;
            case 5: readEntireLog(); break;
            case 6: exitNow(); break;
        }
    }
    
    public void runConsole(int user){
        command = user;
        switch(command){
            case 0: welcome(); break;
            case 1: getMoney.runRegister(); break;
            case 2: displayMenu(); break;
            case 3: readLog(); break;
            case 4: System.out.println("Under development -- please pick another option:"); welcome(); break;
            case 5: readEntireLog(); break;
            case 6: exitNow(); break;
            default: System.out.println("That command does not exist - sorry!!!"); break;
        }
    }
    
//METHODS for runConsole method -------------------------------------------------------------   
 /**
    * exportLog
    * method used to store sales for the day in common file for temporary reference with TRY/CATCH for FileNotFoundException
     * 
 */
      protected static void exportLog(){
         PrintWriter outputStream = null;
                try{
                  outputStream = new PrintWriter(new FileOutputStream("runningActivityLog.txt", true));}
                   catch (FileNotFoundException emc){
                   System.out.println("File Not Found!!!");
                   }
                   System.out.println("Writing contents to file...\n");
                        String temp = "";
                        int addTo = allOrders.size();
                        temp+= allOrders.get(addTo-1);
                        outputStream.println(temp);
                   outputStream.close();

    }  

 /**
    * exportStampLog
    * method used to export all final sales for the day to a common file for storage with TRY/CATCH for FileNotFoundException
     * 
 */
      protected static void exportStampLog(){
         PrintWriter outputStream = null;
         PrintWriter emptyDaylog = null;
                try{
                  outputStream = new PrintWriter(new FileOutputStream("finalActivityLog.txt", true));
                   emptyDaylog = new PrintWriter(new FileOutputStream("runningActivityLog.txt"));}//to help clear activity log at end of day AFTER exporting total day's sales
                 catch (FileNotFoundException emc){
                   System.out.println("File Not Found!!!");
                   }
                   System.out.println("Exporting contents to finalActivityLog.txt ...");
                        outputStream.println("END of Activity ------------------ (Stamped) " + new Date() + " -----------------------\n");
                        for(int i = 0; i < allOrders.size(); i++){
                            outputStream.println(allOrders.get(i));
                        }
                   outputStream.close();
                   emptyDaylog.close();//clear the daily list of orders for re-use
    } 
      
 /**
    * readLog
    * method used to read the runningActivityLog file while active in the Console (all sales in one day)
 */
        public void readLog(){
         Scanner input = null;
                try{
                   input = new Scanner(new FileInputStream("runningActivityLog.txt"));}
                catch (FileNotFoundException emc){
                   System.out.println("File Not Found!!!");
                   }
                   System.out.println("Getting contents to runningActivityLog.txt ...\n");
                   String constant = "";
                   while(input.hasNextLine()){
                       constant = input.nextLine();
                       System.out.println(constant);
                   }
                   input.close(); 
                   welcome();
    } 

 /**
    * readLog
    * method used to read the finalActivityLog file while active in the Console (all sales, all time)
 */
        public void readEntireLog(){
         Scanner input = null;
                try{
                   input = new Scanner(new FileInputStream("finalActivityLog.txt"));}
                catch (FileNotFoundException emc){
                   System.out.println("File Not Found!!!");
                   }
                   System.out.println("Getting contents to finalActivityLog.txt ...\n");
                   String constant = "";
                   int count = 0;
                   while(input.hasNextLine()){
                       constant = input.nextLine();
                       count++;
                       System.out.println(constant);
                   }
                   input.close(); 
                   welcome();
    } 
        
//HELPERS for runConsole method -------------------------------------------------------------
 /**
    * welcome
    * method used to print main menu options for runConsole
 */
    protected static void welcome(){
        System.out.println("Thanks for using Quick Order (TM)!  Here are the available commands: ");
        System.out.println("1. Run Register");
        System.out.println("2. Display Cafe Menu");
        System.out.println("3. Review Today's Sales");
        System.out.println("4. See Customer List");
        System.out.println("5. Review ALL Sales (before today)"); //readEntireLog()
        System.out.println("6. Close Register");
        System.out.println("\nPlease enter a command to continue:");
    } 
 
  /**
    * displayMenu
    * method used to print out available menu options based on the cafe's inventory
 */    
    private void displayMenu(){
        System.out.println("*~ TIP ~* You can only place orders once you run the register: ");
        System.out.println(" 1. Small Coffee");
        System.out.println(" 2. Medium Coffee");
        System.out.println(" 3. Large Coffee");
        System.out.println(" 4. 1 lb bag of Coffee");
        System.out.println(" 5. 2 lb bag of Coffee");
        System.out.println(" 6. 5 lb bag of Coffee");
        System.out.println(" 7. Plain Bagel(s)");
        System.out.println(" 8. Everything Bagel(s)");
        System.out.println(" 9. Assorted Bagels");
        System.out.println("10. Chocolate Muffin(s)");
        System.out.println("11. Bananna Muffin(s)");
        System.out.println("12. Blueberry Muffin(s)");
        System.out.println("\nPlease enter a command to continue:"); 
    }    
        
 /**
    * exitNow
    * method used to end runConsole
 */
    private void exitNow(){
        //export one last time
        //display file
        exportStampLog();
        close = true; //exit
    }   
    
  /**
    * getStatus
    * method used to check the status of the Console object as an extension of the Register (i.e. open or closed for the day)
     * @return boolean close 
 */
    public boolean getStatus(){
        boolean status = close;
        return status;
    }

 /**
    * addTo
    * method used to add an order to the allOrders ArrayList
    * @param Order nextO 
 */
    public void addTo(Order nextO){
       allOrders.add(0, nextO);}
    
 /**
    * addTo
    * method used to add an order to the allCustomers ArrayList
    * @param Customer nextClient
 */
    public void addTo(Customer nextClient){
       allCustomers.add(0, nextClient);}
  
}//END CLASS
