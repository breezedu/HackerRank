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



    /*
     * Complete the 'getMinimumDifference' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY a
     *  2. STRING_ARRAY b
     */

    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
		
    // Write your code here 
    	List<Integer> retList = new ArrayList<Integer>(); 
    	
    	for(int i=0; i<a.size(); i++){
    		
    		String first = a.get(i);
    		String second = b.get(i);
    		
            Map<Character, Integer> count = new HashMap<>();
            for( char ch: first.toCharArray() ) {
                int ct = count.containsKey(ch) ? count.get(ch) : 0;
                count.put(ch, (ct + 1));
            }
            
            for( char ch: second.toCharArray() ) {
                int ct = count.containsKey(ch) ? count.get(ch) : 0;
                count.put(ch, (ct - 1));
            }
            
            List<Integer> values = new ArrayList<>( count.values() );
            int total = 0;
            for( Integer v: values ) {
                total += Math.abs(v);
            }
            
            if(first.length() != second.length() ) total = -1;
            
            System.out.println("To remove: " + total) ;
    		
            retList.add(total); 
            
    	} //end for loop; 
    	
    	return retList; 

}

public class AnagramDifference {
    public AnagramDifference(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int bCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> b = IntStream.range(0, bCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = getMinimumDifference(a, b);

   

        bufferedReader.close();
     //   bufferedWriter.close();
    }

}