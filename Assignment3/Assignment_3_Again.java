package assignment_3_again;
/**
 * @author Corey Sattler
 * @version Assignment THREE 1.0
 * October , 2013
 */
/**
 * Class Description
 * Main class used for running the class methods in the single question for Assignment 3
 */

//import classes
import java.util.Scanner;

public class Assignment_3_Again {
 /**
 * @param args command line arguments
 * variable: userCommand used for taking user input to control the dog 
 */
    
    public static void main(String[] args) {
//new objects & variables
     Scanner input = new Scanner (System.in);
            int userCommand;
            Owner person = new Owner();
            Room walkAbout = new Room();
            Dog jubba = new Dog();

     System.out.println("Please enter a command to get started.  Keep in mind that the pen starts in the up position: ");
            userCommand = input.nextInt();
            //person.command(userCommand);
            do{          
            person.command(userCommand);
            jubba.moveDoggie(person.getPen(), person.getMove(), person.getDirection(), walkAbout.getRoom());
            System.out.println("Please enter another command to continue: ");
            userCommand = input.nextInt();
        }
while (userCommand != 0); 
    }//END MAIN
}
