package thirtyDaysLearning;

import java.util.Scanner;

/*******
 * 
 * @author Jeff
 * 
 * Task: 
 * https://www.hackerrank.com/challenges/s10-poisson-distribution-2/problem
 */

public class Stats_day05_PoissonDistribution_2 {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        double lamb_a   = scan.nextDouble();
        double lamb_b   = scan.nextDouble();
        int K = 1;
        
        scan.close();
        
        double p_a = Math.pow(lamb_a, K) * Math.exp(-1 * lamb_a) / factoral(K); 
        double Ca = 160 + 40 * p_a * p_a; 
        double Ca2 = 160 + 40 * ( lamb_a + lamb_a * lamb_a); 
        
        double p_b = Math.pow(lamb_b, K) * Math.exp(-1 * lamb_b) / factoral(K); 
        double Cb = 128 + 40 * p_b * p_b; 
        double Cb2 = 160 + 40 * ( lamb_b + lamb_b * lamb_b); 
        
        System.out.printf("%.3f", Ca);
        System.out.println(); 
        System.out.printf("%.3f", Cb); 
        
        System.out.println(); 
        System.out.printf("%.3f", Ca2);
        System.out.println(); 
        System.out.printf("%.3f", Cb2); 
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
