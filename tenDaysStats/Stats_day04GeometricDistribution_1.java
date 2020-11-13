package tenDaysStats;

import java.util.Scanner;

public class Stats_day04GeometricDistribution_1 {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        int numerator   = scan.nextInt();
        int denominator = scan.nextInt();
        int n           = scan.nextInt();
        scan.close();
        
        double p = (double) numerator / (denominator);
        double q = 1 - p;  

        System.out.printf("%.3f", Math.pow(q, n-1) * Math.pow(p, 1)); 
    }

}
