package thirtyDaysLearning;

import java.io.*;
import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
} //end Node class;

class Day15_linkedlist {

    public static  Node insert(Node head,int data) {
		
        //if the current head node is null, return the newly created curNode; 
		Node curNode = new Node(data);
		if(head == null)
			return curNode;
		
		//initiate a pointer node pointing to the tail node of the linked list;
		Node Nodetail = head;		
		while( Nodetail.next != null){
			Nodetail = Nodetail.next;
		} 		
		
		//add curNode to the tail of the linked list; 
		Nodetail.next = curNode;
		
		return head;
    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
