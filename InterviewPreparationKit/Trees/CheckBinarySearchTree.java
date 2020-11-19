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

class CheckBinarySearchTree {

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
		ArrayList<Integer> inOrder = inOrderTraversal(root); 
		if(inOrder.size() < 2)
			return true; 
		
		boolean bst = true; 
		for( int i=0; i<inOrder.size()-1; i++){ 
			System.out.print(" " + inOrder.get(i) );
			if(inOrder.get(i) > inOrder.get(i+1))
				bst = false; 
		}
		System.out.println(); 
		
		return bst; 
		
    } //end lca() method; 

	

	private static ArrayList<Integer> inOrderTraversal(Node root) {
		// TODO Auto-generated method stub		
		
		if(root == null){
			return null;
		}
		
		System.out.println("work on node:" + root.data); 
		
		ArrayList<Integer> currList = new ArrayList<Integer>(); 
		ArrayList<Integer> leftList = inOrderTraversal(root.left); 
		ArrayList<Integer> rightList = inOrderTraversal(root.right); 
		
		if(leftList != null){
			for(int i=0; i<leftList.size(); i++){
				currList.add(leftList.get(i)); 
			}
		} //end add left list
		
		currList.add(root.data); 
		
		if(rightList != null){
			for(int i=0; i<rightList.size(); i++){
				currList.add( rightList.get(i) ); 
			}
			
		} //end add right list; 
		
		return currList;
		
	}//end inOrderTraversal(); 



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
    }

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
    }	
}