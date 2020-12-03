package section_Trees;

import java.util.*;
import java.io.*;

/******************
 * Share the same Node class from HeightOfaBinaryTree.java
	class Node {
	    Node left;
	    Node right;
	    int data;
	    
	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}
 */

class CheckBinarySearchTree_2 {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static boolean checkBST(Node root) {
		if(root == null){
			return true; 
		}
		
      	// Write your code here. 
		return checkBST_MinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
    } //end checkBST() method; 

	
	private static boolean checkBST_MinMax(Node root, int min, int max) {
		// TODO Auto-generated method stub
		if( root.data > max || root.data < min)
			return false;
		boolean leftCheck = checkBST_MinMax(root.left, min, root.data);
		boolean rightCheck = checkBST_MinMax(root.right, root.data, max);
		
		return (leftCheck && rightCheck); 
	}//end checkBST_MinMax(); 


	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data ) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }//end insert() method; 

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	
        scan.close();
        boolean bst = checkBST(root);
        System.out.println( bst );
    }//end main(); 	
}