package section_Trees;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayPairs_advance_BruceForce {

    // Complete the solve function below.
    static long solve(long[] arr) {
    	
    	long total = 0; 
    	
    	for(int i=0; i<arr.length - 1; i++){
    		for(int j=i+1; j<arr.length; j++){
    			
    			long max_ij = getMaxArrayRange(arr, i, j);
    			
    			if(arr[i] * arr[j] <= max_ij)
    				total++; 
    			
    		}
    	}
    	
		return total;


    } //end solve() method; 

    private static long getMaxArrayRange(long[] arr, int start, int end) {
		// TODO Auto-generated method stub
    	long max = arr[end]; 
    	for(int i=start; i<end; i++ ){
    		if(arr[i] > max)
    			max = arr[i];
    	}
    	
		return max;
	}

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        long result = solve(arr);

       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();
        
        System.out.println(" There are " + result + " paired numbers meeting the criteria."); 

        scanner.close();
    }
}
