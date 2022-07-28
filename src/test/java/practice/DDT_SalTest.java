package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDT_SalTest {

 static int salary;

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//WebDriver driver=WebDriverManager.chromedriver().create();
		FileInputStream fis=new FileInputStream("../SDET7_NAGA/target/sdet7.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=  book.getSheet("Sheet1");
	int ro=sh.getLastRowNum();
		for(int i=1;i<=ro;i++) {
		
			Cell sal=sh.getRow(i).getCell(1);
			int salary=(int)sal.getNumericCellValue();
	if(salary>=1500) {
		Cell data=book.getSheet("Sheet1").getRow(i).getCell(0);	

			System.out.println(data);
			}
		}
		}
	}

