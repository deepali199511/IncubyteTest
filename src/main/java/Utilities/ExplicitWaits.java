package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeout)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
	}
}

