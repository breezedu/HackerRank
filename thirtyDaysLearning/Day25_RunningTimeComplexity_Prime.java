package thirtyDaysLearning;

import java.io.*;
import java.util.*;

public class Day25_RunningTimeComplexity_Prime {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */ 

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        in.close(); 

        for(int i=0; i<a.length; i++){
            boolean prim = true; 
            int sqt = (int) Math.sqrt(a[i]);
            
            for(int j=2; j<=sqt; j++){
                if( a[i] % j == 0){
                    prim = false; 
                } 
            } //end for j<sqt loop; 

            if(prim) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime"); 
            }

        } //end for i<a.length loop; 
    }
}
