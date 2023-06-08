package SchemeConverter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class CSVWritter {

	public static void imprimirResultados (String fileName, String parameters, String origin, String dest) {
		BufferedWriter bw = null;
		try {
			File file = new File(dest+"\\"+fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			ArrayList<String[]> data = CSVReader.getData(origin,",");
			Iterator<String[]> dataIterator = data.iterator();
			
			bw.write("record{"+parameters+"} \n(");
			bw.newLine();
			while (dataIterator.hasNext()) {
				String[] arr = dataIterator.next();
				bw.write("\t "+DataConverter.getFinalCol(arr[0],arr[1],arr[2],arr[3]));
				bw.newLine();
			}
			bw.write(")");
			
		} 
		catch (IOException ioe) {
			ioe.printStackTrace();
		} 
		finally {
			try {
				if (bw != null)
					bw.close();
			} 
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}	
	}
	
	
}
