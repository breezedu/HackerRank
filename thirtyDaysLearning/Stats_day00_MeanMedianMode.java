package thirtyDaysLearning;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Stats_day00_MeanMedianMode {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. 
         * Print output to STDOUT. 
         * Your class should be named Solution. 
         */

         Scanner scanner = new Scanner(System.in); 

                int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        scanner.close();
        

        Arrays.sort(arr); 
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i]; 
        }

        float mean = (float) sum / arr.length;
        float median; 
        if( arr.length % 2 == 1){
            median = arr[ arr.length/2]; 
        } else {
            median = (float)(arr[arr.length/2] + arr[arr.length/2 -1])/2; 
        }

        //check mode, not necessary to use HashMap or double for loops to calculate counts for each item;
        int mode = arr[0];
        int max = 1;
        int appearance = 1;        

        for(int i=1; i<arr.length; i++){

            if ( arr[i] == arr[i-1] ) {
                appearance ++; 
                
            } else {
            	appearance = 1; 
            }

            if( appearance > max ){
                max = appearance; 
                mode = arr[i]; 
            }

        }

      //  System.out.println(" arr[0] = " + arr[0]); 
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode); 

    }
}