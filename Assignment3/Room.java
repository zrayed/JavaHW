package assignment_3_again;
/**
 * @author Corey Sattler
 * @version Assignment THREE 2.0
 * October 17, 2013
 */
/**
 * Class Description
 * Room class used for creating a room object and printing Dog's commands in Assignment 3
 */
public class Room {
    static int [][] room;

          /**
    * Default Constructor
    * to initialize a Room object as a 2d 20x20 array
    * 
 */
public Room(){
	room = new int [20] [20];
        for (int r = 0; r < room.length; r++){
            for (int c = 0; c < room[r].length; c++){
                room[r][c] = 0;}}
}//END constructor

//ACCESSOR
        /**
    * getRoom
    * is a helper Method for other objects to access a Room object's array
     * @return room
 */
public int [][] getRoom(){
    return room;
}

      /**
    * showDog
    * is a static Method for other objects to reveal when a pen was used in a Room
    * @param array can be used to pass an array through the showDog formula
 */
public static void showDog (){
	String [][] display = new String[20][20];   
        for (int i = 0; i < room.length; i++){
            for (int j = 0; j < room[i].length; j++){
		     if (room[i][j] == 0){
			display [i][j] = " ";}
			else{
			display [i][j] = "*";}           
		System.out.print(" " + display[i][j] + " ");
            }
        System.out.println();
        }
   }//END showDog   
    
public static void showDog (int [][] array){
	String [][] display = new String[20][20];   
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
		     if (array[i][j] == 0){
			display [i][j] = " ";}
			else{
			display [i][j] = "*";}           
		System.out.print(" " + display[i][j] + " ");
            }
        System.out.println();
        }
   }//END showDog 

    @Override
    /**Not so sure I needed to do this??*/
    public String toString(){
       for (int row = 0; row < room.length; row++){
            for (int column = 0; column < room[row].length; column++){
                System.out.print(" " + room[row][column] + " ");
            }
        System.out.println();
        }
    return "";
}

}//END class
