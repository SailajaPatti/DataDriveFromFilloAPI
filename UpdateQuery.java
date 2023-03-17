package FilloAPI.ExcelDriveFromFilloAPI;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class UpdateQuery {
	@Test
	public void updatedemo() throws FilloException {
		Fillo fillo = new Fillo();
		Connection conn=fillo.getConnection("C:\\Users\\1685453\\ExcelDriven.xlsx");
		//to perform the update operation make sure u need to close the excel
		String query= "UPDATE TestData set data1='Sailaja' Where TC_Name='Login Page'";
		conn.executeUpdate(query); //executeUpdate method should be used
		conn.close();
	}

}
