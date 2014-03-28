package assignment_4.again.ControlCenter;
/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 *  used for running  for question 1 in Assignment 4
 */

public class Item {
    private double shippingWeight;
    private int description;
     
 /**
    * Default Constructor
    * to initialize class variables for a Console object
 */
    public Item(){
        shippingWeight = 0.0;
        description = 0;
    }
    
 /**
    * Item Constructor
    * to initialize class variables for a Console object
    * @param description to make sure the item is on the menu
 */
      public Item(int description){
        shippingWeight = 0.0;
        if (description != 0 && description < 13)
            this.description = description;
        else
            System.out.println("Sorry! This is not a menu item!!!"); 
        } 
   
//MUTATORS for Item object ------------------------------------------------------------- 
       public void setItem(int k){
           description = k;
       }
       
//ACCESSORS for Customer object -------------------------------------------------------------   
 /**
    * getItem
    * accessor method used to get an Item's description
    * @return description (actually returns a surface copy "order" to prevent deep displacement of value)
 */
       public String getItem (){
           String order = "";
           switch(description){
            case 1: order = "Small Coffee"; break;
            case 2: order = "Medium Coffee"; break;	
            case 3: order = "Large Coffee"; break;
            case 4: order = "1 lb bag of Coffee"; break;
            case 5: order = "2 lb bag of Coffee"; break;
            case 6: order = "5 lb bag of Coffee"; break;	
            case 7: order = "Plain Bagel(s)"; break;
            case 8: order = "Everything Bagel(s)"; break;
            case 9: order = "Assorted Bagels"; break;
            case 10: order = "Chocolate Muffin(s)"; break;	
            case 11: order = "Banana Muffin(s)"; break;
            case 12: order = "Blueberry Muffin(s)"; break;
            default: System.out.println("Sorry! Customer has not picked an item yet!"); break; 

           }
           return order;
       }//end getItem
    
 /**
    * getPriceforQuantity
    * accessor method used to get the item's price per item depending on how how many a Customer orders
    * -- MUST set description before running this method!
    * @return price -- a local variable (double) to the method 
 */ 
    public double getPriceforQuantity(int quantity){
        double price = 0.0;
        switch (this.description){ 
            case 1: price = .90; break;
            case 2: price = 1.45; break;	
            case 3: price = 2.30; break;
            case 4: price = 5.00; break;
            case 5: price = 7.50; break;
            case 6: price = 10.75; break;	
            case 7: if(quantity < 6 && quantity > 0){price = 0.5;} 
                    else{if(quantity < 13) price = 0.45; 
                    else {price = 0.40;}} break;
            case 8: if(quantity < 6 && quantity > 0) price = 1.20; 
                    else{if(quantity < 13) price = 1.08; 
                    else{price = 1.03;}} break;
            case 9:  if(quantity < 6) {System.out.println("Sorry! This deal is not available for the number of bagels selected!!!"); price = 0.0;} 
                    else{if(quantity > 6 && quantity < 13) price = 0.86; 
                    else{price = 0.78;}} break;
            case 10: if(quantity < 6 && quantity > 0) price = 0.85; 
                    else{if(quantity < 13) price = 0.80; 
                    else{price = 0.75;}} break;
            case 11: if(quantity < 6&& quantity > 0) price = 0.85; 
                       else{if(quantity < 13) price = 0.80; 
                       else{price = 0.75;}} break;
            case 12: if(quantity < 6 && quantity > 0) price = 1.00; 
                     else{if(quantity < 13) price = 0.80; 
                     else{price = 0.78;}} break;
            default: System.out.println("Sorry! No item selected yet!"); break;
        }//end switch statement
        return price;
    }//END getPriceforQ
    
 /**
    * getWeight
    * accessor method used to get the item's weight per item depending on how how many a Customer orders
    * @return shippingWeight (would make this a local variable but method is never used in program) 
 */ 
    public double getWeight(int quantity){
        switch (description){
            case 1: shippingWeight = 0.0; System.out.println("We do not ship this item - pick-up or in-store only!"); break; //assume customer still purchases item
            case 2: shippingWeight = 0.0; System.out.println("We do not ship this item - pick-up or in-store only!"); break; //assume customer still purchases item
            case 3: shippingWeight = 0.0; System.out.println("We do not ship this item - pick-up or in-store only!"); break; //assume customer still purchases item
            case 4: shippingWeight = 1.0; break;
            case 5: shippingWeight = 2.0; break;
            case 6: shippingWeight = 5.0; break;
            case 7: if(quantity < 6 && quantity > 0){shippingWeight = 0.0; System.out.println("We do not ship this less than 6 bagels - pick-up only!");}//assume customer still purchases item 
                    else{if(quantity < 13) shippingWeight = 2.0; 
                    else {shippingWeight = 4.1;}} break;
            case 8: if(quantity < 6 && quantity > 0){shippingWeight = 0.0; System.out.println("We do not ship this less than 6 bagels - pick-up only!");} //assume customer still purchases item
                    else{if(quantity < 13) shippingWeight = 2.2; 
                    else {shippingWeight = 4.4;}} break;
            case 9:  if(quantity < 6 && quantity > 0){shippingWeight = 0.0; System.out.println("We do not ship this less than 6 bagels - pick-up only!");} //assume customer still purchases item
                    else{if(quantity < 13) shippingWeight = 2.1; 
                    else {shippingWeight = 4.2;}} break;
            case 10: if(quantity < 6 && quantity > 0){shippingWeight = 0.0; System.out.println("We do not ship this less than 6 Muffins - pick-up only!");} //assume customer still purchases item
                    else{if(quantity < 13) shippingWeight = 2.5; 
                    else {shippingWeight = 5.4;}} break;
            case 11: if(quantity < 6 && quantity > 0){shippingWeight = 0.0; System.out.println("We do not ship this less than 6 Muffins - pick-up only!");} //assume customer still purchases item
                    else{if(quantity < 13) shippingWeight = 2.5; 
                    else {shippingWeight = 5.4;}} break;
            case 12: if(quantity < 6 && quantity > 0){shippingWeight = 0.0; System.out.println("We do not ship this less than 6 Muffins - pick-up only!");} //assume customer still purchases item
                    else{if(quantity < 13) shippingWeight = 2.6; 
                    else {shippingWeight = 5.6;}} break;
            default: System.out.println("Sorry! No item selected yet!"); break;
    }
        return shippingWeight;
  }  //end getWeight
    
 /**
    * toString
    * formating display of an Item object when printed as a String
    * @return getItem() method from above
 */ 
    @Override
    public String toString(){
    return getItem();}
    
 /**
    * equals
    * method used to compare two Items based on description and shippingWeight
    * @param other -- other Item to be compared
 */
    public boolean equals(Item other){
        if(this.description == other.description && this.shippingWeight == other.shippingWeight)
            return true;
        else
            return false;}
    
}// END CLASS
