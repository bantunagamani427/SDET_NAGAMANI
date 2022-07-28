package com.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Delete_Campaign {
	WebDriver driver;
	public Create_Delete_Campaign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='More']")
	private WebElement morelink;
	public WebElement getmorelink() {
		return morelink;
	}

	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaignlink;
	public WebElement getcampaignlink() {
		return campaignlink;
	}

	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createcampaignbtn;
	public WebElement getcreatecampaignbtn() {
		return createcampaignbtn;
	}

	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignNameTxt;
	public WebElement getcampaignNameTxt() {
		return campaignNameTxt;
	}

	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement savebtn;
	public WebElement getsavebtn() {
		return savebtn;
	}


	@FindBy(xpath="(//a[text()='Campaigns'])[1]")
	private WebElement campaignPage;
	public WebElement getcampaignPage() {
		return campaignPage;
	}

	
	@FindBy(xpath="//input[@name='selected_id']")
	private WebElement selectbox;
	public WebElement getselectbox() {
		return selectbox;
		}
	
	@FindBy(xpath="(//input[@value='Delete'])[1]")
	private WebElement deletebtn;
	public WebElement getdeletebtn() {
		return deletebtn;
		}
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement deleteVerify;
	public WebElement getdeleteVerify() {
		return deleteVerify;
	}

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyCreated;
	public WebElement getverifyCreated() {
		return verifyCreated;
		
	}

	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchtextbox;
	public WebElement getsearchtextbox() {
		return searchtextbox;
	}

	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement dropdown;
	public WebElement getdropdown() {
		return dropdown;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small create']")
	private WebElement searchNow;
	public WebElement getsearchNow() {
		return searchNow;
		}
	


	
 }

