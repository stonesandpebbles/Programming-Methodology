/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	// Name: 
	// Section Leader: 
	
/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW -1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;

/** Runs the Breakout program. */
	public void run() {
		/* You fill this in, along with any subsidiary methods */
		/* Don't forget to add your name/SL at the top. */
	
	createBricks();
	 createPaddle();
	 createBallandBounce();
	 while(chancesovr!=NTURNS){
		 waitForClick();
		
	createBallandBounce();
	 
	 }
	 add(new GLabel("game over",WIDTH/2,HEIGHT/2));
	}
	
	 private void createBricks(){
		 int brickxoffset=(WIDTH-BRICK_WIDTH*NBRICKS_PER_ROW-NBRICKS_PER_ROW*BRICK_SEP)/2;
		 int brickyoffset=BRICK_Y_OFFSET;
		 Color color=Color.RED;
		 for(int i=0;i<NBRICK_ROWS;i++){
			 switch(i/2){
			 case 1:color=Color.ORANGE;
			 		break;
			 case 2:color=Color.YELLOW;
			 		break;	
			 case 3:color=Color.GREEN;
			 		break;
			 case 4:color=Color.CYAN;
			 		break;
			 }
			 
				 for(int j=0;j<NBRICKS_PER_ROW;j++){
					 GRect rect=new GRect(brickxoffset,brickyoffset,BRICK_WIDTH,BRICK_HEIGHT);
					 rect.setColor(color);
					 rect.setFilled(true);
					 add(rect);
					 brickxoffset+=BRICK_SEP+BRICK_WIDTH;
				 }
			 brickyoffset+=BRICK_HEIGHT+BRICK_SEP;
			 brickxoffset=(WIDTH-BRICK_WIDTH*NBRICKS_PER_ROW-NBRICKS_PER_ROW*BRICK_SEP)/2;
			 
			
			 
		 }
		
	 }
private void createPaddle(){
	 paddle=new GRect(PADDLE_WIDTH,PADDLE_HEIGHT);
	paddle.setFilled(true);
	add(paddle,(WIDTH-PADDLE_WIDTH)/2,HEIGHT-PADDLE_Y_OFFSET-PADDLE_HEIGHT);
	addMouseListeners();
	
}
private void createBallandBounce(){
	ball=new GOval(2*BALL_RADIUS,2*BALL_RADIUS);
	ball.setFilled(true);
	add(ball,WIDTH/2-BALL_RADIUS,HEIGHT/2-BALL_RADIUS);
	vx = rgen.nextDouble(1.0, 3.0);
	if (rgen.nextBoolean(0.5)) vx = -vx;
	vy=3;
	
	while(!gameOver()){
	ball.move(vx, vy);
	checkForBoundary();
	//checkForCollision();
	getCollidingObject();
	checkForCollision();
	pause(15);
	}
	
	pause(100);
	remove(ball);
	remove(msg);
	
	

	
	
}
private void checkForBoundary(){
	if(ball.getX()-WIDTH+2*BALL_RADIUS>0||(ball.getX()<0)){
		vx=-vx;
	}
	if(ball.getY()<0){
		vy=-vy;
		//double diff=ball.getY()-HEIGHT;
		//ball.move(0,-2*diff);
	}
	
}
private GObject getCollidingObject(){
	double x=ball.getX();
	double y=ball.getY();
	collider=getElementAt(x,y);
	if(collider==null) collider=getElementAt(x,y+2*BALL_RADIUS);
	if(collider==null)collider=getElementAt(x+2*BALL_RADIUS,y);
	if(collider==null)collider=getElementAt(x+2*BALL_RADIUS,y+2*BALL_RADIUS);
	return(collider);
	
	
	
	
	}
private void checkForCollision(){
	if(collider!=null)
	{
		if(collider!=paddle)
		{remove(collider);
		println(+count);
		count--;
		vy=-vy;}
		else vy=-vy;
		
		}
	}

private boolean gameOver(){
	if(count==0){
		msg=new GLabel("you win",WIDTH/2,HEIGHT/2);
		add(msg);
		return(true);
	}
	else if(ball.getY()-getHeight()+2*BALL_RADIUS>0){
		msg=new GLabel("turn over",WIDTH/3,HEIGHT/2);
		add(msg);
		//pause(20);
		chancesovr++;
		remove(ball);
		addMouseListeners();
		pause(50);
		return true;
	}
	else return false;
}




public void mouseMoved(MouseEvent e){
	lastx=e.getX();
if((e.getX()-WIDTH+PADDLE_WIDTH)<=0){	
	paddle.move(lastx-paddle.getX(),0);
}
}
int count=NBRICK_ROWS*NBRICKS_PER_ROW;
int chancesovr=0;
private GLabel msg;
private int lastx;
private GObject collider;
private GOval ball;
private GRect paddle;
private RandomGenerator rgen=RandomGenerator.getInstance();
private double vx,vy;
}
