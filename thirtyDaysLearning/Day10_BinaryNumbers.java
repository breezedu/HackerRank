package thirtyDaysLearning;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day10_BinaryNumbers {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String bin = "";

        while(n > 0){
           // System.out.print(" cir: " + n);

            if(n%2 ==0){
                n = n/2;
                bin = '0' + bin;
            } else {
                bin = '1' + bin;
                n = (n-1)/2;
            }

        }

        int max = 0;
        int currCount = 0;
        
        for(int i=0; i < bin.length(); i++){
        	
        	if(bin.charAt(i) == '1'){
        		currCount++;
        		
        	} else {
        		
        		if(currCount > max){
        			max = currCount;        			
        		}
        		
        		currCount = 0;
        	}
        	
        	 if(currCount > max){
                 max = currCount;
                 
             } //in case the last few chars are all '1's; i.e. 439 = 110110111;
            
        }


        System.out.println(bin);
        System.out.println(max);



        scanner.close();
    }
}
