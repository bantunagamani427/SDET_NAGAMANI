package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {

	public static void main(String [] args) {
WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.lenskart.com/");
driver.manage().window().maximize();
driver.findElement(By.name("q")).click();
String str=driver.findElement(By.xpath("//div[@class='trending_block']")).getText();
 System.out.println(str);
}}
