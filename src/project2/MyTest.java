package project2;

import java.io.IOException;

public class MyTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MyDataFrame df1 = MyPandas.readCSV("./CA.txt");
		MyDataFrame df2 = MyPandas.readCSV("./TX.txt");
		MyDataFrame df3 = MyPandas.concat(df1, df2);
		
		MyPandas.writeCSV(df1, "./Output.txt");
		MyPandas.writeCSV(df3, "./Combined.txt");
		
		//df.head(5);
		df1.dType(1);
		
	}

}
