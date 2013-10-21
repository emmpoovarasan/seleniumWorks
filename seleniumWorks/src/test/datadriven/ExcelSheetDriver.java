package test.datadriven;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelSheetDriver {

	static Sheet wrkSheet;
	static Workbook wrkBook = null;
	static Hashtable dict = new Hashtable();
	
	// Create a constructor
	public ExcelSheetDriver(String ExcelSheetPath) throws 	BiffException, IOException{
		
		// Initialize
		wrkBook = Workbook.getWorkbook(new File(ExcelSheetPath));
		wrkSheet = wrkBook.getSheet("Sheet1");
		
	}
	//Return the Number of Rows
	public static int RowCount(){
		return wrkSheet.getRows();
	}
	//Returns the Cell value by taking row and Column values as argument
	public static String ReadCell(int Column, int Row){
		return wrkSheet.getCell(Column, Row).getContents();
		
	}
	
	//Create Column Dictionary to hold all the Column Names
	public static void ColumnDictionary(){
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int col=0; col<wrkSheet.getColumns(); col++){
			dict.put(ReadCell(col, 0), col);
		}
	}
	
	// Read Column Names
	public static int GetCell(String colName){
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			// TODO: handle exception
			return(0);
		}
	}
	
	
	
}
