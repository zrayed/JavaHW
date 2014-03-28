package assignment_4.again.ControlCenter;

import java.util.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.text.NumberFormat;

/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description: 
 * Order class used for creating new cafe orders in Assignment 4
 */

public class Order {
    DateFormat easy = DateFormat.getDateInstance(DateFormat.SHORT);
    NumberFormat moneyOut = NumberFormat.getCurrencyInstance();
    public static int orderCount = 0; 
    private String address;
    private int orderNumber, status;
    private ArrayList<OrderDetail> list = new ArrayList<>(); //AGGREGATION
    private Date date;
    private boolean type;
    private double total, totalTax, revenue;
    private static final double taxAmount = .07;
    
//CONSTRUCTORS for Order object -------------------------------------------------------------  
/**
    * Order 
    * default constructor
 */
    public Order(){
        date = new Date();
        status = 1; //order not complete/unpaid
        type = true; // "IN STORE"
        orderCount++; //keep tally of orders
        orderNumber = orderCount;  //assign order number
        total = 0.0;
        totalTax = 0.0;
        revenue = 0.0;
    }
    
/**
    * Order 
    * constructor
    * @param type sets if the order is in-store or for delivery
    * @param kNew sets an order's association with Customer and sets default shipping address to client's home address
 */
    public Order(boolean type){
        date = new Date();
        status = 1; 
        this.type = type; 
        orderCount++; 
        orderNumber = orderCount;  
        total = 0.0;
        totalTax = 0.0;
        revenue = 0.0;
    }
    
//METHODS for Order object ------------------------------------------------------
 /**
    * addDetail
    * method used to place OrderDetail into an Order's ArrayList list
 */
   public void addDetail(OrderDetail nextO){
       list.add(nextO);}
   
 /**
    * calcTax
    * public method used to calculate an Order's total Tax due by running through its ArrayList of OrderDetails
    * @return totalTax
 */
    public double calcTax(){
        int newRevenue = (int)revenue;
            if(list.get(0).getStatus() == true)
                totalTax = 0.0;
            else
                totalTax = newRevenue*taxAmount;
            return totalTax;
    }
  
 /**
    * calcRevenue
    * public method used to calculate an Order's Revenue (or subTotal) due by running through its ArrayList of OrderDetails
    * @return revenue
 */
    public double calcRevenue(){
        for(int i = 0; i < list.size(); i++){
            revenue += calcRevenue(list.get(i)); 
        }
        return revenue;
    }       
    
 /**
    * calcRevenue
    * private helper method used to calculate an Order's Revenue (or subTotal) due
    * @param toPurchase used to get an orderDetail's subtotal
 */
    private double calcRevenue(OrderDetail toPurchase){
        revenue = toPurchase.getSubTotal();
        return revenue;}
    
 /**
    * calcTotal
    * public method used to calculate an Order's total amount due due by running through its ArrayList of OrderDetails
    * @return total
 */
    public double calcTotal(){
        for(int i = 0; i < list.size(); i++){
            total += calcTotal(list.get(i)); 
        }
        total+= calcTax();
        return total;
    }  
    
 /**
    * calcTotal
    * private helper method used to calculate an Order's Revenue (or subTotal) due
    * @param toPurchase used to calculate a single orderDetail object's subTotal and tax amount
 */
    private double calcTotal(OrderDetail toPurchase){
        total = toPurchase.getSubTotal();
        return total;
    }
    
 /**
    * calcTotalWeight
    * public method used to calculate an Order's total weight - not extended/operable anywhere because was told not important to assignment
    * @return weight (local variable as entire sum of all objects in ArrayList list)
 */    
    public double calcTotalWeight(){
        double weight = 0.0;
        for(int i = 0; i < list.size(); i++){
            weight += calcTotalWeight(list.get(i)); 
        }
        return weight;
    }   
     
 /**
    * calcTotalWeight
    * private helper method used to calculate an Order's weight
    * @param toPurchase used to calculate a single orderDetail object's weight
 */
    private double calcTotalWeight(OrderDetail toPurchase){
        double totalWeight;
        totalWeight = toPurchase.getSubWeight();
        return totalWeight;
    }     
//ACCESSORS for Order object -------------------------------------------------------------------
 /**
    * getStatus
    * accessor method used to get the status of an order
    * @return stat -- a local String variable description of the status variable based on type
 */
        public String getStatus(){
            String stat;
            if(type == true){
            switch(status){
                case 1: stat = "Unpaid"; break;
                case 2: stat = "Served"; break;
                case 3: stat = "Paid"; break;  
                case 4: stat = "Tab"; break;
                default: stat = "New";break;}
            }
            else{switch(status){
                case 1: stat = "Unpaid"; break;
                case 2: stat = "Put on Tab"; break;
                case 3: stat = "Paid"; break;
                case 4: stat = "Packaged"; break;
                case 5: stat = "Shipped"; break;
                case 6: stat = "Recieved"; break;
                case 7: stat ="Completed"; break;
                default: stat = "New";break;}
            }
            return stat;}//end getStatus
              
