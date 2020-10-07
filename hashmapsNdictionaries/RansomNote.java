package hashmapsNdictionaries;

import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {

	
	// Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {

    	HashMap<String, Integer> noteHash = new HashMap<String, Integer>(); 
    	
    	String binaryYN = "Yes"; 
    	
    	for(int i=0; i< magazine.length; i++){
    		
    		if( !noteHash.containsKey(magazine[i])){
    			noteHash.put(magazine[i], 1);
    		
    		} else {
    			
    			int currValue = noteHash.get(magazine[i]);
    			noteHash.put(magazine[i], currValue + 1); 
    			
    		}
    		
    	} //end for note length loop; 
    	
    	
    	for(int i = 0; i< note.length; i ++){
    		
    		if( !noteHash.containsKey(note[i])){
    			System.out.println("Note does not contain: " + note[i]);
    			binaryYN = "No"; 
    		
    		} else {
    			
    			int currValue = noteHash.get(note[i] ) - 1; 
    			noteHash.put(note[i],  currValue); 
    			
    			if( currValue < 0){
    				binaryYN = "No";
    				System.out.println("There's no more word: " + note[i]);
    			}
    		}
    		
    	} //end for magazine length; 
    	
    	System.out.println(binaryYN);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
	
}
