package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import Utilities.ExplicitWaits ;
import baseClass.TestBase;

public class GmailMails extends TestBase {

	
	public static ExplicitWaits explicitWait;

	@FindBy(xpath = "//div[contains(text(),'Compose')]") WebElement composeButton;
	@FindBy(xpath = "//textarea[@id=':pv']") WebElement sendEmailTo;
	@FindBy(xpath = "//input[@name='subjectbox']") WebElement emailSubject;
	@FindBy(xpath = "//div[@id=':qh']") WebElement emailBody;
	@FindBy(xpath = "//div[@id=':p3']") WebElement sendMailButton;
	@FindBy(xpath = "//div[@class='aaZ']") WebElement newMessageWindow;

	

	public GmailMails() {
		PageFactory.initElements(driver,this );
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void composeMail(String To, String Subject, String Body) {
		ExtentTest test2 = extent.createTest("Gmail Compose mail", "Compose a simple mail in gmail");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		composeButton.click();
		test2.pass("Clicked on compose button");
		
		ExplicitWaits.waitForElementToBeVisible(driver,newMessageWindow , 5);
		
		test2.pass("New Message window is displayed.");
		sendEmailTo.sendKeys(To);
		test2.pass("Entered receipient's mail id.");
		emailSubject.sendKeys(Subject);
		test2.pass("Entered Subject of the mail.");
		emailBody.sendKeys(Body);
		test2.pass("Entered message in mail body.");
		//sendMailButton.click();
		//test2.pass("Message send successfully.");
		
		
	}
	
	
}
