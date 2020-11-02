package thirtyDaysLearning;

import java.util.*;
import java.io.*;

/*********
 * 
 * @author Jeff
 *
 *
 	class Node{
    	Node left,right;
    	int data;
    	Node(int data){
        	this.data=data;
        	left=right=null;
    	}
	}
	
 */
class tNode{
    tNode left,right;
    int data;
    tNode(int data){
        this.data=data;
        left=right=null;
    }
}

class Day23_Bst_LevelOrderTraversal{

static void levelOrder(tNode root){
      //Write your code here
      ArrayList<tNode> nList = new ArrayList<tNode>();
      ArrayList<Integer> levelData = new ArrayList<Integer>();
      
      nList.add(root);
      
      while(true){
    	  
          int child = 0; 
          ArrayList<tNode> currList = new ArrayList<tNode>(); 
          
          for( int i=0; i< nList.size(); i++){
        	  tNode currNode = nList.get(i); 
        	  levelData.add(currNode.data);
        	  
        	  if( currNode.left != null){
        		  child ++;
        		  currList.add(currNode.left);
        	  }
        	  
        	  if( currNode.right != null){
        		  child ++;
        		  currList.add(currNode.right); 
        	  }
          } //end for nList loop; 
          
          nList = currList; 
          
          if(child == 0)
        	  break; 

      } //end while(true) loop; 
      
      for(int i=0; i<levelData.size(); i++){
    	  System.out.print( levelData.get(i) + " ");
      } 
      
    }//end levelOrder class; 

public static tNode insert(tNode root,int data){
        if(root==null){
            return new tNode(data);
        }
        else{
            tNode cur;
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
            tNode root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            
            sc.close();
            levelOrder(root);
        }	
}