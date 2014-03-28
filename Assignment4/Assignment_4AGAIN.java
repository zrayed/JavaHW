package assignment_4.again;

import java.util.Scanner;
import assignment_4.again.ControlCenter.*;
/**
 * @author Corey Sattler
 * @version Assignment FOUR 1.0
 * Tuesday, Nov. 10, 2013
 */
/**
 * Class Description
 *  MAIN used for running methods in Assignment 4
 */
public class Assignment_4AGAIN {

    /**
     * @param args the command line arguments
     * @param employee used within a loop to receive user's commands in running a Console object
     */
    public static void main(String[] args) {
       //QUESTION 1
        Scanner input = new Scanner(System.in);
        Console shop_1 = new Console();
            
        shop_1.runConsole();
        do{ int employee = input.nextInt();
            shop_1.runConsole(employee);
        }
        while(shop_1.getStatus()!= true);

        //QUESTION 2
            //use sub-directory: Assignment_4(AGAIN)\src\assignment_4\again\Part2 if using Windows command prompt
            //please keep in mind that there is a second Test.java file in the main directory in case you want to run
            //command line from within NetBeans......and then, of course, there is a comparison copy in the main diretory
            //in case you want to see the Test.java file before running ConvertJavaSource
        
        //QUESTION 3
            //Placed the main file in the general directory for Assignment_4(AGAIN)
            // hope this is not wrong as the ProjectSrc files are there too
            // at one point had it in its own directory but then realized issues with package statements
            //needing to be matched beyond the basic package proji; required for question
    }
}
