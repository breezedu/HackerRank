package tenDaysStats;

import java.io.*;
import java.util.*;

/***
 * 
 * @author Jeff
 * Question: https://www.hackerrank.com/challenges/s10-quartiles/problem
 */
public class Stats_day01_quartiles {

    public static void main(String[] args) {
        /* Enter your code here. 
         * Read input from STDIN. 
         * Print output to STDOUT. 
         * Your class should be named Solution. 
        */

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        in.close();
        
        Arrays.sort(a); 
        for(int i=0; i<a.length; i++){
        	System.out.print( " " + a[i]);
        }
        System.out.println(); 

        int median = calMedian(a, 0, a.length-1);
        
        int Q1; // = calMedian(a, 0, a.length/2);
        
        
        if( a.length %2 ==0){
        	Q1 = calMedian(a, 0, a.length/2 - 1 );
        } else {
        	Q1 = calMedian(a, 0, a.length/2 );
        }
        
        
       
        int Q3; // = calMedian(a, a.length/2, a.length-1);
        
        if( a.length %2 ==0) {
        	Q3 = calMedian(a, a.length/2, a.length-1);
        }else {
        	Q3 = calMedian(a, a.length/2 + 1, a.length-1); 
        }
        
        System.out.println(Q1 + "\n" + median + "\n" + Q3);

    }

	private static int calMedian(int[] a, int p1, int p2) {
		// TODO Auto-generated method stub
		System.out.println("Two pivots: " + p1 + " and " + p2); 
		
		if( ( p2 - p1)%2 == 0 ){
			return a[(p2 + p1)/2]; 
		} else {
			return (a[ (p2 + p1)/2 ] + a[ (p2 + p1)/2 + 1]) /2; 
		}

	} 
}
