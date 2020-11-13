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

public class Stats_day05_PoissonDistribution_01 {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        double lamb   = scan.nextDouble();
        int K = scan.nextInt();
        
        scan.close();
        
        double p = Math.pow(lamb, K) * Math.exp(-1 * lamb) / factoral(K); 
        
        System.out.printf("%.3f", p); 
    }

	private static double factoral(int k) {
		// TODO Auto-generated method stub
		int Fac = 1;
		for(int i=k; i>1; i--){
			Fac *= i; 
		}
		return Fac;
	}

}
