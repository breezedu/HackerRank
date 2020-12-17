package section_Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/******************
 * 
 * @author Jeff
 * Question:
 * https://www.hackerrank.com/challenges/making-anagrams/problem
 */
public class MakingAnagrams_ArrayLoop {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {    		
    	
    	System.out.println("S1 length: " + s1.length());
    	System.out.println("S2 length: " + s2.length());
    	
    	int chrArr[] = new int[26]; 
    	
    	for(int i=0; i<s1.length(); i++){
    		chrArr[s1.charAt(i) - 97] ++;
    	}
    	
    	printArray( chrArr ); 
    	
    	for(int i=0; i<s2.length(); i++){
    		chrArr[s2.charAt(i) - 97] --; 
    	}
    	
    	printArray( chrArr ); 
    	
        int count=0;
        
        for(int i=0;i<26;i++)
        	count += Math.abs(chrArr[i]);
        
        System.out.println("Count: " + count);    	
    	
    	return count; 
    	
    } //end makingAnagrams(); 

    private static void printArray(int[] chrArr) {
		// TODO Auto-generated method stub
		System.out.println();
		for( int i=0; i< chrArr.length; i++){
			System.out.print( " " + chrArr[i]);
		}
		
		System.out.println(); 
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

      //  bufferedWriter.write(String.valueOf(result));
      //  bufferedWriter.newLine();

      //  bufferedWriter.close();

        scanner.close(); 
        
        System.out.println("Result: " + result); 
    }
}

