package assignment_2.again;
/**
 * @author Corey Sattler
 * @version Assignment TWO 1.0
 * October 3, 2013
 */
/**
 * Class Description
 * Main class used for running solutions for all 3 questions in Assignment 2
 */

//import methods
import java.util.Scanner;
import java.util.Arrays;


public class Assignment_2AGAIN {

  /**
 * @param r integer for counting the number of lockers/students for Question 1
 * @param locker String array for assigning open/close 
 * @param student int variable for comparing lockers to each student
 * @param play user input variable (int) for number of games to simulate playing craps
 * @param bunga crapShoot simulation object for passing play
 * @param numberList array for generating 
 * @param key random number 1-100,000 for assigning an index number that will correspond with numberList for the magic number
 */

    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);

// QUESTION 1 -- LOCKERS
            //prompt use for number of students/lockers
        int r;
        System.out.println("Please enter a number of lockers to run a test for student open/close exercise: ");
        r = input.nextInt();
               // boolean closed = true; -- COULD NOT FIGURE OUT HOW TO USE BOOLEAN VALUES instead of STRINGS!!!!
        
        Check_2 bupa = new Check_2();
        bupa.Check_2(r);
        
       /* String close = "closed.";
        String open = "open!";
                //create new Arrays for receiving values
            String [] locker = new String[r];
            int [] student = new int[r];	
		//initialize entire locker set to closed && student body with "ID" numbers
		for (int i = 0; i < r ; i++){
			locker[i] = close;
			student[i] = i + 1;
		}
	
	//run locker use by number of students
            for(int index = 0; index < r; index++){
		for(int lockCounter = 0; lockCounter < r; lockCounter++){
                    int reCount = lockCounter + 1;
		if( reCount % student[index] == 0){	
                    if ((locker[lockCounter]).equals(close)){
			locker[lockCounter] = open;
                        //System.out.println("Locker " + (lockCounter+1) + " is " + locker[lockCounter]);
                    }
                else{
 	   		locker[lockCounter] = close;
                //System.out.println("Locker " + (lockCounter+1) + " is" + locker[lockCounter]);
                    }
                }
             }
           }
            //return value for each locker number now that each student has run through the example
        for (int count = 0; count < r; count++)
        System.out.println("Locker " + (count + 1) + " is " + locker[count]);
*/
//QUESTION 2 -- CRAP
        int play;
        System.out.println("\nWe have created a craps game simulator for you.\nPlease pick a number of games to play and hit enter to find your chances of winning: ");
            //create a new CrapShoot object then receive user input for how many times to run simluation
        crapShoot bunga = new crapShoot();
        play = input.nextInt();
            bunga.crapShoot(play);
 
//QUESTION 3 -- TIME ESTIMATE for Array
            //create an Array with 100,000 objects and assign random values
            int [] numberList = new int[100000];
            for (int i = 0; i < numberList.length; i++)
                numberList[i] = (int)(Math.random()*100000 + 1);
            
            //create an index for assigning a KEY
            int key;
            key = (int)(Math.random()*100000);
                        //check Key generation  
            System.out.println("\nKEY is: " + numberList[key]);

                   //run Linear Search and track time
            long startTime = System.currentTimeMillis();
                LinearSearch.linearSearch(numberList, numberList[key]);
            long endTime = System.currentTimeMillis();
            long executionTime = endTime - startTime;
       System.out.println("Linear Search method took: " + executionTime + " milliseconds!");

                   //run Binary Search and track time
               Arrays.sort(numberList);
            long startTime_2 = System.currentTimeMillis();
                BinarySearch.binarySearch(numberList, numberList[key]);
            long endTime_2 = System.currentTimeMillis();
            long executionTime_2 = endTime_2 - startTime_2;
       System.out.println("Binary Search method took: " + executionTime_2 + " milliseconds!");
                   
            
    }
}
