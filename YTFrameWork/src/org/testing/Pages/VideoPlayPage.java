package org.testing.Pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideoPlayPage {
	
	WebDriver driver;
	Properties pr;
	
	public VideoPlayPage(WebDriver driver, Properties pr)
	{
		this.driver = driver;
		this.pr =pr;
	}
	
	public void PlayVideo(int videoPosition) throws InterruptedException
	{
		List<WebElement> allvideos = driver.findElements(By.xpath(pr.getProperty("Allvideos")));
		int count =0;
		Thread.sleep(5000);
		for(WebElement e: allvideos)
		{
			count++;
			try {
			if(count==videoPosition)
			{
				e.click();
			}}catch(Exception e1) {continue;}
			
		}
	}

}
