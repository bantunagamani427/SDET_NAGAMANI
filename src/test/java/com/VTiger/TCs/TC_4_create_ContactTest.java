package com.VTiger.TCs;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.CreateContact;
import com.ObjectRepository.OrganizationsInfoPage;
import com.ObjectRepository.VerifyPage;
import com.Vtiger.generic.BaseClass;
import com.Vtiger.generic.FakeData;
import com.Vtiger.generic.RetryAnalyzer;
import com.Vtiger.generic.WebDriverUtil;

@Listeners(com.Vtiger.generic.ListenerClass.class)

public class TC_4_create_ContactTest extends BaseClass {

	@Test(priority=4,retryAnalyzer = RetryAnalyzer.class)
	public void createcontactwithorg() throws IOException, InterruptedException {
		WebDriverUtil wbdUtil=new WebDriverUtil(driver);

		CreateContact createContact=new CreateContact(driver);

		FakeData fakeData = new FakeData();
		String firstname = fakeData.firstName();
		String lastname = fakeData.lastname();

		createContact.getcontactlink().click();
		createContact.getcreateContact().click();

		WebElement list = createContact.getbeforeFname();
		wbdUtil.selectDD("Mr.", list);

		createContact.getfirstname().sendKeys(firstname);
		createContact.getlastname().sendKeys(lastname);
		createContact.getsavebtn().click();

		//OrganizationsInfoPage orgInfoPage=new OrganizationsInfoPage(driver);
		VerifyPage verify=new VerifyPage(driver);
		
		WebElement s1=verify.getverifyCreated();
		String actual = s1.getText();
		//Assert.assertFalse(true);
		//System.out.println("create contact is not verified");

		if(actual.contains(firstname)) {
			System.out.println("create contact verified");
		}
		else {
			System.out.println("create contact  not verified");
		}

	}}

