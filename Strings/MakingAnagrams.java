package section_Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
    	
    	int diff = 0; 
    	HashMap<Character, Integer> chrH = new HashMap<Character, Integer>(); 
    	
    	//1st, find out the count of characters s1 and s2 share;
    	for(int i=0; i<s1.length(); i++){
    		if( !chrH.containsKey(s1.charAt(i))){
    			chrH.put(s1.charAt(i), 1);
    		
    		} else {
    			chrH.put(s1.charAt(i), chrH.get(s1.charAt(i)) + 1);
    		}
    	} //end for i<s1.len loop; 
    	
    	int common = 0; 
    	
    	for(int i=0; i<s2.length(); i++){
    		if(chrH.containsKey(s2.charAt(i)) ){
    			common ++; 
    			
    			chrH.put(s2.charAt(i), chrH.get(s2.charAt(i))-1);
    			
    			if(chrH.get(s2.charAt(i)) == 0)
    				chrH.remove(s2.charAt(i)); 
    		}
    	}
    	
    	System.out.println("S1 length: " + s1.length());
    	System.out.println("S2 length: " + s2.length());
    	System.out.println("Substring length in common: " + common); 
    	
    	diff = s1.length() + s2.length() - common - common; 
    	
    	return diff; 
    	
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

