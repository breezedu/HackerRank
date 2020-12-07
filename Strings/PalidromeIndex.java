package section_Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PalidromeIndex {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
    	int index = -1;
    	
    	int end = s.length()-1; 
    	int start = 0;
    	
    	while( start < end){
    		
    		if( s.charAt(start) == s.charAt(end)){
    			start ++;
    			end --;
    		
    		} else {
    			String subS = s.substring(0, start) + s.substring(start+1);
    			if( isPalidrome(subS)){
    				return start;
    				
    			} else {
    				
    				return end;
    			}
    		}
    		
    	}
    	
    	return index; 

    }

    private static boolean isPalidrome(String s) {
		// TODO Auto-generated method stub
    	
    	int start =0;
    	int end = s.length() -1;
    	
    	while(start < end){
    		if(s.charAt(start) == s.charAt(end)){
    			start ++;
    			end --;
    		} else {
    			return false; 
    		}
    		
    	} //end while; 
    	
		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);
            
            System.out.println( "remove index: " + result);

         //   bufferedWriter.write(String.valueOf(result));
         //   bufferedWriter.newLine();
        }

        //bufferedWriter.close();
        
        

        scanner.close();
    }
}

