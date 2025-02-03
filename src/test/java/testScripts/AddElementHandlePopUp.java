package testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_AcComforterPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class AddElementHandlePopUp extends BaseClass {
	
	@Test
	public void testCase8() throws FileNotFoundException, IOException {
		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		
		accpage.womenSection();
		
		MonteCarlo_AcComforterPage stolepage = new MonteCarlo_AcComforterPage(driver);
		
		stolepage.selectStole();
		
		stolepage.priceRange(datautilities.readingdataPropertyFile("InitialPrice"));
		
		Assert.assertEquals(stolepage.noResult(),datautilities.readingdataPropertyFile("Noresult"));
		
		stolepage.resetFilter();
		
		stolepage.firstPrice(datautilities.readingdataPropertyFile("FirstPrice"));
		
		stolepage.priceRange(datautilities.readingdataPropertyFile("SecondPrice"));
		
		stolepage.firstProduct();
		
		MontoCarlo_ProductPage product= new MontoCarlo_ProductPage(driver);
		
		product.wishlistAdd();
		
		product.emailHandling();
		
		Assert.assertEquals(datautilities.readingdataPropertyFile("email"),product.emailHandling());
		
	}
	

}
