/*
 * File: FindRange.java
 * --------------------
 * This program is a stub for the FindRange problem, which finds the
 * smallest and largest values in a list of integers.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {

	// Name: 
	// Section Leader: 
	private static final int SENTINEL=0;
	public void run() {
		// You fill this in
		int smallest=1;
		int largest=1;
		int number=readInt("?");
		while(number!=SENTINEL){
			if(largest<number){
				largest=number;
			}
			else if(smallest>number){
				smallest=number;
			}
			number=readInt("?");
		}
		println("smallest="+smallest);
		println("largest is="+largest);
	}

}
