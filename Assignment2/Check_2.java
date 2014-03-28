package assignment_2.again;

public class Check_2 {
     //prompt use for number of students/lockers
        String [] locker;
        int [] student;
        String close;
        String open;
                //create new Arrays for receiving values
 public Check_2(){
        close = "closed.";
        open = "open!";        
    }

    //initialize the array according to user input
    public void Check_2(int x){
            //assign length for arrays
        locker = new String [x];
	student = new int [x];
		//initialize entire locker set to closed && student body with "ID" numbers
		for (int i = 0; i < x ; i++){
			locker[i] = close;
			student[i] = i + 1;
		}
	
	//run locker use by number of students
            for(int index = 0; index < x; index++){
		for(int lockCounter = 0; lockCounter < x; lockCounter++){
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
        for (int count = 0; count < x; count++)
            if (locker[count].equals(open))
        System.out.println("Locker " + (count + 1) + " is " + locker[count]);

}
}
