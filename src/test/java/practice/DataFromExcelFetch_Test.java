package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.Vtiger.generic.ExcelFetching;

public class DataFromExcelFetch_Test {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
ExcelFetching excelfetch=new ExcelFetching();
String data1=excelfetch.readDatafromExcel("Sheet1", 0, 1);
System.out.println(data1);
 }
}


