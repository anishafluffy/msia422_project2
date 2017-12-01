package project2;

import java.io.IOException;

public class MyTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyDataFrame df1 = MyPandas.readCSV("./CA.txt");
		MyDataFrame df2 = MyPandas.readCSV("./TX.txt");
		MyDataFrame df = MyPandas.concat(df1, df2);
		
		//MyPandas.writeCSV(df1, "./Output.txt");
		//MyPandas.writeCSV(df, "./Combined.txt");
		
		//df.head(5);
		//df.tail(5);
		
		//df.dType(2);
		//df.dType("STATE");
		
		//df.slice(5); //gives an error when enter incorrect
		//df.slice("name"); //gives an error when enter incorrect




	}

}
