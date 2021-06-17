package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Pages.GmailLogin;
import Pages.GmailMails;
import baseClass.TestBase;

public class GmailTest extends TestBase {

	GmailLogin loginPage;
	GmailMails mailBox;


	public GmailTest() {
		super();
	}

	@BeforeClass()
	public void setUp()
	{
		initialization();
		ExtentReportsetup();
		loginPage = new GmailLogin();
		mailBox = new GmailMails();
		mailBox = loginPage.loginIntoGmail(prop.getProperty("Username"),prop.getProperty("Password"));
	}

	@Test(priority=1, enabled=true)
	public void verifyGmailTitleTest()
	{
		ExtentTest test1 = extent.createTest("Get Gmail title", "Incubyte Automation test");
		String homePageTitle = mailBox.getPageTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle,"Gmail", "Title not matched");
		test1.pass("Gmail Title verified successfully");

	}

	@Test(priority=2, enabled=true)
	public void sendMail() {
		mailBox.composeMail(prop.getProperty("SendTo"),prop.getProperty("Subject"), prop.getProperty("Body"));
	}


	@AfterSuite
	public void teardown()
	{
		extent.flush();
	}
}
