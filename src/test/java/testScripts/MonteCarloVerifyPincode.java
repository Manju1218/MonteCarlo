package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_FindStores;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class MonteCarloVerifyPincode extends BaseClass{
	static Logger logger = LogManager.getLogger(MonteCarloVerifyPincode.class);
	@Test
	public void testCase5() throws EncryptedDocumentException, IOException, InterruptedException {
		
		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
		logger.info("click on signin");
		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
		
		logger.info("Entering the username");

		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		logger.info("Entering the password");

		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		logger.info("click on signinButton");

		signin.loginButton();
		logger.info("Verifying the Account page");

		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		
		MontoCarlo_AccountPage accpage = new MontoCarlo_AccountPage(driver);
		
		logger.info("click on home click");

		accpage.HomeClick();
		logger.info("click on shop blanket");

		accpage.shopBlanket();
		logger.info("click on image");

		accpage.imgBlank();
		
		MontoCarlo_ProductPage propage= new MontoCarlo_ProductPage(driver);
		logger.info("click on product description");

		propage.proDesc();
		
		utilities.waitElementClick(propage.getClickStores(), driver);
		logger.info("click on stores");

		propage.clickStores();
		
		MonteCarlo_FindStores findStore= new MonteCarlo_FindStores(driver);
		logger.info("click on search store");

		findStore.searchStore();
		logger.info("click on zipcode");

		findStore.searchFindStoreTextBox(datautilities.readingdataPropertyFile("ZipCode"));
		logger.info("click on directions");

		findStore.direction();
	}
	
}
