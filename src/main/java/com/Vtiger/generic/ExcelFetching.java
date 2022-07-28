	package com.Vtiger.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author reamer
 *@Description : This class is going to fetch the data from excel sheet
 */
public class ExcelFetching {
/**
 *@author 
 * @return 
 * @throws IOException 
 * @throws EncryptedDocumentException 
 * @Description :This method is going to fetch the data
 */
	public String readDatafromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream("../SDET7_NAGA/src/test/java/com/Vtiger/generic/NAGA - Copy.xlsx");	
	Workbook book =WorkbookFactory.create(fis);
	Sheet sh = book.getSheet(sheet);
	Row r= sh.getRow(row);
	Cell c = r.getCell(cell);
	String data=c.getStringCellValue();
	return data;
	}
}
