package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import pom.MonteCarlo_CartPage;
import pom.MonteCarlo_CheckOutPage;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MonteCarlo_WishlistPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class TestCase10 extends BaseClass{
	static Logger logger = LogManager.getLogger(TestCase10.class);
	@Test
	public void testCase10() throws EncryptedDocumentException, IOException {
		MonteCarlo_LoginPage login = new MonteCarlo_LoginPage(driver);
		logger.info("click on signin");
		login.loginButton();
		MonteCarlo_SigninPage signin = new MonteCarlo_SigninPage(driver);
		logger.info("Entering username");

		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		logger.info("Entering password");

		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		logger.info("click on signinButton");

		signin.loginButton();
		logger.info("Verifying the account page");

		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		logger.info("click on cart");

		accpage.cartClick();
	
		MonteCarlo_CartPage cartpage= new MonteCarlo_CartPage(driver);
		logger.info("click on start shopping");

		cartpage.startShooping();
		logger.info("click on filter");

		cartpage.filter();
		logger.info("choose from high to low");

		cartpage.HighToLow();
		logger.info("select product");

		cartpage.selectPro10();
		
		MontoCarlo_ProductPage prpage= new MontoCarlo_ProductPage(driver);
		logger.info("Add to wishlist");

		prpage.addwish();
		logger.info("click on wishlist");

		prpage.gotoWish();
		
		MonteCarlo_WishlistPage wish = new MonteCarlo_WishlistPage(driver);
		
		
		SoftAssert s = new SoftAssert();
		logger.info("Verifying the item added or not");

		s.assertEquals(wish.bedSheet(),datautilities.readingdataPropertyFile("productNameTC10"));
		
		utilities.waitElementClick(wish.webEleWailadd(),driver );
		logger.info("click on add to cart");

		wish.addToCart();
		logger.info("click on edit");

		cartpage.addEdit();
		logger.info("Entering note");

		cartpage.cartNote(datautilities.readingdataPropertyFile("note"));
		logger.info("Initiate checkout");

		cartpage.initiateCheckout();
		
		MonteCarlo_CheckOutPage checkout= new MonteCarlo_CheckOutPage(driver);
		logger.info("Entering address");

		checkout.addressInput(datautilities.readingdataPropertyFile("address1"));
		logger.info("selecting address");

		checkout.addressSecondOption();
		
		s.assertAll();
	}

}
