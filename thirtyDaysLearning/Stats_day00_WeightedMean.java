package thirtyDaysLearning;

import java.io.*;
import java.util.*;

public class Stats_day00_WeightedMean {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];
        int[] weight = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }


        String[] arrItems2 = scanner.nextLine().split(" ");

        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems2[i]);
            weight[i] = arrItem;
        }

        int sum = 0;
        int sumWeight = 0;

        for(int i=0; i<n; i++){
            sum += arr[i] * weight[i];
            sumWeight += weight[i];
        }

        //convert to double, then round to 1 decimal place
        double res = (double)sum/sumWeight;
        res = Math.round( res * 10 )/10.0;
        System.out.println(res);

    }
}