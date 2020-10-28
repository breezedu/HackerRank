package thirtyDaysLearning;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day20_Sorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        int totalSwap = 0; 
        for(int i=0; i<a.length; i++){
            int numOfSwap = 0;  

            for(int j=0; j<a.length-1; j++){

                if( a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp; 
                    numOfSwap ++;
                } 
            } //end for(j) loop

            totalSwap += numOfSwap; 
            if(numOfSwap == 0)
                break; 

        } //end for(i) loop

        System.out.println("Array is sorted in " + totalSwap + " swaps.");
        System.out.println("First Element: " + a[0]); 
        System.out.println("Last Element: " + a[a.length - 1]); 
    }
}
