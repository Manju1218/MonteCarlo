package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_AddressPage;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MontoCarlo_AccountPage;

public class DeleteAddressFromAccount extends BaseClass{
	@Test
	public void testCase7() throws EncryptedDocumentException, IOException, InterruptedException {
		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
		
		
		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		
		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		
		signin.loginButton();
		
		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		

		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		
		accpage.address();
		
		MonteCarlo_AddressPage address = new MonteCarlo_AddressPage(driver);
		address.deleteAdd();
		
		utilities.alertacceptPopup(driver);
		
		
		
		
		 
		
	}	

}
