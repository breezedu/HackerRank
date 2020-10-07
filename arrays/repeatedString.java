package arrays;
import java.io.*;
import java.util.*;

public class repeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	
    	
    	long repeat = n / s.length(); 
    	
    	int noOfa_in_s = 0; 
    	for(int i = 0; i< s.length(); i++){
    		if( s.charAt(i) == 'a')
    			noOfa_in_s ++; 
    	}
    	
    	long part_of_s = n % s.length(); 
    	int partNoOfS = 0; 
    	
    	for(int i =0; i< part_of_s; i ++){
    		if( s.charAt(i) == 'a')
    			partNoOfS ++; 
    	}
    	
		return partNoOfS + noOfa_in_s*repeat;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
        
        System.out.println("There are " + result + " letter a(s)."); 
    }
}
