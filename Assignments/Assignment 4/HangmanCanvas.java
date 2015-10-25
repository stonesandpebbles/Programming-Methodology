/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		removeAll();
		START_Y=getHeight()-OFFSET;
		drawCanvas(0);
		
		
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		if(wordDisp!=null) remove(wordDisp);
		wordDisp=new GLabel(word,50,250);
		
		add(wordDisp);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		count++;
		int x=50;
		gchar+=letter;
		add(new GLabel(gchar,x,300));
		drawCanvas(count);
	}
	
	
	private void drawCanvas(int i)
	{
		switch(i){
		case 0://add(new GLabel("WTF",70,80));
				add(new GLine(START_X,START_Y,START_X,-SCAFFOLD_HEIGHT+START_Y));
		       add(new GLine(START_X,-SCAFFOLD_HEIGHT+START_Y,START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y));
		       add(new GLine(START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y,START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH));
		       break;
		       
	   case 1: add(new GOval(START_X+BEAM_LENGTH-HEAD_RADIUS,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH,2*HEAD_RADIUS,2*HEAD_RADIUS));
	           break;
	           
	   case 2: add(new GLine(START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS,START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH));
	           break;
	          
	   case 3:add(new GLine(START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,START_X+BEAM_LENGTH-UPPER_ARM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD));
	   			add(new GLine(START_X+BEAM_LENGTH-UPPER_ARM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,START_X+BEAM_LENGTH-UPPER_ARM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH));
	            break;
	            
	   case 4: add(new GLine(START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,START_X+BEAM_LENGTH+UPPER_ARM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD));			
	   			   
	   		  add(new GLine(START_X+BEAM_LENGTH+UPPER_ARM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD,START_X+BEAM_LENGTH+UPPER_ARM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+ARM_OFFSET_FROM_HEAD+LOWER_ARM_LENGTH));
		       break;
		       
	   case 5:add(new GLine(START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,START_X+BEAM_LENGTH+HIP_WIDTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH));
	   		  add(new GLine(START_X+BEAM_LENGTH+HIP_WIDTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,START_X+BEAM_LENGTH+HIP_WIDTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH));
	   		  break;
	   	
	   case 6:add(new GLine(START_X+BEAM_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,START_X+BEAM_LENGTH-HIP_WIDTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH));
		      add(new GLine(START_X+BEAM_LENGTH-HIP_WIDTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH,START_X+BEAM_LENGTH-HIP_WIDTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH));		  
		      break;
		     
	   case 7:add(new GLine(START_X+BEAM_LENGTH+HIP_WIDTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,START_X+BEAM_LENGTH+HIP_WIDTH+FOOT_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH));
	   			break;
	   			
	   case 8:add(new GLine(START_X+BEAM_LENGTH-HIP_WIDTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH,START_X+BEAM_LENGTH-HIP_WIDTH-FOOT_LENGTH,-SCAFFOLD_HEIGHT+START_Y+ROPE_LENGTH+2*HEAD_RADIUS+BODY_LENGTH+LEG_LENGTH));		
		       break;
		}
	
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int OFFSET=50;
	private static final int START_X=150;
	private static int START_Y;
 GLabel wordDisp;
private String gchar="";

int count;


}
