package tenDaysStats;

import java.io.*;
import java.util.*;

/**********
 * 
 * @author Jeff
 * question link: https://www.hackerrank.com/challenges/s10-binomial-distribution-2/problem 
 */
public class Stats_day04_BinomialDistributionII {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        double p = 12;
        double q = 88;

        p = p/(p+q);
        q = 1.0-p; 
        
      //  System.out.println(" p = " + p + " \n q = " + q);
      //  System.out.println("combination of 2 out of 10: " + combination(10, 2) ); 

        double piston_rej = 0; 
        for(int i=0; i<3; i++){
        	piston_rej += calBinomial(10, i, p, q);
        }
        
        double piston_rejMore2 = 0;
        for( int i=0; i<2; i++){
        	piston_rejMore2 += calBinomial(10, i, p, q); 
        }
        
        System.out.printf("%.3f", piston_rej); 
        System.out.println(); 
        System.out.printf("%.3f", 1 - piston_rejMore2); 


    } //end main(); 

	private static double calBinomial(int n, int x, double p, double q) {
		// TODO Auto-generated method stub
		
		return combination(n, x) * Math.pow(p, x) * Math.pow(q, n-x);
		
	} //end calBionomial() 

	private static double combination(int n, int x) {
		// TODO Auto-generated method stub
		double C = 1.0;
		for(int i=1; i<= x; i++){
			C *= (double) (n+1-i)/i;
		}
		
		return C;
	} //end combination() 
}
