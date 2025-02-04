package testScripts;

import java.io.IOException;

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
	
	@Test
	public void testCase9() throws EncryptedDocumentException, IOException {
//		1.Open the browser
//		2.Maximize the browser                     
//		3.Enter the Url
//		4.Click on Login
//		5.Enter Username and password
//		6.Verify the homepage 
//		7.Click on cart
//		8.Click on start Shopping
//		9.Select Filters : Date Old to New
//		10.Click on the Product
//		11.Click on add to cart
//		12.Click on Close Button.
		
		MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
		loginpage.loginButton();
		
		MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
		
		
		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		
		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		
		signin.loginButton();
		
		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		
		accpage.cartClick();
		

		
		MonteCarlo_CartPage cartpage= new MonteCarlo_CartPage(driver);
		
		cartpage.startShooping();
		
		cartpage.filter();
		
		cartpage.date();
		
		cartpage.selectPro();
		
		MontoCarlo_ProductPage productpage= new MontoCarlo_ProductPage(driver);
		productpage.addCartItem();
		
		productpage.orderNote(datautilities.readingdataPropertyFile("Note"));
		
		productpage.saveNote();
		
		productpage.closeCart();
	
	}

}
