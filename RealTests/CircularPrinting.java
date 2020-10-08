package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getTime' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static long getTime(String s) {
    // Write your code here
    String arr  = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    HashMap<Character, Integer> chaHash = new HashMap<Character, Integer>();
    
    for(int i=0; i< 26; i++){
        chaHash.put(arr.charAt(i), i);
    }
    
    // the first dis
    long dis = Math.min(  chaHash.get(s.charAt(0)), 26 - chaHash.get(s.charAt(0)) ) ; 
    
    for(int i=1; i<s.length(); i++){
        
        int dis1 = Math.abs(  chaHash.get(s.charAt(i)) - chaHash.get(s.charAt(i-1)) ) ; 
        int dis2 = 26 - dis1 ; 
        
        dis += Math.min(dis1, dis2); 
        System.out.println("i = " + i + ", char = " + s.charAt(i) + "dis = " + Math.min(dis1,  dis2)); 
        
    }
    
    return dis; 
    
    }

}

public class CircularPrinting {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long result = Result.getTime(s);
        
        System.out.println(result); 

     //   bufferedWriter.write(String.valueOf(result));
     //   bufferedWriter.newLine();

     //   bufferedReader.close();
     //   bufferedWriter.close();
    }
}