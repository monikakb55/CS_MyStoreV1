package com.MyStorePageObject;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {

	WebDriver driver;

	public SearchResultPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Faded Short Sleeve T-shirts")
	WebElement searchProdResult;
	
//	@FindBy(xpath = "Faded Short Sleeve T-shirts")
//	WebElement moveToMouseOnTsrt;
	
	@FindBy(linkText = "More")
	WebElement more;

	// Action methods

	public String getSearchProdResult() {
		return searchProdResult.getText();

	}


	public void clickOnMoreButton() {
		
	   more.click();
	}
	
/*	public void moveToMouseOnTsrt() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(more));
		
		Actions actions = new Actions(driver);
	    actions.moveToElement(more).build().perform();
		
		
	} */

}
