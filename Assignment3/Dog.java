package assignment_3_again;
/**
 * @author Corey Sattler
 * @version Assignment THREE 2.0
 * October 17, 2013
 */
/**
 * Class Description
 * Dog class used for receiving and running commands from Owner in Assignment 3
 */

public class Dog {
    
  private int spaces;
  private int mark;
  private int coordinate;
    private int position_R;
    private int position_C;  
    private boolean write;

    /**
    * Default Constructor
    * to initialize class variables for a Dog object
     * variable: spaces takes in x
     * variable: mark is set to 1 or 0 depending on state of the variable 'write' (p)
     * variable: coordinate takes in y
     * variable: position_R keeps track of which row the dog is in
     * variable: position_C keeps track of which column the dog is in
     * variable: boolean write takes in p
 */
   public Dog (){
        coordinate = 0;
        spaces = 0;
        position_R = 0;
    	position_C = 0;
        mark = 0;
        write = false;
        //k = 0;
   }

    /**
    * moveDoggie
    * Method used to move a dog object based on command values from an owner
    * @param x used for taking in the command of how far to move the dog forward
    * @param y used for taking in the state of direction for the dog 
    * @param p is passed into the variable write
    * @param array is a 2d int array which takes in an array -- SHOULD BE A ROOM OBJECT?
 */
   
public void moveDoggie (boolean p, int x, int y, int[][] array){ 
    write = p;
    spaces = x;
    coordinate = y;
    if (write == true)
	{ mark = 1;} 
            else{mark = 0;}
          
    if (spaces < 20){  //DOWN      
	if (coordinate == 0){
              if (spaces + position_R > 19){spaces = 19 - position_R;}
            int move = 0;
            for (int r = 0; r < spaces + 1; r++){
                 move = position_R + r;
                array[move][position_C] = mark;
                }position_R = move; array[position_R][position_C] = 1;}
        
	else { //RIGHT
	if (coordinate == 1){ 
            if (position_C - spaces < 0){spaces = position_C;}
	    int move = position_C;
            for (int c = spaces; c > 0; c--){
               // while(move > -1){
                	array[position_R][move] = mark;
                        move -= 1;
                        }position_C = move; array[position_R][position_C] = 1;}
	else { //UP
	if (coordinate == 2){
            if (position_R - spaces < 0){spaces = position_R;}
            int move = position_R;
            for (int r = spaces; r > 0; r--){
                array[move][position_C] = mark;
                move -= 1;}
		position_R = move; array[position_R][position_C] = 1;}  
	else { //LEFT
	if (coordinate == 3){
               if (spaces + position_C > 19){spaces = 19 - position_C;}
	        int move = 0;
		for (int c = 0; c < (spaces + 1); c++){
                	move = position_C + c;
                        array[position_R][move] = mark;} 
			position_C = move; 
                        array[position_R][position_C] = 1;}
	 } } }//END direction statements
}//end major IF
    else{
    System.out.println("In proper command entry.  Please try again.");}
    
 } //END method
    
}//end CLASS
