//create contact and check it is deleted or not//
package com.VTiger.TCs;
import java.io.IOException;
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
public class Delete_Campaign {
static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException, IOException {
			PropertyFile datafetch=new PropertyFile();
	String browser=datafetch.fetchpro("browser");
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else {
	System.out.println("browser not found");	
	}
	   driver.get(datafetch.fetchpro("URL"));
		WebDriverUtil util=new WebDriverUtil(driver);//creating the obj after initlizing the driver

		//driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   util.maximizeWindow();
	   util.pageLoad();
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(datafetch.fetchpro("username"),Keys.TAB,datafetch.fetchpro("password"),Keys.ENTER);
		FakeData fakedata=new FakeData();
		String orgname=fakedata.orgname();
		Random ran=new Random();
		int data=ran.nextInt(100);
		driver.findElement(By.xpath("//a[text()='More']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		driver.findElement(By.xpath("//a[text()='More']")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement ele = driver.findElement(By.name("search_field"));
		Select s=new Select(ele);
		s.selectByIndex(1);
		driver.findElement(By.name("submit")).click();
		String mainID=driver.getWindowHandle();
		Set<String> allID = driver.getWindowHandles();
		for(String i:allID) {
			if(!mainID.equals(i)) {
				driver.switchTo().window(i);
	         }}
		Thread.sleep(2000);
		driver.findElement(By.name("selected_id")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		util.acceptAlert();
	//Alert alertpopup=driver.switchTo().alert();
	//alertpopup.accept();
		String verify=driver.findElement(By.xpath("//span[normalize-space(text())='No Campaign Found !']")).getText();
		Thread.sleep(2000);
		if(verify.equalsIgnoreCase("No Campaign Found !")) {
			System.out.println("Test case is passed");
		}
		else {
			System.out.println("Test case is failed");
		}
		Thread.sleep(2000);
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		util.moveToElement(signout);
		//Actions act=new Actions(driver);
		//act.moveToElement(signout);
		signout.click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
         }}