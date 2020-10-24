package thirtyDaysLearning;

import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}

class Student extends Person{
	private int[] testScores;

    /*	
    *   Class Constructor
    *   
    *   @param firstName - A string denoting the Person's first name.
    *   @param lastName - A string denoting the Person's last name.
    *   @param id - An integer denoting the Person's ID number.
    *   @param scores - An array of integers denoting the Person's test scores.
    */
    // Write your constructor here
	public Student(String firstname, String lastname, int id, int[] scores){
		super(firstname, lastname, id);
		this.testScores = scores;
		this.firstName =firstname; 
		this.lastName = lastname;
		this.idNumber = id;
	} // end public Student() constructor; 

    /*	
    *   Method Name: calculate
    *   @return A character denoting the grade.
    */
    // Write your method here
	public char calculate(){
		
		int sum = 0;
		for(int i=0; i<testScores.length; i++){
			sum += testScores[i]; 
		}
		
		int avg = sum / testScores.length; 
		
		if(avg < 40){
			return 'T'; 
		} else if(avg <55){
			return 'D'; 
		} else if(avg <70){
			return 'P';
		} else if(avg <80){
			return 'A';
		} else if(avg <90){
			return 'E'; 
		}else if(avg <=100){
			return 'O'; 
		}
		
		
		return 0;
		
	}//end calculate() public method;
}

class Day12_Inheritance {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate() );
	}
}
