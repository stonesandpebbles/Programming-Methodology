/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

	HangmanCanvas canvas;
	
	
	
	
	public void init(){
		canvas=new HangmanCanvas();
		add(canvas);
	}
	
	
	
	
    public void run() {
		/* You fill this in */
    	p=new HangmanLexicon();
    	canvas.reset();
    	consoleGame();
	}

    
    
    
	private void consoleGame(){
		String word=p.getWord(rgen.nextInt(0,p.getWordCount()));
		println("Welcome to Hangman");
		println(word);
		gword="";
		for(int i=0;i<word.length();i++){
			gword+="-";
		}
		println("the word now looks like this:"+gword);
		canvas.displayWord(gword);
		while(true){
			println("no of guesses left=="+count);
			String str=readLine("your guess:");
			char ch=str.charAt(0);
			ch=Character.toUpperCase(ch);
	        if((ch<'A')||((ch>'Z')&&(ch<'a'))||(ch>'z')||str.length()>1){
	        	println("ILLLLEGAL CHARACTER");
	        	
	        }
	        else{
	        	
	        	checkGuess(ch,word);
	        }
	        
	        if(count<1){
	        	println("you lose,the word was::"+word);
	        	break;
	        }
			println("the word now looks like this:"+gword);
			
			canvas.displayWord(gword);
			
	        if(gword.equals(word)){
	        	
	        	println("YOUUUUUUUU WIIIIIIIIIIINNNN");
	        	break;
	        }
	
		}
	}
	
	
	
	
	private void checkGuess(char ch,String word){
		boolean repeat=false;
		boolean p=false;
		for(int i=0;i<word.length();i++){
			if(ch==gword.charAt(i))repeat=true;
			
			if(ch==word.charAt(i)&&(gword.charAt(i)=='-')){
				
				gword=gword.substring(0,i)+ch+gword.substring(i+1);
				
				p=true;
			}
			
				
			
		}
		if(!p&&!repeat){
		println("you guessed wrong,the letter does not fit");
		count--;
		canvas.noteIncorrectGuess(ch);
		}
		else if(!repeat) println("you guessed the correct letter");
	
	}


int count =8;
String gword;
RandomGenerator rgen=new RandomGenerator();
HangmanLexicon p; 
}
