//Abdalla Abdelmagid

import java.util.*;

class Main {
	static Scanner in = new Scanner(System.in);

	// Test Driver for Person Class
    public static void main(String[] args) {
		String name = "John Smith";
        int age = 42;
        int height = 65;
		int weight = 140;
		int credits = 28;
		double gpa = 3.25;
		String major = "Biology";
		int teachingLoad = 12;
		double score = 3.5;
		String department = "Biology";
	
    	Student js = new Student(name, age, height, weight, credits, gpa, major);
		System.out.println("Method getName returns " + js.getName());
		System.out.println("Method getAge returns " + js.getAge());
		System.out.println("Method getHeight returns " + js.getHeight());
		System.out.println("Method getWeight returns " + js.getWeight());
		System.out.println("Method getCredits returns " + js.getCredits());
		System.out.println("Method getGpa returns " + js.getGpa());
		System.out.println("Method getMajor returns " + js.getMajor());
		System.out.println("toString method returns " + js.toString());
		System.out.println("What year is student in? " + js.status());
		System.out.println("Student on Deans list? " + js.deansList());

		Professor rj = new Professor(name, age, height, weight, teachingLoad, score, department);
		System.out.println("Method getTeachingLoad returns" + rj.getTeachingLoad());
		System.out.println("Method getScore returns" + rj.getScore());
		System.out.println("Method getDepartment returns" + rj.getDepartment());
		System.out.println("Professor rating: " + rj.rating());
		System.out.println("toString method returns " + rj.toString());
		
        
 
  
  }
}
