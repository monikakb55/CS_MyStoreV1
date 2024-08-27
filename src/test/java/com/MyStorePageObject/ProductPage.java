package com.MyStorePageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	
	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(id = "color_14")
	WebElement prodColour;
	
	@FindBy(xpath = "//div[@class='functional-buttons clearfix']")
	WebElement moveToMouseOnCompareProd;
	
	@FindBy(css = ".add_to_compare.checked")
	WebElement addToCompare;
	
	public void selectSize(String sizeType) {
		
		Select oSelect = new Select(size);
		oSelect.selectByVisibleText(sizeType);
	}
	
	public void getProdColour() {
		
		prodColour.click();
	}
	
	public void moveToMouseOnProd() {
		
		Actions actionsObj =  new Actions(driver);
		
		actionsObj.moveToElement(moveToMouseOnCompareProd).build().perform();
				
	}
	
	public void clickOnAddToCompr() {
		
		addToCompare.click();
		
	}
	
}	
	
	
	
	
	


