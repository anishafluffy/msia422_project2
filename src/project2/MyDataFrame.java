package project2;

import java.util.ArrayList;

public class MyDataFrame {

	private ArrayList<String> state;
	private ArrayList<String> gender;
	private ArrayList<Integer> year;
	private ArrayList<String> name;
	private ArrayList<Integer> count;

	// Constructor
	public MyDataFrame(ArrayList<String> state, ArrayList<String> gender, ArrayList<Integer> year, ArrayList<String> name, ArrayList<Integer> count) { 
        this.state = state;
        this.gender = gender;
        this.year = year;
        this.name = name;
        this.count = count;
	} 
	
	//1. head & tail
	public MyDataFrame head(int n) {
		for (int i = 0; i < n; i++)  
	      {  
	         System.out.println(
	        		 this.state.get(i).toString() + ", " + 
	        		 this.gender.get(i).toString() + ", " + 
	        		 this.year.get(i).toString() + ", " + 
	        		 this.name.get(i).toString() + ", " + 
	        		 this.count.get(i).toString()
	        		 );  
	      }
		return null;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
