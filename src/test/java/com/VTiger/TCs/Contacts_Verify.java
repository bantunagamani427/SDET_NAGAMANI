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

	//login.getUsernametextbox().sendKeys(data);
	//login.getPaaswordtxtbox(datafetch.fetchpro("password"));
	login.getLoginbutton();
	//driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(datafetch.fetchpro("username"),Keys.TAB,datafetch.fetchpro("password"),Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	//driver.findElement(By.xpath("//select[@name='salutationtype']")).click();
	WebElement ele = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	util.select_DD(ele, 2);
	//Select s=new Select(ele);
	//s.selectByIndex(2);
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	String mainID=driver.getWindowHandle();
	Set<String> allID = driver.getWindowHandles();
	for(String i:allID) {
		if(!mainID.equals(i)) {
			driver.switchTo().window(i);
		}}
	Thread.sleep(2000);
	driver.findElement(By.id("search_txt")).sendKeys(firstname);
	WebElement dropdown=driver.findElement(By.name("search_field"));
	util.select_DD(dropdown,1);
	//Select s1=new Select(dropdown);
	driver.findElement(By.xpath("//option[text()='Organization Name']")).click();
	driver.findElement(By.name("search")).click();
	//driver.findElement(By.xpath("//a[text()='Nagamani']")).click();
	driver.switchTo().window(mainID);
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	String verify=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(verify.contains(firstname+lastname)) {
		System.out.println("contact verified");
	}
	else {
		System.out.println("contact not verified");
	}
	WebElement signout=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	util.moveToElement(signout);
	//Actions act=new Actions(driver);
	//act.moveToElement(signout);
	signout.click();
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}}
