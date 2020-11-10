package thirtyDaysLearning;

import java.util.Scanner;

/*******
 * 
 * @author Jeff
 * 
 * Task: 
 * https://www.hackerrank.com/challenges/s10-normal-distribution-1/problem
 */

public class Stats_day06_NormalDistribution {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        double mean  = scan.nextDouble();
        double sigma = scan.nextDouble(); 
        double x1 = scan.nextDouble(); 
        double x2 = scan.nextDouble(); 
        double x3 = scan.nextDouble(); 

        scan.close();
        
        double p1 = calCDF_normal(x1, mean, sigma);  
        
        System.out.printf("%.3f", p1);
        
        double p2 = calCDF_normal(x3, mean, sigma) - calCDF_normal(x2, mean, sigma); 
        
        System.out.println(); 
        System.out.printf("%.3f", p2 ); 
    }

	private static double calCDF_normal(double x, double mean, double sigma) {
		// TODO Auto-generated method stub
		
		return 0.5 * (1 + errFunction( (x - mean) /(sigma * Math.sqrt(2))));
	} //end calCDF_normal() function; 

	private static double errFunction(double z) {
		// TODO Auto-generated method stub
		double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
                                            t * ( 1.00002368 +
                                            t * ( 0.37409196 + 
                                            t * ( 0.09678418 + 
                                            t * (-0.18628806 + 
                                            t * ( 0.27886807 + 
                                            t * (-1.13520398 + 
                                            t * ( 1.48851587 + 
                                            t * (-0.82215223 + 
                                            t * ( 0.17087277))))))))));
        if (z >= 0) return  ans;
        else        return -ans;
	} //end errFunction(); 



} //ee
