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

public class Stats_day08_LeastSquareRegression {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Integer> xList = new ArrayList<Integer>(); 
        ArrayList<Integer> yList = new ArrayList<Integer>(); 
        
        while( true ){
        	
        	String items = scanner.nextLine();
        	if(items.length() < 1)
        		break;
        	
        	String[] arrItems1 = items.split(" ");

        	
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int xi = Integer.parseInt(arrItems1[0]);
            int yi = Integer.parseInt(arrItems1[1]);
            
            xList.add(xi);
            yList.add(yi);
        }

        scanner.close();
        
        printAL(xList);
        printAL(yList); 
        
        float sum_x = 0;
        float sum_y = 0;
        float sum_xy = 0;
        float sum_x2 = 0;
        
        for(int i=0; i<xList.size(); i++){
        	
        	sum_x += xList.get(i);
        	sum_y += yList.get(i); 
        	sum_xy += xList.get(i) * yList.get(i); 
        	sum_x2 += xList.get(i) * xList.get(i); 
        }
        
        float beta =  ( xList.size() * sum_xy - sum_x*sum_y ) / ( xList.size() * sum_x2 - sum_x * sum_x); 

        System.out.println("Num of elements in the list: " + xList.size()); 
        System.out.println(" beta: " + beta); 
      //  System.out.printf("%.3f",  beta ); 
        
        float alpha = sum_y/xList.size() - beta * sum_x/xList.size(); 
        
        System.out.println(" alpha: " + alpha); 
        
        double estimate = alpha + beta * 80; 
        
      //  System.out.println("Estimate score: " + estimate); 
        
        System.out.printf("%.3f",  estimate ); 

    }

	private static void printAL(ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		int n = list.size(); 
		for(int i=0; i<n; i++){
			System.out.print( "  " + list.get(i));
		} 
		
		System.out.println(); 
	}

} //ee
