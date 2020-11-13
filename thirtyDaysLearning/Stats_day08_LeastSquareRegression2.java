package tenDaysStats;

import java.util.ArrayList;
import java.util.Scanner;

/*******
 * 
 * @author Jeff
 * 
 * Task: 
 * https://www.hackerrank.com/challenges/s10-least-square-regression-line/problem
 */

public class Stats_day08_LeastSquareRegression2 {
	
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	    double[] x = new double[]{95,85,80,70,60};
	    double[] y = new double[]{85,95,70,65,70};
	    
	    double sdX = standardDeviation(x);
	    double sdY = standardDeviation(y);
	    
	    double b = pearsonCoefficient(x, y) * (sdY/sdX); 
	    double a = mean(y) - b*mean(x);
	    
	    double xi = 80;
	    
	    System.out.printf("%.3f", a+b*xi);
	} //end main(); 

	/*****
	 * calculate Pearson coefficient
	 * @param a
	 * @param b
	 * @return
	 */
	public static double pearsonCoefficient(double[] a, double[] b){
	    double meanX = mean(a);
	    double sdx = standardDeviation(a);
	    
	    double meanY = mean(b);
	    double sdy = standardDeviation(b);
	    
	    double numerator = 0;
	    for(int i=0;i<a.length;i++){
	        numerator += (a[i]-meanX)*(b[i]-meanY);
	    }
	    double pearsonCoefficient = (double)numerator /(a.length*sdx*sdy);
	    return pearsonCoefficient;
	} // end pearsonCoefficient(); 
	
	/*******
	 * calculate mean of an array
	 * @param a
	 * @return
	 */
	public static double mean(double[] a) {
	    double sum = 0;
	    for (int i = 0; i < a.length; i++) {
	        sum = sum + a[i];
	    }
	    double mean = (double)sum / a.length;
	    return mean;
	}//end mean(); 
	
	/*******
	 * Calculate SD of an array
	 * @param a
	 * @return
	 */
	public static double standardDeviation(double[] a) {
	    double sumOfSquaredDifferences = 0;
	    double mean = mean( a ); 
	    
	    for (int i = 0; i < a.length; i++) {
	        sumOfSquaredDifferences = sumOfSquaredDifferences + Math.pow(mean - a[i], 2);
	    }
	    
	    double variance = (double)sumOfSquaredDifferences / a.length;
	    double standardDeviation = (double)Math.sqrt(variance);
	    return standardDeviation;
	} //end standardDeviation(); 

    

} //ee
