package org.testing.Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	Properties pr;
	
	public LoginPage(WebDriver driver, Properties pr) {
		this.driver = driver;
		this.pr =pr;
	}
	
	public void signin(String userName, String Password) throws InterruptedException
	{
		driver.findElement(By.xpath(pr.getProperty("signinBtn"))).click();
		driver.findElement(By.xpath(pr.getProperty("EmailTxt"))).sendKeys(userName);
		driver.findElement(By.xpath(pr.getProperty("continueEmail"))).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);		
		Thread.sleep(10000);
		WebElement body= driver.findElement(By.xpath(pr.getProperty("password")));
		wait.until(ExpectedConditions.elementToBeClickable(body));
		body.sendKeys(Password);
		WebElement e =driver.findElement(By.xpath(pr.getProperty("continuePass")));
		e.click();
	}

}
