package org.testing.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoadDriver {
	
	public static WebDriver Load(String Browser)
	{
		WebDriver driver =null;
		switch(Browser.toLowerCase())
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:/Selenium_Libraries/chromedriver_win32/chromedriver.exe"); 
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.geckodriver.driver", "D:\\Selenium_Libraries\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", "D:\\Selenium_Libraries\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		}
		return driver;
	}

}
