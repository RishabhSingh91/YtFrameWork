package org.testing.TestScripts;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Base.Base;
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC10 extends Base {

	@Test
	public void Subscription() throws InterruptedException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath(pr.getProperty("signinBtn"))).click();
		driver.findElement(By.xpath(pr.getProperty("EmailTxt"))).sendKeys("ytdummy91@gmail.com");
		driver.findElement(By.xpath(pr.getProperty("continueEmail"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(pr.getProperty("password"))).sendKeys("Dummy@1234");
		driver.findElement(By.xpath(pr.getProperty("continuePass"))).click();
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

		List<WebElement> allvideos = driver.findElements(By.xpath(pr.getProperty("Allvideos")));
		int count = 0;
		Thread.sleep(5000);
		for (WebElement e : allvideos) {
			count++;
			try {
				if (count == 5) {
					e.click();
				}
			} catch (Exception e1) {
				continue;
			}
		}

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
		driver.findElement(By.xpath(pr.getProperty("SignoutDropDown"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("SignoutBtn"))).click();
	}

}
