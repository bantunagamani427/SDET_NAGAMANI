package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerParticularTable {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		String allrows=driver.findElement(By.xpath("//table[@class='lvt small']")).getText();
			System.out.println("print allRows"+allrows);
		System.out.println("******************");
		String onename = driver.findElement(By.xpath("//table[@class='lvt small']//tr[4]//td[3]")).getText();
		System.out.println("4th row, 3rd column name= "+onename);
		System.out.println("*****************");
	Thread.sleep(2000);
		List<WebElement> organization = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]//td[3]"));
			//int a=organization.size();
				for(WebElement i:organization) {
					System.out.println(i.getText());
				}
		System.out.println("***************");
		List<WebElement> checkbox = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]//td[1]"));
		{
			for (int i = 3; i <= checkbox.size(); i++) {
				driver.findElement(By.xpath("//table[@class='lvt small']//tr["+i+"]//td[1]")).click();
			}
		}
		String lastname = driver.findElement(By.xpath("//table[@class='lvt small']//tr[last()]//td[3]")).getText();
System.out.println("Lastname= "+lastname);
		System.out.println("***************"); 
		List<WebElement> name = driver.findElements(By.xpath("//table[@class='lvt small']//tr[*]//td[3]"));
		for(WebElement i:name) {
			if(i.getText().equals("bannu64")) 
			{
				System.out.println("particular name="+i.getText());	
			
			}}}}

