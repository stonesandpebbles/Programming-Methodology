/*
 * File: Hailstone.java
 * --------------------
 * This program is a stub for the Hailstone problem, which computes
 * Hailstone sequence described in Assignment #2.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {

	// Name: 
	// Section Leader: 
	
	public void run() {
		// You fill this in
		int counter=0;
		int number=readInt("enter a number");
		while(number!=1){
			if(number%2==0){
				println(+number+"is even so i divide by 2");
				number=number/2;
				
			
			}
			else{
				println(+number+"is odd so i make 3n+1");
				number=3*number+1;
				
			}
			counter++;
		}
		println("the process took steps="+counter);
	}

}
