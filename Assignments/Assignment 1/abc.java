import acm.program.*;
import acm.graphics.*;
public class abc extends GraphicsProgram{
	/* The number of days in the month */
	private static final int DAYS_IN_MONTH = 31;
	/* The day of the week on which the month starts */
	/* (Sunday = 0, Monday = 1, Tuesday = 2, and so on) */
	private static final int DAY_MONTH_STARTS = 5;
	/* The width in pixels of a day on the calendar */
	private static final int DAY_WIDTH = 40;
	/* The height in pixels of a day on the calendar */
	private static final int DAY_HEIGHT = 30;
	
	public void run(){
		int counter=1;
		int k=(DAYS_IN_MONTH+DAY_MONTH_STARTS+7)/7;
		if(k%7==0){
			k--;
		}
		for(int j=0;j<k;j++){
			
		
		for(int i=0;i<7;i++){
			GRect box=new GRect(DAY_WIDTH*i,DAY_HEIGHT*j,DAY_WIDTH,DAY_HEIGHT);
			add(box);
			if(((j>=1)||(i>=DAY_MONTH_STARTS))&&(counter<=DAYS_IN_MONTH)){
				GLabel date=new GLabel("+i",DAY_WIDTH*i+5,DAY_HEIGHT*j+10);
				add(date);
				println(+counter);
				counter++;
				
			}
			
		}
		}
		
	}

}
