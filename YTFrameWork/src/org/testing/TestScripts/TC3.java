package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Base.Base;
import org.testing.Pages.LoginPage;
import org.testing.Pages.LogoutPage;
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TC3 extends Base {
		
	@Test
	public void Subscription() throws InterruptedException, IOException
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		LoginPage obj = new LoginPage(driver, pr);
		LogoutPage obj2 = new LogoutPage(driver, pr);
		test = extent.createTest("Subscriptions videos");
		obj.signin("ytdummy91@gmail.com", "Dummy@1234");
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("Subscription"))).click();
		Thread.sleep(5000);
		obj2.Logout();
		}catch (Exception e) {
			test.fail(MarkupHelper.createLabel("TC3 "+" TestCase Fail", ExtentColor.RED));
		}
	}
}
