

	import acm.program.*;
	import acm.graphics.*;
	import acm.util.*;
	import java.awt.event.*;/**@import java.awt.event.**/
	public class prac extends GraphicsProgram{
		

		
		public void run(){
			//addMouseListeners();
			addMouseListeners();
		}
			public void mousePressed(MouseEvent e){
				lastx=e.getX();
				lasty=e.getY();
				 line=new GLine(e.getX(),e.getY(),lastx,lasty);
				add(line);
			}
			public void mouseDragged(MouseEvent e){
				
				line.setEndPoint(e.getX(),e.getY());
				
			
				
			}
				
			
			private double lastx,lasty;	
			public GLine line;
			

		//private RandomGenerator rgen=RandomGenerator.getInstance();
		private RandomGenerator rgen = new RandomGenerator();
	}



