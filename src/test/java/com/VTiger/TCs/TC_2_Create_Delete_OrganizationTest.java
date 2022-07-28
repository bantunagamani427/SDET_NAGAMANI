package com.VTiger.TCs;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.CreateOrgPageInfo;
import com.ObjectRepository.Create_Delete_Campaign;
import com.ObjectRepository.DeleteOrg;
import com.ObjectRepository.HomePage;
import com.ObjectRepository.OrganizationsInfoPage;
import com.ObjectRepository.VerifyPage;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.FakeData;
import com.Vtiger.generic.RetryAnalyzer;
import com.Vtiger.generic.WebDriverUtil;

@Listeners(com.Vtiger.generic.ListenerClass.class)

public class TC_2_Create_Delete_OrganizationTest extends BaseClass {

	@Test(priority=2,retryAnalyzer=RetryAnalyzer.class)
	public void deleteOrg() throws IOException, InterruptedException {
		WebDriverUtil driverUtil = new WebDriverUtil(driver);

		FakeData fakeData = new FakeData();
		String orgname = fakeData.companyname();
		
		HomePage homepage=new HomePage(driver);
		homepage.getOrglinkbtn().click();

		OrganizationsInfoPage orgInfoPage=new OrganizationsInfoPage(driver);
		orgInfoPage.getCreateorglinkbtn().click();

		Thread.sleep(2000);

		CreateOrgPageInfo createOrgpage=new CreateOrgPageInfo(driver);
		createOrgpage.getOrgnametextbox().sendKeys(orgname);
		Thread.sleep(2000);
		createOrgpage.getSavebutton().click();
		Thread.sleep(2000);


		
		DeleteOrg deleteorg=new DeleteOrg(driver);
		deleteorg.getOrglinkbtn().click();
		Thread.sleep(2000);

		deleteorg.getsearchorgtxtbox().sendKeys(orgname);
		Thread.sleep(2000);

       VerifyPage verifydeleteorg=new VerifyPage(driver);

		deleteorg.getSelectorgtypeDD().click();
		WebElement orgDD = deleteorg.getSelectorgtypeDD();
		driverUtil.selectDD("Organization Name", orgDD);
		Thread.sleep(2000);

		verifydeleteorg.getsearchNow().click();
		//deleteorg.getSearchorgbtn().click();
		Thread.sleep(2000);
		
		WebElement getCheckBox = deleteorg.getselectCheckBox1();
		driverUtil.moveToelement(getCheckBox);
		deleteorg.getselectCheckBox1().click();
		Thread.sleep(5000);
		
		deleteorg.getdeletebutton().click();
		Thread.sleep(4000);

        driverUtil.acceptAlert();
		Thread.sleep(4000);


		 WebElement deletedVerify = deleteorg.getdeleteVerify();
		String deletedVerify1=deletedVerify.getText();
		
		Assert.assertEquals(deletedVerify1, "No Organization Found !");
		System.out.println("delete organization is verified");


		}
}

