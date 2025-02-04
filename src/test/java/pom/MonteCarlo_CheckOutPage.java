package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarlo_CheckOutPage {
	
		@FindBy(id="shipping-address1")
		private WebElement addressInput;
		
		@FindBy(id="shipping-address1-option-1")
		private WebElement addressSecondOption;
	 
		public MonteCarlo_CheckOutPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}
		
		public void addressInput(String address) {
			addressInput.sendKeys(address);
		}
		
		public void addressSecondOption() {
			addressSecondOption.click();
		}
	 
}
