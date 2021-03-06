package project2;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class MyPandas {

	//1. read
	public static MyDataFrame readCSV(String path) throws IOException {
		//take in path
		File file = new File(path);
		//create arraylists of all columns
		ArrayList<Integer> index = new ArrayList<>();
		ArrayList<String> state = new ArrayList<>();
		ArrayList<String> gender = new ArrayList<>();
		ArrayList<Integer> year = new ArrayList<>();
		ArrayList<String> name = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		//read each column
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			//String line = bufferedReader.readLine(); // skip header
			int i = 0;
			String line; //don't skip header
			while ((line = bufferedReader.readLine()) != null) {
				index.add(i);
				state.add(line.split(",")[0]);
				gender.add(line.split(",")[1]);
				year.add(Integer.parseInt(line.split(",")[2]));
				name.add(line.split(",")[3]);
				count.add(Integer.parseInt(line.split(",")[4]));
				i++;
			}
		}
//		for (String n : name) {
//			System.out.println(n);
//		}
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count); 
		return df;
	}
	
	//2. write
	public static void writeCSV(MyDataFrame data, String path) throws IOException {
		//export text file
		FileWriter writer = new FileWriter(path);
		writer.write("State, " + "Gender, " + "Year, " + "Name, " + "Count" + "\n");
		for (int i = 0; i < data.getLength(); i++) {
			writer.write(data.get(i));
			writer.write("\n");	  
			}

		writer.close();
	}
	
	//3. concatenate
	public static MyDataFrame concat(MyDataFrame df1, MyDataFrame df2) {
		
		ArrayList<Integer> index = df1.getIndex();
		ArrayList<String> state = df1.getState();
		ArrayList<String> gender = df1.getGender();
		ArrayList<Integer> year = df1.getYear();
		ArrayList<String> name = df1.getName();
		ArrayList<Integer> count = df1.getCount();
		
		int len1 = df1.getLength();
		int len2 = df2.getLength();
		
		for (int i = 0; i < len2; i++) {
			index.add(i + len1);
		}
		
		state.addAll(df2.getState());
		gender.addAll(df2.getGender());
		year.addAll(df2.getYear());
		name.addAll(df2.getName());
		count.addAll(df2.getCount());
		
		MyDataFrame df = new MyDataFrame(index, state, gender, year, name, count);
		return df;
	}
	
	//main
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//readCSV("./CA.txt");
	}

}
