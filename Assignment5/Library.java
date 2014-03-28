package assignment_5;

import java.util.*;
import java.io.*;

/**
 * @author Corey Sattler
 * @version Assignment FIVE 1.0
 * Tuesday, Nov. 21, 2013
 */
/**
 * Class Description
 *  used for creating a library object that can command the file access for counting letters
 */
public class Library {
    private String fName;
    private File target;
    private ArrayList <Sherlock> charList = new ArrayList<>();
    private Scanner read;
    private Character tempValue;
    LinkedHashMap checkFinal = new LinkedHashMap();
//CONSTRUCTORS for Customer object -------------------------------------------------------------  
/**
    * Library
    * default constructor initiates a LinkedHashMap
 */
    public Library(){ 
        initiateKey();
    }
    
    
//METHODS for Library object ------------------------------------------------------
 /**
    * openUp
    * method for opening a file, reading its contents letter by letter, documenting the number of times each occurs then returning the results
    * @param feel is the name of the file to be run
    * 
 */
    public void openUp(String feel) {
        fName = feel;
        try {
            target = new File(fName);
            read = new Scanner(target);
        
            System.out.println("Reading the file and calculating the character ratio(s)...\n");

            Sherlock local;

            String temp;
            boolean pain = false;

            while(read.hasNext()){
                temp = read.next().toLowerCase();
                    for(int i = 0 ; i < temp.length(); i++){
                            Character what = temp.charAt(i);
                                if(Character.isLetter(what)){
					if(charList.isEmpty()){
						local = new Sherlock(what);
        					charList.add(local);}
					else{
                                            for(int k = 0; k < charList.size(); k++){
                                                if(what == (charList.get(k).getSymbol())){
                                                    pain = true;
                                                    charList.get(k).setCount();
                                                    break;}
                                                else
                                                    pain = false;
                                            }//end compare to arrayList of available letters
                                        if(pain == false) 
                                            {local = new Sherlock(what); charList.add(local);}}//add a new Sherlock object if letter does not exist in Array yet
                                }//end if nextChar isLetter
                    }//end for each String/word in file
            }  //end while hasNext   
            read.close();
            showResults();
        }
        catch(FileNotFoundException e){
            System.out.println("Sorry Charlie! That file does not exist, please try again by entering another file name:");
            Scanner input = new Scanner(System.in);
            String idiot = input.nextLine();
            openUp(idiot);
        } 
    }//end openUp method

 /**
    * showResults
    * private helper method for showing the results based on a LinkedHashMap 
 */
    private void showResults(){
        System.out.println("RELATIVE FREQUENCY of letters from: " + fName + "\n---------------------------------------");
        
            for (int j = 0; j < charList.size(); j++){
                if(checkFinal.containsKey(charList.get(j).getSymbol()))
                    checkFinal.put(charList.get(j).getSymbol(), charList.get(j));
		}
                printFinal(checkFinal);
    }
   
 /**
    * printFinal
    * private helper method for showing the results based on a LinkedHashMap
    * @param half should be the self-contained HashMap initialized with each new Library object
 */
    private void printFinal(LinkedHashMap half){   
        Set set = half.entrySet();
        Iterator i = set.iterator();
            while(i.hasNext()) {
                Map.Entry finish = (Map.Entry)i.next();
                    if(finish.getValue() == 0)
                        {System.out.println(Character.toUpperCase((char)finish.getKey()) + " ---> NEVER USED!");}
                    else
                        System.out.println(finish.getValue());  
            }//end checkMissing
    }
    
 /**
    * initiateKey
    * private helper method for creating a new Library object, sets keys to LinkedHashMap to a - z
 */
    private void initiateKey(){
      int k = 97;
        for(int i = 0; i < 26; i++){
            checkFinal.put((char)k, 0);
                k++;}    
    }
        
    
    
}
