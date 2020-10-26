package thirtyDaysLearning;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day16_Exceptions_String2Integer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next(); 
        
        try{
        	System.out.println( Integer.parseInt(S));
        } catch (NumberFormatException e){
        	System.out.println("Bad String");
        }
        
        in.close();
        
    }
}
