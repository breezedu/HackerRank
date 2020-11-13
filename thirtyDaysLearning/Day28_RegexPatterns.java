package thirtyDaysLearning;

import java.io.*;
import java.util.*;

/****************
 * 
 * @author Jeff
 * 
 * Question: 
 * https://www.hackerrank.com/challenges/s10-spearman-rank-correlation-coefficient/problem
 */


public class Day28_RegexPatterns {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        ArrayList<String> users = new ArrayList<String>(); 

        for( int i=0; i<n; i++){
            String newLine = scanner.nextLine(); 
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); 
            
            if(newLine.contains("@gmail.com")){
            	String[] newUser = newLine.split(" ");
            	users.add( newUser[0] );
            }
                    	
        } //end for(i<n) loop; 

        scanner.close(); 
        Collections.sort(users);
        
        for(int i=0; i<users.size(); i++){
        	System.out.println(users.get(i)); 
        }
        
    } //end main(); 

}