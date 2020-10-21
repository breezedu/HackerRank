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



class ResultTG {

    /*
     * Complete the 'droppedRequests' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY requestTime as parameter.
     */

    public static int droppedRequests(List<Integer> requestTime) {
    // Write your code here
    int requestDrop = 0;   
    //HashMap<Integer, Integer> requestCount = new HashMap<Integer, Integer>();
    
    Queue<Integer> requestQ01 = new LinkedList<Integer>();
    Queue<Integer> requestQ10 = new LinkedList<Integer>();
    Queue<Integer> requestQ60 = new LinkedList<Integer>();
    
    for(int i=0; i< requestTime.size(); i++){        	
    	
    	
    	int currRequest = requestTime.get(i);         
    	        
        // check current time and the time in 10s 
        
        int currTime = currRequest; 
        int preTime01 = Math.max(currTime -1, 1);
        int preTime10 = Math.max(currTime - 9, 1); 
        int preTime60 = Math.max(currTime - 59, 1); 
        
        System.out.println(" working on ith: " + i + " currTime=" + 
                            requestTime.get(i) + " pre01=" + preTime01 + 
                            " pre10=" + preTime10 + " pre60=" + preTime60
                            + " Qs size: " + requestQ01.size() + " | " + requestQ10.size() + " | " + requestQ60.size()); 
        
        boolean drop01=false, drop10=false, drop60=false; 
        
        //while requestQ01 contains any request not in current second, remove it
        while( requestQ01.peek()!=null && requestQ01.peek() < currTime){
        	System.out.print(" Q01 remove item: " + requestQ01.peek());
        	requestQ01.poll();

        }

        //while requestQ10 contains any request not in past 10 seconds, remove it
        while( requestQ10.peek()!=null && requestQ10.peek() < preTime10 ){
        	System.out.print(" Q10 remove item: " + requestQ10.peek());
        	requestQ10.poll();
        }
        
        //while requestQ60 contains any request not in past 60 second, remove it
        while( requestQ60.peek()!=null && requestQ60.peek() < preTime60){
        	System.out.print(" Q60 remove item: " + requestQ60.peek());
        	requestQ60.poll();
        }
        
        //check size of each Queue
        if(requestQ01.size() > 2){
        	drop01 = true;
        } else {
        	requestQ01.add(currRequest);
        }
        
        if(requestQ10.size() > 19){
        	drop10 = true;
        } else {
        	requestQ10.add(currRequest);
        }
        
        if(requestQ60.size() > 59){
        	drop60 = true;
        } else {
        	requestQ60.add(currRequest);
        }
        
        // if an item got dropped from any Queue, requestDrop ++; 
    	if(drop01 || drop10 || drop60){
    		requestDrop ++; 
    	
    	}                           
        
    }//end for loop    
    
   
    
     return requestDrop;  
    } //end droppedRequests() function; 

} //end ResultTG class; 

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

        int result = ResultTG.droppedRequests(requestTime);
        
        System.out.println("Out: " + result); 

    //    bufferedWriter.write(String.valueOf(result));
    //    bufferedWriter.newLine();

        bufferedReader.close();
     //   bufferedWriter.close();
    }
}
