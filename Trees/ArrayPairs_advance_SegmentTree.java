package section_Trees;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayPairs_advance_SegmentTree {

    // Complete the solve function below.
    static long solve(long[] arr) {
    	
    	long total = 0; 
    	
    	long[] setTree = SegmentTreeMax( arr ); 
    	
    	System.out.println("Built the segment tree."); 
    	    	
    	for(int i=0; i<arr.length - 1; i++){
    		//System.out.println("Working on the ith = " + i + " loop."); 
    		
    		for(int j=i+1; j<arr.length; j++){
    			
    			long max_ij = setTreeMax(setTree, arr.length, i, j);
    			
    		//	System.out.println(" i=" + i + ", j=" + j + ", max=" + max_ij); 
    			
    			if(arr[i] * arr[j] <= max_ij){
    				total++;     				
    			}
    			
    		} //end inner for j loop; 
    	} //end outer for i loop; 
    	
		return total;

    } //end solve() method; 





	private static long setTreeMax(long[] setTree, int n, int from, int to) {
		// TODO Auto-generated method stub
		from += n;
		to += n+1;
		
		long max = Long.MIN_VALUE;
		
		while( from < to){
			if ((from & 1) == 1) { // 'from' is odd, so it is the right child of its parent, then interval includes node 'from' but doesn't include its parent
                max = Math.max(max, setTree[from]);
                from++;
            }
            if ((to & 1) == 1) { // 'to' is odd, so it's the right child of its parent, then might as well use the parent
                to--;
                max = Math.max(max, setTree[to]);
                                
            }
            from >>= 1; // shift right is the same as divide by 2 but a little faster
            to >>= 1;  
			
		}
		
		return max;
	}

	private static long[] SegmentTreeMax(long[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length; 
		long tree[] = new long[n * 2]; 
		System.arraycopy(arr,  0, tree,  n, n);
		
		for(int i=n-1; i>0; i--){
			tree[i] = Math.max(tree[ 2*i],  tree[2*i + 1]); 
		}
		
		return tree;
	}//end segmentTree(); 


    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    	long starttime = System.currentTimeMillis(); 
    	System.out.println("01 Time: " + starttime); 
    	
    	File text = new File("E:/Github/HackerRank/Trees/segTreeTest.txt"); 
    	
    	Scanner scanner = new Scanner(text);
    	
        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        System.out.println(arrItems.length);
        
        System.out.println("02 Time: " + (System.currentTimeMillis() - starttime ) ); 

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        long result = solve(arr);

        System.out.println("03 Time: " + (System.currentTimeMillis() - starttime) ); 
       // bufferedWriter.write(String.valueOf(result));
       // bufferedWriter.newLine();

       // bufferedWriter.close();
        
        System.out.println(" There are " + result + " paired numbers meeting the criteria."); 

        scanner.close();
    }
}
