package thirtyDaysLearning;

import java.io.*;
import java.util.*;

public class Day06_ReviewStrings {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
       		
        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int NofS = scan.nextInt();
        String[] strs = new String[NofS]; 
        
        for(int i=0; i<NofS; i++){
          // scan.nextLine(); 
          String str = scan.next();   
          
  		String odd = ""; 
  		String even = "";
  		for(int j=0; j<str.length(); j++){
  			
  			if(j%2 ==0){
  				even += str.charAt(j);
  			} else {
  				odd += str.charAt(j); 
  			}
  			
  		} 
  		
  		System.out.println(even + " " + odd);

        }          
        
        scan.close();
    }

	private static void splitStr(String str) {
		// TODO Auto-generated method stub
		String odd = ""; 
		String even = "";
		for(int i=0; i<str.length(); i++){
			
			if(i%2 ==0){
				even += str.charAt(i);
			} else {
				odd += str.charAt(i); 
			}
			
		} 
		
		System.out.println(even + " " + odd);
	}
}
