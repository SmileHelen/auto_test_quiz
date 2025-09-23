package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginSuccessPage {
	
	private WebDriver fdriver;
	public LoginSuccessPage(WebDriver driver){
		this.fdriver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.fdriver,20), this);
	}
	
	@FindBy(xpath="//div[@class='post-content']/p/strong")
	private WebElement testLoginSuccess;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	private WebElement testLogoutBtn;
	
	public WebElement getLoginSuccess() {
		return testLoginSuccess;
	}
	
	public WebElement getLogoutBtn() {
		return testLogoutBtn;
	}

}
