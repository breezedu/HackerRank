package thirtyDaysLearning;

import java.util.*;
import java.io.*;
class LinkedNode{
    LinkedNode left,right;
    int data;
    LinkedNode(int data){
        this.data=data;
        left=right=null;
    }
}
class Day22_BinearySearchTree{

	public static int getHeight(LinkedNode root){
		
		if( root.left == null & root.right ==null){
			return 0;
		} else if( root.left ==null & root.right != null){
			return 1 + getHeight(root.right);
		} else if( root.left != null & root.right == null){
			return 1 + getHeight(root.left); 
			
		} else {
			return Math.max(1 + getHeight(root.left),  1 + getHeight(root.right)); 
		}
      //Write your code here
    }

    public static LinkedNode insert(LinkedNode root,int data){
        if(root==null){
            return new LinkedNode(data);
        }
        else{
            LinkedNode cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
	 public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        LinkedNode root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}