
package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowserTest {

	public static void main(String[] args) {

//WebDriverManager.chromedriver().setup();
//WebDriver driver= new ChromeDriver();
WebDriver driver=WebDriverManager.chromedriver().create();		
driver.get("http://amazon.in");
	}
	}
