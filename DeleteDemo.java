package FilloAPI.ExcelDriveFromFilloAPI;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;

public class DeleteDemo {

	@Test
	public void deletedata() throws FilloException {
		Fillo fillo = new Fillo();
		Connection conn=fillo.getConnection("C:\\Users\\1685453\\ExcelDriven.xlsx");
		//delete data with some condition
		String query="Delete from TestData where data3='hyd'";
		conn.executeUpdate(query);
		//to delete entire table
		String query1="Delete from TestData1";
		conn.executeUpdate(query1);
		conn.close();
	}
}
