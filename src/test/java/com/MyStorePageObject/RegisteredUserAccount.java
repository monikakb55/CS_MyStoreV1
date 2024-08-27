package com.MyStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {

	WebDriver driver;

	public RegisteredUserAccount(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='View my customer account']")
	WebElement userName;
	
	@FindBy(id ="search_query_top")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@name='submit_search']")
	WebElement submit_search;
	
	
	@FindBy(linkText = "Sign out")
	WebElement signOut;

	// There will be String instead of void bcoz it will return name of the user ..
	public String getUserName() {
		// Store the text in the String.

		String text = userName.getText();

		return text;
	}
	
	public void enterDataInSearchBox(String searchKey) {
		
		searchBox.sendKeys(searchKey);
	}
	
	public void clickOnSearchButton() {
		
		submit_search.click();
	}

	public void clickOnSignOut() {
		signOut.click();
		
	}
}
