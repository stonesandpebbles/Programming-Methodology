/*
 * File: Pyramid.java
 * ------------------
 * This program is a stub for the Pyramid problem, which draws
 * a brick pyramid.
 */

import acm.program.*;
import acm.graphics.*;

public class Pyramid extends GraphicsProgram {

	// Name:
	// Section Leader:
	
	/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

	/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

	/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		// You fill this in
		int counter=14;
		int y=1;
		int startingptx=(getWidth()-(14*BRICK_WIDTH))/2;
		while(counter>0){
			for(int i=0;i<counter;i++){
				GRect brick=new GRect(BRICK_WIDTH*i+startingptx,getHeight()-BRICK_HEIGHT*y,BRICK_WIDTH,BRICK_HEIGHT);
				add(brick);
		}
			startingptx=startingptx+(BRICK_WIDTH/2);
			counter--;
			y++;
		}
	}
}
