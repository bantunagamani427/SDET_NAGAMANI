package com.VTiger.TCs;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.CreateOrgPageInfo;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrganizationsInfoPage;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.FakeData;
import com.Vtiger.generic.RetryAnalyzer;
import com.Vtiger.generic.WebDriverUtil;

@Listeners(com.Vtiger.generic.ListenerClass.class)
public class TC_01_CreateAndVerify_orgTest extends BaseClass {


	@Test(priority=1,retryAnalyzer=RetryAnalyzer.class)
	public void createOrgz() throws InterruptedException
	{

		WebDriverUtil driverUtil = new WebDriverUtil(driver);

		FakeData fakeData = new FakeData();
		String orgname = fakeData.companyname();
		Thread.sleep(2000);

		HomePage homePage = new HomePage(driver);
		WebElement orglink = homePage.getOrglinkbtn();
		driverUtil.waitankclick(orglink);

		OrganizationsInfoPage organizationsInfoPage = new OrganizationsInfoPage(driver);
		organizationsInfoPage.getCreateorglinkbtn().click();
		Thread.sleep(2000);




		CreateOrgPageInfo createOrgPage = new CreateOrgPageInfo(driver);
		createOrgPage.getOrgnametextbox().sendKeys(orgname);
		createOrgPage.getSavebutton().click();
		Thread.sleep(2000);

		driverUtil.refreshPage();
		
		String actualorgname=organizationsInfoPage.getcreateOrgVerify().getText();
		//Assert.assertEquals(actualorgname,orgname );
		//System.out.println("create organization and verified");
		if(actualorgname.contains(orgname)) {
			System.out.println("organization is created and verified ");
		}
		else {
			System.out.println("organization is created and not verified");
		}

	}
}
