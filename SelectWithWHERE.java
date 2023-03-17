package FilloAPI.ExcelDriveFromFilloAPI;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class SelectWithWHERE {
  @Test
  public void readData() throws FilloException {
	//SELECT with WHERE Condition
	    Fillo fillo = new Fillo();
		Connection conn=fillo.getConnection("C:\\Users\\1685453\\ExcelDriven.xlsx");
		String query=" Select * From TestData where TC_Name='Home Page'";
		Recordset rs=conn.executeQuery(query);
		//or
		//Recordset rs=conn.executeQuery(Select * From TestData).where("TC_Name='Home Page'");
		while(rs.next()) {
			System.out.println(rs.getField("TC_Name")+"---"+rs.getField("data1")+"---"+rs.getField("data2")+"---");
		}
		//Using multiple Where Conditions
		
		//String query1= "Select * from TestData where TC_Name='Home Page'and data1='ram";
		//rs=conn.executeQuery(query1);
		//or
		rs=conn.executeQuery("Select * From TestData").where("TC_Name='Home Page'").where("data3='delhi'");
		
		while(rs.next()) {
			System.out.println(rs.getField("TC_Name")+"---"+rs.getField("data1")+"---"+rs.getField("data2")+"---");
		}
		//with like condition
		rs=conn.executeQuery("Select * from TestData where  TC_Name like '%Page'");
		while(rs.next()) {
			System.out.println(rs.getField("TC_Name")+"---"+rs.getField("data1")+"---"+rs.getField("data2")+"---");
		}
		rs.close();
		conn.close();
}
}
