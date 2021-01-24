package org.testing.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	protected static EdgeDriver driver;
	protected static Properties pr;
	
	@BeforeMethod
	public void Launch() throws IOException
	{
		System.setProperty("webdriver.edge.driver", "D:\\Selenium_Libraries\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		File f = new File("../YTFrameWork/src/org/testing/Properties/WebelementYT.properties");
		FileInputStream fi = new FileInputStream(f);
		pr= new Properties(); 
		pr.load(fi);
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
