package com.VTiger.TCs;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepository.Create_Delete_Campaign;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.FakeData;
import com.Vtiger.generic.RetryAnalyzer;
import com.Vtiger.generic.WebDriverUtil;


public class TC_3_Create_Delete_CampaignTest  extends BaseClass{
	@Test(priority=3,retryAnalyzer = RetryAnalyzer.class)
public void createCampaign() throws InterruptedException {
	WebDriverUtil wbdUtil=new WebDriverUtil(driver);
	
	Create_Delete_Campaign verifyCampaign=new Create_Delete_Campaign(driver);
	WebElement getMore = verifyCampaign.getmorelink();
	wbdUtil.moveToelement(getMore);
	
	verifyCampaign.getcampaignlink().click();
	verifyCampaign.getcreatecampaignbtn().click();
	Thread.sleep(2000);

	FakeData fakeData = new FakeData();
	String campname = fakeData.companyname();
	Thread.sleep(2000);
	
	verifyCampaign.getcampaignNameTxt().sendKeys(campname);
	verifyCampaign.getsavebtn().click();
	Thread.sleep(2000);

	
	verifyCampaign.getcampaignlink().click();
	verifyCampaign.getsearchtextbox().sendKeys(campname);
	Thread.sleep(2000);

	verifyCampaign.getdropdown().click();
	WebElement campDD = verifyCampaign.getdropdown();
	wbdUtil.selectDD("Campaign Name", campDD);
	Thread.sleep(2000);

	verifyCampaign.getsearchNow().click();
	Thread.sleep(2000);

	
	WebElement checkbox = verifyCampaign.getselectbox();
	wbdUtil.moveToelement(checkbox);
	verifyCampaign.getselectbox().click();
	
	verifyCampaign.getdeletebtn().click();
	Thread.sleep(4000);

	wbdUtil.acceptAlert();
	Thread.sleep(4000);

	
	Create_Delete_Campaign verifydelete=new Create_Delete_Campaign(driver);
	String actual=verifydelete.getdeleteVerify().getText();
	Thread.sleep(2000);
	
	Assert.assertEquals(actual, "No Campaign Found !");
	System.out.println(" create campaign and delete verified");
	
	}
}
