/*
 * File: GraphicsHierarchy.java
 * ----------------------------
 * This program is a stub for the GraphicsHierarchy problem, which
 * draws a partial diagram of the acm.graphics hierarchy.
 */

import acm.program.*;
import acm.graphics.*;

public class GraphicsHierarchy extends GraphicsProgram {

	// Name: 
	// Section Leader:
	private static final int BOX_WIDTH=140;
	private static final int BOX_HEIGHT=60;

	public void run() {
		// You fill this in
		int width=getWidth()/2;
		int height=getHeight()/2;
		GRect box1=new GRect(width-BOX_WIDTH/2,height-BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
		add(box1);
		GLabel box1L=new GLabel("Program");
		double w1=box1L.getWidth();
		double h1=box1L.getAscent();
		add(box1L,width-BOX_WIDTH/2+((140-w1)/2),height-BOX_HEIGHT+((60-h1)/2));
		
		GRect box2=new GRect(width-BOX_WIDTH/2,height+BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
		add(box2);
	    GLabel box2L=new GLabel("Graphics Program");
	    double w2=box2L.getWidth();
		double h2=box2L.getAscent();
		add(box2L,width-BOX_WIDTH/2+((140-w2)/2),height+BOX_HEIGHT+((60-h2)/2));
		GRect box3=new GRect(width-(1.5*BOX_WIDTH)-10,height+BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
		add(box3);
		GLabel box3L=new GLabel("Dialog Program");
		double w3=box3L.getWidth();
		double h3=box3L.getAscent();
		add(box3L,width-(1.5*BOX_WIDTH+10)+((140-w3)/2),height+BOX_HEIGHT+((60-h3)/2));
		GRect box4=new GRect(width+BOX_WIDTH/2+10,height+BOX_HEIGHT,BOX_WIDTH,BOX_HEIGHT);
		add(box4);
		GLabel box4L=new GLabel("Console Program");
		double w4=box4L.getWidth();
		double h4=box4L.getAscent();
		add(box4L,width+BOX_WIDTH/2+10+((140-w4)/2),height+BOX_HEIGHT+((60-h4)/2));
		add(new GLine(width,height,width,height+BOX_HEIGHT));
		add(new GLine(width,height,width-BOX_WIDTH-10,height+BOX_HEIGHT));
		add(new GLine(width,height,width+BOX_WIDTH+10,height+BOX_HEIGHT));
	}

}
