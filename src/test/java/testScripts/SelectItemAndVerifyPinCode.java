package testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericlibraries.BaseClass;
import pom.MonteCarlo_AcComforterPage;
import pom.MonteCarlo_LoginPage;
import pom.MonteCarlo_SigninPage;
import pom.MontoCarlo_AccountPage;
import pom.MontoCarlo_ProductPage;

public class SelectItemAndVerifyPinCode extends BaseClass{

	@Test
	public void testCase3() throws EncryptedDocumentException, IOException, InterruptedException {
		MonteCarlo_LoginPage login = new MonteCarlo_LoginPage(driver);
		login.loginButton();
		MonteCarlo_SigninPage signin = new MonteCarlo_SigninPage(driver);
		
		signin.userName(datautilities.readingdataExcelFile("Sheet1", 1, 1));
		
		signin.passWord(datautilities.readingdataExcelFile("Sheet1", 1, 2));
		
		signin.loginButton();
		
		Assert.assertEquals(driver.getTitle(),datautilities.readingdataPropertyFile("AccountPapeTitle"));
		
		MontoCarlo_AccountPage accpage= new MontoCarlo_AccountPage(driver);
		
		utilities.mouseOver(accpage.mensHower(), driver);
		Thread.sleep(3000);
		accpage.roundNeck();
		MonteCarlo_AcComforterPage  specifiactions = new MonteCarlo_AcComforterPage(driver);
		
		specifiactions.clickSize();
		
		specifiactions.chooseBrand();
		
		specifiactions.clickBrand();
		
		specifiactions.sleeve();
		
		specifiactions.sleeveSelect();
		
		specifiactions.thirdItem();
		
		MontoCarlo_ProductPage product = new MontoCarlo_ProductPage(driver);
		
		product.enterPincode(datautilities.readingdataPropertyFile("pincode"));
		
		
		
		
	}
}
