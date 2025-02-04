package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_CartPage;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class MontoCarlo_AddToCartOldNew9 extends BaseClass{
	static Logger logger = LogManager.getLogger(MontoCarlo_AddToCartOldNew9.class);
	@Test
	public void testCase9() throws EncryptedDocumentException, IOException {

		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
		logger.info("click on signin");

		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
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
		
		logger.info("click on startShopping");
		
		cartpage.startShooping();
		
		logger.info("click on filter");

		cartpage.filter();
		
		logger.info("choose date");

		cartpage.date();
		
		logger.info("select the product");

		cartpage.selectPro();
		
		MontoCarlo_ProductPage productpage= new MontoCarlo_ProductPage(driver);
		
		logger.info("click on add to cart");

		productpage.addCartItem();
		
		logger.info("adding a note");

		productpage.orderNote(datautilities.readingdataPropertyFile("Note"));
		
		logger.info("saving note");

		productpage.saveNote();
		
		logger.info("close cart");

		productpage.closeCart();
	
	}

}
