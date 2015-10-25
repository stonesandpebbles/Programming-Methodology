import acm.program.*;

public class sectionhandout4 extends ConsoleProgram{

	public void run(){
		while (true) {
			String digits = readLine("Enter a numeric string: ");
			String sub=readLine("Enter substring to delete:");
			if (digits.length() == 0) break;
			println(removeAllOccurences(digits,sub));
		}
		
		
	}
	
	private String removeAllOccurences(String str,String sub){
		
		while(true){
			int k =str.indexOf(sub);
			if(k>=0){
			str=str.substring(0,k)+str.substring(k+sub.length());
			
				//i--;
			
			}
			else break;
			
			
			
		}
		return str;
	}
//private String str;
}

