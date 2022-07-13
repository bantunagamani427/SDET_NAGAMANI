package practice;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Quantity_AddedToCart {
public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Redmi",Keys.ENTER);
		String str=driver.findElement(By.xpath("//div[@class='_4rR01T']/ancestor::div[@class='_2kHMtA']//div[@class='_30jeq3 _1_WHN1']")).getText();
		System.out.println("intial price= "+str);
		//String a=str.replaceAll("₹","");
		//String b=a.replaceAll(",","");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           System.out.println(b);
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.xpath("//div[@class='_4rR01T']/ancestor::div[@class='_2kHMtA']//div[@class='_30jeq3 _1_WHN1']"));
      ele.click();
      String mainId=driver.getWindowHandle();
      Set<String>allId=driver.getWindowHandles();
      for(String i:allId) {
    	  if(!mainId.equals(i)) {
    		  driver.switchTo().window(i);}}
		driver.findElement(By.xpath("//*[name()='svg' and @class='_1KOMV2']")).click();
		Thread.sleep(3000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4000)");
	WebElement ele1=driver.findElement(By.xpath("//input[@class='_253qQJ']"));	
		Actions act=new Actions(driver);
		act.moveToElement(ele1).perform();
driver.findElement(By.xpath("//button[text()='+']")).click();
String str2=driver.findElement(By.xpath("//div[text()='Total Amount']/ancestor::div[@class='dimARw']/descendant::div[@class='_1dqRvU']")).getText();
System.out.println("price after adding quantity by 1= "+str2);
	}}
