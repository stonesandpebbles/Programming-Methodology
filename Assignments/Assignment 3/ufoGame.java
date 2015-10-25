import acm.program.*;
import acm.graphics.*;

import java.awt.*;
import java.awt.event.*;

public class ufoGame extends GraphicsProgram{

/** Size and speed of UFO */ 
private static final int UFO_WIDTH=40;
private static final int UFO_HEIGHT = UFO_WIDTH / 2; 
private static final int UFO_SPEED = 5; 
/** Size and speed of bullets */ 
private static final int BULLET_SPEED = 10;
private static final int BULLET_DIAM = 5;
/** Animation cycle delay */
private static final int DELAY = 10;



public void run(){
	setup();
	while(!gameOver()){
	checkForBoundary();
	moveDist();
	checkForCollision();
	pause(DELAY);
	
	
	}
	checkForCollision();
}
private boolean gameOver(){
	if (shooter!=null){
		obj=getElementAt(shooter.getX(),shooter.getY());
	}
	if(obj!=null||ufo.getY()-getHeight()>0){
	
		return true;
	}
	return false;
		
	}

private void checkForBoundary(){
	if(ufo.getX()-getWidth()+UFO_WIDTH>=0||ufo.getX()<0){
		ufo.move(0,UFO_HEIGHT);
		ux=-ux;
		
	}
	if(shooter!=null){
	if(shooter.getY()<0){
		remove(shooter);
		shooter=null;
	}
	}
	
}
private void moveDist(){
	ufo.move(ux,0);
	if(shooter!=null){
	shooter.move(0, -BULLET_SPEED);
}
}
private void checkForCollision(){
	if(obj==ufo){
		remove(ufo);
		ufo=null;
		remove(shooter);
		shooter=null;
		add(new GLabel("hdfasjkhs",250,49));
	}
}
private void setup(){
	ufo=new GRect(0,0,UFO_WIDTH,UFO_HEIGHT);
	 ufo.setFilled(true);
	add(ufo);
	shooter=new GOval(getWidth()/2,getHeight(),BULLET_DIAM,BULLET_DIAM);
	shooter.setFilled(true);
	add(shooter);
	addMouseListeners();
	
}
public void mouseClicked(MouseEvent e){
	if(shooter==null){
	shooter=new GOval(getWidth()/2,getHeight(),BULLET_DIAM,BULLET_DIAM);
	shooter.setFilled(true);
	add(shooter);
	}
}
private GObject obj;
private int ux=UFO_SPEED;
private GRect ufo;
private GOval shooter;
}
