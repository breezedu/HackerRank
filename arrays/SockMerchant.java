package arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

public class SockMerchant {
	
	static int sockMerchant(int n, int[] ar) {
	    Hashtable<Integer, Integer> sockT = new Hashtable<Integer, Integer>();
	    int pair = 0;
	    for(int i =0; i<n; i++){
	        if(!sockT.containsKey(ar[i])){
	
	            sockT.put(ar[i], i);
	        } else {
	
	            sockT.remove(ar[i]);
	            pair++;
	        }
	    }
	     return pair;
	     
	} // this part belong to the solution :)     

	

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    } //end main() 
	
} //end everything; 
