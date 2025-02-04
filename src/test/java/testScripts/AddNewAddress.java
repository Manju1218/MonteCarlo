package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_AddressPage;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MontoCarlo_AccountPage;

public class AddNewAddress extends BaseClass {
	static Logger logger= LogManager.getLogger(AddElementHandlePopUp.class);

	@Test
	public void testCase6() throws EncryptedDocumentException, IOException, InterruptedException {
		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
		logger.info("Open App");
		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
		
		logger.info("entering username");
		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		logger.info("entering password");
		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		logger.info("Click on login");
		signin.loginButton();
		logger.info("Login successfully");
		logger.info("Verifying account page");

		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		logger.info("verified successfully");

		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		logger.info("click on address");

		accpage.address();
		
		MonteCarlo_AddressPage addpage= new MonteCarlo_AddressPage(driver);
		logger.info("Click on add new address");

		addpage.addNewAddress();
		logger.info("entering name");

		addpage.getName(datautilities.readingdataPropertyFile("Name"));
		logger.info("entering phone number");

		addpage.getPhone(datautilities.readingdataPropertyFile("phoneNumber"));
		logger.info("entering address1");

		addpage.getAddress(datautilities.readingdataPropertyFile("Address1"));
		logger.info("entering city");

		addpage.getCity(datautilities.readingdataPropertyFile("city"));
		logger.info("entering zip");

		addpage.getZip(datautilities.readingdataPropertyFile("Zip"));
		logger.info("setting this address as default");

		addpage.defaultSet();
		Thread.sleep(6000);
		logger.info("Submit add submit");

		addpage.addAddressSubmit();

		logger.info("submit successfully");

		
	
		
	}

}
