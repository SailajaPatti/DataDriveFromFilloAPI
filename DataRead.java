package FilloAPI.ExcelDriveFromFilloAPI;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataRead {

	@Test
	public void getDataFromExcel() throws FilloException {
	//C:\Users\1685453\ExcelDriven.xlsx
		Fillo fillo = new Fillo();
		Connection conn=fillo.getConnection("C:\\Users\\1685453\\ExcelDriven.xlsx");
		String query=" Select * From TestData";
		ArrayList<String> list=new ArrayList();
		Recordset recordset = conn.executeQuery(query);
		//recordset contains all rows of that sheet
		//gives all rows count in the sheet which contains data from excel except Header since it is recognised as columns
		System.out.println(recordset.getCount()); 
		while(recordset.next()) {
		//to print total data	
		System.out.println(recordset.getField("TC_Name")+"---"+recordset.getField("data1")+"---"+recordset.getField("data2")+"---");
		}
		//get last row data
		recordset.moveLast(); //scope is in last row
		System.out.println(recordset.getField("TC_Name")+"---"+recordset.getField("data1")+"---"+recordset.getField("data2")+"---");
	   //get previous row data
		recordset.movePrevious(); //scope in prevoius of last row
		System.out.println(recordset.getField("TC_Name")+"---"+recordset.getField("data1")+"---"+recordset.getField("data2")+"---");
		//to move first and get first row data
		recordset.moveFirst();
		System.out.println(recordset.getField("TC_Name")+"---"+recordset.getField("data1")+"---"+recordset.getField("data2")+"---");
		//get total coumns
		int count=recordset.getFieldNames().size();
		System.out.println("total columns: "+ count);
		//get req column
		System.out.println(recordset.getFieldNames().get(0));
		System.out.println(recordset.getField(1).name());
		//to print all column names in a list
		list=recordset.getFieldNames();
		System.out.println(list);
		//list.stream().filter(s->s.endsWith("data2")).count();
			
		
		recordset.close(); //to avoid leak memory
		conn.close(); //to close the 
}}
