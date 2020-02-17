package io.kanchi.oopsconcepts.design;

/**Cohesion is Cohesion is the Object Oriented principle most closely associated with making sure that a 
 * class is designed with a single, well-focused purpose.
 * 
 * more focussed a class is = more cohesiveness
 * @author kanch
 *
 */

// Java program to illustrate 
//high cohesive behavior 

class Multiply { 
 int a = 5; 
 int b = 5; 
 public int multiply(int a, int b) 
 { 
     this.a = a; 
     this.b = b; 
     return a * b; 
 } 
}  

class Display { 
	public void display(int c) {
		System.out.println("Output is = "+c);
	}
} 

public class Cohesion {
	public static void main(String[] args) 
	 { 
	     Multiply m = new Multiply(); 
	     Display d = new Display();
	     d.display(m.multiply(5, 5)); 
	 } 

}
