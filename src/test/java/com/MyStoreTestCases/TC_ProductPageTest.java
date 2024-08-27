package com.MyStoreTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.MyStorePageObject.IndexPage;
import com.MyStorePageObject.MyAccount;
import com.MyStorePageObject.ProductPage;
import com.MyStorePageObject.RegisteredUserAccount;
import com.MyStorePageObject.SearchResultPage;


public class TC_ProductPageTest extends BaseClass {
	
	@Test(enabled=true)
	public void verifySearchProduct() {
	String searchKey = "T-shirt";
	logger.info("verifyLogin- passed");
	String prodSize =  "M";
	
	//1st pase
	IndexPage indxPg = new IndexPage(driver);			
	indxPg.clickOnSignIn();
	logger.info("Click on signin");
	//2nd Page
	MyAccount myAcPg = new MyAccount(driver);  
	myAcPg.enterEmailAddress(emailAddress);
	logger.info("Entered email address");
	myAcPg.enterPassword(password);
	logger.info("Entered password");
	myAcPg.clickSignIn();
	logger.info("Click on sign in button");
	
	//3rd page
	RegisteredUserAccount regstUserAcPg = new RegisteredUserAccount(driver);
	String userName = regstUserAcPg.getUserName();
	logger.info("Get the expected name");
	Assert.assertEquals("Sindhu Kumari", userName);
	
	regstUserAcPg.enterDataInSearchBox(searchKey);
	regstUserAcPg.clickOnSearchButton();

	//4rth page
	SearchResultPage searchPg = new SearchResultPage(driver);
	String searchProdName = searchPg.getSearchProdResult();
	logger.info("entered search item in the search box");

	searchPg.clickOnMoreButton();
	logger.info("Clicked on More button");
	
	ProductPage prodPage = new ProductPage(driver);
	prodPage.selectSize(prodSize);
	logger.info("Product size selected M");
	
	prodPage.getProdColour();
	logger.info("Product colour selected pink");
	
	}
	
	@Test(enabled=false)
	public void AddToComparePordWithoutLogin() {
		
		IndexPage indxPg = new IndexPage(driver);	
		indxPg.clickOnTshirtMenu();
		logger.info("Click on Tshirt menu");
		
		ProductPage prodPage = new ProductPage(driver);
		
		prodPage.moveToMouseOnProd();
		logger.info("Move to mouse on Tshirt");
		
		prodPage.clickOnAddToCompr();
		logger.info("Click on add to compare");


		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
