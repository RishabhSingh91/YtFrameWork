package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.Base.Base;
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC3 extends Base {
		
	@Test
	public void Subscription() throws InterruptedException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		driver.findElement(By.xpath(pr.getProperty("signinBtn"))).click();
		driver.findElement(By.xpath(pr.getProperty("EmailTxt"))).sendKeys("ytdummy91@gmail.com");
		driver.findElement(By.xpath(pr.getProperty("continueEmail"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(pr.getProperty("password"))).sendKeys("Dummy@1234");
		driver.findElement(By.xpath(pr.getProperty("continuePass"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(pr.getProperty("Subscription"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(pr.getProperty("SignoutDropDown"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("SignoutBtn"))).click();
	}
}
