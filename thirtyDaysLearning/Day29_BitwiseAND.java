package thirtyDaysLearning;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Day29_BitwiseAND {
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        ArrayList<Integer> bitwiseAndList = new ArrayList<Integer>(); 
        
        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            
            int maxBitwise = calBitwise(n, k);
            
            bitwiseAndList.add(maxBitwise); 
            //System.out.println(maxBitwise); 
        }

        scanner.close();
        
        for(int i=0; i<bitwiseAndList.size(); i++){
        	System.out.println(bitwiseAndList.get(i)); 
        }
    } //end main(); 

	private static int calBitwise(int n, int k) {
		// TODO Auto-generated method stub
		int retBitwise = 0;
		
		for(int i=0; i<n; i++){
			for(int j=i+1; j<=n; j++){
				
				int currBit = i & j; 
				if(currBit > retBitwise && currBit <k)
					retBitwise = currBit; 
				
			}
		}
		
		return retBitwise;
		
	}//end calBitwise(); 

}
