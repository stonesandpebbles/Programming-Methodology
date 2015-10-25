/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}
	
	public void run() {
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	private void playGame() {
		/* You fill this in */
		for (int f=0;f<17;f++){
			for(int g=0;g<2;g++)
			{
				cat[f][g]=true;
			}
		}
	
		for(int i=0;i<13;i++){
			
			
			for(int j=0;j<nPlayers;j++){
				display.printMessage(playerNames[j]);
			
				int turn=0;
				display.waitForPlayerToClickRoll(j+1);
				diceRandom(turn);
				display.displayDice(dice);
				turn++;
				
				int category=0;
				
				while(turn<3){
					display.printMessage("select and roll again if you want");
					display.waitForPlayerToSelectDice();
					int count=0;
					for(int k=0;k<N_DICE;k++){
						p[k]=display.isDieSelected(k);
						if (p[k]) count++;
					}
					if (count==0) break;
					diceRandom(turn);
					display.displayDice(dice);
					turn++;
					
				}
				//println("fine");
				category=display.waitForPlayerToSelectCategory();
				while(!cat[category-1][j])
				{
				 display.printMessage("choose another category");
				 category=display.waitForPlayerToSelectCategory();
				}
				
				cat[category-1][j]=false;//println("fine2");
				boolean l=checkCategory(dice, category);//gdpgdgdlgpdlgdlgdlgpdlgpdlgdplgpdlg
				//println("fine3");
				int score=0;
				
				
				if (l)
					score=scoreKeeping(category,j);
				
				
				display.updateScorecard(category,j+1,score);
				
			}
		}
		
		for (int i=0;i<nPlayers;i++){
			bonus[i]=0;
			display.updateScorecard(UPPER_SCORE, i+1, upScore[i]);
			display.updateScorecard(LOWER_SCORE, i+1, downScore[i]);
			if (upScore[i]>63)bonus[i]=35;
			display.updateScorecard(UPPER_BONUS, i+1, bonus[i]);
			totalScore[i]=upScore[i]+downScore[i]+bonus[i];
		
			display.updateScorecard(TOTAL,i+1 , totalScore[i]);
		}
		int bigindex=0,big=0;
		for (int h=0;h<nPlayers;h++){
			if (totalScore[h]>big) 
				big=totalScore[h];
				bigindex=h;
		}
		display.printMessage(playerNames[bigindex]+"WON!!!!!!!!!!!!!!!!!");
	}
	
	private void diceRandom(int turn){
		for(int i=0;i<N_DICE;i++){
			if (p[i]||(turn==0)){
				dice[i]=rgen.nextInt(1, 6);
		}
		}
	}
		
	
	
	private boolean checkCategory(int[] dice,int category)
	{
		boolean b;
		switch(category){
		
		case 1:
			return true;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			return true;
		case 9:
		case 10:
			
			for(int j=0;j<6;j++){
				
				int count=0;
				for(int i=0;i<N_DICE;i++){
					if (dice[i]==j)count++;
				}
				if (count>=category)
					return true;
			}
		case 11:
			
		case 12:
			
		case 13:
			for (int j=1;j<=6;j++){
				int test13=dice[j];
				for(int i=0;i<N_DICE;i++){
					for(int k=0;k<N_DICE;k++){
						if(dice[k]!=(test13+i))return false;
					}
				
				}
			}
			return true;
		case 14:
			int testval=dice[0];
			for(int i=0;i<N_DICE;i++){
				if(dice[i]!=testval)return false;
				
			}
			return true;
		case 15:
			return true;
		}
		return false;	
	}
	
	
	
	
	private int scoreKeeping(int category,int j){
		int score =0;
		
			
		
			switch(category){
			
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:	
					for (int i=0;i<N_DICE;i++){
						if(dice[i]==category)
							score+=dice[i];
					}
					break;
				case 9:
				case 10:
					for(int i=0;i<N_DICE;i++){
						score+=dice[i];
							
					}
					break;
				case 11:score=25;
						break;
					
				case 12:score=30;
						break;
						
				case 13:score=40;
						break;
						
				case 14:score=50;
						break;
					
				case 15:
					
					
					for(int i=0;i<N_DICE;i++){
							score+=dice[i];}	
						
						break;	
			}
			if (category<=6)upScore[j]+=score;
			else downScore[j]+=score;
		
		return score;
	}
/* Private instance variables */
	private boolean [] p={true,true,true,true,true,true};
	
	private int nPlayers=2;
	private int []totalScore=new int [nPlayers];
	private int[] dice=new int[N_DICE];
	private String[] playerNames;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	private int [] upScore=new int [nPlayers];
	private int [] downScore=new int [nPlayers];
	private boolean [][] cat=new boolean [17][nPlayers];
	private int []bonus=new int [nPlayers];
}
