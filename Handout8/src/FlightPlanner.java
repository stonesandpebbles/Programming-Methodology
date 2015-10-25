import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;



public class FlightPlanner {

	HashMap<String, ArrayList<String>> dest = new HashMap<String, ArrayList<String>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlightPlanner fp = new FlightPlanner();
		fp.readFile();
		fp.display();
	}
	
	private void readFile(){
		BufferedReader rd = null;
		try {
			 rd = new BufferedReader(new FileReader("flights.txt"));
			 String line= "";
			 while((line=rd.readLine()) != null){
				 if(!line.equals("")){
					String[] splitString = line.split(" -> ");
					String key = splitString[0];
					//System.out.println(splitString[1]);
					String listValue = splitString[1];
					ArrayList<String> value = null;
					if(dest.containsKey(key))
					{
						value = dest.get(key);
						value.add(listValue);
					}
					else{
						value = new ArrayList<String>();
						value.add(listValue);
					}
					dest.put(key, value);
				 }
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				rd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void display(){
		System.out.println("Welcome to Flight Planner!");
		System.out.println("Here's a list of all cities in our database");
		Set keyList = dest.keySet();
		Iterator itr = keyList.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		ArrayList<String> route = new ArrayList<String>();
		System.out.println("Let's plan a round trip!");
		System.out.print("Enter the starting city: ");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		String destination = choice;
		ArrayList<String> choiceList = dest.get(choice);
		route.add(choice);
		System.out.println("From "+choice+" you can fly directly to");
		printArrayList(choiceList);
		System.out.print("Where do you want to go to from "+choice+":");	
		while(true)
		{	
			System.out.print("Where do you want to go to from "+destination+":");
			String input = sc.nextLine();
			choiceList = dest.get(input);
			if(choice.equals(input)){
				route.add(input);
				break;
			}
			if(choiceList == null){
				System.out.println("You can't get to that city by a direct flight");
				continue;
			}
			destination = input;
			route.add(destination);
			System.out.println("From "+destination+" you can fly directly to");
			printArrayList(choiceList);	
		}
		System.out.println("The route you have chosen is:");
		printRoute(route);
	}

	
	private void printRoute(ArrayList route){
		for(int i = 0; i < route.size()-1; i++){
			System.out.print(route.get(i));
			System.out.print(" -> ");
		}
		System.out.print(route.get(route.size()-1));
	}
	
	
	private void printArrayList(ArrayList choiceList){
		for(int i = 0; i < choiceList.size(); i++){
			System.out.println(choiceList.get(i));
		}
	}
}
