package org.testing.TestScripts;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.jasper.tagplugins.jstl.core.Catch;
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

import com.aventstack.extentreports.Status;

public class TC10 extends Base {

	@Test
	public void Subscription() throws InterruptedException, IOException {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		LoginPage obj = new LoginPage(driver, pr);
		LogoutPage obj2 = new LogoutPage(driver, pr);
		VideoPlayPage obj3 = new VideoPlayPage(driver, pr);
		test = extent.createTest("Hastag videos and Liking");
		obj.signin("ytdummy91@gmail.com", "Dummy@1234");
		Thread.sleep(5000);
		List<WebElement> SuggestionList = driver.findElements(By.xpath(pr.getProperty("Hashtag")));
		int slist = 0;
		Thread.sleep(5000);
		for (WebElement e : SuggestionList) {
			if (e.getText().equalsIgnoreCase("Selenium")) {
				e.click();
			}
		}
		Thread.sleep(5000);

		obj3.PlayVideo(2);

		Thread.sleep(5000);
		List<WebElement> allLikebutton = driver.findElements(By.xpath(pr.getProperty("allLikebutton")));
		int num = 0;
		for (WebElement e2 : allLikebutton) {
			num++;
			if (num == 1) {
				e2.click();
			}
		}
		Thread.sleep(5000);
		obj2.Logout();
	}catch (Exception e) {
         e.printStackTrace();
	}
		}

}
