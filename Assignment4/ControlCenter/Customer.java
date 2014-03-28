package assignment_4.again.ControlCenter;

import java.util.ArrayList;

/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 * Customer class used for documenting Orders placed at the hypothetical coffee shoppe in Assignment 4
 */
public class Customer {
    private String name, address;
    private ArrayList <Integer> orderList;//document how many and which specific orders a customer makes
    
//CONSTRUCTORS for Customer object -------------------------------------------------------------  
/**
    * Customer
    * default constructors
    * @param s sets name
    * @param k, p sets name and address
    * @param String k, String p, Order j sets name, address, and current(Order)
 */
    public Customer(){
        name = "noName";
        address = "000 noWhere";
        orderList = new ArrayList<>();}
    
/**
    * Customer
    * constructor
    * @param s sets name
 */
    public Customer(String s){
        name = s;
        address = "000 noWhere";
        orderList = new ArrayList<>();}
    
/**
    * Customer
    * constructor
    * @param k sets name
    * @param p sets address
 */
     public Customer(String k, String p){
        name = k;
        address = p;
        orderList = new ArrayList<>();}   

     
//ACCESSORS for Customer object -------------------------------------------------------------   
 /**
    * getName
    * accessor method used to get a Customer's name
    * @return name (actually returns a surface copy to prevent deep displacement of value)
 */
    public String getName(){
        String h = name;
        return h;}
  
 /**
    * getAddress
    * accessor method used to get a Customer's personal address
    * @return address (actually returns a surface copy to prevent deep displacement of value)
 */
    public String getAddress(){
        String m = address;
        return m;}
    
    
//MUTATORS for Customer object -------------------------------------------------------------   
 /**
    * setName
    * mutator method used to change a Customer's name as it appears in the system
    * @param x used to set the value for variable name
 */
    public void setName(String x){
        name = x;}

 /**
    * setAddress
    * mutator method used to change a Customer's personal address as it appears in the system
    * @param y used to set the value for variable address
 */
   public void setAddress(String y){
        address = y;}
   
 /**
    * setCurrent
    * mutator method used to change a Customer's most current order as it appears in the system
    * @param kurrent used to set the value for variable current
 */
   public void addOrder (Order kurrent){
        orderList.add(0, kurrent.getOrder());}

 /**
    * toString
    * formating display of a Customer object when printed as a String
 */
    @Override
    public String toString(){
        return "Customer: " + name + "    |    Address: " + address;}
    
    
 /**
    * equals
    * method used to compare two customers based on name and address in the system
    * @param c other customer to be compared
 */
    public boolean equals(Customer c){
        if ((this.name).equals(c.name) && (this.address).equals(c.address))
            return true;
        else
            return false;}
    
} // END Class
