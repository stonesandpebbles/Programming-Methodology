import acm.program.*;
import acm.graphics.*;
import java.awt.*;
public class robotFace extends GraphicsProgram {
	
	private static final int HEAD_WIDTH=200;
	private static final int HEAD_HEIGHT=300;
	private static final int EYE_RADIUS=50;
	private static final int MOUTH_WIDTH=150;
	private static final int MOUTH_HEIGHT=50;
	public void run(){
		GRect face=new GRect((getWidth()-HEAD_WIDTH)/2,(getHeight()-HEAD_HEIGHT)/2,HEAD_WIDTH,HEAD_HEIGHT);
		face.setColor(Color.GRAY);
		face.setFilled(true);
		//face.setColor(Color.BLACK);
		add(face);
		GOval eye1=new GOval((getWidth()-HEAD_WIDTH)/2+25,(getHeight()-HEAD_HEIGHT)/2+HEAD_HEIGHT/4,EYE_RADIUS,EYE_RADIUS);
		GOval eye2=new GOval(getWidth()/2+25,(getHeight()-HEAD_HEIGHT)/2+HEAD_HEIGHT/4,EYE_RADIUS,EYE_RADIUS);
		eye1.setColor(Color.YELLOW);
		eye2.setColor(Color.YELLOW);
		eye1.setFilled(true);
		eye2.setFilled(true);
		add(eye1);
		add(eye2);
		GRect mouth=new GRect((getWidth()-HEAD_WIDTH)/2+25,getHeight()/2+HEAD_HEIGHT/4-MOUTH_HEIGHT,MOUTH_WIDTH,MOUTH_HEIGHT);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		add(mouth);
		
		
		
	}

}
