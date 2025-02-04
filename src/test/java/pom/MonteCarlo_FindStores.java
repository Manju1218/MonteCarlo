package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarlo_FindStores {
	

	
		@FindBy(id = "searchInput")
		private WebElement searchStore;
		
		@FindBy(xpath ="//a[normalize-space()='Get Directions']")
		private WebElement direction;
		
		public MonteCarlo_FindStores(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		public void searchStore() {
			searchStore.click();
		}
		
		public void searchFindStoreTextBox(String search) {
			searchStore.sendKeys(search);
		}
		
		public void direction() {
			direction.click();
		}

}
