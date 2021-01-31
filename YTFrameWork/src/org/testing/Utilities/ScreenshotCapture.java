package org.testing.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotCapture {
	
	public static void TakeScreenshot(WebDriver driver, String Filepath) throws IOException
	{
		
		TakesScreenshot sc = (TakesScreenshot) driver;
		File f = sc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(Filepath));
	}

}
