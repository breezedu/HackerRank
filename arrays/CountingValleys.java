package arrays;
import java.io.*;



public class CountingValleys {

    public static int countingValleys(int steps, String path) {
		
    	int seeLevel = 0; 
    	int valleyCount = 0; 
    	
    	for(int i = 0; i<path.length(); i++){
    		
    		char currCh = path.charAt(i);
    		if(currCh == 'D'){
    			seeLevel++;
    			if(seeLevel == 0) {
    				valleyCount ++; 
    			}
    		} else {
    			
    			seeLevel--; 
    		}
    		
    	}
    	
    	// Write your code here
    	return valleyCount;
    }
	
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = countingValleys(steps, path);
        
        //int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
