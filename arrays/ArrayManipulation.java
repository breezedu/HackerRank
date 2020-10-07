package arrays;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {
	
	 // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
    	
    	/*
    	 *   1  2  3  4  5   6  7  8   9  10
    	 *  [0, 0, 0, 0, 0,  0, 0, 0,  0,  0]
    	 *  [3, 0, 0, 0, 0, -3, 0, 0,  0,  0]    // a: 1, b: 5, k: 3, so b+1 = 6
    	 *  [3, 0, 0, 7, 0, -3, 0, 0, -7,  0]    // a: 4: , b: 8, k: 7, so b+1 = 9
    	 *  [3, 0, 0, 7, 0, -2, 0, 0, -7, -1]   // a: 6, b: 9, k: 1, so b+1 = 10
    	 */
    	
    	long[] arr = new long[n+1]; 
    	for(int i=0; i<=n; i++){
    		arr[i] = 0; 
    	}
    	
    	int row = queries.length; 
    	//int col = queries[0].length; 
    	
    	for(int i=0; i<row; i++){
    		
    		int piviot1 = queries[i][0] - 1;
    		int piviot2 = queries[i][1] - 0; 
    		
    		arr[piviot1] += queries[i][2];
    		arr[piviot2] -= queries[i][2];
    	
    		
    		for(int j=0; j<n; j++){
    			System.out.print(arr[j] + " ");
    		}
    		System.out.println(); 
    		
    	}
    	long maxV = arr[0]; 
    	for(int i=1; i<n; i++){
    		arr[i] += arr[i-1]; 
    		if(arr[i] > maxV)
    			maxV = arr[i]; 
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
        
        System.out.println(" The max is: " + result);

       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();

        scanner.close();
    }

}
