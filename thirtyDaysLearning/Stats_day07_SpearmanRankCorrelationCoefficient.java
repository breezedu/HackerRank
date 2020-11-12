package tenDaysStats;

import java.io.*;
import java.util.*;

/****************
 * 
 * @author Jeff
 * 
 * Question: 
 * https://www.hackerrank.com/challenges/s10-spearman-rank-correlation-coefficient/problem
 */


public class Stats_day07_SpearmanRankCorrelationCoefficient {

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
        
        //getRankArrayIndex() returen indics of each element in the array; 
        int[] rank_a = getRankArrayIndex( arra );
        int[] rank_b = getRankArrayIndex( arrb ); 
        
        double diffRanks = 0; 
        
      //  System.out.println("Mean arra: " + mean_a + " Std arra: " + sig_a); 
      //  System.out.println("Mean arrb: " + mean_b + " Std arrb: " + sig_b); 
        
        //calculate difference between ranked

        for(int i=0; i<n; i++){
        	diffRanks += (rank_a[i] - rank_b[i]) * (rank_a[i] - rank_b[i]); 
        }
        
        double Rxy = 1 - 6*diffRanks/(n * (n*n - 1)); 
        
        System.out.printf("%.3f", Rxy);
        
    } //end main(); 
    
    

	private static int[] getRankArrayIndex(double[] arr) {
		// TODO Auto-generated method stub
		if(arr.length == 0){
			return null; 
		}
		
		int n = arr.length; 
		int[] rank = new int[n]; 
		
		//make a copy of the original array; 
		double[] sortArr = new double[n];
		for(int i=0; i<n; i++){
			sortArr[i] = arr[i]; 
		}
		
		Arrays.sort(sortArr);
		
		HashMap<Double, Integer> sortMap = new HashMap<Double, Integer>(); 
		for(int i=0; i<n; i++){
			sortMap.put(sortArr[i], i+1); 
		}
		
		for(int i=0; i<n; i++){
			
			rank[i] = sortMap.get(arr[i]); 
		}
		
		return rank;
	} //end getRankArrayIndex() method; 

}