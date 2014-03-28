package assignment_1;
/**
 * @author Corey Sattler
 * @version Assignment ONE 1.0
 * September 26, 2013
 */
/**
 * Class Description
 * Method used for recursive calculation in Question 4
 */
public class F {
      /**
     * @param n double variable for F method, to be put in by user and passed to useInt variable
     * @return result is the final calculation depending on what n the user puts in  
     */
     public static double F(double n){
                 double result = 0.0;
                 if (n == 0) return Math.round(3.0);
                 else {if (n == 1) return Math.round(5.0);
                 else {
                 result = F(n-1) + 5 * F(n-2) + n + 3;
                 return result;  
                        }
                    }
                 }
}
