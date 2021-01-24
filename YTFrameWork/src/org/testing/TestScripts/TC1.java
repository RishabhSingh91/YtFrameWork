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
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.steadystate.css.dom.Property;

public class TC1 extends Base {
 
	@Test
	public void Login() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath(pr.getProperty("signinBtn"))).click();
		driver.findElement(By.xpath(pr.getProperty("EmailTxt"))).sendKeys("ytdummy91@gmail.com");
		driver.findElement(By.xpath(pr.getProperty("continueEmail"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		Thread.sleep(10000);
		WebElement body= driver.findElement(By.xpath(pr.getProperty("password")));
		System.out.println("main body is displayed: "+ body.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(body));
		System.out.println("Body is interactable: "+body.isEnabled());
		System.out.println("Reached");
		body.sendKeys("Dummy@1234");
		WebElement e =driver.findElement(By.xpath(pr.getProperty("continuePass")));
		e.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("TrendingVideo"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("SignoutDropDown"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("SignoutBtn"))).click();
		
	}
	


}
