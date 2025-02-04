package testScripts;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	static Logger logger = LogManager.getLogger(AddProductToWishList.class);
	@Test
	public void testCase1() throws EncryptedDocumentException, IOException, InterruptedException {
	MonteCarlo_LoginPage loginpage = new MonteCarlo_LoginPage(driver);
	logger.info("click on signin");
	loginpage.loginButton();
	
	MonteCarlo_SigninPage signin= new MonteCarlo_SigninPage(driver);
	logger.info("Entering username");

	
	signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
	logger.info("Entering password");

	signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
	logger.info("click on signinButton");

	signin.loginButton();
	logger.info("Verifying account page");

	@Nullable
	String acctitle = driver.getTitle();

	Assert.assertEquals(acctitle, datautilities.readingdataPropertyFile("AccountPapeTitle"));
	
	MontoCarlo_AccountPage accountpage= new MontoCarlo_AccountPage(driver);
	WebElement mo = accountpage.getHomeFurnishing();
	utilities.waitElementClick(mo, driver);
	logger.info("Mouse Overing on Home Furnishing");

	utilities.mouseOver(mo, driver);
	logger.info("Click on acComforter");

	accountpage.acComforter();


	MonteCarlo_AcComforterPage comforter= new MonteCarlo_AcComforterPage(driver);
	logger.info("click size");

	comforter.clickSize();
	logger.info("selecting size");

	comforter.chooseSize();
	logger.info("click colour");

	utilities.waitElementClick(comforter.waitColour(), driver);
	comforter.clickColour();
	
	utilities.waitElementClick(comforter.waitColour(), driver);
	logger.info("selecting colour");

	comforter.chooseColour();
	logger.info("click on brand");

	comforter.clickBrand();
	Thread.sleep(3000);
	logger.info("choose brand");

	comforter.chooseBrand();
	logger.info("click availability");

	utilities.waitElementClick(comforter.waitAvailability(), driver);
	comforter.clickAvailability();
	logger.info("choose availability");

	comforter.chooseAvailability();
	logger.info("click on product");

	comforter.chooseProduct();
	
	MontoCarlo_ProductPage product = new MontoCarlo_ProductPage(driver);
	logger.info("Adding to wish list");

	product.wishlistAdd();
	logger.info("click on wishlist");

	product.wishList();
	
	MonteCarlo_WishlistPage wishlist= new MonteCarlo_WishlistPage(driver);
	logger.info("Verifying the item added to wishlist");

	String currentWishTitle = driver.getTitle();
	
	Assert.assertEquals(currentWishTitle,datautilities.readingdataPropertyFile("wishlistTitle"));
	utilities.waitElementClick(wishlist.waitCart(), driver);
	logger.info("click on cart");

	wishlist.addToCart();
	
	}

}
