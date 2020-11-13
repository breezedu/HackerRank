package tenDaysStats;

import java.io.*;
import java.util.*;

public class Stats_day01_StandardDeviation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        in.close();
        
        float mean = 0; 
        for( int i=0; i<a.length; i++){
            mean += a[i]; 
        }

        mean = mean/a.length; 

        double sigma = 0;
        for(int i=0; i<a.length; i++){
            sigma += (a[i] - mean)*(a[i] - mean); 
        }
        
        sigma = Math.sqrt(sigma/a.length); 
        sigma = Math.round(sigma * 10.0)/10.0; 
        
        System.out.println(sigma); 
    }
}