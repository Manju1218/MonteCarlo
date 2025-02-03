package testScripts;

import java.io.IOException;

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
	
	@Test
	public void testCase6() throws EncryptedDocumentException, IOException, InterruptedException {
		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
		
		
		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		
		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		
		signin.loginButton();
		
		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));

		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		
		accpage.address();
		
		MonteCarlo_AddressPage addpage= new MonteCarlo_AddressPage(driver);
		
		addpage.addNewAddress();
		
		addpage.getName(datautilities.readingdataPropertyFile("Name"));
		addpage.getPhone(datautilities.readingdataPropertyFile("phoneNumber"));
		addpage.getAddress(datautilities.readingdataPropertyFile("Address1"));
		addpage.getCity(datautilities.readingdataPropertyFile("city"));
		addpage.getZip(datautilities.readingdataPropertyFile("Zip"));
		addpage.defaultSet();
		Thread.sleep(6000);
		addpage.addAddressSubmit();
//String address="570026 bangalore AN";
		String actual="  Manjunath\r\n"
				+ "bangalore,Electronic city\r\n"
				+ "570026 bangalore AN\r\n"
				+ "India  ";
				
		Assert.assertEquals(actual, addpage.textadd());	
		
		Reporter.log(addpage.textadd(),true);
//		Assert.assertEquals(actAddress,);
		
	
		
	}

}
