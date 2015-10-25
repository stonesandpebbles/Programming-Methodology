/*
 * File: Rainbow.java
 * ------------------
 * This program is a stub for the Target problem, which displays
 * a target by adding consecutively smaller circles to the canvas.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class Target extends GraphicsProgram {

	// Name:
	// Section Leader:
	private static final int BIG_CIRCLE=72;
	private static final int MEDIUM_CIRCLE=(int)(0.65*72);
	private static final int SMALL_CIRCLE=(int)(0.3*72);
	public void run() {
		int centrex=getWidth()/2;
		int centrey=getHeight()/2;
		// You fill this in
		//add(new GOval(0,0,45,45));
		GOval bigcircle=new GOval(centrex-BIG_CIRCLE,centrey-BIG_CIRCLE,2*BIG_CIRCLE,2*BIG_CIRCLE);
		bigcircle.setColor(Color.RED);
		bigcircle.setFilled(true);
		add(bigcircle);
		GOval mediumcircle=new GOval(centrex-MEDIUM_CIRCLE,centrey-MEDIUM_CIRCLE,2*MEDIUM_CIRCLE,2*MEDIUM_CIRCLE);
		mediumcircle.setFilled(true);
		mediumcircle.setColor(Color.WHITE);
		add(mediumcircle);
		GOval smallcircle=new GOval(centrex-SMALL_CIRCLE,centrey-SMALL_CIRCLE,2*SMALL_CIRCLE,2*SMALL_CIRCLE);
		smallcircle.setColor(Color.RED);
		smallcircle.setFilled(true);
		add(smallcircle);
		
		
	}

}
