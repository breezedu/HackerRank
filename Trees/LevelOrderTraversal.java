package section_Trees;

import java.util.*;
import java.io.*;

/*****
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

class LevelOrderTraversal {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
      
      if( root == null){
    	  return; 
      }
      
      Queue<Node> levelOT = new LinkedList<Node>();
      
      levelOT.add(root); 
      
      while( !levelOT.isEmpty() ){
    	  
    	  Node currNode = levelOT.poll(); 
    	  System.out.print(currNode.data + " ");
    	  
    	  if(currNode.left != null){
    		  levelOT.add(currNode.left);
    	  }
    	  
    	  if(currNode.right != null){
    		  levelOT.add(currNode.right); 
    	  }
    	  
      } //end while levelOT is emputy loop; 
		
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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
        levelOrder(root);
    }	
}