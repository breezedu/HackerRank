package thirtyDaysLearning;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
  	private int[] elements;
  	public int maximumDifference;

	// Add your code here
  	// A class constructor that takes an array of integers as a parameter and saves it to the elements instance variable.

  	Difference(int[] elements){
  		this.elements = elements;
  		this.maximumDifference = 0;
  	}
  	
  	// A computeDifference method that finds the maximum absolute difference between any  
  	// 2 numbers in N and stores it in the maximumDifference instance variable.
  	public void computeDifference(){
  	    for(int i=0; i<elements.length-1; i++){
  	        for(int j=i+1; j<elements.length; j++){
  	            if( Math.abs( elements[i] - elements[j]) > maximumDifference)
  	               maximumDifference = Math.abs( elements[i] - elements[j]); 
  	        }
  	    } //end for( i loop)
  		
  	} //end computeDifference() method; 


} // End of Difference class

public class Day14_test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
