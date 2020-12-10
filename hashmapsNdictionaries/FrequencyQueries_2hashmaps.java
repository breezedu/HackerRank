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

/***************************************
 * 
 * @author Jeff
 * Queestion: 
 * https://www.hackerrank.com/challenges/frequency-queries/problem 
 */
public class FrequencyQueries_2hashmaps {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	
    	//the return list
    	ArrayList<Integer> retl = new ArrayList<Integer>();
    	
    	//the hash map to count frequency of all numbers/integers
    	HashMap<Integer, Integer> qMap = new HashMap<Integer, Integer>();
    	
    	//the hash map to store frequency of all unique integers
    	HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>(); 
    	
    	//work on each list, although there are only 2 ints in each list
    	for( List<Integer> qList : queries){
    		int op = qList.get(0);
    		int num = qList.get(1);
    		
    		switch( op ){
    		
    		case 1:
    			if(!qMap.containsKey(num)){
    				qMap.put(num, 1);
    				freq = add2Hash(freq, 1);
    				
    			} else {
    				//update freq hashmap first; 
    				freq = minusFromHash(freq, qMap.get(num));
    				freq = add2Hash(freq, qMap.get(num)+1); 
    				
    				qMap.put(num, qMap.get(num)+1);
    			}
    			break;
    		case 2: 		    			
    			if(qMap.containsKey(num) && qMap.get(num)>1){
    				
    				
    				//remove qMap.get(num) from the freq map;
    				freq = minusFromHash(freq, qMap.get(num)); 	    				
    				//add the new frequency to the freq hashmap;
    				freq = add2Hash(freq, qMap.get(num) -1);    	
    				
    				qMap.put(num, qMap.get(num)-1);
    							
    			
    			} else if(qMap.containsKey(num) && qMap.get(num)==1){
    				qMap.remove(num);
    				freq = minusFromHash(freq, 1);
    				
    			}    			
    			break;
    		case 3:
    			System.out.println("working on " + num + " qMap contains value: " + qMap.containsValue(num));
    			System.out.println(" -- freq contains: " + freq.get(num));
    			if(freq.containsKey(num)){
    				retl.add(1);
    			} else {
    				retl.add(0);
    			}
    			break; 
    		
    		} //end switch(op) loop;
    		
    	}//end for qList loop;
    	
    	
    	return retl;

    } //end freqQuery() 

    /******
     * for a HashMap<x,y> make the entry to HashMap<x, y-1>;
     * @param freq
     * @param n
     * @return
     */
    private static HashMap<Integer, Integer> minusFromHash(HashMap<Integer, Integer> freq, Integer n) {
		// TODO Auto-generated method stub
    	System.out.println(" minusFHash: " + n + " contains " + freq.get(n)); 
    	if(!freq.containsKey(n))
    		return freq;
    	
    	if(freq.get(n) == 1){
    		freq.remove(n);    		
    	} else {    		
    		freq.put(n, freq.get(n) - 1);    		
    	}
    	
    	System.out.println(" minusFHash done: " + n + " contains " + freq.get(n)); 
    	    	
		return freq;
	}//end minusFromHash();

    /************
     * For a hashmap<x,y>, make the entry to HashMap<x, y+1>; 
     * @param freq
     * @param n
     * @return
     */
	private static HashMap<Integer, Integer> add2Hash(HashMap<Integer, Integer> freq, int n) {
		// TODO Auto-generated method stub    	
    	if(!freq.containsKey(n)){
    		freq.put(n, 1);
    	} else {
    		freq.put(n, freq.get(n)+1);
    	}
    	
		return freq;
	} //end add2Hash() 



	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

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

        List<Integer> ans = freqQuery(queries);
        
        for(int i=0; i<ans.size(); i++){
        	System.out.println(ans.get(i)); 
        }

        
      //  bufferedWriter.write(
      //      ans.stream()
       //         .map(Object::toString)
        //        .collect(joining("\n"))
       //     + "\n"
      //  );

        bufferedReader.close();
     //   bufferedWriter.close();
    }
}

