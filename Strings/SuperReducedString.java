package section_Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**********************************
 * 
 * @author Jeff
 * Question
 * https://www.hackerrank.com/challenges/reduced-string/problem
 */
public class SuperReducedString {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {

    	Stack<Character> retS = new Stack<Character>();  
    	
    	String retStr = "";
    	
    	for(int i=0; i<s.length(); i++){
    		if(retS.empty() || retS.peek()!=s.charAt(i)){
    			retS.add( s.charAt(i)); 
    			
    		} else {
    			retS.pop(); 
    		}
    			
    	}//end for i<s.length loop; 
    	
    	if(retS.empty())
    		return "Empty String";
    	
    	//pop each letter in the stack to a string, in a reverse order;
    	while(!retS.empty()) {
    		retStr = retS.pop() + retStr; 
    	}
    	
    	return retStr;
    }//end superReducedString() method; 

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);
        
        System.out.println(" Result: " + result); 

      //  bufferedWriter.write(result);
      //  bufferedWriter.newLine();

        bufferedReader.close();
      //  bufferedWriter.close();
    }
}

