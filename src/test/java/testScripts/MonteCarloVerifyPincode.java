package testScripts;

import java.io.IOException;

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

	@Test
	public void testCase5() throws EncryptedDocumentException, IOException, InterruptedException {
		
		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
		
		
		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		
		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		
		signin.loginButton();
		
		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		
		MontoCarlo_AccountPage accpage = new MontoCarlo_AccountPage(driver);
		
		accpage.HomeClick();
		
		accpage.shopBlanket();
		
		accpage.imgBlank();
		
		MontoCarlo_ProductPage propage= new MontoCarlo_ProductPage(driver);
		
		propage.proDesc();
		
		utilities.waitElementClick(propage.getClickStores(), driver);
		
		propage.clickStores();
		
		MonteCarlo_FindStores findStore= new MonteCarlo_FindStores(driver);
		
		findStore.searchStore();
		
		findStore.searchFindStoreTextBox(datautilities.readingdataPropertyFile("ZipCode"));
		
		findStore.direction();
	}
	
}
