package tenDaysStats;

import java.io.*;
import java.util.*;

/***
 * 
 * @author Jeff
 * Question: https://www.hackerrank.com/challenges/s10-quartiles/problem
 * 
 * Input: 
 * 6
   6 12 8 10 20 16
   5 4 3 2 1 5
 */
public class Stats_day01_InterquartileRange {

    public static void main(String[] args) {
        /* Enter your code here. 
         * Read input from STDIN. 
         * Print output to STDOUT. 
         * Your class should be named Solution. 
        */

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        
        //input element array
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        //input frequency array
        int len = 0;
        for(int a_i=0; a_i < n; a_i++){
            b[a_i] = in.nextInt();
            len += b[a_i]; 
        }

        int[] arr = new int[len];
        int index_p = 0;
        
        for(int i=0; i<n; i++){
        	for(int j=0; j<b[i]; j++){
        		arr[index_p] = a[i];
        		index_p ++;
        	}
        }

        in.close();
        
        Arrays.sort(arr); 
        for(int i=0; i<arr.length; i++){
        	System.out.print( " " + arr[i]);
        }
        System.out.println(); 

        float median = calMedian(arr, 0, arr.length-1);
        
        float Q1; // = calMedian(a, 0, a.length/2);
        
        
        if( arr.length %2 ==0){
        	Q1 = calMedian(arr, 0, arr.length/2 - 1);
        } else {
        	Q1 = calMedian(arr, 0, arr.length/2 );
        }
        
        
        
        float Q3; // = calMedian(a, a.length/2, a.length-1);
        
        if( arr.length %2 ==0) {
        	Q3 = calMedian(arr, arr.length/2, arr.length-1);
        }else {
        	Q3 = calMedian(arr, arr.length/2 + 1, arr.length-1); 
        }
        
        System.out.println(Q1 + "\n" + median + "\n" + Q3);
        
        System.out.println("interquartile range: Q3-Q1 = " + (Q3-Q1) ); 

    } //end main() 

	private static float calMedian(int[] a, int p1, int p2) {
		// TODO Auto-generated method stub
		System.out.println("Two pivots: " + p1 + " and " + p2); 
		
		if( ( p2 - p1)%2 == 0 ){
			return a[(p2 + p1)/2]; 
		} else {
			return (float) ((a[ (p2 + p1)/2 ] + a[ (p2 + p1)/2 + 1]) /2.0); 
		}

	} //end calMedian() method; 
}
