package testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import genericlibraries.BaseClass;
import pom.MonteCarlo_AcComforterPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;
//import org.apache.logging.log4j,.LogManager;

public class AddElementHandlePopUp extends BaseClass {
	static Logger logger = LogManager.getLogger(AddElementHandlePopUp.class);
	@Test
	public void testCase8() throws FileNotFoundException, IOException {
		logger.info("launch browser");
		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		logger.info("click on women section");
		accpage.womenSection();
		
		MonteCarlo_AcComforterPage stolepage = new MonteCarlo_AcComforterPage(driver);
		logger.info("click on stole");
		stolepage.selectStole();
		logger.info("Select the price and reading from property file");
		stolepage.priceRange(datautilities.readingdataPropertyFile("InitialPrice"));
		logger.info("verifying the result should be no result");
		Assert.assertEquals(stolepage.noResult(),datautilities.readingdataPropertyFile("Noresult"));
		logger.info("resetting the filter");
		stolepage.resetFilter();
		logger.info("entering starting price");

		stolepage.firstPrice(datautilities.readingdataPropertyFile("FirstPrice"));
		logger.info("entering end price");

		stolepage.priceRange(datautilities.readingdataPropertyFile("SecondPrice"));
		logger.info("selecting price product");

		stolepage.firstProduct();
		
		MontoCarlo_ProductPage product= new MontoCarlo_ProductPage(driver);
		logger.info("adding product to wishlist");
		
		product.wishlistAdd();
		logger.info("click on wishlist");
		product.emailHandling();
		logger.info("verifying the pop up");
		Assert.assertEquals(datautilities.readingdataPropertyFile("email"),product.emailHandling());
		logger.info("closing the app");
	}
	

}
