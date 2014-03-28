package assignment_5;

import java.util.*;


/**
 * @author Corey Sattler
 * @version Assignment FIVE 1.0
 * Tuesday, Nov. 21, 2013
 */
/**
 * Class Description
 *  MAIN used for running methods in Assignment 4
 */
public class Assignment_5 {

    /**
     * @param args the command line arguments
     * @param user to take the name of a file
     * @param question an array of 100 random Point objects 
     */
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        //QUESTION 1
        System.out.println("We have created a secret file system which can return the value ratio of letter types to total letters.\n Please enter a name of the file you would like to open:");
            String user = input.nextLine();
            Library holmes = new Library();
                holmes.openUp(user);
                
        //QUESTION 2
                System.out.println("\n\n Time for QUESTION 2:");
                System.out.println("Generate 100 random Points and then sort by X value: ");
                Point [] question = new Point[100];
                    for(int i = 0; i < question.length; i++){
                        question[i] = new Point(Point.randomNum(), Point.randomNum());
                    }
                    
                   Arrays.sort(question);
                    for(int k = 0; k < question.length; k++){
                     System.out.println(question[k]);
                   }
                    
                    System.out.println("\n Now sort by Y value: ");  
                    List <Point> why = Arrays.asList(question);

                    Collections.sort(why, new CompareY());

                        for(int n = 0; n < why.size(); n++){
                        System.out.println(why.get(n));
                    }
                    
       //QUESTION 3: Compile then run GroupCheck.java in command prompt with file "yourKillingMe.java" 
                     //from main folder Assignment_5                 
    }//end MAIN
}
