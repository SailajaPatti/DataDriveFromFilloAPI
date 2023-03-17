package FilloAPI.ExcelDriveFromFilloAPI;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class CreateSheets {
	@Test
	public void createSheet() {
	    String filePath = "C:\\Users\\1685453\\ExcelDriven.xlsx";
	    try {
	        Fillo fillo = new Fillo();
	        Connection connection = fillo.getConnection(filePath);
	        connection.createTable("TestData3", new String[] { "TC_Name", "data1", "data2",
						"data3"});
	        connection.createTable("TestData4");
	        connection.close();
	   } catch (FilloException e) {
	     e.printStackTrace();
	   } catch (Exception e) {
	     e.printStackTrace();
	   }
	}

}