 /**
    * getDate
    * accessor method used to get an Order's date of order
    * @return date (actually returns a surface copy to prevent deep displacement of value) -- formatted to dd/mm/yyyy
 */
    public String getDate(){
            Date m = date;
            return easy.format(m);}
        
 /**
    * getType
    * accessor method used to get an Order's type (in-store or delivery)
    * @return p a local String variable based on if type is true/false (in-store/delivery)
 */
    public String getType(){
        String p;
            if (type == true)
                p = "In-store";
            else
                p = "Delivery";
        return p;}
    
 /**
    * getOrder
    * accessor method used to get an Order's assigned order number
    * @return orderNumber (actually returns a surface copy to prevent deep displacement of value)
 */
    public int getOrder(){
        int temp = orderNumber;
        return temp;}
    
 /**
    * getTotal
    * accessor method used to get an Order's total amount of money due
    * @return total (actually returns a surface copy to prevent deep displacement of value)
 */
    public double getTotal(){
        double temp = total;
        return temp;}
 /**
    * getTax
    * accessor method used to get an Order's amount of tax due on the order
    * @return totalTax (actually returns a surface copy to prevent deep displacement of value)
 */
    public double getTax(){
        double temp = totalTax;
        return temp;}
    
 /**
    * getRevenue
    * accessor method used to get an Order's amount of revenue generated by the order (a.k.a. subTotal)
    * @return revenue (actually returns a surface copy to prevent deep displacement of value)
 */
    public double getRevenue(){
        double rev = revenue;
        return rev;}
    
 /**
    * getAddress
    * accessor method used to get the customer associated with this order's shipping address
    * @return address (actually returns a surface copy to prevent deep displacement of value)
 */
    public String getAddress(){
        String ad = address;
        return ad;}
    
 /**
    * getList
    * accessor method used to get the Order's ArrayList of OrderDetails
    * @return list (actually returns a deep copy to prevent displacement of values)
 */
    public String getList(){
        String localList = "";
        ArrayList<OrderDetail> whatever = new ArrayList<>();
            for (int i = 0; i < list.size(); i++){
                if(i < list.size() - 1){
                whatever.add(list.get(i));
                localList += whatever.get(i) + "\n";}
                else{whatever.add(list.get(i));
                localList += whatever.get(i);}
            }
        return localList;
    } 
    
 /**
    * getSize
    * accessor method used to get the length of an Order's ArrayList of OrderDetails
    * @return list.size()
 */
    public int getSize(){
        return list.size();
    }

//MUTATORS for Order object -------------------------------------------------------------   
 /**
    * setStatus
    * mutator method used to change an Order's status as it appears in the system
    * @param x used to set the int value for variable status
 */
    public void setStatus(int x){
        status = x;}
      
 /**
    * setStatus
    * mutator method used to change an Order's type as it appears in the system
    * @param x used to set the boolean value for variable type
 */
    public void setType(boolean x){
        type = x;}
    
 /**
    * setAddress
    * mutator method used to change a Order's shipping address as it appears in the system
    * @param ad used to set the String value for variable address 
 */
    public void setAddress(Customer kNew){
        address = kNew.getAddress();
        } //for Shipping IF Delivery
        
 /**
    * toString
    * formating display of an Order object when printed as a String -- use get methods instead of calc, becaues otherwise would continually be changing values
 */
    @Override
    public String toString(){
        String result = easy.format(date) + ", " + " (Order #" + orderNumber + ")" + " -- " + getType() + ", STATUS: " + getStatus() + "   ";
        result+= detailList();
        result+= "----------------------------------------------\n"; 
        result+= printSpaces() + "Sub Total: " + moneyOut.format(getRevenue()) + "\n" + printSpaces() + "Tax Due: " + moneyOut.format(getTax()) + "\n" + printSpaces() + "Total Due: " + moneyOut.format(getTotal()) + "\n";
        if(type == false){result+= "\n" + printSpaces() + "SHIPPING TO: " + getAddress() + "\n"; 
            return result;}
        else 
            return result;}

 /**
    * detailList
    * helper method used for formatting toString
 */    
    private String detailList(){
        String subResult = "";
            for (int i = 0; i < list.size(); i++){
                subResult += list.get(i) + "\n" + printSpaces();
            }
        return subResult;
    }   
    
 /**
    * detailList
    * helper method used for formatting toString
 */ 
    private String printSpaces(){
        int spaces = 44; //default characters for formatting
        String countLength = Integer.toString(orderNumber);//convert orderNumber to String for counting spaces
        int countL = countLength.length();//count spaces taken up by custom orderNumber
        spaces += getStatus().length() + countL; //total spaces to indent for formatting
        String x = "";
        for(int i = 0; i < spaces; i++){
            x+=" ";}
        return x;
    }
    
 /**
    * equals
    * method used to compare two Orders based on list size (items ordered) or total due or totalTax
    * @param c other Order to be compared
 */
    public boolean equals(Order c){
        if (this.list.size() == c.list.size() || this.revenue == c.revenue || this.total == c.total || this.totalTax == c.totalTax)
            {return true;}// change to if ITEMS arrayLists are EQUAL than the orders are equal
        else
            return false;}
}//END Class
