package arrays;

import java.io.IOException;
import java.util.Scanner;

public class JumpingOnTheClouds { 
	
	// Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
		int noOfJumps = 0, i = 0;
		while(true) {
			if(i + 2 < c.length && c[i + 2] == 0) {
				i += 2;
			} else if(i + 1 < c.length) {
				i++;
			} else {
				break;
			}
			noOfJumps++;
		}
		
		System.out.println(noOfJumps);
		return noOfJumps;
		
    } //end jumpingOnClouds() function; 

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.print(result);
       // bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    } //end Main(); 

} //end everything; 
