package hashmapsNdictionaries;

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

/***************************
 * 
 * @author Jeff
 * Question: 
 * https://www.hackerrank.com/challenges/count-triplets-1/problem 
 * It burned a lot of my brain energy :)
 * Not sure if I could figure out the solution next time... 
 * Test case: 
 * Input: 
    6 3
	1 3 9 9 27 81
	
 *	Output
	Check: 81
	Check: 27
	Check: 9
	 - contain pair: 27 count: 1
	Check: 9
	 - contain pair: 27 count: 1
	Check: 3
	 - contain pair: 9 count: 2
	Check: 1
	 - contain pair: 3 count: 2
	the answer: 6
 */


public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	
    	HashMap<Long, Long> countMap = new HashMap<Long, Long>(); 
    	HashMap<Long, Long> pairMap = new HashMap<Long, Long>(); 
    	long count = 0;
    	
    	for(int i=arr.size()-1; i>=0; i--){
    	//	System.out.println("Check: " + arr.get(i)); 
    		
    		if( pairMap.containsKey(arr.get(i) * r) ){
    		//	System.out.println(" - contain pair: " + arr.get(i)*r + " count: " + pairMap.get(arr.get(i)*r) );
    			count += pairMap.get( arr.get(i) * r); 
    			
    		} //end condition #1
    		
    		if( countMap.containsKey( arr.get(i)*r)){
    			
    			if( !pairMap.containsKey(arr.get(i))){    				
    				pairMap.put(arr.get(i), countMap.get(arr.get(i)*r));
    				
    			} else {
        			pairMap.put(arr.get(i), pairMap.get(arr.get(i)) + countMap.get(arr.get(i) * r));
    				
    			}
    			
    		} //end condition #2;
    		
    		if(!countMap.containsKey(arr.get(i))){
    			countMap.put(arr.get(i), (long) 1);
    			
    		} else{
    			countMap.put( arr.get(i), countMap.get( arr.get(i)) + 1);
    		
    		}
    		
    	}//end for loop; 
  	
		return count;

    }


	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);
        
        System.out.println("the answer: " + ans); 

     //   bufferedWriter.write(String.valueOf(ans));
     //   bufferedWriter.newLine();

        bufferedReader.close();
     //   bufferedWriter.close();
    }
}

