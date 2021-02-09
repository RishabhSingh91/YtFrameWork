package org.testing.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testing.Utilities.LoadDriver;
import org.testing.Utilities.LoadProperties;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
public class Base {
	protected static EdgeDriver driver;
	protected static Properties pr;
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
		
	
	@BeforeSuite(enabled = true)
	public void  ReportGenerator()
	{
    	htmlReporter = new ExtentHtmlReporter("C:\\Users\\jamwa\\OneDrive\\Desktop\\Reports\\MyOwnReport.html");
    	extent = new ExtentReports();
    	extent.attachReporter(htmlReporter);
    	
    	 extent.setSystemInfo("OS", "Windows 10");
         extent.setSystemInfo("Host Name", "Rishabh");
         extent.setSystemInfo("Environment", "QA");
         extent.setSystemInfo("User Name", "Rishabh Singh");
         htmlReporter.config().setChartVisibilityOnOpen(true);
         htmlReporter.config().setDocumentTitle("AutomationTesting.in Demo Report");
         htmlReporter.config().setReportName("My Own Report");
         htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
         htmlReporter.config().setTheme(Theme.STANDARD);
	}
	
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
		driver.manage().deleteAllCookies();
	}

	@AfterMethod(enabled = true)
	public void closeBrowser(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.fail(MarkupHelper.createLabel(result.getName()+" TestCase Fail", ExtentColor.RED));
			test.fail(result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel(result.getName()+" Testcase Pass" , ExtentColor.GREEN));			
		}else {
			test.skip(MarkupHelper.createLabel(result.getName()+" Testcase Skipped" , ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}
		driver.quit();
		
	}
	
	@AfterSuite(enabled = true)
	public void quitReport()
	{
		extent.flush();
	}

}
