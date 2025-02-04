package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_AcComforterPage;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MonteCarlo_WishlistPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class AddProductToWishList extends BaseClass {
	
	@Test
	public void testCase1() throws EncryptedDocumentException, IOException, InterruptedException {
	MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
	loginpage.loginButton();
	
	MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
	
	
	signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
	
	signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
	
	signin.loginButton();
	
	@Nullable
	String acctitle = driver.getTitle();

	Assert.assertEquals(acctitle, datautilities.readingdataPropertyFile("AccountPapeTitle"));
	
	MontoCarlo_AccountPage accountpage= new MontoCarlo_AccountPage(driver);
	WebElement mo = accountpage.getHomeFurnishing();
	Thread.sleep(1000);

	utilities.mouseOver(mo, driver);

	accountpage.acComforter();


	MonteCarlo_AcComforterPage comforter= new MonteCarlo_AcComforterPage(driver);
	
	comforter.clickSize();
	
	comforter.chooseSize();
	Thread.sleep(3000);
	comforter.clickColour();
	
	Thread.sleep(4000);
	comforter.chooseColour();

	comforter.clickBrand();
	Thread.sleep(3000);
	comforter.chooseBrand();
	Thread.sleep(3000);
	comforter.clickAvailability();

	comforter.chooseAvailability();

	comforter.chooseProduct();
	
	MontoCarlo_ProductPage product = new MontoCarlo_ProductPage(driver);
	
	product.wishlistAdd();
	
	product.wishList();
	
	MonteCarlo_WishlistPage wishlist= new MonteCarlo_WishlistPage(driver);
	
	String currentWishTitle = driver.getTitle();
	
	Assert.assertEquals(currentWishTitle,datautilities.readingdataPropertyFile("wishlistTitle"));
	Thread.sleep(3000);
	wishlist.addToCart();
	
	}

}
