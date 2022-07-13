package practice;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class ComparingPrices {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//button[text()='✕']")).click();
	driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Redmi",Keys.ENTER);
	 String u=driver.findElement(By.xpath("//div[text()='REDMI 9i Sport (Carbon Black, 64 GB)']")).getText();
	System.out.println(u);
	 String str=driver.findElement(By.xpath("//div[text()='REDMI 9i Sport (Carbon Black, 64 GB)']/ancestor::div[@class='_2kHMtA']//div[@class='_30jeq3 _1_WHN1']")).getText();
	System.out.println(str);
	String a=str.replaceAll("₹","");
	String b=a.replaceAll(",","");
	int c=Integer.parseInt(b);
	System.out.println(c);
driver.close();
WebDriverManager.chromedriver().setup();
WebDriver driver1=new ChromeDriver();
driver1.get("https://www.amazon.in/");
driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver1.manage().window().maximize();
driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("redmi 9i sport carbon black, 64 gb",Keys.ENTER);
String redmi=driver1.findElement(By.xpath("//span[text()='MI REDMI 9i Sport (Carbon Black, 64 GB) (4 GB RAM)']/ancestor::div[@class='sg-row']//span[@class='a-price-whole']")).getText();
System.out.println(redmi);
String d=redmi.replaceAll(",","");
int e=Integer.parseInt(d);
System.out.println(e);
if(c<e) {
System.out.println("lowest price of redmi in flipkart "+c);	
}
else {
	System.out.println("lowest price of redmi in amazon "+e);
}
}
}