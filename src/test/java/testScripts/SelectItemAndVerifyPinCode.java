package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_AcComforterPage;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class SelectItemAndVerifyPinCode extends BaseClass{
	
	static Logger logger = LogManager.getLogger(SelectItemAndVerifyPinCode.class);
	@Test
	public void testCase3() throws EncryptedDocumentException, IOException, InterruptedException {
		
		MonteCarlo_LoginPage login = new MonteCarlo_LoginPage(driver);
		
		logger.info("click on signin");
		
		login.loginButton();
		
		MonteCarlo_SigninPage signin = new MonteCarlo_SigninPage(driver);
		
		logger.info("Entering username");

		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		
		logger.info("Entering password");

		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		
		utilities.waitElementClick(signin.waitButton(), driver);
		
		signin.loginButton();
		
		logger.info("Verifying Account page");

		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		
		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		
		logger.info("Mouse overing on mens");

		utilities.mouseOver(accpage.mensHower(), driver);
		
		utilities.waitElementClick(accpage.waitNeck(), driver);
		
		logger.info("click on roundNeck");

		accpage.roundNeck();
		MonteCarlo_AcComforterPage  specifiactions = new MonteCarlo_AcComforterPage(driver);
		logger.info("click on size");

		specifiactions.clickSize();
		logger.info("choose size");

		specifiactions.chooseSize();
		logger.info("click on brand");

		
		specifiactions.clickBrand();
		utilities.waitElementClick(specifiactions.waitBrandNeck(), driver);
		logger.info("choose brand");

		specifiactions.chooseBrand();
		
		logger.info("click on sleeve");

		specifiactions.sleeve();
		
		logger.info("choose sleeve");

		specifiactions.sleeveSelect();
		utilities.waitElementClick(specifiactions.waitItem(), driver);
		logger.info("click on thirdItem");

		specifiactions.thirdItem();
		
		MontoCarlo_ProductPage product = new MontoCarlo_ProductPage(driver);
		logger.info("Entering the pincode");

		product.enterPincode(datautilities.readingdataPropertyFile("pincode"));
		logger.info("checking the pincode");

		product.checkPin();
		
		
		
		
	}
}
