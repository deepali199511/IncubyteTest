package baseClass;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent= null;
	
	protected TestBase(){
		try 
		{
			prop = new Properties();
			FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Configurations/Config.properties");
			prop.load(inputStream);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public static void initialization() {

		String BrowserName = prop.getProperty("Browser");
		if(BrowserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BrowserName.equals("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}
		else if(BrowserName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Path of Driver Executable is not Set for any Browser");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		driver.get(prop.getProperty("Url"));

	}
	
	public void ExtentReportsetup()
	{
		htmlReporter = new ExtentHtmlReporter("GmailTest.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() throws IOException
	{
		//driver.quit();
	}
	
}

