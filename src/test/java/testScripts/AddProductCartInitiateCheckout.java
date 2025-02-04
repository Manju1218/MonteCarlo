package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class AddProductCartInitiateCheckout extends BaseClass{

	
	@Test
	public void testCase4() throws EncryptedDocumentException, IOException {
		
		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
	
		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
		
		
		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		
		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		
		signin.loginButton();
		
		MontoCarlo_AccountPage accpage = new MontoCarlo_AccountPage(driver);
		
		accpage.searchBar();
		
		accpage.productName(datautilities.readingdataPropertyFile("WomenHoodie"));
		
		accpage.womenHooded();
		
		MontoCarlo_ProductPage product = new MontoCarlo_ProductPage(driver);
		
		product.selectSizeWomen();
		product.increaseQty();
		product.addCart();
		product.checkInitiate();
		
		
		
		
	}
}
