package section_Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {

    // Complete the anagram function below.
    static int anagram(String s) { 
    	
    	if(s.length()%2 != 0)
    		return -1; 
    	
    	String s1 = s.substring(0, s.length()/2);
    	String s2 = s.substring(s.length()/2); 
    	
    	HashMap<Character, Integer> s1Map = new HashMap<Character, Integer>(); 
    	
    	for(int i=0; i<s1.length(); i++){
    		if(!s1Map.containsKey(s1.charAt(i))){
    			s1Map.put(s.charAt(i), 1);
    		
    		} else {
    			s1Map.put(s.charAt(i),  s1Map.get(s.charAt(i)) + 1); 
    		}
    	}
    	
    	int count = 0; 
    	
    	for(int i=0; i<s2.length(); i++){
    		
    		if( !s1Map.containsKey(s2.charAt(i)) || s1Map.get(s2.charAt(i)) < 1){
    			count ++; 
    		} else {
    			s1Map.put(s2.charAt(i),  s1Map.get(s2.charAt(i))-1); 
    		}
    			
    	}
    	
		return count;    	
    } //end anagram(); 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);
            
            System.out.println("Result: " + result); 

       //    bufferedWriter.write(String.valueOf(result));
       //     bufferedWriter.newLine();
        }

      //  bufferedWriter.close();

        scanner.close();
    }
}

