package thirtyDaysLearning;

import java.io.*;
import java.util.*;

/****************
 * 
 * @author Jeff
 * 
 * Question: https://www.hackerrank.com/challenges/s10-pearson-correlation-coefficient/problem 
 */


public class Stats_day07_PearsonCorrelationCoeff {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        double[] arra = new double[n];
        double[] arrb = new double[n]; 

        String[] arrItems1 = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            double arrItem = Double.parseDouble(arrItems1[i]);
            arra[i] = arrItem;
        }
        
        String[] arrItems2 = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        
        for (int i = 0; i < n; i++) {
            double arrItem = Double.parseDouble(arrItems2[i]);
            arrb[i] = arrItem;
        }
        
        scanner.close();
        
        double mean_a = calMean(arra); 
        double mean_b = calMean(arrb); 

        double sig_a = calStd(arra);
        double sig_b = calStd(arrb); 
        
      //  System.out.println("Mean arra: " + mean_a + " Std arra: " + sig_a); 
      //  System.out.println("Mean arrb: " + mean_b + " Std arrb: " + sig_b); 
        
        //calculate Pearson Correlation coefficient
        double pearCoeff = 0; 
        for(int i=0; i<n; i++){
        	pearCoeff += (arra[i] - mean_a)*(arrb[i] - mean_b); 
        }
        
        pearCoeff = pearCoeff/(n * sig_a * sig_b); 
        System.out.printf("%.3f", pearCoeff);
        
    } //end main(); 
    
    

	private static double calStd(double[] arr) {
		// TODO Auto-generated method stub
		if(arr.length == 0){
			return 0; 
		}
		
		double mean = calMean(arr); 
		
		double std = 0;
		
		for( int i=0; i<arr.length; i++){
			std += (arr[i] - mean) * (arr[i] - mean);  
		}
		
		return Math.sqrt(std/arr.length);
	} //end calStd(); 

	private static double calMean(double[] arr) {
		// TODO Auto-generated method stub
		if( arr.length == 0){
			return 0; 
		} 
		
		double mean = 0; 
		for(int i=0; i<arr.length; i++){
			mean += arr[i]; 
		}
		
		return mean/arr.length;
	} //end calMean(); 
}