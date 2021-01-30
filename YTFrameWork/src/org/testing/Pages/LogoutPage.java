package org.testing.Pages;

import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
	
	WebDriver driver;
	Properties pr;
	
	public LogoutPage(WebDriver driver, Properties pr)
	{
		this.driver =driver;
		this.pr = pr;
	}
	
	public void Logout() throws InterruptedException
	{
		
		driver.findElement(By.xpath(pr.getProperty("SignoutDropDown"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(pr.getProperty("SignoutBtn"))).click();
	}

}
