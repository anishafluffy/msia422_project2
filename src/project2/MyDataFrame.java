package project2;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
    public ArrayList getIndex() { 
        return this.index; 
    } 
    public ArrayList getState() { 
        return this.state; 
    } 
    public ArrayList getGender() { 
        return this.gender; 
    } 
    public ArrayList getYear() { 
        return this.year; 
    } 
    public ArrayList getName() { 
        return this.name; 
    } 
    public ArrayList getCount() { 
        return this.count; 
    } 
    
	// get i row of dataframe
	public String get(int i) {
        return
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
		return null;
	}
	
	//2. data type
	//index: Returns the type of the column specified by index
		//If the type is not uniform, return �String�
	public String dType(int index) {
		return null;
	}
	//Returns the type of the column specified by name
		//If the type is not uniform, return �String�
	public String dType(String name) {
		return null;
	}
	
	//3. slicing
	//Returns the column specified by index
	public MyDataFrame slice(int index) {
		//MyDataFrame.getCol(0); 
		return null;
	}
	
	//Returns the column specified by name
	public MyDataFrame slice(String name) {
		return null;
	}
	
	//Returns the columns specified by an index array
	public MyDataFrame slice(int[] indexArr) {
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

	//Returns the rows starting from label
	public MyDataFrame loc(String label) {
		return null;
	}

	//Returns the rows between from and to (including from and to)
	public MyDataFrame loc(int from, int to) {
		return null;
	}
	
	//Returns the rows between from and to (including from and to)
	public MyDataFrame loc(String from, String to) {
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
	public Object getMin(int index) {
		return null;
	}
	
	//Returns the minimum element of the column specified by label
	public Object getMin(String label) {
		return null;
	}
	
	//Returns the maximum element of the column specified by index
	public Object getMax(int index) {
		return null;
	}
	
	//Returns the maximum element of the column specified by label
	public Object getMax(String label) {
		return null;
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
