package tenDaysStats;

import java.util.Scanner;

/*******
 * 
 * @author Jeff
 * 
 * Task: 
 * The probability that a machine produces a defective product is 1/3.
 * What is the probability that the 1st defect is found during the first  inspections?
 */

public class Stats_day04GeometricDistribution_2 {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        int numerator   = scan.nextInt();
        int denominator = scan.nextInt();
        int n           = scan.nextInt();
        scan.close();
        
        double p = (double) numerator / (denominator);
        double q = 1 - p;  
        
        double total_p = 0; 
        
        for(int i=0; i<n; i++){
        	total_p += Math.pow(q, i) * Math.pow(p,  1); 
        }

        System.out.printf("%.3f", total_p); 
    }

}
