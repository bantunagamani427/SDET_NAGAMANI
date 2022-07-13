
package com.VTiger.TCs;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.generic.FakeData;
import com.Vtiger.generic.PropertyFile;
import com.Vtiger.generic.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete_Organization {
static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
		PropertyFile datafetch=new PropertyFile();
		String browser=datafetch.fetchpro("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			}
		else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser not found");
		}
		driver.get(datafetch.fetchpro("URL"));
		WebDriverUtil util=new WebDriverUtil(driver);//creating the obj after initilizing the driver 
//driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		util.pageLoad();
		util.maximizeWindow();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(datafetch.fetchpro("username"),Keys.TAB,datafetch.fetchpro("password"),Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		Random ran=new Random();
		int data=ran.nextInt(100);
		FakeData fakedata=new FakeData();
		String orgname=fakedata.orgname();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String mainID=driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();
		for(String i:allID) {
			if(!mainID.equals(i)) {
				driver.switchTo().window(i);
			}
		}
		Thread.sleep(2000);
	WebElement ele = driver.findElement(By.xpath("//a[text()='Organizations']"));
		util.moveToElement(ele);
	//Actions act=new Actions(driver);
		//act.moveToElement(ele);
		ele.click();
driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);
WebElement ele1 = driver.findElement(By.name("search_field"));
util.select_DD(ele1, 1);
//Select s=new Select(ele1);
//s.selectByIndex(1);
driver.findElement(By.name("submit")).click();
Thread.sleep(2000);
driver.findElement(By.name("selected_id")).click();
driver.findElement(By.xpath("//input[@value='Delete']")).click();
util.acceptAlert();
//Alert alertpopup=driver.switchTo().alert();
//alertpopup.accept();
String verify=driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
if(verify.equalsIgnoreCase("No Organization Found !")) {
	System.out.println("Test Case is passed");
  }
else {
	System.out.println("Test case is failed");
}
WebElement signout = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
util.moveToElement(signout);
//Actions act1=new Actions(driver);
//act1.moveToElement(signout);
Thread.sleep(2000);
signout.click();
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
