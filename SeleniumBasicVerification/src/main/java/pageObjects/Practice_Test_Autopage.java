package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Practice_Test_Autopage {
	private WebDriver fdriver;
	public Practice_Test_Autopage(WebDriver driver){
		this.fdriver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(this.fdriver,20), this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Test Login Page')]")
	private WebElement testLoginPage;
	
	@FindBy(xpath="//div[contains(text(),'Test Exceptions')]")
	private WebElement testExceptions;
	
	@FindBy(xpath="//div[@class='post-content']/p/strong")
	private WebElement testLoginSuccess;
	
	
	public WebElement getLoginPage() {
		return testLoginPage;
	}

	
	public WebElement getExceptions() {
		return testExceptions;
	}
	
	public WebElement getLoginSuccess() {
		return testLoginSuccess;
	}
	
	
}
