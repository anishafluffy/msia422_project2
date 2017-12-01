package project2;

import java.io.IOException;

public class MyTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyDataFrame df = MyPandas.readCSV("./CA.txt");
		MyPandas.writeCSV(df, "./Output.txt");
		
		df.head(5);
		
		
	}

}
