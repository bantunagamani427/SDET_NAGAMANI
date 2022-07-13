package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lowest_Price {
public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			String str=driver.getTitle();
			System.out.println(str);
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile under 20000");
			driver.findElement(By.id("nav-search-submit-button")).click();
			driver.findElement(By.xpath("//span[text()='Samsung']")).click();
			String str1=driver.findElement(By.xpath("//span[text()='Samsung Galaxy M33 5G (Emerald Brown, 8GB, 128GB Storage) | Travel Adapter to be Purchased Separately']/ancestor::div[@class='sg-col-inner']//span[@class='a-price-whole']")).getText();
//String str2=str1.toString();
String[] a=str1.split(",");
int b=Integer.parseInt(a[0])*1000;
int c=Integer.parseInt(a[1]);
int d=b+c;
if(d<20000) {
	System.out.println("Price lower than 20,000 is "+str1);}
else {
	System.out.println("testcase is failed");}}}
