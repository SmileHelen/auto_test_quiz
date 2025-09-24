package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.LoginSuccessPage;
import pageObjects.Practice_Test_Autopage;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class EdgeTestCase {
	
	private WebDriver webdriver;
	private LoginPage loginPage;
	private Practice_Test_Autopage parcticPage;
	private LoginSuccessPage successPage;


	@BeforeClass
	public void initDriver(){

//		String edgeDriverPath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe";
//		System.setProperty("webdriver.edge.driver", edgeDriverPath);
		EdgeOptions options = new EdgeOptions();
//		options.addArguments("user-data-dir=E:\\UserData");
		options.addArguments("--remote-allow-origins=*");
		webdriver = new EdgeDriver(options);
			
		loginPage = new LoginPage(webdriver);
		parcticPage = new Practice_Test_Autopage(webdriver);
		successPage = new LoginSuccessPage(webdriver);
		
	}
	
	// open the test site
	@BeforeMethod
	public void initSite(){
		webdriver.get("https://practicetestautomation.com/practice/");
	}
	
	
	// Positive LogIn test
	@Test(priority=1)
	public void loginSuccess() throws InterruptedException{		
		
		
		parcticPage.getLoginPage().click();
		loginPage.getUername().sendKeys("student");
		loginPage.getPassword().sendKeys("Password123");
		loginPage.getSubmitButton().click();
		String url = webdriver.getCurrentUrl();
		Assert.assertTrue(StringUtils.contains(url, "practicetestautomation.com/logged-in-successfully/"));
		
		String message = successPage.getLoginSuccess().getText();
		Assert.assertTrue(StringUtils.contains(message, "Congratulations") | StringUtils.contains(message, "successfully logged in"));
		
		System.out.print(successPage.getLogoutBtn().getCssValue("display"));
		Assert.assertTrue(StringUtils.contains(successPage.getLogoutBtn().getCssValue("display"), "inline-block"));
	}
	
	
	// Negative username test
	@Test(priority=2)
	public void negativeUsername() throws InterruptedException{
	
		
		parcticPage.getLoginPage().click();
		loginPage.getUername().sendKeys("incorrectUser");
		loginPage.getPassword().sendKeys("Password123");
		
		loginPage.getSubmitButton().click();
		
		Thread.sleep(5000);
		String message = loginPage.getLoginFail().getText();
		String status = loginPage.getLoginFail().getCssValue("display");
	    Assert.assertTrue(StringUtils.contains(status, "block"));
		Thread.sleep(5000);
		Assert.assertTrue(StringUtils.contains(message, "Your username is invalid!"));
		Thread.sleep(2000);
	}
	
	// Negative password test
	@Test(priority=3)
	public void negativePassword() throws InterruptedException{
		
		parcticPage.getLoginPage().click();
		
		loginPage.getUername().sendKeys("student");
		loginPage.getPassword().sendKeys("incorrectPassword");
		
		loginPage.getSubmitButton().click();
		
		Thread.sleep(5000);
		String message = loginPage.getLoginFail().getText();
		String status = loginPage.getLoginFail().getCssValue("display");
	    Assert.assertTrue(StringUtils.contains(status, "block"));
		
		Assert.assertTrue(StringUtils.contains(message, "Your password is invalid!"));

	}
	
	// close the test site
	@AfterTest
	public void quiteDriver(){
		webdriver.quit();
	}
}
