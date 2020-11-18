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

class LowestCommonAncestor_2 {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
		
      	// Write your code here.
		ArrayList<Node> v1_list = findPath2Node(root, v1);
		ArrayList<Node> v2_list = findPath2Node(root, v2);
				
		int point = 0; 
		int endP = Math.min(v1_list.size(),  v2_list.size()); 
		
		for(int i=0; i<endP; i++){
			if(v1_list.get(i) != v2_list.get(i)){
				point = i -1; 
				break; 
			}
			
			point = endP - 1; 
		}
		
		return v1_list.get(point);
    } //end lca() method; 

	private static ArrayList<Node> findPath2Node(Node root, int v1) {
		// TODO Auto-generated method stub
		if(root == null){
			return null; 
		}
		
		ArrayList<Node> ret_list = new ArrayList<Node>(); 
		
		ret_list.add(root); 
		
		if(root.data == v1){
			return ret_list; 
		
		} else{
			ArrayList<Node> left_list = findPath2Node(root.left, v1);
			ArrayList<Node> right_list = findPath2Node(root.right, v1); 
			
			if( left_list != null && left_list.get( left_list.size() - 1).data == v1){
				for(int i=0; i<left_list.size(); i++){
					ret_list.add( left_list.get(i) ); 
				}
				
				return ret_list; 
			} else if(right_list!= null && right_list.get(right_list.size() - 1).data == v1){
				
				for( int i=0; i< right_list.size(); i++){
					ret_list.add( right_list.get(i) ); 
				}
				
				return ret_list; 
			
			} else {
				
				return null; 
			}
		} //end if-else; 
		
	} //end findPath2Node() method; 

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
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}