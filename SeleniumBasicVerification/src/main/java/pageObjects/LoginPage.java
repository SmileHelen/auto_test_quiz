package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
	
	private WebDriver fdriver;
	public LoginPage(WebDriver driver){
		this.fdriver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.fdriver,20), this);
	}
	
	@FindBy(id="username")
	private WebElement usernameInput;
	
	@FindBy(id="password")
	private WebElement passwordInput;
	
	@FindBy(id="submit")
	private WebElement submitButton;
	
	@FindBy(id="error")
	private WebElement testLoginFail;
	
	public WebElement getUername() {
		return usernameInput;
	}
	
	public WebElement getPassword() {
		return passwordInput;
	}
	
	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public WebElement getLoginFail() {
		return testLoginFail;
	}


}
