/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

/*
 * Name: 
 * Section Leader: 
 */

public class CollectNewspaperKarel extends SuperKarel {

	public void run() {
		// You fill in this part
		moveToTheNewspaper();
		pickUpTeNewspaper();
		returnToStartingPoint();
		

	}
private void moveToTheNewspaper(){
	while(frontIsClear()){
		move();
	}
	turnRight();
	while(leftIsBlocked()){
		move();
	}
	turnLeft();
	while(noBeepersPresent()){
		move();
	}
	}
	
private void pickUpTeNewspaper(){
	pickBeeper();

    turnAround();
}

private void returnToStartingPoint(){
	move();
	move();
	move();
	turnRight();
	move();
	turnRight();
}

}

