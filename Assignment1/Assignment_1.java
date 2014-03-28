package assignment_1;
/**
 * @author Corey Sattler
 * @version Assignment ONE 1.0
 * September 26, 2013
 */
/**
 * Class Description
 * Main class used for running solutions for all 6 questions in Assignment 1
 */
//import scanners
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;

public class Assignment_1 {
    /**
     * @param args the command line arguments
QUESTION 1 -- SUMMATION
     * @param useNumber input for Question 1
     * @param i counter for Question 1
    * @return sum output for Question 1
   * QUESTION 2 -- FACTORIAL
     * @param useInt input for Question 2 (double assigned for larger input and parsed to int later)
     * @param p counter for Question 2
     * @return product output for Question 2
 * QUESTION 3 -- Modulus Table
 * @param useMod input variable for Question 3
*QUESTION 4 -- using F(int) recursively
   * @param f double for user input Question 4 tied to class method F
 * QUESTION 5 -- Rolling a pair of DICE
     * @param index used to initialize diceGame Array to 0.0 && later as a local for counting number of sums of 2-12
     * @param roll input (number of rolls desired) 
     * @param roll_1 random number 1 using Math.random
     * @param roll_2 random number 2 using Math.random
     * @param diceGame 13 point Array for dice roll sum count -- double for larger output capacity
 * Prompt user for number of rolls
 * @param r is local counter for generating number of user rolls
 * @return sum2 temporary place holder for sum of two random dice
 * @return total sum of all rolls
* @param h local counter for formatting
  * @param l is a poor choice for local loop counter because it looks like a 1, but oh well
  * @param s is the loop counter for double digit number formatting in the table
 * QUESTION 6 -- Typing as fast as you can!
     * @param answer string for comparison of user input to check for correctness
     * @param test for receiving empty println input from user to begin && end the Date count for subtraction 
     * @param start DATE object for starting count in milliseconds
     * @param test_2 for input of user typing of prompt sentence to calculate speed
     * @param finish DATE object for ending count in milliseconds
     * @param time_1 long variable for formatting Date object start
     * @param time_2 long variable to format Date object finish
     * @return end long variable to calculate difference between finish and start
     * @param record current record for typing speed 
 */

    public static void main(String[] args) {

Scanner input = new Scanner (System.in);

    //QUESTION 1 -- SUMMATION
    
double useNumber = 0, i = 0, sum = 0;
            System.out.println("We can compute the total sum of an integer to include all the numbers from 0 to that integer.\nPlease select an integer for us to do this:");
            useNumber = input.nextInt();
                while (i < useNumber){
                i++;
                sum += i;
                }
            System.out.println("The sum of your integer " + Math.round(useNumber) + " is " + Math.round(sum));

  //QUESTION 2 -- FACTORIAL
     
            double useInt = 0, p = 1, product = 1;
            System.out.println("We can compute the total product of an integer to include all the numbers from 1 to that integer.\nPlease select an integer for us to do this factorial:");
            useInt = input.nextInt();
                while (p < useInt){
                p++;
                product *= p;
                }
            System.out.println("The factorial for your integer " + Math.round(useInt) + " is " + Math.round(product));

//QUESTION 3 -- Modulus Table

            int useMod = 0;
            System.out.println("We can compute the remainders for any number in a 12-base multiplication table.\nPlease select an integer for us to calculate:");
            useMod = input.nextInt();
            Table.mod(useMod);
           
//QUESTION 4 -- using F(int) recursively
  
               double f = 0;
              System.out.println("We have a secret recursive method for you to test using any number.  Please enter a number to test:");
               f = input.nextDouble();   
              System.out.println("Using the number " + Math.round(f) + " with our secret method, you get: " + Math.round(F.F(f)));
      
//QUESTION 5 -- Rolling a pair of DICE

	int index, sum2 = 0;                
	int roll = 0, roll_1 = 0, roll_2 = 0, total = 0;
        double [] diceGame = new double [13];

                for(index = 0; index < 13; index++){
                    diceGame[index] = 0.0;
                }

       System.out.println("\nWe can now simulate the roll of a pair of dice as many times as you prefer,\nand then display a frequency chart for each number rolled, complete with a total sum.");
        System.out.println("To get started, please tell us how many times you would like to roll this pair of dice:");
                roll = input.nextInt();
                 for (int r = 0; r < roll; r++){
                System.out.print(".....rolling...");
                roll_1 = (int)(Math.random()*6);
                roll_2 = (int)(Math.random()*6);
                sum2 = (int)(roll_1 + roll_2);
                System.out.println(sum2);
			diceGame[sum2] += 1.0;
                total = total + sum2;
                }
                

 //convert Array objects to percentage of rolls

for(index = 2; index < 13; index++) {
diceGame[index] = Math.round((diceGame[index]/roll)*100);
}

 //Display total of ALL rolls

       System.out.println("The total sum of your " + Math.round(roll) + " roll(s) was " + Math.round(total));
       System.out.println("Here is a frequency distribution chart showing each rolling pair: \n");
//Freq. Distribution CHART Heading

       System.out.println("                                               PERCENTAGE of TOTAL ROLLS");
        for (int h = 0; h < 11; h++){
            if (h == 0)
             System.out.print("   " + h + "        ");
            else{
            System.out.print(h + "0        ");            
            }
       }
       System.out.println("");
 //DISPLAY Distributed percentages

 for (int l = 2; l < 13; l++){
            if (l < 10){
             System.out.print(" " + l + " ");
              for(int y = 0; y < diceGame[l]; y++){
		System.out.print("*");}
            System.out.println("");}
            else{
            System.out.print(l + " ");   
           for(int s = 0; s < diceGame[l]; s++){
		System.out.print("*");}
                System.out.println("");
            }
 }

//QUESTION 6 -- Typing as fast as you can!
          int record = 6325;
          String answer = "I type very quickly.";
          String test = "";
          String test_2 = "";
          System.out.println("\nFinally, let us test your typing speed.\nWhen you are ready, hit ENTER, then type the sentence\n\"I type very quickly\" as fast as you can\nfollowed by hitting ENTER again.\nNow press ENTER to begin...");
          test_2 = input.nextLine();
          test = input.nextLine();
            Date start = new Date();
          test_2 = input.nextLine();
            Date finish = new Date();
                long time_1 = start.getTime();
                long time_2 = finish.getTime();
                long end = (time_2) - (time_1);
        
                //COMPARE & DISPLAY user input to answer

         if (test_2.equals(answer)){
         System.out.println("\nIt took you " + end + " milliseconds to type the magic sentence.\n The current record is " + record + " milliseconds.");
            if (end < record)
           System.out.println("Congradulations!!!!  You are the new record holder!");
         } 
        else{
         System.out.println("Your input was disqualified because of a spelling mistake.  Please try again later.");
         }
    }
}
