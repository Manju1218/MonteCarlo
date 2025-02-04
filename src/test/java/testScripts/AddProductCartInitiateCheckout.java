package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class AddProductCartInitiateCheckout extends BaseClass{
	static Logger logger = LogManager.getLogger(AddProductCartInitiateCheckout.class);
	@Test
	public void testCase4() throws EncryptedDocumentException, IOException {
		
		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
		logger.info("Click on signin");
		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
		
		logger.info("Reading the username");

		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		logger.info("Reading the password");

		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		logger.info("Click on signinButton");

		signin.loginButton();
		
		MontoCarlo_AccountPage accpage = new MontoCarlo_AccountPage(driver);
		logger.info("Click on search bar");

		accpage.searchBar();
		logger.info("Reading the product name from property file");

		accpage.productName(datautilities.readingdataPropertyFile("WomenHoodie"));
		logger.info("click on womenHooded");

		accpage.womenHooded();
		
		MontoCarlo_ProductPage product = new MontoCarlo_ProductPage(driver);
		
		logger.info("choose the size");

		product.selectSizeWomen();
		
		logger.info("Increase the quantity");

		product.increaseQty();
		
		logger.info("Adding to the cart");

		product.addCart();
		
		logger.info("check initiate");

		product.checkInitiate();
		
		
		
		
	}
}
