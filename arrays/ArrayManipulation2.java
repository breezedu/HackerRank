package arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation2 {
	
	 // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	
    	long maxV = 0; 
    	
    	long[] arr = new long[n]; 
    	for(int i=0; i<n; i++){
    		arr[i] = 0; 
    	}
    	
    	int row = queries.length; 
    	//int col = queries[0].length; 
    	
    	for(int i=0; i<row; i++){
    		
    		int piviot1 = queries[i][0] - 1;
    		int piviot2 = queries[i][1] - 0; 
    		
    		for(int j=piviot1; j<piviot2; j++){
    			arr[j] += queries[i][2]; 
    			
    			if(arr[j] > maxV) 
    				maxV = arr[j]; 
    		}
    		
    	//	for(int j=0; j<n; j++){
    	//		System.out.print(arr[j] + " ");
    	//	}
    	//	System.out.println(); 
    		
    	}
    	
		return maxV;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }

}
