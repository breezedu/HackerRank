package arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SparseArrays {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) { 
    	
    	int[] ret = new int[queries.length]; 
    	HashMap<String, Integer> dict = new HashMap<String, Integer>(); 
    	
    	for(int i=0; i<strings.length; i++){
    		if(!dict.containsKey(strings[i])){
    			dict.put(strings[i], 1);
    			
    		} else {
    			dict.put(strings[i], dict.get(strings[i]) + 1);
    			
    		}
    	}
    	
    	for(int i=0; i<queries.length; i++){
    		if(dict.containsKey(queries[i])){
        		ret[i] = dict.get( queries[i]);
        		
    		} else {
    			ret[i] = 0; 
    		
    		}
    	}
    	
		return ret;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
