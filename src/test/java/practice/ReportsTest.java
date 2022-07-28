package practice;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportsTest {
	//this class is used to set path,theme,title(look and feel)	
	ExtentSparkReporter reporter;
	//this class is used to attach reports manual inputs
	ExtentReports reports;
	//this class is used to create entries in reports
	ExtentTest test;
	@Test
	public void reportCreation() throws IOException {
		reporter=new ExtentSparkReporter("../SDET7_NAGA/SCREENSHOT Facebook/Nag.html");//path of screenshot taking
		reporter.config().setDocumentTitle("FaceBook");
		reporter.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(reporter);//attach path where we have to take screenshot
		reports.setSystemInfo("Application Version","5.0.9");
		reports.setSystemInfo("browser", "chrome");
		reports.setSystemInfo("Environment","QA");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
	    test=reports.createTest("FaceBook12");
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		String path="../SDET7_NAGA/SavedScreenshot/FaceBook123.PNG";//path where we have to store with an extension of .png
		File dest=new File(path);
		FileUtils.copyFile(file, dest);
		test.addScreenCaptureFromPath(path);
		reports.flush();
	}
}
