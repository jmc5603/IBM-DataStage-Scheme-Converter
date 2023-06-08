package SchemeConverter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CSVReader {
	
	//C:\\Users\\aihac\\eclipse-workspace\\TPE_PROG3\\src\\TPE_PROG3\\dataset4.csv

	public static ArrayList<String[]> getData(String csvFile, String splitBy) {
		ArrayList<String[]> filteredData = new ArrayList<>();
		String tmp = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			 while ((tmp = br.readLine()) != null) {
				 String[] items = tmp.split(splitBy);
				 String[] usedItems = new String[4];
				 usedItems[0]=items[0];
				 usedItems[1]=items[1];
				 usedItems[2]=items[2];
				 usedItems[3]=items[3];
				 filteredData.add(usedItems);	 
			 }	
		} 
		catch (Exception e) {
			 e.printStackTrace();
		}
		return filteredData;
	}
	
}
