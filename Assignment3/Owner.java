package assignment_3_again;

import java.util.Scanner;
/**
 * @author Corey Sattler
 * @version Assignment THREE 2.0
 * October 17, 2013
 */
/**
 * Class Description
 * Owner class used for receiving user commands to be passed to the Dog in Assignment 3
 */

public class Owner {

    private boolean pen;
    private int variable;
    private int direction;
      static Scanner user = new Scanner (System.in);
      private int move;

          /**
    * Default Constructor
    * to initialize class variables for an Owner object
     * variable: pen takes in x
     * variable: variable takes in y
     * variable: direction keeps track of which row the dog is in
     * variable: move
 */
public Owner (){
    variable = 0;
    direction = 0;
    pen = false;
    move = 0;
}
    /**
    * command
    * Method to initialize class variables for an Owner object
     * @param k takes user input for switch statement of commands
 */

public void command(int k){
	variable = k; 
		switch (variable){
			case 1: pen = false; break;
			case 2: pen = true; break;	
			case 3: if(direction < 3) direction++; else{direction = 0;} break;
			case 4: if(direction > 0) direction--; else{ direction = 3;} break;
			case 5: System.out.println("Please enter a number of spaces you would like to move forward:");
                                move = user.nextInt(); break;	
			case 6: Room.showDog(); break;
			case 9: finished(); break;
			default: System.out.println("Sorry! Unacceptable command!"); break;
		}
} 

//ACCESSORS
        /**
    * getMove
    * is a helper Method for other objects to access how far the dog should move forward
     * @return move
 */

public int getMove (){
    return move;
}

       /**
    * getPen
    * is a helper Method for other objects to access the current state of the pen (up or down)
     * @return pen
 */
public boolean getPen(){
    return pen;
}

       /**
    * getDirection
    * is a helper Method for other objects to access the current direction of the owner's command
     * @return direction
 */
public int getDirection(){
    return direction;
}

       /**
    * finished
    * is a void Method for ending the program
 */

private void finished(){
		System.out.println("Your have decided to finish.  Here is your final design trail: "); 
        	Room.showDog(); 
        	System.exit(0);
}     

}//end CLASS
