package org.testing.TestScripts;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Base.Base;
import org.testing.Pages.LoginPage;
import org.testing.Pages.LogoutPage;
import org.testing.Pages.VideoPlayPage;
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC8 extends Base{
	
	@Test
	public void Subscription() throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		LoginPage obj = new LoginPage(driver, pr);
		LogoutPage obj2 = new LogoutPage(driver, pr);
		VideoPlayPage obj3 = new VideoPlayPage(driver, pr);
		obj.signin("ytdummy91@gmail.com", "Dummy@1234");
		Thread.sleep(5000);
		obj3.PlayVideo(12);
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("SubscribeVideo"))).click();
		Thread.sleep(5000);
		obj2.Logout();
	}
}
