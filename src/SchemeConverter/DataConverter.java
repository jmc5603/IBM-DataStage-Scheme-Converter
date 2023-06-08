package SchemeConverter;

public class DataConverter {

	public DataConverter() {
		super();
	}
	
	public static String convertName(String data) {
		return data.replace("OOU_", "").replace(".csv", ".txt");
	}
	
	public static String convertType(String data, String data2){
		String finalType = "";
		
		if(data.startsWith("VARCHAR2")) {
			int lenght = getLenght(data);
			finalType = "string[max="+lenght+"]";
		}
		else if(data.startsWith("CHAR")) {
			finalType = "string[1]";
		}
		else if(data.startsWith("NUMBER")) {
			int lenght = getLenght(data);
			String decimals = data2.replace(")", "");
			finalType = "decimal["+lenght+","+decimals+"]";
		}
		else if(data.startsWith("FLOAT")) {
			finalType = "float";
		}
		else if(data.startsWith("DATE")||data.startsWith("TIMESTAMP")) {
			finalType = "timestamp {timestamp_format='%yyyy-%mm-%dd %hh:%nn:%ss', null_field=' '}";
		}
		else if(data.startsWith("CLOB")) {
			finalType = "longvarchar";
		}
		// agregar mas segun sea necesario...
		else {
			System.out.println("ERROR: HAY VARIABLE NUEVA "+data);
		}
		
		return finalType;
	}
	
	public static int getLenght (String data) {
		String target = data.split("\\(")[1];
		return Integer.parseInt(target.replaceAll("[^0-9]", ""));
	}
	
	public static String getFinalCol(String col1, String col2, String col3, String colAux) {
		String result = "";
		if(col2.startsWith("NUMBER")) {
			if(colAux.contains("Yes")) {
				result = col1+":nullable "+convertType(col2,col3)+";";
			}
			else {
				result = col1+": "+convertType(col2,col3)+";";
			}
		}
		else {
			if(col3.contains("Yes")) {
				result = col1+":nullable "+convertType(col2,col3)+";";
			}
			else {
				result = col1+": "+convertType(col2,col3)+";";
			}
		}
		return result;
	}
}
