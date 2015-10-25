/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

/*
 * Name: 
 * Section Leader: 
 */

public class StoneMasonKarel extends SuperKarel {

	public void run() {
		// You fill in this part
		getIntoPosition();
		doMasonWork();
		while(frontIsClear()){
			
			move();
			move();
			move();
			move();
			getIntoPosition();
		    doMasonWork();
		}
	
	}
	private void getIntoPosition(){
		turnLeft();
		while(frontIsClear()){
			move();
		}
		turnAround();
		}
		private void doMasonWork(){
			while(frontIsClear()){
				if(noBeepersPresent()){
					putBeeper();
				}
				
				move();
			}
			if(noBeepersPresent()){
				putBeeper();
			}
			
			turnLeft();
		}
}//voila