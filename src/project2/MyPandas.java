package project2;

import java.io.*;
import java.util.*;

public class MyPandas {

	public static MyDataFrame readCSV(String path) throws IOException {
		//take in path
		File file = new File(path);
		//create arraylists of all columns
		ArrayList<String> state = new ArrayList<>();
		ArrayList<String> gender = new ArrayList<>();
		ArrayList<Integer> year = new ArrayList<>();
		ArrayList<String> name = new ArrayList<>();
		ArrayList<Integer> count = new ArrayList<>();
		//read each column
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line = bufferedReader.readLine(); // skip header
			while ((line = bufferedReader.readLine()) != null) {
				state.add(line.split(",")[0]);
				gender.add(line.split(",")[1]);
				year.add(Integer.parseInt(line.split(",")[2]));
				name.add(line.split(",")[3]);
				count.add(Integer.parseInt(line.split(",")[4]));
			}
		}
		for (String n : name) {
			System.out.println(n);
		}
		MyDataFrame df = new MyDataFrame(state, gender, year, name, count); 
		return df;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//readCSV("./CA.txt");
	}

}
