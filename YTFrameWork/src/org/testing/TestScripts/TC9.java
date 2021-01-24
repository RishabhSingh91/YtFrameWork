package org.testing.TestScripts;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TC9 extends Base {	
	@Test
	public void Subscription() throws InterruptedException, IOException
	{
		Properties pr = LoadProperties.Load("../YTFrameWork/src/WebelementYT");
		WebDriverWait wait = new WebDriverWait(driver, 10);	
		driver.findElement(By.xpath(pr.getProperty("signinBtn"))).click();
		driver.findElement(By.xpath(pr.getProperty("EmailTxt"))).sendKeys("ytdummy91@gmail.com");
		driver.findElement(By.xpath(pr.getProperty("continueEmail"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(pr.getProperty("password"))).sendKeys("Dummy@1234");
		driver.findElement(By.xpath(pr.getProperty("continuePass"))).click();
		Thread.sleep(5000);
		List<WebElement> allvideos = driver.findElements(By.xpath(pr.getProperty("Allvideos")));
		int count =0;
		Thread.sleep(5000);
		for(WebElement e: allvideos)
		{
			count++;
			try {
			if(count==11)
			{
				e.click();
			}}catch(Exception e1) {
				continue;}
			
		}
		Thread.sleep(5000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)");
		Thread.sleep(15000);
		List<WebElement>comment =driver.findElements(By.xpath(pr.getProperty("allComments")));
		int size=comment.size();
		for(int i=1;i<size;i++)
		{
			WebElement com = comment.get(i);
				try {
					System.out.println("Passed element id is: "+com.getAttribute("id"));
					Thread.sleep(3000);
					    driver.findElement(By.xpath(pr.getProperty("comment1"))).sendKeys("I loved this video");
				}
				catch(Exception e)
				{
					try {
						driver.findElement(By.xpath(pr.getProperty("comment2"))).sendKeys("I loved this video");
					}catch(Exception e1)
					{
						System.out.println("Entered second loop");
						e1.printStackTrace();
						continue;}
					System.out.println("Failed element id is: "+com.getAttribute("id"));
					e.printStackTrace();
					continue;
				}
			
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(pr.getProperty("AddComment"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("SubscribeVideo"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(pr.getProperty("SignoutDropDown"))).click();
		Thread.sleep(5000); 
		driver.findElement(By.xpath(pr.getProperty("SignoutBtn"))).click();
}	
}
