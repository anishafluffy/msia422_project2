package project2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class MyDataFrame {

	private ArrayList<Integer> index;
	private ArrayList<String> state;
	private ArrayList<String> gender;
	private ArrayList<Integer> year;
	private ArrayList<String> name;
	private ArrayList<Integer> count;

	// Constructor
	public MyDataFrame(ArrayList<Integer> index, ArrayList<String> state, ArrayList<String> gender, ArrayList<Integer> year, ArrayList<String> name, ArrayList<Integer> count) { 
		this.index = index;
		this.state = state;
        this.gender = gender;
        this.year = year;
        this.name = name;
        this.count = count;
	}

	//getters
    public ArrayList<Integer> getIndex() { 
        return this.index; 
    } 
    public ArrayList<String> getState() { 
        return this.state; 
    } 
    public ArrayList<String> getGender() { 
        return this.gender; 
    } 
    public ArrayList<Integer> getYear() { 
        return this.year; 
    } 
    public ArrayList<String> getName() { 
        return this.name; 
    } 
    public ArrayList<Integer> getCount() { 
        return this.count; 
    } 
    
	// get i row of dataframe
	public String get(int i) {
        return
             this.index.get(i).toString() + ", " + 
       		 this.state.get(i).toString() + ", " + 
       		 this.gender.get(i).toString() + ", " + 
       		 this.year.get(i).toString() + ", " + 
       		 this.name.get(i).toString() + ", " + 
       		 this.count.get(i).toString()
       		 ;  
	}
	
	// get length of dataframe
	public int getLength() {
		return this.index.size();
	}

	@SuppressWarnings("rawtypes")
	public ArrayList getCol(int index1) {
		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		//create column depending on input
		ArrayList col = null; 
		try {
			//state
			if (index1 == 0) { col = df.getState(); } 
			//gender
			else if (index1 == 1) { col = df.getGender(); } 
			//year
			else if (index1 == 2) { col = df.getYear(); } 
			//name
			else if (index1 == 3) { col = df.getName(); } 
			//count
			else if (index1 == 4) { col = df.getCount(); } 
			else { throw new IllegalArgumentException(); }
		}
		catch (IllegalArgumentException e) {
			System.out.println("Incorrect index entered for slice.");
		}
		return col; 
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getCol(String name1) {
		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		//create column depending on input
		ArrayList col = null; 
		try {
			//state
			if ("state".equalsIgnoreCase(name1)) { col = df.getState(); } 
			//gender
			else if ("gender".equalsIgnoreCase(name1)) { col = df.getGender(); } 
			//year
			else if ("year".equalsIgnoreCase(name1)) { col = df.getYear(); } 
			//name
			else if ("name".equalsIgnoreCase(name1)) { col = df.getName(); } 
			//count
			else if ("count".equalsIgnoreCase(name1)) { col = df.getCount(); } 
			else { throw new IllegalArgumentException(); }
		}
		catch (IllegalArgumentException e) {
			System.out.println("Incorrect index entered for slice.");
		}
		return col; 
	}
	
	//1. head & tail
	//head: Returns the first n rows of the data
	public MyDataFrame head(int n) {
		System.out.println("Index, " + "State, " + "Gender, " + "Year, " + "Name, " + "Count");
		for (int i = 0; i < n; i++)  
	      {  
	         System.out.println(
	        		 this.index.get(i).toString() + ", " + 
	        		 this.state.get(i).toString() + ", " + 
	        		 this.gender.get(i).toString() + ", " + 
	        		 this.year.get(i).toString() + ", " + 
	        		 this.name.get(i).toString() + ", " + 
	        		 this.count.get(i).toString()
	        		 );  
	      }
		return null;
	}
	//tail: Returns the last n rows of the data
	public MyDataFrame tail(int n) {
		int len = this.index.size();
		System.out.println("Index, " + "State, " + "Gender, " + "Year, " + "Name, " + "Count");
		for (int i = n; i > 0 ; i--)  
	      {  
	         System.out.println(
	        		 this.index.get(len - i).toString() + ", " + 
	        		 this.state.get(len - i).toString() + ", " + 
	        		 this.gender.get(len - i).toString() + ", " + 
	        		 this.year.get(len - i).toString() + ", " + 
	        		 this.name.get(len - i).toString() + ", " + 
	        		 this.count.get(len - i).toString()
	        		 );  
	      }
		return null;
	}
	
	//2. data type
	//index: Returns the type of the column specified by index
		//If the type is not uniform, return String
	public String dType(int index) {
		try {
			//state
			if (index == 0) { System.out.println("String"); } 
			//gender
			else if (index == 1) { System.out.println("String"); } 
			//year
			else if (index == 2) { System.out.println("Integer"); } 
			//name
			else if (index == 3) { System.out.println("String"); } 
			//count
			else if (index == 4) { System.out.println("Integer"); } 
			else { throw new IllegalArgumentException(); }
		}
		catch (IllegalArgumentException e) {
			System.out.println("Incorrect index entered for dType.");
		}
		return null;
	}
	
	//Returns the type of the column specified by name
		//If the type is not uniform, return String
	public String dType(String name) {
		try {
			//state
			if ("state".equalsIgnoreCase(name)) { System.out.println("String"); } 
			//gender
			else if ("gender".equalsIgnoreCase(name)) { System.out.println("String"); } 
			//year
			else if ("year".equalsIgnoreCase(name)) { System.out.println("Integer"); } 
			//name
			else if ("name".equalsIgnoreCase(name)) { System.out.println("String"); } 
			//count
			else if ("count".equalsIgnoreCase(name)) { System.out.println("Integer"); } 
			else { throw new IllegalArgumentException(); }
		}
		catch (IllegalArgumentException e) {
			System.out.println("Incorrect name entered for dType.");
		}
		return null;
	}
	
	//3. slicing
	//Returns the column specified by index
	@SuppressWarnings("rawtypes")
	public MyDataFrame slice(int index1) {
		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		//get specified column
		ArrayList col = df.getCol(index1);
		
		//print specified column
		for (int i = 0; i < col.size(); i++)  
	      {  
	         System.out.println(col.get(i).toString());  
	      } 
		return null;
	}
	
	//Returns the column specified by name
	@SuppressWarnings("rawtypes")
	public MyDataFrame slice(String name1) {
		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		//get specified column
		ArrayList col = df.getCol(name1);
		
		//print specified column
		for (int i = 0; i < col.size(); i++)  
	      {  
	         System.out.println(col.get(i).toString()); 
	         
	      } 
		return null;
	}
	
	//Returns the columns specified by an index array
	public MyDataFrame slice(int[] indexArr) {
		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		for (int x = 0; x < indexArr.length; x++) {
		    System.out.println(indexArr[x]);
			//get specified column
			ArrayList col = df.getCol(indexArr[x]);
		}
		return null;
	}
	
	//Returns the columns specified by a name array
	public MyDataFrame slice(String[] nameArr) {
		return null;
	}
	
	//4. filtering
	//Returns data filtered by applying �col op o� on MyDataFrame object, 
		//e.g. �count > 10�, �state = �IL��
	public MyDataFrame filter(String col, String op, Object o) {
		return null;
	}
	
	//5. indexing
	//Returns the rows starting from index
	public MyDataFrame loc(int index) {
		return null;
	}

	//Returns the rows between from and to (including from and to)
	public MyDataFrame loc(int from, int to) {
		return null;
	}
	
	//6. sorting
	//Returns the data sorted by the column specified by index
	public MyDataFrame sort(int index) {
		return null;
	}

	//Returns the data sorted by the column specified by name
	public MyDataFrame sort(String name) {
		return null;
	}
	
	//7. aggregation
	//Returns the minimum element of the column specified by index
	public Object getMin(int index1) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println(Collections.min(df.getCol(index1)));
		return null;
	}
	
	//Returns the minimum element of the column specified by label
	public Object getMin(String label) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println(Collections.min(df.getCol(label)));
		return null;
	}
	
	//Returns the maximum element of the column specified by index
	public Object getMax(int index1) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println(Collections.max(df.getCol(index1)));
		return null;
	}
	
	//Returns the maximum element of the column specified by label
	public Object getMax(String label) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println(Collections.max(df.getCol(label)));
		return null;
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
