package thirtyDaysLearning;

import java.io.*;
import java.util.*;

public class Stats_day04_BinomialDistributionI {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        double p = 1.09;
        double q = 1.00;

        p = p/(p+q);
        q = 1.0-p; 
        
        System.out.println("p = " + p + " , q = " + q);
        System.out.println( combination(6, 3) ); 

        double boyMore3 = 0; 
        for(int i=3; i<7; i++){
        	boyMore3 += calBinomial(6, i, p, q);
        }
        
        System.out.println(boyMore3); 
        System.out.printf("%.3f", boyMore3); 


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
