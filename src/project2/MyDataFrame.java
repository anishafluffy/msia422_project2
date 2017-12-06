package project2;

import java.lang.reflect.Array;
import java.util.*;

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
	
	public static <T extends Comparable<T>> void keySort(final List<T> key, List<?>... lists){
		// Create a List of indices
		List<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < key.size(); i++)
		indices.add(i);
		
		// Sort the indices list based on the key
		Collections.sort(indices, new Comparator<Integer>(){
			@Override public int compare(Integer i, Integer j) {
				return key.get(i).compareTo(key.get(j));
			}
		});
		
		// Create a mapping that allows sorting of the List by N swaps.
		Map<Integer,Integer> swapMap = new HashMap<Integer, Integer>(indices.size());
		
		// Only swaps can be used b/c we cannot create a new List of type <?>
		for(int i = 0; i < indices.size(); i++){
			int k = indices.get(i);
			while(swapMap.containsKey(k))
			k = swapMap.get(k);
			swapMap.put(i, k);
		}
		
		// for each list, swap elements to sort according to key list
		for(Map.Entry<Integer, Integer> e : swapMap.entrySet())
		for(List<?> list : lists)
		Collections.swap(list, e.getKey(), e.getValue());
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
	@SuppressWarnings("rawtypes")
	public MyDataFrame slice(int[] indexArr) {
		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		for (int y = 0; y < df.getLength(); y++) {
			for (int x = 0; x < indexArr.length; x++) {
				//get specified column
				ArrayList col = df.getCol(indexArr[x]); 
				System.out.print(col.get(y).toString()); 
				if (x < indexArr.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("\n");
		}
		return null;
	}
	
	//Returns the columns specified by a name array
	@SuppressWarnings("rawtypes")
	public MyDataFrame slice(String[] nameArr) {
		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		for (int y = 0; y < df.getLength(); y++) {
			for (int x = 0; x < nameArr.length; x++) {
				//get specified column
				ArrayList col = df.getCol(nameArr[x]); 
				System.out.print(col.get(y).toString()); 
				if (x < nameArr.length - 1) {
					System.out.print(", ");
				}
			}
			System.out.print("\n");
		}
		return null;
	}
	
	//4. filtering
	//Returns data filtered by applying col op o on MyDataFrame object, 
		//e.g. count > 10, state = IL 
	public MyDataFrame filter(String col, String op, int o) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		//Initiate new ArrayLists
		ArrayList<Integer> newindex = new ArrayList<>();
		ArrayList<Integer> index1 = new ArrayList<>();
		ArrayList<String> state1 = new ArrayList<>();
		ArrayList<String> gender1 = new ArrayList<>();
		ArrayList<Integer> year1 = new ArrayList<>();
		ArrayList<String> name1 = new ArrayList<>();
		ArrayList<Integer> count1 = new ArrayList<>();
		
		int len = df.getLength();
		
		if (op.equals(">")) {
			//Grab new index entries of filtered column
			for (int i = 0; i < len; i++) {
				if ((int) df.getCol(col).get(i) > o) {
					newindex.add(i);
				}
			}
			//Filter the rest of columns
			for (int i : newindex) {
				index1.add(df.getIndex().get(i));
				state1.add(df.getState().get(i));
				gender1.add(df.getGender().get(i));
				year1.add(df.getYear().get(i));
				name1.add(df.getName().get(i));
				count1.add(df.getCount().get(i));
			}
		}
		else if (op.equals("<")) {
			//Grab new index entries of filtered column
			for (int i = 0; i < len; i++) {
				if ((int) df.getCol(col).get(i) < o) {
					newindex.add(i);
					System.out.println(i);
				}
			}
			//Filter the rest of columns
			for (int i : newindex) {
				index1.add(df.getIndex().get(i));
				state1.add(df.getState().get(i));
				gender1.add(df.getGender().get(i));
				year1.add(df.getYear().get(i));
				name1.add(df.getName().get(i));
				count1.add(df.getCount().get(i));
			}
		}
		else if (op.equals("=")) {
			//Grab new index entries of filtered column
			for (int i = 0; i < len; i++) {
				if ((int) df.getCol(col).get(i) == o) {
					newindex.add(i);
				}
			}
			//Filter the rest of columns
			for (int i : newindex) {
				index1.add(df.getIndex().get(i));
				state1.add(df.getState().get(i));
				gender1.add(df.getGender().get(i));
				year1.add(df.getYear().get(i));
				name1.add(df.getName().get(i));
				count1.add(df.getCount().get(i));
			}
		}
		else if (op.equals(">=")) {
			//Grab new index entries of filtered column
			for (int i = 0; i < len; i++) {
				if ((int) df.getCol(col).get(i) >= o) {
					newindex.add(i);
				}
			}
			//Filter the rest of columns
			for (int i : newindex) {
				index1.add(df.getIndex().get(i));
				state1.add(df.getState().get(i));
				gender1.add(df.getGender().get(i));
				year1.add(df.getYear().get(i));
				name1.add(df.getName().get(i));
				count1.add(df.getCount().get(i));
			}
		}
		else if (op.equals("<=")) {
			//Grab new index entries of filtered column
			for (int i = 0; i < len; i++) {
				if ((int) df.getCol(col).get(i) <= o) {
					newindex.add(i);
				}
			}
			//Filter the rest of columns
			for (int i : newindex) {
				index1.add(df.getIndex().get(i));
				state1.add(df.getState().get(i));
				gender1.add(df.getGender().get(i));
				year1.add(df.getYear().get(i));
				name1.add(df.getName().get(i));
				count1.add(df.getCount().get(i));
			}
		}		
		
		//Create new dataframe and print result
		MyDataFrame df2 = new MyDataFrame(index1, state1, gender1, year1, name1, count1);
		int len2 = df2.getLength();
		for (int i = 0; i < len2; i++) {
			System.out.println(df2.get(i));
		}
		return null;
	}
	
	public MyDataFrame filter(String col, String op, String o) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		//Initiate new ArrayLists
		ArrayList<Integer> newindex = new ArrayList<>();
		ArrayList<Integer> index1 = new ArrayList<>();
		ArrayList<String> state1 = new ArrayList<>();
		ArrayList<String> gender1 = new ArrayList<>();
		ArrayList<Integer> year1 = new ArrayList<>();
		ArrayList<String> name1 = new ArrayList<>();
		ArrayList<Integer> count1 = new ArrayList<>();
		
		int len = df.getLength();
		
		if (op.equals("=")) {
			//Grab new index entries of filtered column
			for (int i = 0; i < len; i++) {
				if (df.getCol(col).get(i).equals(o)) {
					newindex.add(i);
				}
			}
			//Filter the rest of columns
			for (int i : newindex) {
				index1.add(df.getIndex().get(i));
				state1.add(df.getState().get(i));
				gender1.add(df.getGender().get(i));
				year1.add(df.getYear().get(i));
				name1.add(df.getName().get(i));
				count1.add(df.getCount().get(i));
			}
		}
		//Create new dataframe and print result
		MyDataFrame df2 = new MyDataFrame(index1, state1, gender1, year1, name1, count1);
		int len2 = df2.getLength();
		for (int i = 0; i < len2; i++) {
			System.out.println(df2.get(i));
		}
		return null;
	}
	
	//5. indexing
	//Returns the rows starting from index
	public MyDataFrame loc(int index1) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println("Index, " + "State, " + "Gender, " + "Year, " + "Name, " + "Count");
		int len = df.getLength();
		for (int i = index1; i < len; i++) {
			System.out.println(df.get(i));
		}
		return null;
	}

	//Returns the rows between from and to (including from and to)
	public MyDataFrame loc(int from, int to) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println("Index, " + "State, " + "Gender, " + "Year, " + "Name, " + "Count");
		//int len = df.getLength();
		for (int i = from; i <= to; i++) {
			System.out.println(df.get(i));
		}
		return null;
	}
	
	//6. sorting
	//Returns the data sorted by the column specified by index
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyDataFrame sort(int index1) {
		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		//create key column to sort on
		ArrayList key = df.getCol(index1);
		//state
		ArrayList<String> list1 = df.getState(); 
		//gender
		ArrayList<String> list2 = df.getGender(); 
		//year
		ArrayList<Integer> list3 = df.getYear();
		//name
		ArrayList<String> list4 = df.getName(); 
		//count
		ArrayList<Integer> list5 = df.getCount();
	
		//sort each list (excluding key)
		keySort(key, list1, list2, list3, list4, list5);
		for (int i = 0; i < df.getLength(); i++)  
	      {  
	         System.out.println(
        		 list1.get(i).toString() + ", " + 
				 list2.get(i).toString() + ", " + 
				 list3.get(i).toString() + ", " + 
				 list4.get(i).toString() + ", " + 
				 list5.get(i).toString()
        		 );  
	      }
		return null;
	}

	//Returns the data sorted by the column specified by name
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyDataFrame sort(String name1) {		//initialize df
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		
		//create key column to sort on
		ArrayList key = df.getCol(name1);
		//state
		ArrayList<String> list1 = df.getState(); 
		//gender
		ArrayList<String> list2 = df.getGender(); 
		//year
		ArrayList<Integer> list3 = df.getYear();
		//name
		ArrayList<String> list4 = df.getName(); 
		//count
		ArrayList<Integer> list5 = df.getCount();
	
		//sort each list (excluding key)
		keySort(key, list1, list2, list3, list4, list5);
		for (int i = 0; i < df.getLength(); i++)  
	      {  
	         System.out.println(
        		 list1.get(i).toString() + ", " + 
				 list2.get(i).toString() + ", " + 
				 list3.get(i).toString() + ", " + 
				 list4.get(i).toString() + ", " + 
				 list5.get(i).toString()
        		 );  
	      }
		return null;
	}
	
	//7. aggregation
	//Returns the minimum element of the column specified by index
	@SuppressWarnings("unchecked")
	public Object getMin(int index1) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println(Collections.min(df.getCol(index1)));
		return null;
	}
	
	//Returns the minimum element of the column specified by label
	@SuppressWarnings("unchecked")
	public Object getMin(String label) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println(Collections.min(df.getCol(label)));
		return null;
	}
	
	//Returns the maximum element of the column specified by index
	@SuppressWarnings("unchecked")
	public Object getMax(int index1) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println(Collections.max(df.getCol(index1)));
		return null;
	}
	
	//Returns the maximum element of the column specified by label
	@SuppressWarnings("unchecked")
	public Object getMax(String label) {
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		System.out.println(Collections.max(df.getCol(label)));
		return null;
	}

	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
