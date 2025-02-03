package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonteCarlo_SigninPage {
	
	@FindBy(id="customer[email]")
	private WebElement username;
	
	@FindBy(id="customer[password]")
	private WebElement password;

	@FindBy(xpath="(//span[contains(text(),'Login')])[2]")
	private WebElement loginbutton;
	
	public MonteCarlo_SigninPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void userName(String name) {
		username.sendKeys(name);
	}
	
	public void passWord(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void loginButton() {
		loginbutton.click();
	}
}
