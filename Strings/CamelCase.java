package section_Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/***********************
 * 
 * @author Jeff
 * Question: https://www.hackerrank.com/challenges/camelcase/problem
 */
public class CamelCase {

    // Complete the camelcase function below.
    static int camelcase(String s) {
    	
    	if(s.length() == 0)
    		return 0;
    	
    	int count = 1;
    	
    	for(int i=0; i<s.length(); i++){
    		if( s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
    			count ++; 
    	}
    	
    	return count;
    } //end camelcase() method; 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = camelcase(s);

    //    bufferedWriter.write(String.valueOf(result));
    //    bufferedWriter.newLine();

     //   bufferedWriter.close();

        scanner.close();
        
        System.out.println("There are " + result + " words."); 
    }
}

