package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import baseClass.TestBase;

public class GmailLogin extends TestBase {

	@FindBy(xpath = "//input[@id='identifierId']") WebElement enterEmailId;
	@FindBy(xpath = "//span[contains(text(),'Next')]") WebElement emailNextButton;
	@FindBy(xpath = "//input[@name='password']") WebElement enterPassword;
	@FindBy(xpath = "//div[@id='passwordNext']") WebElement passwordNextButton;
	
	
	public GmailLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public  GmailMails loginIntoGmail(String emailId, String password) {
		ExtentTest test1 = extent.createTest("Gmail Login Test", "Signing into Gmail");
		
		enterEmailId.sendKeys(emailId);
		test1.pass("Emailid entered");
		emailNextButton.click(); 
		test1.pass("Navigating to password page");
		enterPassword.sendKeys(password);
		test1.pass("Entered password");
		passwordNextButton.click();
		test1.pass("Clicked Next");		
		
		try {
			String title= "Gmail";
			Assert.assertEquals( driver.getTitle(), title,"Login failure");
			test1.pass("Logged in successfully");
		}
		catch(Exception e) {
		 System.out.println("Login failure");
		}
		
		return new GmailMails();

	}
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
}
