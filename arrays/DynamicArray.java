package arrays;

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


/*******************
 * 
 * @author Jeff
 * 
 * Question: https://www.hackerrank.com/challenges/dynamic-array/problem 
 * 
 */
class daResult {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		
    // Write your code here
    	
    	ArrayList<Integer> retL = new ArrayList<Integer>(); 
    	
    	ArrayList< ArrayList<Integer> > seqList = new ArrayList< ArrayList<Integer> >(); 
    	for(int i=0; i<n; i++){
    		ArrayList<Integer> temp = new ArrayList<Integer>(); 
    		seqList.add(temp); 
    	}
    	
    	int lastAnswer = 0; 
    	
    	for(int i=0; i<queries.size(); i++){
    		
    		List<Integer> currL = queries.get(i); 
    		
    		int Q = currL.get(0);
    		int x = currL.get(1);
    		int y = currL.get(2); 
    		
    		int index = ((x^lastAnswer)%n); 
    		//int size = seqList.get(index).size(); 
    		
    		//System.out.println(" Q = " + Q + " x = " + x + " y = " + y + " index: " + index + " size: " + size); 
    		
    		if(Q == 1){
    			 
    			seqList.get(index).add(y); 
    			
    		} else if( Q == 2){
    			 
    			int size = seqList.get(index).size(); 
    			lastAnswer = seqList.get( index ).get( y%size ); 
    			
    			//System.out.println(lastAnswer); 
    			
    			retL.add(lastAnswer);
    			
    		} //end if-else 
    		
    	} //end for loop; 
    	
    	
    	
    	return retL;

    } //end dynamicArray(); 

} //daResult; 

public class DynamicArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = daResult.dynamicArray(n, queries);
        
        /*
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
        
        */
        bufferedReader.close(); 
        
        for(int i=0; i<result.size(); i++){
        	System.out.println(result.get(i)); 
        }
    } //end main(); 
    
}//end dynamicArray

