package assignment_2.again;
/**
 * @author Corey Sattler
 * @version Assignment TWO 1.0
 * October 3, 2013
 */
/**
 * Class Description
 * Main class used for running CRAPS game simulation for Question 2
 */
/**
 * @param roll_1 random number 1-6 for first die in first roll
 * @param roll_2 random number 1-6 for second die in first roll
 * @return comeOut sum of 2 dice rolled for each game in the simulator used as the point for matching (if not 7 or 11)
 * @param win counter for number of games won in the simulation
 * @param lose counter for number of games lost in the simulation
  * @param roll_3 random number 1-6 for first die in second round of continuous rolling (until win/lose)
 * @param roll_4 random number 1-6 for second die in second round of continuous rolling (until win/lose)
 * @return sum total for 2 dice rolled continuously in second round of the game (until win/lose)
 * @return percent calculated winning percentage of simulator
 */
public class crapShoot {
    int comeOut, win, lose, sum, point, roll_1, roll_2, roll_3, roll_4;

    //constructor for initializing values -- good practice, but NECESSARY ?
public void crapShoot(){
    comeOut = 0;
    win =0;
    lose = 0; 
    sum = 0;
    point = 0;
    roll_1 = 0;
    roll_2=0;
    roll_3=0;
    roll_4=0;
    }
    
    public void crapShoot(int j){
for (int i = 0; i < j; i++){

    roll_1 = (int)((Math.random()*6)+1);
    roll_2 = (int)((Math.random()*6)+1);
        comeOut = roll_1 + roll_2;
        System.out.println("Game number " + (i+1));
        System.out.println("Come Out is: " + comeOut);
    if (comeOut == 7 || comeOut == 11){
	win += 1;
        System.out.println("You rolled a 7||11!  wins are now: " + win);
        }
        else{
            if (comeOut == 4 || comeOut == 5 || comeOut == 6 || comeOut == 8 || comeOut == 9 || comeOut == 10){
                do{
                   
                    roll_3 = (int)((Math.random()*6)+1);
                    roll_4 = (int)((Math.random()*6)+1);
                        sum = roll_3 + roll_4;
                        System.out.println("Second round roll was: " + sum + " and your point is " + comeOut);       
                    if (sum == comeOut){
                        win+=1; 
                        System.out.println("You rolled point match! Wins are now: " + win);
                        }
                        else{
                            if (sum == 7){
                            lose += 1;
                            System.out.println("You lost.......losses are now: " + lose);
                            }
                        }
                    }//end do loop
                    while(sum != 7 && sum != comeOut);
            }//end of if comeOut |4-10| statement 
            else{
                lose+=1;
                System.out.println("You lost.......losses are now: " + lose);
            }
        }//end original else statement
    } // end of original for loop counting user input number of games
        //REPORT on the total simulation results
    System.out.println("Total wins are: " + win);  
    System.out.println("Total losses are: " + lose); 
    double percent = ((((double)win) / ((double)j))*100);
    System.out.printf("Probability of winning " + j + " games is: %.2f%%\n", percent);
    }// end void constructor

}//end entire class