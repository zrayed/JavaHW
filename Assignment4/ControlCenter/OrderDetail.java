package assignment_4.again.ControlCenter;

import java.text.NumberFormat;

/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 * used for generating details for each item ordered by a customer in Assignment 4
 */
public class OrderDetail {
    NumberFormat moneyOut = NumberFormat.getCurrencyInstance();
    private int quantity;
    private boolean taxStatus;
    private double subTotal, subWeight;
    private String what;
 
/**
    * OrderDetail
    * default constructor
 */
    public OrderDetail(){
        quantity = 0;
        taxStatus = false;//FOR PROFIT by default
        subTotal = 0.0;
        what = "nothingSoFar";}
    
/**
    * OrderDetail
    * constructor
    * @param q used to set the quantity of an item to be ordered
 */
    public OrderDetail(int q){
        quantity = q;
        taxStatus = false;
        subTotal = 0.0; 
        what = "nothingSoFar";}
    
/**
    * OrderDetail
    * constructor
    * @param q used to set the quantity of an item to be ordered
    * @param stat to set the TaxStatus
 */
    public OrderDetail(int q, boolean stat){
        quantity = q;
        taxStatus = stat;
        subTotal = 0.0;
        what = "nothingSoFar";}
    
//MUTATORS for OrderDetail object ------------------------------------------------------------- 
 /**
    * setStatus
    * mutator method used to change an OrderDetail's tax status as it appears in the system
    * @param status used to set the value for variable taxStatus
 */
    public void setStatus(boolean status){
        taxStatus = status;}
    
 /**
    * setQuantity
    * mutator method used to change an OrderDetail's quantity as it appears in the system
    * @param q used to set the value for variable taxStatus
 */
    public void setQuantity(int q){
        quantity = q;}
    
     /**
    * setDescription
    * accessor method used to get the customer associated with this order's shipping address
    * @param iq Item object used to get the description for the item to be purchased
 */
    public void setDescription(Item iq){
        what = iq.getItem();}

    
//ACCESSORS for OrderDetail object -------------------------------------------------------------   
 /**
    * getStatus
    * accessor method used to get a OrderDetail's status
    * @return taxStatus (actually returns a surface copy to prevent deep displacement of value)
 */
    public boolean getStatus(){
        boolean tax = taxStatus;
        return tax;}
    
 /**
    * getQuantity
    * accessor method used to get a OrderDetail's quantity
    * @return quantity (actually returns a surface copy to prevent deep displacement of value)
 */
    public int getQuantity(){
        int quant = quantity;
        return quant;}
    
 /**
    * getSubTotal
    * public method used to calculate an OrderDetail's subTotal
    * @param toPurchase used for getting the price per item
    * @return subTotal (actually returns a copy to prevent overwriting original value)
 */
       public double getSubTotal(){
           double temp = subTotal;
           return temp;}
      
 /**
    * getSubWeight
    * public method used to calculate an OrderDetail's subTotal
    * @param toPurchase used for getting the price per item
    * @return subTotal (actually returns a copy to prevent overwriting original value)
 */
       public double getSubWeight(){
           double temp = subWeight;
           return temp;}
       
       
//METHODS for OrderDetail object ------------------------------------------------------    
 /**
    * calcSubTotal
    * public method used to calculate an OrderDetail's subTotal
    * @param toPurchase used for getting the price per item
    * @return subTotal
 */
       public double calcSubTotal(Item toPurchase){
           subTotal = quantity*getPrice(toPurchase);
           return subTotal;}
           
 /**
    * getPrice
    * private helper method used to get an Item's priceforQuantity 
    * @return nextI.getPriceforQuantity(quantity)
 */
       private double getPrice(Item nextI){
            return nextI.getPriceforQuantity(quantity);}
       
  /**
    * calcWeight
    * public method used to calculate an OrderDetail's total weight
 */
        public double calcWeight(Item toPurchase){
             subWeight =quantity*toPurchase.getWeight(quantity);
             return subWeight;} 
    
 /**
    * toString
    * formating display of an OrderDetail object when printed as a String
 */
    @Override
        public String toString(){
            return what + " (" + quantity + "): " + moneyOut.format(getSubTotal());
        }
        
 /**
    * equals
    * method used to compare two customers based on name and address in the 
system
    * @param other OrderDetail to be compared
 */
        public boolean equals(OrderDetail other){
            if(this.quantity == other.quantity && this.subTotal == other.subTotal)
                   return true;
            else
                return false;
        }
        
}//END Class
