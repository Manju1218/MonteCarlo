package testScripts;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MonteCarlo_WishlistPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class AddItemToWishListBySearchBox2  extends BaseClass{
	
	@Test
	public void testCase2() throws EncryptedDocumentException, IOException, InterruptedException {
	MonteCarlo_LoginPage login = new MonteCarlo_LoginPage(driver);
	login.loginButton();
	MonteCarlo_SigninPage signin = new MonteCarlo_SigninPage(driver);
	
	signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
	
	signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
	
	signin.loginButton();
	
	Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
	
	MontoCarlo_AccountPage accpage = new MontoCarlo_AccountPage(driver);
	
	accpage.searchBar();
	
	
	accpage.productName(datautilities.readingdataPropertyFile("productName"));
	
	accpage.fourthItem();
	
	MontoCarlo_ProductPage product = new MontoCarlo_ProductPage(driver);
	
	product.addToList();
	
	product.wishList();

	Assert.assertEquals(product.gettext(),datautilities.readingdataPropertyFile("productName2") );
	
	MonteCarlo_WishlistPage wish= new MonteCarlo_WishlistPage(driver);

	utilities.mouseOver(wish.mouseHower(), driver);
	}
	

}
