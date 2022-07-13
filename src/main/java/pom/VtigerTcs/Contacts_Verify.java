package pom.VtigerTcs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.Vtiger.generic.PropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Contacts_Verify {
public static WebDriver driver;
	public static void main(String[] args) throws IOException {		
		PropertyFile datafetch=new PropertyFile();
		String url=datafetch.fetchpro("URL");
		String un=datafetch.fetchpro("username");
		String pwd=datafetch.fetchpro("password");
		String browser=datafetch.fetchpro("browser");
      if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();}
		else if(browser.equals("opera")) {
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();}
	}

}
