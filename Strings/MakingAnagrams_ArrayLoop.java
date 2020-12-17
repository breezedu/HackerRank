package section_Strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MakingAnagrams_ArrayLoop {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {    		
    	
    	System.out.println("S1 length: " + s1.length());
    	System.out.println("S2 length: " + s2.length());
    	
    	int cArr1[]=new int[26];
        int cArr2[]=new int[26];
        for(int i=0;i<s1.length();i++)
        	cArr1[s1.charAt(i)-97]++;
        
        for(int i=0;i<s2.length();i++)
        	cArr2[s2.charAt(i)-97]++;
        
        int count=0;
        
        for(int i=0;i<26;i++)
        	count += Math.abs(cArr1[i]-cArr2[i]);
        
        System.out.println("Count: " + count);    	
    	
    	return count; 
    	
    } //end makingAnagrams(); 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      //  BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

      //  bufferedWriter.write(String.valueOf(result));
      //  bufferedWriter.newLine();

      //  bufferedWriter.close();

        scanner.close(); 
        
        System.out.println("Result: " + result); 
    }
}

