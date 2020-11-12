package thirtyDaysLearning;

import java.util.Scanner;

public class Stats_day06_CentralLimitTheorem_03 { 
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in); 

        int n = scan.nextInt();
        double mean  = scan.nextDouble();
        double sigma = scan.nextDouble(); 
        double NintyFiveConf = scan.nextDouble(); 
        double zscore = scan.nextDouble(); 
        System.out.println("Print confidence intervals: "); 

        scan.close();
        
        double confInterval = zscore * sigma / Math.sqrt(n); 
        
        System.out.format("%.2f%n", mean - confInterval);
        System.out.format("%.2f%n", mean + confInterval);
        
    } //end main(); 


}
