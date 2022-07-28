package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFetching_NormalTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("../SDET7_NAGA/target/sdet7.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=  book.getSheet("Sheet1");
DataFormatter format=new DataFormatter();
Cell data= book.getSheet("Sheet1").getRow(1).getCell(1);
System.out.println(data);
	}

}
