package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtility 
{
	@Test
	public void ExcelReader() throws EncryptedDocumentException, IOException  
	{
		
		FileInputStream fis=new FileInputStream("C:\\Users\\anubhav\\eclipse-workspace\\Test-AAF-01FRMWRK\\src\\test\\resources\\ExternalFiles\\Signup&Login.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet st = wb.getSheet("Signup");
		Row rw = st.getRow(0);
		Cell cl = rw.getCell(0);
		 String rslt= cl.getStringCellValue();
		 System.out.print(rslt);
		
	}
}
