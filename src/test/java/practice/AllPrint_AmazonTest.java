package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class AllPrint_AmazonTest {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.id("searchDropdownBox")).click();//click on dropdown//
		//store all categories of list//
		String str=driver.findElement(By.xpath("//select[@title='Search in']")).getText();
		//List<WebElement>ele=driver.findElements(By.xpath("//select[@name='url']"));
		//for(WebElement str:ele) {
		System.out.println(str);
		//print all list//
		WebElement ele=driver.findElement(By.xpath("//option[@value='search-alias=stripbooks']"));//to select books 
		String str1=ele.getText();//store books//
		System.out.println("***********");
		System.out.println(str1);
	}}
