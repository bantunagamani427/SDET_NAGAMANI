package com.VTiger.TCs;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.CreateOrgPageInfo;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrganizationsInfoPage;
import com.ObjectRepository.VerifyPage;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.FakeData;
import com.Vtiger.generic.RetryAnalyzer;
import com.Vtiger.generic.WebDriverUtil;

@Listeners(com.Vtiger.generic.ListenerClass.class)

public class TC_5_create_org_DDTest extends BaseClass{

	@Test(priority=5,retryAnalyzer = RetryAnalyzer.class)

	public void createOrgDD() throws IOException, InterruptedException {

		WebDriverUtil wbdutil=new WebDriverUtil(driver);


		FakeData fakeData = new FakeData();
		String orgname=fakeData.companyname();

		//Assert.assertFalse(true);
		
		HomePage homepage=new HomePage(driver);
		homepage.getOrglinkbtn().click();

		OrganizationsInfoPage orgInfoPage=new OrganizationsInfoPage(driver);
		orgInfoPage.getCreateorglinkbtn().click();

		Thread.sleep(2000);

		CreateOrgPageInfo createOrgpage=new CreateOrgPageInfo(driver);
		createOrgpage.getOrgnametextbox().sendKeys(orgname);
		Thread.sleep(2000);


		WebElement industryDD1 = orgInfoPage.getselectIndustryDD();
		wbdutil.selectDD("Education", industryDD1);
		Thread.sleep(2000);


		WebElement orgTypeDD = orgInfoPage.getSelectorgtypeDD();
		wbdutil.selectDD("Analyst", orgTypeDD);

		WebElement ratingDD = orgInfoPage.getselectRatingDD();
		wbdutil.selectDD("Active", ratingDD);

		createOrgpage.getSavebutton().click();

		Thread.sleep(2000);
		
		VerifyPage verify=new VerifyPage(driver);
		String actual = verify.getverifyCreated().getText();
		//Assert.assertEquals(actual,orgname );
	  // System.out.println("create org with dropdown verified");
		
		if(actual.contains(orgname)) {
		System.out.println(" create org with dropdown verified");
		}
		
		else {
			System.out.println(" create org with dropdown not verified");
}
	}
}
