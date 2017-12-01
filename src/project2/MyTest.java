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
		
		//df.slice(3); //gives an error when enter incorrect
		//df.slice(5); //gives an error when enter incorrect
		
		int[] indexArr = {1,2};
		df.slice(indexArr);

		//df.slice("name"); //gives an error when enter incorrect

		df.getMax(4);
		df.getMin(3);
		df.getMax("count");
		df.getMin("count");
<<<<<<< HEAD
		df.loc(700000);
		df.loc(5,10);
=======

		

>>>>>>> baf547849e27735162826082c30752b996e21a0f
	}

}
