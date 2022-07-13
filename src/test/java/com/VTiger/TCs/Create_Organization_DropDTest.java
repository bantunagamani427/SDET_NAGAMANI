package com.VTiger.TCs;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.generic.FakeData;
import com.Vtiger.generic.PropertyFile;
import com.Vtiger.generic.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

//Dropdown organization or verify the name in organization

public class Create_Organization_DropDTest {
	static	WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
		PropertyFile datafetch=new PropertyFile();
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
		WebDriverUtil util=new WebDriverUtil(driver);//creating the obj after initilizing the driver
Random ran=new Random();
		int data=ran.nextInt(100);
		FakeData fakedata=new FakeData();
		String orgname=fakedata.orgname();
		//driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.get(datafetch.fetchpro("URL"));
		//driver.manage().timeouts().implicitlyWait(Duration.);
		//driver.manage().window().maximize();
		util.maximizeWindow();
		util.pageLoad();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(datafetch.fetchpro("username"),Keys.TAB,datafetch.fetchpro("password"),Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement industry=driver.findElement(By.name("industry"));
		util.select_DD("Banking", industry);
		//Select industry_dd=new Select(industry);
		//industry_dd.selectByVisibleText("Banking");
		WebElement account=driver.findElement(By.name("accounttype"));
		util.select_DD("Analyst", account);
		//Select account_type=new Select(account);
		//account_type.selectByVisibleText("Analyst");
		WebElement rating=driver.findElement(By.name("rating"));
		util.select_DD("Acquired", rating);
		//Select rating_type=new Select(rating);
		//rating_type.selectByVisibleText("Acquired");
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(2000);
		WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(2000);
		util.moveToElement(signout);
		//Actions act=new Actions(driver);
		//act.moveToElement(signout).perform();
		//signout.click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}}

