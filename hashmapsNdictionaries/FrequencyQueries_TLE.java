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

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	
    	ArrayList<Integer> retl = new ArrayList<Integer>(); 
    	HashMap<Integer, Integer> qMap = new HashMap<Integer, Integer>();
    	
    	for( List<Integer> qList : queries){
    		int op = qList.get(0);
    		int num = qList.get(1);
    		
    		switch( op){
    		
    		case 1:
    			if(!qMap.containsKey(num)){
    				qMap.put(num, 1);
    			} else {
    				qMap.put(num, qMap.get(num)+1);
    			}
    			break;
    		case 2:
    			if(qMap.containsKey(num) && qMap.get(num)>1){
    				qMap.put(num, qMap.get(num)-1);
    			
    			} else if(qMap.containsKey(num) && qMap.get(num)==1){
    				qMap.remove(num);
    			}
    			break;
    		case 3:
    			if(qMap.containsValue(num)){
    				retl.add(1);
    			} else {
    				retl.add(0);
    			}
    			break; 
    		
    		} //end switch(op) loop;
    		
    	}//end for qList loop;
    	
    	
    	return retl;

    } //end freqQuery() 

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

