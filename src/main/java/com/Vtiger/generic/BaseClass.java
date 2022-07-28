package com.Vtiger.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ObjectRepository.HomePage;
import com.ObjectRepository.LoginPage;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements IAutoconsts{
	
	public  WebDriver driver;
	WebDriverUtil driverUtil;
	public static WebDriver sdriver;
	PropertyFile propertyfile =PropertyFile.getObjectPropfile();
	
	
	@BeforeSuite
	public void connectTODatabase() {
		System.out.println("connect to database");	
	}
	@AfterSuite
	public void closeDataBase() {
		System.out.println("database connection closed");
	}
	@BeforeClass
	public void launchBrowser() throws IOException, InterruptedException {


		String browser=propertyfile.readDatafromPropfile("browser");
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}


		else if(browser.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}
		else {
			System.out.println("browser not found");
		}

		driverUtil = new WebDriverUtil(driver);
		String url=propertyfile.readDatafromPropfile("URL");

		driver.get(url);
		sdriver=driver;
	}
	@AfterClass
	public void closeBrowser() {

		driverUtil.closeBrowser();
	}
	@BeforeMethod
	public void logintoApp() throws IOException, InterruptedException
	{


		driverUtil.maximiseWindow();
		Thread.sleep(2000);

		//		LoginPage2 loginPage2= new LoginPage2(driver);
		//		loginPage2.logintoApp(propertyfile.readDatafromPropfile("username"), propertyfile.readDatafromPropfile("password"));
		//		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.getlogintoapp(propertyfile.readDatafromPropfile("username"),propertyfile.readDatafromPropfile("password"));
		//		loginpage.getUsernametextbox().sendKeys(propertyfile.readDatafromPropfile("username"));	
		//		Thread.sleep(2000);
		//		loginpage.getPasswordtextbox().sendKeys(propertyfile.readDatafromPropfile("password"));
		//		loginpage.getLoginbtn().click();

	}
	@AfterMethod
	public void logoutfromApp() {
		HomePage homepage=new HomePage(driver);
		homepage.getHomepageimg().click();
		homepage.getSignoutimg().click();
		driverUtil=new WebDriverUtil(driver);
		driverUtil.moveToelement(homepage.getSignoutimg());
		driverUtil.waitankclick(homepage.getsignoutlink());
	}
	public static String takeScreenShot(String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path=IAutoconsts.screenshotpath+name+".png";
		File dest=new File(path);
		Files.copy(src, dest);
		
		return path;
}
}