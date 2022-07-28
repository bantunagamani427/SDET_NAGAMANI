package com.Vtiger.generic;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	int count=0;
	int trycount=2;
	public boolean retry(ITestResult result) {
		if(count<trycount) {
			count++;
			return true;
		}
		return false;
	}

}
