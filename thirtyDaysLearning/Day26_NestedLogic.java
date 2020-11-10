package thirtyDaysLearning;

import java.io.*;
import java.util.*;

/*************
 * 
 * @author Jeff
 * Question from hacker Rank: 
 * https://www.hackerrank.com/challenges/30-nested-logic/problem
 */

public class Day26_NestedLogic {
	
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. 
         * Print output to STDOUT. 
         * Your class should be named Solution. */
        Scanner input = new Scanner(System.in); 
        
        int day_r = input.nextInt(); 
        int month_r = input.nextInt();
        int year_r = input.nextInt(); 
        
        int day_e = input.nextInt(); 
        int month_e = input.nextInt(); 
        int year_e = input.nextInt(); 
        
        input.close(); 
        
        int fine = 0; 
        if(year_r > year_e){
        	fine = 10000; 
        	
        } else if( year_r == year_e && month_r > month_e){
        	fine = (month_r - month_e) * 500; 
        	
        } else if( year_r == year_e && month_r == month_e && day_r > day_e){
        	fine = (day_r - day_e) * 15; 
        } //end if-else nest; 
        
        System.out.println( fine ); 
        
        
    }

}
