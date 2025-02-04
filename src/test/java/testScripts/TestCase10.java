package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import pom.MonteCarlo_CartPage;
import pom.MonteCarlo_CheckOutPage;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MonteCarlo_WishlistPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class TestCase10 extends BaseClass{
	
	@Test
	public void testCase10() throws EncryptedDocumentException, IOException {
		MonteCarlo_LoginPage login = new MonteCarlo_LoginPage(driver);
		login.loginButton();
		MonteCarlo_SigninPage signin = new MonteCarlo_SigninPage(driver);
		
		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		
		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		
		signin.loginButton();
		
		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		
		accpage.cartClick();
		

		
		MonteCarlo_CartPage cartpage= new MonteCarlo_CartPage(driver);
		
		cartpage.startShooping();
		
		cartpage.filter();
		
		cartpage.HighToLow();
		
		cartpage.selectPro10();
		
		MontoCarlo_ProductPage prpage= new MontoCarlo_ProductPage(driver);
		
		prpage.addwish();
		
		prpage.gotoWish();
		
		MonteCarlo_WishlistPage wish = new MonteCarlo_WishlistPage(driver);
		
		
		SoftAssert s = new SoftAssert();
		//s.assertEquals(wish.bedSheet(),datautilities.readingdataPropertyFile("productNameTC10"));
		
		utilities.waitElementClick(wish.webEleWailadd(),driver );
		wish.addToCart();
		cartpage.addEdit();
		cartpage.cartNote(datautilities.readingdataPropertyFile("note"));
		cartpage.initiateCheckout();
		
		MonteCarlo_CheckOutPage checkout= new MonteCarlo_CheckOutPage(driver);
		
		checkout.addressInput(datautilities.readingdataPropertyFile("address1"));
		checkout.addressSecondOption();
		s.assertAll();
	}

}
