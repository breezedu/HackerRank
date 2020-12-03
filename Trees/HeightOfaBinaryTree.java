package section_Trees;

import java.util.*;
import java.io.*;

/*********************
 * 
 * @author Jeff
 * Question: 
 * https://www.hackerrank.com/interview/interview-preparation-kit/trees/challenges
 * 
 * Input: 
 * 7
 * 3 5 2 1 4 6 7
 * 
 * Output
 * 3
 */
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

class HeightOfaBinaryTree {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static int height(Node root) {
		if(root.left == null & root.right == null){
			return 0;
		
		} else if(root.left == null){
			return 1 + height(root.right); 
			
		} else if(root.right == null){
			return 1 + height(root.left);
			
		} else {
			return 1 + Math.max(height(root.left), height(root.right) ); 
		}

		
    } //end height() method; 

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
        int height = height(root);
        System.out.println(height);
    }	
}
