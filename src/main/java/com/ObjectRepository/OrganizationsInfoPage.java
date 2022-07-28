package com.ObjectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage {
	WebDriver driver;
	public  OrganizationsInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath="//img[@title='Create Organization...']")
	private WebElement createorglinkbtn;
	public WebElement getCreateorglinkbtn() {
		return createorglinkbtn;
	}

	@FindBy(name="search_text")
	private WebElement searchorgtxtbox;
	public WebElement getsearchorgtxtbox() {
		return searchorgtxtbox;

	}

	@FindBy(name="industry")
	private WebElement selectIndustryDD;
	public WebElement getselectIndustryDD() {
		return selectIndustryDD;
		}
	
	@FindBy(name="rating")
	private WebElement selectRatingDD;
	public WebElement getselectRatingDD() {
		return selectRatingDD;
		
	}
	
	
	
	@FindBy(name="accounttype")
	private WebElement selectorgtypeDD;
	public WebElement getSelectorgtypeDD() {
		return selectorgtypeDD;
	}


	@FindBy(name="submit")
	private WebElement searchorgbtn;
	public WebElement getSearchorgbtn() {
		return searchorgbtn;
	}


	@FindBy(xpath="//a[@title='Organizations']")
	private WebElement searchedorgname;
	public WebElement getSearchedorgname() {
		return searchedorgname;
	}
	
	@FindBy(name="selected_id")
	private WebElement selectCheckBox;
	public WebElement getselectCheckBox() {
		return selectCheckBox;
		}
	
	
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement createOrgVerify;
	public WebElement getcreateOrgVerify() {
		return createOrgVerify;
		}
	
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deletebutton;
	public WebElement getdeletebutton() {
		return deletebutton;
		}
	}