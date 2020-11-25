package section_Trees;

import java.util.*;
import java.io.*;
	
/****************
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


class BST_insertion {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root, int data) {
		if(root == null){
			root = new Node(data); 
			
		} else if(data > root.data){
			Node currNode = insert( root.right, data); 
			root.right = currNode; 
			
		} else {
			Node currNode = insert( root.left, data);
			root.left = currNode; 
		}
		
		return root;    	
    }// end insert(); 

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}