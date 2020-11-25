package section_Trees;

import java.util.*;
import java.io.*;


/**********
 * We do have to consider all nodes, as shown below: 
 *          1
 *	      /   \
 *	    2       3
 *	      \   
 *	        4  
 *	          \
 *	            5
 *	             \
 *	               6
 * Top view of the above binary tree is
 * 2 1 3 6
 * 
 * Input: 
   116
   37 23 108 59 86 64 94 14 105 17 111 65 55 31 79 97 78 25 50 22 66 46 104 98 81 90 
   68 40 103 77 74 18 69 82 41 4 48 83 67 6 2 95 54 100 99 84 34 88 27 72 32 62 9 56 
   109 115 33 15 91 29 85 114 112 20 26 30 93 96 87 42 38 60 7 73 35 12 10 57 80 13 52 
   44 16 70 8 39 107 106 63 24 92 45 75 116 5 61 49 101 71 11 53 43 102 110 1 58 36 28 
   76 47 113 21 89 51 19 3
 * 
 * Output: 
   1 2 4 14 23 37 108 111 115 116 83 84 85 
 */


/******
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



class TreeTopView {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	
	static class QueueNode{
	    Node node;
	    int level;
	    public QueueNode(Node node, int level){
	        this.node = node;
	        this.level = level;
	    }
	}
	
	public static void topView(Node root) {
    
		//took a queue - similar to BFS approach
        Queue<QueueNode> queue = new LinkedList<QueueNode>();
       
        //Taking a TreeMap<first, second>
        //first - stores the level of the node
        //second - stores the node.data
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
	//why TreeMap? Because I want the nodes to be sorted from leftmost to rightmost
        
        //start (since root, level = 0)
        queue.add(new QueueNode(root, 0));
        
        while(!queue.isEmpty()){
            //remove element from queue
            QueueNode r = queue.poll();
            //if the level of this node has never been reached before -> visible in top view
            if(!map.containsKey(r.level)){
                map.put(r.level, r.node.data);
            }
            
            //add node's descendants
            //all left child node levels = node.level - 1
            //all right child node levels = node.level + 1
            if(r.node.left != null){
                queue.add(new QueueNode(r.node.left, r.level - 1));
            }
            if(r.node.right != null){
                queue.add(new QueueNode(r.node.right, r.level + 1));
            }
        }
        //since already sorted (cuz TreeMap), print from left to right
        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
		
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
        topView(root);
    }	
}