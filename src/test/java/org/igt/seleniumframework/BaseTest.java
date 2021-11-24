package org.igt.seleniumframework;

import java.io.IOException;
import java.util.Map;

import org.igt.drivers.Driver;
import org.igt.frameworkconstants.FrameworkConstants;
import org.igt.reports.ExtentReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
/**
 * Set of methods to initilize & close the report and drivers.
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
public class BaseTest {
	
	protected BaseTest() {
		
	}
	@BeforeSuite
	public void beforSuite() {
		ExtentReport.initReports();
	}
	@AfterSuite
	public void afterSuite()  {
		ExtentReport.flushReports();
	}
	
	@BeforeMethod
	protected void setUp(Object[] data)  {
		Map<String,String> map = (Map<String,String>)data[0];
		Driver.initdriver(map.get("browser"),map.get("browserversion"));
	}
	
	@AfterMethod
	protected void tearDown() {
		Driver.quitdriver();
	}

}
