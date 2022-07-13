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
public class VerifyOrganization {
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
		FakeData fakedata=new FakeData();
	String orgname=	fakedata.orgname();
		//driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.get(datafetch.fetchpro("URL"));
		WebDriverUtil util=new WebDriverUtil(driver);//creating the obj after initilizing the obj
//datafetch.fetchpro(orgname)
		util.pageLoad();
		util.maximizeWindow();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(datafetch.fetchpro("username"),Keys.TAB,datafetch.fetchpro("password"),Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		String verify=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(verify.contains(orgname)) {
			System.out.println("verified");
		}
		else {
			System.out.println(" not verified");
}
		Thread.sleep(2000);
		WebElement signout=driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		util.moveToElement(signout);
		signout.click();
		//Actions act=new Actions(driver);
		//act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}}
