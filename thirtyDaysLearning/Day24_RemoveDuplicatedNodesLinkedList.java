package thirtyDaysLearning;

import java.io.*;
import java.util.*;
class lNode{
	int data;
	lNode next;
	lNode(int d){
        data=d;
        next=null;
    }
	
}
class Day24_RemoveDuplicatedNodesLinkedList
{

    public static lNode removeDuplicates(lNode head) { 
    	
    	if (head==null)
    		return null;
    	
    	lNode p = head;
    	lNode q = p.next;
    	
    	/****************************
    	while(q != null){
    		//System.out.println( " p = " + p.data); 
    		
    		while(q != null && q.data == p.data){
    			System.out.print(" q=" + q.data + " ");
    			q = q.next;     			
    		} 
    		
    		p.next = q;
    		p = p.next; 
    		if(p != null)
    			q = p.next;
    	}
    	
    	*/ 
    	
    	while( p.next != null){
    		
    		if(p.next.data == p.data){
    			p.next = p.next.next; 
    		
    		} else {
    			p = p.next; 
    		}
    		
    	} //end while loop; 
    	
		return head;
      //Write your code here

    }

	 public static  lNode insert(lNode head,int data)
     {
        lNode p=new lNode(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            lNode start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(lNode head)
        {
              lNode start=head;
              while(start!=null)
              {
                  System.out.print(start.data+" ");
                  start=start.next;
              }
        }
        public static void main(String args[])
        {
              Scanner sc=new Scanner(System.in);
              lNode head=null;
              int T=sc.nextInt();
              while(T-->0){
                  int ele=sc.nextInt();
                  head=insert(head,ele);
              }
              head=removeDuplicates(head);
              display(head);

       }
    }
