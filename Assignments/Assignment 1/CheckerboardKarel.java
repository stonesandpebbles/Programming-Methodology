/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

/*
 * Name: 
 * Section Leader: 
 */

public class CheckerboardKarel extends SuperKarel {

	public void run() {
		// You fill in this part
		while(notFacingNorth()){
			
		fillRow();
		if(notFacingNorth()){
			changeRow();
			if(frontIsClear()){
				move();
			}
		}
		}
	}
private void fillRow(){
	while(frontIsClear()){
		putBeeper();
    	move();
    
    if(frontIsClear()){
		move();
		
    
		}
    else{
    	changeRow();
    	
    }
    
    }
	if(notFacingNorth()){
    	putBeeper();
    
    }
	
	
	
    }
		
		
    
	
	
	/*if(rightIsBlocked()){
		turnRight();
	}
	if(leftIsBlocked()){
		turnLeft();
	}*/
	
	
	

private void changeRow(){
	
		if(facingEast()){
			
			turnLeft();
			if(frontIsClear()){
		      move();
		      if(leftIsBlocked()){
		      if(frontIsClear()){
		    	  move();
		    	  
		      }
		      }
		     //if(leftIsClear()){
		    	//if(frontIsClear()){
		    		turnLeft();
		    		if(rightIsBlocked()){
		    			if(frontIsBlocked()){
		    			turnRight();
		    		}
		    		}
		    	//}
		      //}
		}
		
	}
		else{
		turnRight();
		if(frontIsClear()){
	    move();
	    if(rightIsBlocked()){
	    if(frontIsClear()){
	    	  move();
	    	  
	      }
	    }
	    //if(rightIsClear()){
	    //if(frontIsClear()){
	    	turnRight();
	    	if(leftIsBlocked()){
	    		if(frontIsBlocked()){
	    			turnLeft();
	    		}
	    	}
	    //}
	    //}
	}
		}
	
	

}
}

