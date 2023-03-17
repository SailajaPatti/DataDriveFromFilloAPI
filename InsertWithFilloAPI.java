package FilloAPI.ExcelDriveFromFilloAPI;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class InsertWithFilloAPI {
	@Test
	public void insertintonExcel() throws FilloException {
		try {
		Fillo fillo = new Fillo();
		Connection conn=fillo.getConnection("C:\\Users\\1685453\\ExcelDriven.xlsx");
		String query= "INSERT into TestData(TC_Name,data1,data2,data3) VALUES('New TC','Som','35','Hyd')";
		conn.executeUpdate(query);
		conn.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
