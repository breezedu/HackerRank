package thirtyDaysLearning;

import java.io.*;
import java.util.*;

public class Day18_QueuesNStacks {
    // Write your code here. 
	
	Stack<Character> stack = new Stack<>();
	Queue<Character> queue = new LinkedList<>();
	
	private void enqueueCharacter(char c) {
		// TODO Auto-generated method stub
		queue.add(c);
	}

	private void pushCharacter(char c) {
		// TODO Auto-generated method stub
		stack.add(c);
	} 
	
	private Object dequeueCharacter() {
		// TODO Auto-generated method stub
		return queue.poll();
	}

	private Object popCharacter() {
		// TODO Auto-generated method stub
		return stack.pop();
	}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        Day18_QueuesNStacks p = new Day18_QueuesNStacks();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }




}