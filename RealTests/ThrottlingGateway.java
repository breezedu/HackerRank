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
        	System.out.println(" Q01 remove item: " + requestQ01.peek());
        	requestQ01.poll();

        }

        //while requestQ10 contains any request not in past 10 seconds, remove it
        while( requestQ10.peek()!=null && requestQ10.peek() < preTime10 ){
        	System.out.println(" Q10 remove item: " + requestQ10.peek());
        	requestQ10.poll();
        }
        
        //while requestQ60 contains any request not in past 60 second, remove it
        while( requestQ60.peek()!=null && requestQ60.peek() < preTime60){
        	System.out.println(" Q60 remove item: " + requestQ60.peek());
        	requestQ60.poll();
        }
        
        /*****************
         * Although, if a request is to be dropped due to multiple violations, it is still counted only once.
         * 27
1
1
1
1
2
2
2
3
3
3
4
4
4
5
5
5
6
6
6
7
7
7
7
11
11
11
11
 working on ith: 0 currTime=1 pre01=1 pre10=1 pre60=1 Qs size: 0 | 0 | 0
 working on ith: 1 currTime=1 pre01=1 pre10=1 pre60=1 Qs size: 1 | 1 | 1
 working on ith: 2 currTime=1 pre01=1 pre10=1 pre60=1 Qs size: 2 | 2 | 2
 working on ith: 3 currTime=1 pre01=1 pre10=1 pre60=1 Qs size: 3 | 3 | 3
* Drop 01 
 working on ith: 4 currTime=2 pre01=1 pre10=1 pre60=1 Qs size: 4 | 4 | 4
 Q01 remove item: 1
 Q01 remove item: 1
 Q01 remove item: 1
 Q01 remove item: 1
 working on ith: 5 currTime=2 pre01=1 pre10=1 pre60=1 Qs size: 1 | 5 | 5
 working on ith: 6 currTime=2 pre01=1 pre10=1 pre60=1 Qs size: 2 | 6 | 6
 working on ith: 7 currTime=3 pre01=2 pre10=1 pre60=1 Qs size: 3 | 7 | 7
 Q01 remove item: 2
 Q01 remove item: 2
 Q01 remove item: 2
 working on ith: 8 currTime=3 pre01=2 pre10=1 pre60=1 Qs size: 1 | 8 | 8
 working on ith: 9 currTime=3 pre01=2 pre10=1 pre60=1 Qs size: 2 | 9 | 9
 working on ith: 10 currTime=4 pre01=3 pre10=1 pre60=1 Qs size: 3 | 10 | 10
 Q01 remove item: 3
 Q01 remove item: 3
 Q01 remove item: 3
 working on ith: 11 currTime=4 pre01=3 pre10=1 pre60=1 Qs size: 1 | 11 | 11
 working on ith: 12 currTime=4 pre01=3 pre10=1 pre60=1 Qs size: 2 | 12 | 12
 working on ith: 13 currTime=5 pre01=4 pre10=1 pre60=1 Qs size: 3 | 13 | 13
 Q01 remove item: 4
 Q01 remove item: 4
 Q01 remove item: 4
 working on ith: 14 currTime=5 pre01=4 pre10=1 pre60=1 Qs size: 1 | 14 | 14
 working on ith: 15 currTime=5 pre01=4 pre10=1 pre60=1 Qs size: 2 | 15 | 15
 working on ith: 16 currTime=6 pre01=5 pre10=1 pre60=1 Qs size: 3 | 16 | 16
 Q01 remove item: 5
 Q01 remove item: 5
 Q01 remove item: 5
 working on ith: 17 currTime=6 pre01=5 pre10=1 pre60=1 Qs size: 1 | 17 | 17
 working on ith: 18 currTime=6 pre01=5 pre10=1 pre60=1 Qs size: 2 | 18 | 18
 working on ith: 19 currTime=7 pre01=6 pre10=1 pre60=1 Qs size: 3 | 19 | 19
 Q01 remove item: 6
 Q01 remove item: 6
 Q01 remove item: 6
 working on ith: 20 currTime=7 pre01=6 pre10=1 pre60=1 Qs size: 1 | 20 | 20
* Drop 10 
 working on ith: 21 currTime=7 pre01=6 pre10=1 pre60=1 Qs size: 2 | 21 | 21
* Drop 10 
 working on ith: 22 currTime=7 pre01=6 pre10=1 pre60=1 Qs size: 3 | 22 | 22
* Drop 01 
* Drop 10 
 working on ith: 23 currTime=11 pre01=10 pre10=2 pre60=1 Qs size: 4 | 23 | 23
 Q01 remove item: 7
 Q01 remove item: 7
 Q01 remove item: 7
 Q01 remove item: 7
 Q10 remove item: 1
 Q10 remove item: 1
 Q10 remove item: 1
 Q10 remove item: 1
 working on ith: 24 currTime=11 pre01=10 pre10=2 pre60=1 Qs size: 1 | 20 | 24
* Drop 10 
 working on ith: 25 currTime=11 pre01=10 pre10=2 pre60=1 Qs size: 2 | 21 | 25
* Drop 10 
 working on ith: 26 currTime=11 pre01=10 pre10=2 pre60=1 Qs size: 3 | 22 | 26
* Drop 01 
* Drop 10 
Out: 7

         * 
         */
        //check size of each Queue
        if(requestQ01.size() > 2){
        	drop01 = true;
        	System.out.println("* Drop 01 ");
        	requestQ01.add(currRequest);
        	
        } else {
        	requestQ01.add(currRequest);
        }
        
        if(requestQ10.size() > 19){
        	drop10 = true;
        	System.out.println("* Drop 10 ");
        	requestQ10.add(currRequest);
        } else {
        	requestQ10.add(currRequest);
        }
        
        if(requestQ60.size() > 59){
        	drop60 = true;
        	System.out.println("* Drop 60 ");
        	requestQ60.add(currRequest);
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
