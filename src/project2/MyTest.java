package project2;

import java.io.IOException;

public class MyTest {

	public static void main(String[] args) throws IOException {
	//MyPandas class
	//1. readCSV
		MyDataFrame df1 = MyPandas.readCSV("./CA.txt");
		MyDataFrame df2 = MyPandas.readCSV("./TX.txt");
		
	//2. writeCSV
		//MyPandas.writeCSV(df1, "./Output.txt");
		//MyPandas.writeCSV(df, "./Combined.txt");
		
	//3. concat
		//MyDataFrame df = MyPandas.concat(df1, df2);
		
	//MyDataFrame class
	//1. Head and Tail
		//df.head(5);
		//df.tail(5);
		
	//2. dType
		//df.dType(2);
		//df.dType("STATE");
		
	//3. Slicing
		//df.slice(3); 
		//df.slice("name"); 

		//int[] indexArr = {1,3,4};
		//df.slice(indexArr);
		
		//String[] nameArr = {"name", "count"};
		//df.slice(nameArr);
		
	//4. Filtering
		//df.filter("year", "=", 2015);
		//df.filter("name", "=", "Spencer");
		
	//5. Indexing
		//df.loc(700000);
		//df.loc(5,10);	
		
	//6. Sorting
		//df.sort(3);
		//df.sort("count");
		
	//7. Aggregation
		//df.getMax(4);
		//df.getMin(3);
		//df.getMax("count");
		//df.getMin("count");

	}

}
