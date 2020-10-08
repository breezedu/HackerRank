package test;
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



class ResultThrottling {

    /*
     * Complete the 'droppedRequests' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY requestTime as parameter.
     */

    public static int droppedRequests(List<Integer> requestTime) {
    // Write your code here
    int requestDrop = 0;   
    HashMap<Integer, Integer> requestCount = new HashMap<Integer, Integer>();
    List<Integer> requestQ = new ArrayList<Integer>();
    
    
    
    for(int i=0; i< requestTime.size(); i++){        	
    	System.out.println(" working on ith: " + i); 
    	
    	int currRequest = requestTime.get(i); 
        requestQ.add( currRequest );
    	        
        // check current time and the time in 10s 
        
        int currTime = currRequest; 
        int preTime10 = Math.max(currTime - 9, 1); 
        int preTime60 = Math.max(currTime - 59, 1); 
        int req10s = 0;
        
        int req60s = 0;
     //   System.out.print(" pretime: " + preTime + " , currTime: " + currTime);
        for(int j=0; j< i; j++){
        	if(requestTime.get(j) >= preTime10 && requestTime.get(j) <= currTime){
        		req10s ++; 
        	}   
        	
        	if(requestTime.get(j) >= preTime60 && requestTime.get(j) <= currTime){
        		req60s ++; 
        	}  
        	
        } //end for 10s; 
    	
    	        
        
    	if(req10s >= 20){
    		requestDrop++;                       
            requestQ.remove( requestQ.size() -1 );  
            System.out.println("Remove 10s + " + currRequest);  
            
    	} else if(req60s >= 60){
    		requestDrop++;        
    	//	System.out.println("Remove 60s + " + currRequest + " queue size: " + requestQ.size());
            requestQ.remove( requestQ.size() -1 );    
            
            } else {
            	
             	
                if(!requestCount.containsKey( currRequest )){
                 
                 requestCount.put(currRequest, 1);           
                 
               } else {            
                       int currCount = requestCount.get( currRequest ) + 1; 
                  //     System.out.println("currCount: " + currCount + " "); 
                       
                       if(currCount > 3) {
                                 requestDrop++;                       
                                 requestQ.remove( requestQ.size() -1 );                                                          
                       } else {
                       			requestCount.put(currRequest,  currCount); 
                       }
               }               
            	
            }
   
                    
        
    }//end for loop    
    
   
    
     return requestDrop;  
    }

}

public class ThrottlingGateway {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
     //   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int requestTimeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> requestTime = IntStream.range(0, requestTimeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = ResultThrottling.droppedRequests(requestTime);
        
        System.out.println("Out: " + result); 

    //    bufferedWriter.write(String.valueOf(result));
    //    bufferedWriter.newLine();

        bufferedReader.close();
     //   bufferedWriter.close();
    }
}
