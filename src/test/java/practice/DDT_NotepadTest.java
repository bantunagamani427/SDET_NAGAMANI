package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DDT_NotepadTest {

	public static void main(String[] args) throws IOException {
	WebDriver driver=WebDriverManager.chromedriver().create();	
FileInputStream fis =new FileInputStream("../SDET7_NAGA/target/sdet.PROPERTIES");
Properties pobj=new Properties();
pobj.load(fis);
String str=pobj.getProperty("url");
System.out.println(str);
driver.get(str);
	}

}
