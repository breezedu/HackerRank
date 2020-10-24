package thirtyDaysLearning;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day01_DataTypes {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int int_a;
        double dou_b;
        String str_c;
        
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        int_a = Integer.parseInt( scan.next()); //scan.nextInt();
        dou_b = Double.parseDouble( scan.next() );
        
        
        /***********************
         * 
         */
        scan.nextLine(); 
        str_c = scan.nextLine(); 
        
        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + int_a);
        /* Print the sum of the double variables on a new line. */
		System.out.println(d + dou_b);
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(s + " " + str_c);
        scan.close();
    }
}
