package section_Stacks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**********
 * 
 * @author Jeff
 *
 * Question: 
 * https://www.hackerrank.com/challenges/balanced-brackets/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 */
public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
    	if(s.length() == 0)
    		return "YES";
    	
    	if(s.length()%2 != 0)
    		return "NO";
    	
    	//int hf = s.length()/2;
    	
    	Stack<Character> brackets = new Stack<Character>();
    	
    	for(int i=0; i<s.length(); i++){
    		if( brackets.isEmpty()){
    			
    			brackets.add(s.charAt(i)); 
    		
    		} else if( twoBracketsmatch( brackets.peek(), s.charAt(i)) ){
    			
    			brackets.pop(); 
    		} else {
    			
    			brackets.add(s.charAt(i)); 
    		}
    		
    	}//end for i<s.length loop; 
    	
    	if(brackets.isEmpty()){
    		return "YES";
    	} else {
    		return "NO";
    	}


    } //end isBalanced() method; 

    private static boolean twoBracketsmatch(char left, char right) {
		// TODO Auto-generated method stub
    	if(left == '{' && right == '}'){
    		return true;
    	
    	} else if( left == '[' && right == ']'){
    		return true;
    		
    	} else if( left == '(' && right == ')'){
    		return true; 
    	}
    	
		return false;
	} //end twoBracketsmatch(); 

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

