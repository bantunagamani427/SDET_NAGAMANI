package pom.VtigerTcs;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.ObjectRepository.CreateOrgPageInfo;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrgInfoPage;
import com.Vtiger.generic.FakeData;
import com.Vtiger.generic.PropertyFile;
import com.Vtiger.generic.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Organization_DD {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
			PropertyFile datafetch=new PropertyFile();
			String browser=datafetch.fetchpro("browser");
			String url=datafetch.fetchpro("URL");
			String un=datafetch.fetchpro("username");
			String pwd=datafetch.fetchpro("password");
			if(browser.equalsIgnoreCase("chrome")){
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				}
			else if(browser.equalsIgnoreCase("opera")) {
				WebDriverManager.operadriver().setup();
				driver=new OperaDriver();
				}
			WebDriverUtil util=new WebDriverUtil(driver);//creating the obj after initilizing the driver 
//pass the driver for connection
	util.pageLoad();
	
	util.maximizeWindow();
	Thread.sleep(2000);
	driver.get(url);
	FakeData fakedata=new FakeData();
	 String orgname=fakedata.orgname();
HomePage homepage=new HomePage(driver);
homepage.getOrglinkbutton().click();
OrgInfoPage orgpageinfo=new OrgInfoPage(driver);
orgpageinfo.getCreateorgplus().click();
CreateOrgPageInfo createorg=new CreateOrgPageInfo(driver);
	createorg.getOrgnametextbox().sendKeys(orgname);
createorg.	
	
}}

		
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

