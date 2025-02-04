package testScripts;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MonteCarlo_WishlistPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class AddItemToWishListBySearchBox2  extends BaseClass{
	static Logger logger= LogManager.getLogger(AddElementHandlePopUp.class);
	@Test
	public void testCase2() throws EncryptedDocumentException, IOException, InterruptedException {
	logger.info("click on signin");
	MonteCarlo_LoginPage login = new MonteCarlo_LoginPage(driver);

	login.loginButton();
	MonteCarlo_SigninPage signin = new MonteCarlo_SigninPage(driver);
	logger.info("reading username from excel sheet");
	
	signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
	logger.info("reading password from excel sheet");
	signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
	logger.info("click on signin button");
	signin.loginButton();
	logger.info("verifying the Account page");

	Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
	
	MontoCarlo_AccountPage accpage = new MontoCarlo_AccountPage(driver);
	logger.info("click on search bar");

	accpage.searchBar();
	
	logger.info("Entering the product name");

	accpage.productName(datautilities.readingdataPropertyFile("productName"));
	logger.info("Selecting four item");

	accpage.fourthItem();
	
	MontoCarlo_ProductPage product = new MontoCarlo_ProductPage(driver);
	logger.info("Adding into wish list");

	product.addToList();
	logger.info("Click on wish list");

	product.wishList();
	logger.info("Verifying the product added to Wish list or not");

	Assert.assertEquals(product.gettext(),datautilities.readingdataPropertyFile("productName2") );
	
	MonteCarlo_WishlistPage wish= new MonteCarlo_WishlistPage(driver);
	logger.info("Mouse over on the item");

	utilities.mouseOver(wish.mouseHower(), driver);
	}
	

}
