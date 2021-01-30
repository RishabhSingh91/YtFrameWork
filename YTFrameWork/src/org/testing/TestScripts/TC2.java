package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Base.Base;
import org.testing.Pages.LoginPage;
import org.testing.Pages.LogoutPage;
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC2 extends Base{

	
	@Test
	public void History() throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		LoginPage obj = new LoginPage(driver, pr);
		LogoutPage obj2 = new LogoutPage(driver, pr);
		obj.signin("ytdummy91@gmail.com", "Dummy@1234");
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("HistoryTab"))).click();
		Thread.sleep(5000);
		obj2.Logout();
		
	}
	
}