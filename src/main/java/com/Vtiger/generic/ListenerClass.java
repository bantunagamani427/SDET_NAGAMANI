package com.Vtiger.generic;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass extends BaseClass  implements ITestListener{

	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test=reports.createTest(result.getMethod().getMethodName()+"got started");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"got Pass");
		//test=reports.createTest(result.getMethod().getMethodName()+"got passed");	
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+"got Fail");

		//test=reports.createTest(result.getMethod().getMethodName()+"got fail");
		String path;
		try {
			path=BaseClass.takeScreenShot(result.getMethod().getMethodName()+"got fail") ;
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"got Skip");
	}


	@Override
	public void onStart(ITestContext context) {
		reporter=new ExtentSparkReporter(IAutoconsts.extentreporterpath);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("VTIGER App");
		reporter.config().setReportName("CRM report");

		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Build", "14.1.3");
		reports.setSystemInfo("Created By", "Test team ");
	}
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();

	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

}
