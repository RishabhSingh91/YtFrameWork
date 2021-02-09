package org.testing.TestScripts;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Base.Base;
import org.testing.Pages.LoginPage;
import org.testing.Pages.LogoutPage;
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testing.Utilities.LogsCapture;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.steadystate.css.dom.Property;

public class TC1 extends Base {
 
	@Test
	public void Login() throws InterruptedException, IOException
	{
		try {
		LogsCapture.takelogs("Login Started", "TC1");
		LoginPage obj = new LoginPage(driver, pr);
		LogoutPage obj2 = new LogoutPage(driver, pr);
		test = extent.createTest("Trending videos");
		obj.signin("ytdummy9102@gmail.com", "Dummy@1234");
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("TrendingVideo"))).click();
		Thread.sleep(5000);
		obj2.Logout();
		LogsCapture.takelogs("Login Passed", "TC1");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
