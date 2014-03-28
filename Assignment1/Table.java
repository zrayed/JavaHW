package assignment_1;
/**
 * @author Corey Sattler
 * @version Assignment ONE 1.0
 * September 26, 2013
 */
/**
 * Class Description
 * Method used for modulus Table display in Question 3
 */

public class Table {
    
    private static int m = 1, k = 1;
    /**
     * @param m defines row headings
     * @param k defines column values per row
     * @param x integer to be put in by user and passed to roll variable
     */
    public static void mod(int x){
    System.out.println("   " + 1 + " " + 2 + " " + 3 + " " + 4 + " " + 5 + " " + 6 + " " + 7 + " " + 8 + " " + 9 + " " + 10 + " " + 11 + " " + 12);
                while (m < 13){
                   if (m < 10){
                    System.out.print(" " + m + " ");
                    while (k < 13){
                        if (k < 11){
                    System.out.print((m*k) % x + " ");
                    k++;
                        }
                        else {
                        System.out.print(" " + (m*k) % x + " ");
                        k++;
                        }
                    }
                    System.out.println("");
                    k = 1;
                    m++;}
                   else {
                        System.out.print(m + " ");
                            while (k < 13){
                                if (k < 11){
                                System.out.print((m*k) % x + " ");
                                k++;
                                }
                                else {
                                System.out.print(" " + (m*k) % x + " ");
                                k++;
                                }
                            }
                        System.out.println("");
                        k = 1;
                        m++;
                        }
                }
    }   
}